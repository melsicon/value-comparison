package de.melsicon.talk.value.inheritance.immutables;

import com.google.errorprone.annotations.Immutable;
import org.immutables.value.Value;

@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public interface MovieTicket {
  static ImmutableMovieTicket.Builder builder() {
    return ImmutableMovieTicket.builder();
  }

  String movieName();

  long serial();
}
