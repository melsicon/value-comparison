package de.melsicon.talk.value.inheritance.freebuilder;

import com.google.common.collect.ImmutableMap;
import de.melsicon.talk.value.simple.freebuilder.Person;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public final class MovieTicketTest {
  private static final String MOVIE_NAME = "The Favourite";
  private static final long SERIAL = 1L;

  private static MovieTicket createTicket(long l) {
    return MovieTicket.builder().movieName(MOVIE_NAME).serial(l).build();
  }

  private static ImmutableMap<MovieTicket, SoldMovieTicket> soldTickets() {
    var soldTicket =
        SoldMovieTicket.builder()
            .movieName(MOVIE_NAME)
            .serial(SERIAL)
            .owner(Person.builder().givenName("Charles").build())
            .build();

    return ImmutableMap.of(soldTicket, soldTicket);
  }

  @Test
  public void sellTicket() {
    var tickets = soldTickets();

    var ticket = createTicket(SERIAL);

    assertThat(tickets).doesNotContainKey(ticket);
  }
}
