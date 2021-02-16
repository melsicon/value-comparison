package de.melsicon.talk.value.simple.kotlin;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class EmailAddressTest {
  @Test
  public void creation() {
    var email = new EmailAddress("peter.pan@example.com");

    assertThat(email.getAddress()).isEqualTo("peter.pan@example.com");
  }

  @Test
  public void valid() {
    var ex = assertThrows(IllegalArgumentException.class, () -> new EmailAddress("null"));
    assertThat(ex).hasMessageThat().contains("address");
  }

  @Test
  @SuppressWarnings({"NullAway", "argument.type.incompatible"})
  public void notNull() {
    var ex = assertThrows(NullPointerException.class, () -> new EmailAddress(null));
    assertThat(ex).hasMessageThat().contains("address");
  }
}
