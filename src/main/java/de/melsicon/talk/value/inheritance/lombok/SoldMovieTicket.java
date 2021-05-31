package de.melsicon.talk.value.inheritance.lombok;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.lombok.Person;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings({
  "MissingOverride",
  "MissingSummary",
  "MultiVariableDeclaration",
  "UnnecessarilyFullyQualified",
  "Var",
  "allcheckers:type.anno.before",
  "nullness:initialization.field.uninitialized",
})
@Immutable
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Value
public class SoldMovieTicket extends MovieTicket {
  @NonNull Person owner;
}
