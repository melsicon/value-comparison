package de.melsicon.talk.value.simple.record;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

public final class PersonTest {
  @Test
  public void creation() {
    var person =
        new Person("Peter", "Pan", ImmutableSet.of(EmailAddress.of("peter.pan@example.com")));

    assertThat(person.givenName()).isEqualTo("Peter");

    assertThat(person.surname()).isEqualTo("Pan");

    assertThat(person.email()).containsExactly(EmailAddress.of("peter.pan@example.com"));
  }

  @Test
  public void defaults() {
    var person = new Person("Charles", null, ImmutableSet.of());

    assertThat(person.givenName()).isEqualTo("Charles");

    assertThat(person.surname()).isNull();

    assertThat(person.email()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    assertThrows(NullPointerException.class, () -> new Person(null, null, null));
  }
}
