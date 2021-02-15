package de.melsicon.talk.value.simple.autovalue;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Optional;

/** Representation of a person. */
@Immutable
@AutoValue
public abstract class Person {
  /* package */ Person() {}

  /**
   * Creates a Person builder.
   *
   * @return A new builder
   */
  public static Builder builder() {
    return new AutoValue_Person.Builder().email();
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
  public abstract ImmutableList<String> email();

  /** Builder of a person instance */
  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Set the given name. Required.
     *
     * @param givenName A name
     * @return This builder
     */
    public abstract Builder givenName(String givenName);

    /**
     * Set the surname. Optional, i.e for royalty.
     *
     * @param surname A name
     * @return This builder
     */
    public abstract Builder surname(@Nullable String surname);

    /**
     * Email addresses this person is reachable under. Optional.
     *
     * @param email A list of emails
     * @return This builder
     */
    public abstract Builder email(Iterable<String> email);

    /**
     * Email addresses this person is reachable under. Optional.
     *
     * @param email Emails
     * @return This builder
     */
    public abstract Builder email(String... email);

    /**
     * Constructs a new person with the given parameters.
     *
     * @return A person
     */
    public abstract Person build();
  }
}
