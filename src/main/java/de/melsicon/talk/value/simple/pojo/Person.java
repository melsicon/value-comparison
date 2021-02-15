package de.melsicon.talk.value.simple.pojo;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;
import java.util.Optional;

/** Representation of a person. */
@Immutable
public final class Person {
  private final String givenName;

  private final @Nullable String surname;

  private final ImmutableList<String> email;

  /**
   * Creates a Person.
   *
   * @param givenName Set the given name. Required.
   * @param surname Set the surname. Optional, i.e for royalty.
   * @param email Email addresses this person is reachable under. Optional.
   */
  public Person(String givenName, @Nullable String surname, @Nullable Iterable<String> email) {
    this.givenName = Objects.requireNonNull(givenName, "givenName is a required parameter");
    this.surname = surname;
    this.email = email == null ? ImmutableList.of() : ImmutableList.copyOf(email);
  }

  /**
   * The given name of this person. Everyone has one.
   *
   * @return A name.
   */
  public String givenName() {
    return givenName;
  }

  /**
   * The surname name of this person. Optional, i.e for royalty.
   *
   * @return An optional name
   */
  public Optional<String> surname() {
    return Optional.ofNullable(surname);
  }

  /**
   * Email addresses this person is reachable under.
   *
   * @return An immutable list of email addresses
   */
  public ImmutableList<String> email() {
    return email;
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, surname, email);
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Person)) {
      return false;
    }

    var p = (Person) obj;
    return givenName.equals(p.givenName)
        && Objects.equals(surname, p.surname)
        && email.equals(p.email);
  }

  @Override
  public String toString() {
    return String.format(
        "Person(givenName=%s surname=%s email=[%s])",
        givenName, surname == null ? "(null)" : surname, String.join(",", email));
  }
}
