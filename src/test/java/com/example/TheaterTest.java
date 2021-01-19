package com.example;

import com.example.chapter01.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TheaterTest {

    @Test
    void 초대받은_사람이_입장한다() {
        //given

        //만원의 현금을 갖고있는 초대받은 사람
        Invitation invitation = new Invitation(LocalDateTime.of(2021, 1, 13, 14, 0));
        Bag bag = new Bag(invitation, 10000L);
        Audience audience = new Audience(bag);

        // 티켓 5장을 갖고있는 영화관
        TicketOffice ticketOffice = new TicketOffice(0L,
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L)
        );

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        //when
        theater.enter(audience);

        //then
        Assertions.assertEquals(4, ticketOffice.getTickets().size(), "남은 티켓 수량은 4장이다.");
        Assertions.assertEquals(0L, ticketOffice.getAmount(), "매표소가 보유한 현금은 0원 이다.");
        Assertions.assertEquals(10000L, audience.getAmount(), "매표소가 보유한 현금은 10000원 이다.");
    }

    @Test
    void 초대받지_못한_사람이_입장한다() {
        //given

        //만원의 현금을 갖고있는 초대받지 못한 사람
        Bag bag = new Bag( 10000L);
        Audience audience = new Audience(bag);

        // 티켓 5장을 갖고있는 영화관
        TicketOffice ticketOffice = new TicketOffice(0L,
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L),
                new Ticket(5000L)
        );

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        //when
        theater.enter(audience);

        //then
        Assertions.assertEquals(4, ticketOffice.getTickets().size(), "남은 티켓 수량은 4장이다.");
        Assertions.assertEquals(5000L, ticketOffice.getAmount(), "매표소가 보유한 현금은 5000원 이다.");
        Assertions.assertEquals(5000L, audience.getAmount(), "매표소가 보유한 현금은 5000원 이다.");
    }

}