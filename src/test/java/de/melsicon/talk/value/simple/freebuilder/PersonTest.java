package de.melsicon.talk.value.simple.freebuilder;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;
import static org.junit.Assert.assertThrows;

public final class PersonTest {
  @Test
  public void creation() {
    var person =
        Person.builder()
            .givenName("Peter")
            .surname("Pan")
            .addEmail("peter.pan@example.com")
            .build();

    assertThat(person.givenName()).isEqualTo("Peter");

    assertThat(person.surname()).hasValue("Pan");

    assertThat(person.email()).containsExactly("peter.pan@example.com");
  }

  @Test
  public void defaults() {
    var person = Person.builder().givenName("Charles").build();

    assertThat(person.givenName()).isEqualTo("Charles");

    assertThat(person.surname()).isEmpty();

    assertThat(person.email()).isEmpty();
  }

  @Test
  public void required() {
    var ex = assertThrows(IllegalStateException.class, () -> Person.builder().build());
    assertThat(ex).hasMessageThat().contains("givenName");
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    assertThrows(NullPointerException.class, () -> Person.builder().givenName(null));
  }
}
