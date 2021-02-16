package de.melsicon.talk.value.simple.kotlin

import org.apache.commons.validator.routines.EmailValidator

val EMAIL_VALIDATOR: EmailValidator = EmailValidator.getInstance()

/**
 * A (validated) e-mail address.
 *
 * @param[address] Set the e-mail address.
 */
data class EmailAddress(val address: String) {
    init {
        require(EMAIL_VALIDATOR.isValid(address)) { "$address is not a valid e-mail address" }
    }
}
