package de.melsicon.talk.value.simple.record;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/** Representation of a person. */
public record Person(String givenName, @Nullable String surname, ImmutableList<String> email) {
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
