package de.melsicon.talk.value.simple.pojo;

import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import org.checkerframework.checker.nullness.qual.Nullable;

/** Representation of a person. */
@Immutable
public final class Person {
  private final String givenName;

  private final @Nullable String surname;

  private final ImmutableSet<EmailAddress> email;

  /**
   * Creates a Person.
   *
   * @param givenName Set the given name. Required.
   * @param surname Set the surname. Optional, i.e for royalty.
   * @param email Email addresses this person is reachable under. Optional.
   */
  public Person(
      String givenName, @Nullable String surname, @Nullable Iterable<EmailAddress> email) {
    this.givenName = Objects.requireNonNull(givenName, "givenName is a required parameter");
    this.surname = surname;
    this.email = email == null ? ImmutableSet.of() : ImmutableSet.copyOf(email);
  }

  /**
   * Creates a Person.
   *
   * @param givenName Set the given name. Required.
   * @param surname Set the surname. Optional, i.e for royalty.
   * @param email Email addresses this person is reachable under. Optional.
   * @return A person.
   */
  public static Person of(String givenName, @Nullable String surname, String... email) {
    return new Person(
        givenName,
        surname,
        Arrays.stream(email).map(EmailAddress::of).collect(ImmutableSet.toImmutableSet()));
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
   * @return An immutable set of email addresses
   */
  public ImmutableSet<EmailAddress> email() {
    return email;
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, surname, email);
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    return obj == this
        || (obj instanceof Person p
            && givenName.equals(p.givenName)
            && Objects.equals(surname, p.surname)
            && email.equals(p.email));
  }

  @Override
  public String toString() {
    var emails =
        email.stream()
            .reduce(
                new StringJoiner(", "),
                (joiner, email) -> joiner.add(email.toString()),
                StringJoiner::merge);
    return String.format(
        "Person(givenName=%s surname=%s email=[%s])",
        givenName, surname == null ? "(null)" : surname, emails);
  }
}
