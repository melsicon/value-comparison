package de.melsicon.talk.value.simple.freebuilder;

import com.google.common.base.Preconditions;
import org.apache.commons.validator.routines.EmailValidator;
import org.inferred.freebuilder.FreeBuilder;

/** A (validated) e-mail address. */
@FreeBuilder
public abstract class EmailAddress {
  private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();

  /* package */ EmailAddress() {}

  /**
   * Creates an e-mail address.
   *
   * @param address An address
   * @return An e-mail address
   */
  public static EmailAddress of(String address) {
    return builder().address(address).build();
  }

  /**
   * Creates an e-mail address builder.
   *
   * @return A new builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * The e-mail address.
   *
   * @return The address.
   */
  public abstract String address();

  /** Builder of an e-mail address instance */
  public static class Builder extends EmailAddress_Builder {
    @Override
    public EmailAddress build() {
      var emailAddress = super.build();
      var address = emailAddress.address();
      Preconditions.checkState(
          EMAIL_VALIDATOR.isValid(address), "%s is not a valid e-mail address", address);
      return emailAddress;
    }
  }
}
