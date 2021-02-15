package de.melsicon.talk.value.simple.lombok;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;
import static org.junit.Assert.assertThrows;

@SuppressWarnings("NullAway")
public final class PersonTest {
  @Test
  public void creation() {
    var person =
        Person.builder().givenName("Peter").surname("Pan").email("peter.pan@example.com").build();

    assertThat(person.getGivenName()).isEqualTo("Peter");

    assertThat(person.getSurname()).hasValue("Pan");

    assertThat(person.getEmail()).containsExactly("peter.pan@example.com");
  }

  @Test
  public void defaults() {
    var person = Person.builder().givenName("Charles").build();

    assertThat(person.getGivenName()).isEqualTo("Charles");

    assertThat(person.getSurname()).isEmpty();

    assertThat(person.getEmail()).isEmpty();
  }

  @Test
  public void required() {
    var ex = assertThrows(NullPointerException.class, () -> Person.builder().build());
    assertThat(ex).hasMessageThat().contains("givenName");
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    var ex = assertThrows(NullPointerException.class, () -> Person.builder().givenName(null));
    assertThat(ex).hasMessageThat().contains("givenName");
  }
}