package de.melsicon.talk.value.inheritance.lombok;

import com.google.errorprone.annotations.Immutable;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings({
  "MissingSummary",
  "MultiVariableDeclaration",
  "NullAway",
  "ParameterName",
  "UnnecessarilyFullyQualified",
  "Var",
})
@Immutable
@SuperBuilder
@NonFinal
@Value
public class MovieTicket {
  @NonNull String movieName;

  long serial;
}
