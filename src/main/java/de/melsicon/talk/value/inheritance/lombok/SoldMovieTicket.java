package de.melsicon.talk.value.inheritance.lombok;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.lombok.Person;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@SuppressWarnings({
  "MissingOverride",
  "MissingSummary",
  "MultiVariableDeclaration",
  "NullAway",
  "ParameterName",
  "Var",
})
@Immutable
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Value
public class SoldMovieTicket extends MovieTicket {
  // This needs to be the Lombok annotation
  @NonNull Person owner;
}
