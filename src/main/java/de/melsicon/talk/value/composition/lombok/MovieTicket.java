package de.melsicon.talk.value.composition.lombok;

import com.google.errorprone.annotations.Immutable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@SuppressWarnings({
  "FieldMissingNullable",
  "MissingSummary",
  "MultiVariableDeclaration",
  "NullAway",
  "ObjectToString",
  "ParameterName",
  "Var",
})
@Immutable
@Builder
@Value
public class MovieTicket {
  // This needs to be the Lombok annotation
  @NonNull String movieName;

  long serial;
}
