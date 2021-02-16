package de.melsicon.talk.value.simple.autovalue;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import org.apache.commons.validator.routines.EmailValidator;

/** A (validated) e-mail address. */
@Immutable
@AutoValue
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
    return new AutoValue_EmailAddress.Builder();
  }

  /**
   * The e-mail address.
   *
   * @return The address.
   */
  public abstract String address();

  /** Builder of an e-mail address instance */
  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Set the e-mail address.
     *
     * @param address An address
     * @return This builder
     */
    public abstract Builder address(String address);

    /* package */ abstract EmailAddress autoBuild();

    /**
     * Constructs a new e-mail address with the given parameters.
     *
     * @return An e-mail address
     */
    public EmailAddress build() {
      var emailAddress = autoBuild();
      var address = emailAddress.address();
      Preconditions.checkState(
          EMAIL_VALIDATOR.isValid(address), "%s is not a valid e-mail address", address);
      return emailAddress;
    }
  }
}
