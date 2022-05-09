package ru.netology;

public class TicketData implements Comparable<TicketData> {
  private int id;
  private int price;
  private String departureAirport;
  private String arrivalAirport;
  private int travelTime;

  public TicketData(int id, int price, String departureAirport, String
      arrivalAirport, int travelTime) {
    this.id = id;
    this.price = price;
    this.departureAirport = departureAirport;
    this.arrivalAirport = arrivalAirport;
    this.travelTime = travelTime;
  }

  private int getPrice() {
    return price;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public int getId() {
    return id;
  }

  //TODO сортировка по цене от меньшей к большей
  public int compareTo(TicketData o) {
    TicketData ticketData = (TicketData) o;
    return this.price - ticketData.price;
  }

}
