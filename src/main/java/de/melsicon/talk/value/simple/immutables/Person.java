package de.melsicon.talk.value.simple.immutables;

import com.google.errorprone.annotations.Immutable;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

/** Representation of a person. */
@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public interface Person {
  /**
   * Creates a Person builder.
   *
   * @return A new builder
   */
  static ImmutablePerson.Builder builder() {
    return ImmutablePerson.builder();
  }

  /**
   * The given name of this person. Everyone has one.
   *
   * @return A name.
   */
  String givenName();

  /**
   * The surname name of this person. Optional, i.e for royalty.
   *
   * @return An optional name
   */
  Optional<String> surname();

  /**
   * Email addresses this person is reachable under.
   *
   * @return An immutable list of email addresses
   */
  List<String> email();
}
