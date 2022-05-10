package ru.netology;

import java.util.Arrays;

public class RepositoryTicket {
  private TicketData[] tickets = new TicketData[0];

  public void addTicket(TicketData ticket) {
    TicketData[] newTickets = new TicketData[tickets.length + 1];
    for (int i = 0; i < tickets.length; i++) {
      newTickets[i] = tickets[i];
    }
    newTickets[newTickets.length - 1] = ticket;
    tickets = newTickets;
  }

  public void removeTicketById(int id) {
    TicketData[] newTickets = new TicketData[tickets.length - 1];
    int i = 0;
    for (TicketData ticket : tickets) {
      if (ticket.getId() != id) {
        newTickets[i] = ticket;
        i++;
      }
    }
    tickets = newTickets;
  }

  public TicketData[] getAll() {
    return tickets;
  }
}
