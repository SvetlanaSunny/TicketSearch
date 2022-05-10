package ru.netology;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketData> {
  public int compare(TicketData o1, TicketData o2) {
    return o1.travelTime() - o2.travelTime();
  }
}