package de.melsicon.talk.value.composition.immutables;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.immutables.Person;
import org.immutables.value.Value;

@Immutable
@Value.Style(passAnnotations = {Immutable.class})
@Value.Immutable
public abstract class SoldMovieTicket {
  /* package */ SoldMovieTicket() {}

  public static ImmutableSoldMovieTicket.Builder builder() {
    return ImmutableSoldMovieTicket.builder();
  }

  public abstract MovieTicket ticket();

  public abstract Person owner();
}
