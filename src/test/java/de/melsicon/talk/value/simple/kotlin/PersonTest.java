package de.melsicon.talk.value.simple.kotlin;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.List;
import org.junit.Test;

public final class PersonTest {
  @Test
  public void creation() {
    var person = new Person("Peter", "Pan", List.of(EmailAddress.of("peter.pan@example.com")));

    assertThat(person.getGivenName()).isEqualTo("Peter");

    assertThat(person.getSurname()).isEqualTo("Pan");

    assertThat(person.getEmail()).containsExactly(EmailAddress.of("peter.pan@example.com"));
  }

  @Test
  public void defaults() {
    var person = new Person("Charles", null, List.of());

    assertThat(person.getGivenName()).isEqualTo("Charles");

    assertThat(person.getSurname()).isNull();

    assertThat(person.getEmail()).isEmpty();
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    var ex = assertThrows(NullPointerException.class, () -> new Person(null, null, null));
    assertThat(ex).hasMessageThat().contains("givenName");
  }
}
