package de.melsicon.talk.value.simple.pojo;

import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;
import static org.junit.Assert.assertThrows;

public final class PersonTest {
  @Test
  public void creation() {
    var person = new Person("Peter", "Pan", List.of("peter.pan@example.com"));

    assertThat(person.givenName()).isEqualTo("Peter");

    assertThat(person.surname()).hasValue("Pan");

    assertThat(person.email()).containsExactly("peter.pan@example.com");
  }

  @Test
  public void defaults() {
    var person = new Person("Charles", null, null);

    assertThat(person.givenName()).isEqualTo("Charles");

    assertThat(person.surname()).isEmpty();

    assertThat(person.email()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    var ex = assertThrows(NullPointerException.class, () -> new Person(null, null, null));
    assertThat(ex).hasMessageThat().contains("givenName");
  }
}
