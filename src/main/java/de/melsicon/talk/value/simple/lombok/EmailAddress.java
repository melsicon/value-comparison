package de.melsicon.talk.value.simple.lombok;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import lombok.Value;
import org.apache.commons.validator.routines.EmailValidator;
import org.checkerframework.checker.nullness.qual.NonNull;

/** A (validated) e-mail address. */
@SuppressWarnings({
  "MultiVariableDeclaration",
  "SameNameButDifferent",
  "UnnecessarilyFullyQualified",
  "Var",
  "allcheckers:type.anno.before",
})
@Value(staticConstructor = "of")
@Immutable
public class EmailAddress {
  private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();

  /** The e-mail address. */
  @NonNull String address;

  /* package */ EmailAddress(String address) {
    this.address = address;
    Preconditions.checkState(
        EMAIL_VALIDATOR.isValid(address), "%s is not a valid e-mail address", address);
  }
}
