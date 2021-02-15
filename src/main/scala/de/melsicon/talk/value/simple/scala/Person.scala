package de.melsicon.talk.value.simple.scala

import java.util

import org.checkerframework.checker.nullness.qual.Nullable

import scala.jdk.CollectionConverters._
import scala.jdk.OptionConverters._

final case class Person(
    givenName: String,
    surname: Option[String],
    email: Seq[String]
) {

  /** Java API: Construct a person
    *
    * @param givenName The given name. Required.
    * @param surname   The surname. Optional, i.e for royalty.
    * @param email     Email addresses this person is reachable under. Optional.
    */
  def this(
      givenName: String,
      @Nullable surname: String,
      @Nullable email: java.lang.Iterable[String]
  ) = {
    this(
      util.Objects.requireNonNull(givenName),
      Option(surname),
      if (email == null) Seq.empty else Seq.from(email.asScala)
    )
  }

  /** Java API: The given name of this person. Everyone has one.
    *
    * @return A name.
    */
  def getGivenName: String = givenName

  /** Java API: The surname of this person. Optional, i.e for royalty.
    *
    * @return An optional name
    */
  def getSurname: util.Optional[String] = surname.toJava

  /** Java API: Email addresses this person is reachable under.
    *
    * @return An immutable list of email addresses
    */
  def getEmail: util.List[String] = email.asJava
}
