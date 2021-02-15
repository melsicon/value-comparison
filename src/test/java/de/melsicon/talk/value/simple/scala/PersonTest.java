package de.melsicon.talk.value.simple.scala;

import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;
import static org.junit.Assert.assertThrows;

public final class PersonTest {
  @Test
  public void creation() {
    var person = new Person("Peter", "Pan", List.of("peter.pan@example.com"));

    assertThat(person.getGivenName()).isEqualTo("Peter");

    assertThat(person.getSurname()).hasValue("Pan");

    assertThat(person.getEmail()).containsExactly("peter.pan@example.com");
  }

  @Test
  public void defaults() {
    var person = new Person("Charles", null, (List<String>) null);

    assertThat(person.getGivenName()).isEqualTo("Charles");

    assertThat(person.getSurname()).isEmpty();

    assertThat(person.getEmail()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    assertThrows(NullPointerException.class, () -> new Person(null, null, (List<String>) null));
  }
}
