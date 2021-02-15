package de.melsicon.talk.value.simple.freebuilder;

import com.google.common.collect.ImmutableList;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

/** Representation of a person. */
@FreeBuilder
public interface Person {
  /**
   * Creates a Person builder.
   *
   * @return A new builder
   */
  static Builder builder() {
    return new Builder();
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
  ImmutableList<String> email();

  /** Builder of a person instance */
  class Builder extends Person_Builder {}
}
