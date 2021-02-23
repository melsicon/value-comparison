package de.melsicon.talk.value.simple.record;

import com.google.common.collect.ImmutableSet;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

/** Representation of a person. */
public record Person(String givenName, @Nullable String surname, ImmutableSet<EmailAddress> email) {
  /**
   * Creates a Person.
   *
   * @param givenName Set the given name. Required.
   * @param surname Set the surname. Optional, i.e for royalty.
   * @param email Email addresses this person is reachable under.
   */
  public Person {
    Objects.requireNonNull(givenName, "givenName is a required parameter");
  }
}
