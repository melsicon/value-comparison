package de.melsicon.talk.value.simple.immutables;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

/** Representation of a person. */
@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public abstract class Person {
  /* package */ Person() {}

  /**
   * Creates a Person builder.
   *
   * @return A new builder
   */
  public static ImmutablePerson.Builder builder() {
    return ImmutablePerson.builder();
  }

  /**
   * The given name of this person. Everyone has one.
   *
   * @return A name.
   */
  public abstract String givenName();

  /**
   * The surname name of this person. Optional, i.e for royalty.
   *
   * @return An optional name
   */
  public abstract Optional<String> surname();

  /**
   * Email addresses this person is reachable under.
   *
   * @return An immutable list of email addresses
   */
  public abstract List<EmailAddress> email();

  public abstract static class Builder {
    public abstract ImmutablePerson.Builder addAllEmail(Iterable<? extends EmailAddress> elements);

    /**
     * Email addresses this person is reachable under. Optional. Convenience function mapping {@link
     * String} to {@link EmailAddress}
     *
     * @param email Emails
     * @return This builder
     */
    public final ImmutablePerson.Builder addEmail(String... email) {
      return addAllEmail(
          Arrays.stream(email).map(EmailAddress::of).collect(ImmutableList.toImmutableList()));
    }
  }
}
