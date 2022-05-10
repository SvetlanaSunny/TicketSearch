package ru.netology;

import java.util.Arrays;

public class ManagerTicket {
  private RepositoryTicket ticketData;

  public ManagerTicket(RepositoryTicket ticketData) {
    this.ticketData = ticketData;
  }

  public void addManagerTicket(TicketData tickets) {
    ticketData.addTicket(tickets);
  }

  public boolean searchByFrom(TicketData ticket, String searchFrom, String searchTo) {
    if (ticket.getDepartureAirport().contains(searchFrom)
        && ticket.getArrivalAirport().contains(searchTo)) {
      return true;
    } else {
      return false;
    }
  }

  public TicketData[] findAll(String from, String to) {
    TicketData[] result = new TicketData[0];
    for (TicketData ticket : ticketData.getAll()) {
      if (searchByFrom(ticket, from, to)) {
        TicketData[] newResult = new TicketData[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          newResult[i] = result[i];
        }
        newResult[newResult.length - 1] = ticket;
        result = newResult;
      }
    }
    Arrays.sort(result);
    return result;
  }

}
