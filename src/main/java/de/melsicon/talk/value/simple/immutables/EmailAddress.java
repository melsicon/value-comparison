package de.melsicon.talk.value.simple.immutables;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import org.apache.commons.validator.routines.EmailValidator;
import org.immutables.value.Value;

/** A (validated) e-mail address. */
@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
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
  public static ImmutableEmailAddress.Builder builder() {
    return ImmutableEmailAddress.builder();
  }

  /**
   * The e-mail address.
   *
   * @return The address.
   */
  public abstract String address();

  @Value.Check
  /* package */ void check() {
    var address = address();
    Preconditions.checkState(
        EMAIL_VALIDATOR.isValid(address), "%s is not a valid e-mail address", address);
  }
}
