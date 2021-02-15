package de.melsicon.talk.value.simple.record;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

public final class PersonTest {
  @Test
  public void creation() {
    var person = new Person("Peter", "Pan", ImmutableList.of("peter.pan@example.com"));

    assertThat(person.givenName()).isEqualTo("Peter");

    assertThat(person.surname()).isEqualTo("Pan");

    assertThat(person.email()).containsExactly("peter.pan@example.com");
  }

  @Test
  public void defaults() {
    var person = new Person("Charles", null, ImmutableList.of());

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
