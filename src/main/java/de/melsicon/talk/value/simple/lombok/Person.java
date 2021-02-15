package de.melsicon.talk.value.simple.lombok;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Optional;

/** Representation of a person. */
@SuppressWarnings({
  "FieldMissingNullable",
  "MissingSummary",
  "MultiVariableDeclaration",
  "ObjectToString",
  "Var",
})
@Value
@Builder
@Immutable
public class Person {
  /** The given name of this person. Everyone has one. */
  // This needs to be the Lombok annotation
  @NonNull String givenName;

  /** The surname name of this person. Optional, i.e for royalty. */
  @SuppressWarnings("type.anno.before.modifier")
  @Nullable
  String surname;

  /** Email addresses this person is reachable under. */
  @Singular("email")
  ImmutableList<String> email;

  /**
   * The surname name of this person. Optional, i.e for royalty.
   *
   * @return An optional name
   */
  public Optional<String> getSurname() {
    return Optional.ofNullable(surname);
  }
}
