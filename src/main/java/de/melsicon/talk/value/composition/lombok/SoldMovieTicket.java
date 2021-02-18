package de.melsicon.talk.value.composition.lombok;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.lombok.Person;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@SuppressWarnings({
  "FieldMissingNullable",
  "MissingSummary",
  "MultiVariableDeclaration",
  "NullAway",
  "ParameterName",
  "Var",
})
@Immutable
@Builder
@Value
public class SoldMovieTicket {
  // This needs to be the Lombok annotation
  @NonNull MovieTicket ticket;

  @NonNull Person owner;
}
