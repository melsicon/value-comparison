package de.melsicon.talk.value;

import com.google.common.collect.ImmutableList;
import com.google.common.flogger.FluentLogger;

import java.util.List;

public final class Main {
  private static final FluentLogger log = FluentLogger.forEnclosingClass();
  private static final String EMAIL = "peter.pan@example.com";
  private static final String SURNAME = "Pan";
  private static final String GIVEN_NAME = "Peter";

  private Main() {}

  public static void main(String... args) {
    log.atInfo().log("Autovalue: %s", autovalue());
    log.atInfo().log("FreeBuilder: %s", freebuilder());
    log.atInfo().log("Immutables: %s", immutables());
    log.atInfo().log("Kotlin: %s", kotlin());
    log.atInfo().log("Lombok: %s", lombok());
    log.atInfo().log("Pojo: %s", pojo());
    log.atInfo().log("Scala: %s", scala());
  }

  private static de.melsicon.talk.value.simple.autovalue.Person autovalue() {
    return de.melsicon.talk.value.simple.autovalue.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .email(EMAIL)
        .build();
  }

  private static de.melsicon.talk.value.simple.freebuilder.Person freebuilder() {
    return de.melsicon.talk.value.simple.freebuilder.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .addEmail(EMAIL)
        .build();
  }

  private static de.melsicon.talk.value.simple.immutables.Person immutables() {
    return de.melsicon.talk.value.simple.immutables.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .addEmail(EMAIL)
        .build();
  }

  private static de.melsicon.talk.value.simple.kotlin.Person kotlin() {
    return new de.melsicon.talk.value.simple.kotlin.Person(GIVEN_NAME, SURNAME, List.of(EMAIL));
  }

  private static de.melsicon.talk.value.simple.lombok.Person lombok() {
    return de.melsicon.talk.value.simple.lombok.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .email(EMAIL)
        .build();
  }

  private static de.melsicon.talk.value.simple.pojo.Person pojo() {
    return new de.melsicon.talk.value.simple.pojo.Person(
        GIVEN_NAME, SURNAME, ImmutableList.of(EMAIL));
  }

  private static de.melsicon.talk.value.simple.scala.Person scala() {
    return new de.melsicon.talk.value.simple.scala.Person(GIVEN_NAME, SURNAME, List.of(EMAIL));
  }
}