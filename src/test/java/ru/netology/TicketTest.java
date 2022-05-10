package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketTest {
  @Test
  public void addTicket() {
    RepositoryTicket tickets = new RepositoryTicket();
    TicketData ticketMoskow = new TicketData(1, 2500, "DME", "EGO", 3600);
    TicketData ticketSamara = new TicketData(2, 2600, "DME", "KUF", 3300);
    TicketData ticketVlad = new TicketData(3, 3600, "DME", "OGZ", 3900);
    tickets.addTicket(ticketMoskow);
    tickets.addTicket(ticketVlad);
    tickets.addTicket(ticketSamara);
    TicketData[] actual = tickets.getAll();
    TicketData[] expected = {ticketMoskow, ticketSamara, ticketVlad};
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void removeTicket() {
    RepositoryTicket tickets = new RepositoryTicket();
    TicketData ticketMoskow = new TicketData(1, 2500, "DME", "EGO", 3600);
    TicketData ticketSamara = new TicketData(2, 2600, "DME", "KUF", 3300);
    TicketData ticketVlad = new TicketData(4, 3200, "DME", "OGZ", 3700);
    tickets.addTicket(ticketMoskow);
    tickets.addTicket(ticketVlad);
    tickets.addTicket(ticketSamara);
    tickets.removeTicketById(2);
    TicketData[] actual = tickets.getAll();
    TicketData[] expected = {ticketMoskow, ticketVlad};
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void findAllTicket() {
    RepositoryTicket tickets = new RepositoryTicket();
    ManagerTicket managerTicket = new ManagerTicket(tickets);
    TicketData ticketMoskow = new TicketData(1, 2500, "DME", "EGO", 3600);
    TicketData ticketSamara = new TicketData(2, 2600, "DME", "KUF", 3300);
    TicketData ticketVlad = new TicketData(3, 3200, "DME", "OGZ", 4100);
    TicketData ticketVladS = new TicketData(4, 3600, "DME", "OGZ", 3900);
    managerTicket.addManagerTicket(ticketVladS);
    managerTicket.addManagerTicket(ticketMoskow);
    managerTicket.addManagerTicket(ticketSamara);
    managerTicket.addManagerTicket(ticketVlad);
    TicketData[] actual = managerTicket.findAll("DME", "OGZ", new TicketByTimeAscComparator());
    TicketData[] expected = {ticketVladS, ticketVlad};
    Assertions.assertArrayEquals(expected, actual);
  }

}