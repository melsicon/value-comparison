package de.melsicon.talk.value.simple.freebuilder;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Optional;
import org.inferred.freebuilder.FreeBuilder;

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
  ImmutableList<EmailAddress> email();

  /** Builder of a person instance */
  class Builder extends Person_Builder {
    /**
     * Email addresses this person is reachable under. Optional. Convenience function mapping {@link
     * String} to {@link EmailAddress}
     *
     * @param email Emails
     * @return This builder
     */
    public final Builder addEmail(String... email) {
      return addAllEmail(Arrays.stream(email).map(EmailAddress::of));
    }
  }
}
