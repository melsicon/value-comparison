package de.melsicon.talk.value.simple.lombok;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.apache.commons.validator.routines.EmailValidator;

@SuppressWarnings({
  "MultiVariableDeclaration",
  "Var",
})
@Value
@Builder
@Immutable
public class EmailAddress {
  private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();

  /** The e-mail address. */
  // This needs to be the Lombok annotation
  @NonNull String address;

  /* package */ EmailAddress(String address) {
    this.address = address;
    Preconditions.checkState(
        EMAIL_VALIDATOR.isValid(address), "%s is not a valid e-mail address", address);
  }

  /**
   * Creates an e-mail address.
   *
   * @param address An address
   * @return An e-mail address
   */
  public static EmailAddress of(String address) {
    return new EmailAddress(address);
  }
}
