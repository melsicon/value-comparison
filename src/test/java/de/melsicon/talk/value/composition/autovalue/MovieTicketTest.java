package de.melsicon.talk.value.composition.autovalue;

import com.google.common.collect.ImmutableMap;
import de.melsicon.talk.value.simple.autovalue.Person;
import org.junit.Test;

import java.util.Objects;

import static com.google.common.truth.Truth.assertThat;

public final class MovieTicketTest {
  private static final String MOVIE_NAME = "The Favourite";
  private static final long SERIAL = 1L;
  private static final long AVAILABLE_SERIAL = SERIAL + 1L;

  private static MovieTicket createTicket(long l) {
    return MovieTicket.builder().movieName(MOVIE_NAME).serial(l).build();
  }

  private static ImmutableMap<MovieTicket, SoldMovieTicket> soldTickets() {
    var soldTicket =
        SoldMovieTicket.builder()
            .ticket(createTicket(SERIAL))
            .owner(Person.builder().givenName("Charles").build())
            .build();

    return ImmutableMap.of(soldTicket.ticket(), soldTicket);
  }

  @Test
  public void sellTicket() {
    var tickets = soldTickets();

    var ticket1 = createTicket(SERIAL);
    var ticket2 = createTicket(AVAILABLE_SERIAL);

    assertThat(tickets).containsKey(ticket1);
    assertThat(tickets).doesNotContainKey(ticket2);

    assertThat(Objects.requireNonNull(tickets.get(ticket1)).ticket()).isEqualTo(ticket1);
  }
}
