package de.melsicon.talk.value;

import com.google.common.flogger.FluentLogger;
import de.melsicon.talk.value.simple.lombok.EmailAddress;

public final class Main {
  private static final FluentLogger log = FluentLogger.forEnclosingClass();
  private static final String EMAIL = "peter.pan@example.com";
  private static final String EMAIL2 = "wendy.darling@example.com";
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
        .email(EMAIL, EMAIL2)
        .build();
  }

  private static de.melsicon.talk.value.simple.freebuilder.Person freebuilder() {
    return de.melsicon.talk.value.simple.freebuilder.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .addEmail(EMAIL, EMAIL2)
        .build();
  }

  private static de.melsicon.talk.value.simple.immutables.Person immutables() {
    return de.melsicon.talk.value.simple.immutables.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .addEmail(EMAIL, EMAIL2)
        .build();
  }

  private static de.melsicon.talk.value.simple.kotlin.Person kotlin() {
    return de.melsicon.talk.value.simple.kotlin.Person.of(GIVEN_NAME, SURNAME, EMAIL, EMAIL2);
  }

  private static de.melsicon.talk.value.simple.lombok.Person lombok() {
    return de.melsicon.talk.value.simple.lombok.Person.builder()
        .givenName(GIVEN_NAME)
        .surname(SURNAME)
        .email(EmailAddress.of(EMAIL))
        .email(EmailAddress.of(EMAIL2))
        .build();
  }

  private static de.melsicon.talk.value.simple.pojo.Person pojo() {
    return de.melsicon.talk.value.simple.pojo.Person.of(GIVEN_NAME, SURNAME, EMAIL, EMAIL2);
  }

  private static de.melsicon.talk.value.simple.scala.Person scala() {
    return de.melsicon.talk.value.simple.scala.Person.of(GIVEN_NAME, SURNAME, EMAIL, EMAIL2);
  }
}
