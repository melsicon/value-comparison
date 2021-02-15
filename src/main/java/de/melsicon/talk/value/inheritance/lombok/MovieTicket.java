package de.melsicon.talk.value.inheritance.lombok;

import com.google.errorprone.annotations.Immutable;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@SuppressWarnings({
  "MissingSummary",
  "MultiVariableDeclaration",
  "NullAway",
  "ParameterName",
  "Var",
})
@Immutable
@SuperBuilder
@NonFinal
@Value
public class MovieTicket {
  // This needs to be the Lombok annotation
  @NonNull String movieName;

  long serial;
}
