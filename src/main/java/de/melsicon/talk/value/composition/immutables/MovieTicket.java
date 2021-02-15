package de.melsicon.talk.value.composition.immutables;

import com.google.errorprone.annotations.Immutable;
import org.immutables.value.Value;

@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public abstract class MovieTicket {
  /* package */ MovieTicket() {}

  public static ImmutableMovieTicket.Builder builder() {
    return ImmutableMovieTicket.builder();
  }

  public abstract String movieName();

  public abstract long serial();
}
