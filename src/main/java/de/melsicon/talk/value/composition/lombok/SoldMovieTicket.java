package de.melsicon.talk.value.composition.lombok;

import com.google.errorprone.annotations.Immutable;
import de.melsicon.talk.value.simple.lombok.Person;
import lombok.Builder;
import lombok.Value;
import org.checkerframework.checker.nullness.qual.NonNull;

@SuppressWarnings({
  "MissingSummary",
  "MultiVariableDeclaration",
  "SameNameButDifferent",
  "UnnecessarilyFullyQualified",
  "Var",
  "allcheckers:type.anno.before",
  "nullness:initialization.fields.uninitialized",
})
@Immutable
@Builder
@Value
public class SoldMovieTicket {
  @NonNull MovieTicket ticket;

  @NonNull Person owner;
}
