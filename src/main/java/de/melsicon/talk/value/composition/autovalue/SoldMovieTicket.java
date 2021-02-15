package de.melsicon.talk.value.composition.autovalue;

import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.autovalue.Person;

@Immutable
@AutoValue
public abstract class SoldMovieTicket {
  /* package */ SoldMovieTicket() {}

  public static Builder builder() {
    return new AutoValue_SoldMovieTicket.Builder();
  }

  public abstract MovieTicket ticket();

  public abstract Person owner();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder ticket(MovieTicket ticket);

    public abstract Builder owner(Person owner);

    public abstract SoldMovieTicket build();
  }
}
