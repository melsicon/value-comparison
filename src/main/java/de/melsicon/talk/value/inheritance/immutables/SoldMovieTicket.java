package de.melsicon.talk.value.inheritance.immutables;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.immutables.Person;
import org.immutables.value.Value;

@SuppressWarnings("immutables:subtype")
@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public interface SoldMovieTicket extends MovieTicket {
  static ImmutableSoldMovieTicket.Builder builder() {
    return ImmutableSoldMovieTicket.builder();
  }

  Person owner();
}
