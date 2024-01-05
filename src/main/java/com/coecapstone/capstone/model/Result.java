package com.coecapstone.capstone.model;

public class Result {

  private String month;
  private int bidding_no;
  private String vehicle_class;
  private int quota;
  private int bids_success;
  private int bids_received;
  private int premium;

  public Result() {}

  public Result(
    String month,
    int bidding_no,
    String vehicle_class,
    int quota,
    int bids_success,
    int bids_received,
    int premium
  ) {
    this.month = month;
    this.bidding_no = bidding_no;
    this.vehicle_class = vehicle_class;
    this.quota = quota;
    this.bids_success = bids_success;
    this.bids_received = bids_received;
    this.premium = premium;
  }

  public String getMonth() {
    return this.month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public int getBidding_no() {
    return this.bidding_no;
  }

  public void setBidding_no(int bidding_no) {
    this.bidding_no = bidding_no;
  }

  public String getVehicle_class() {
    return this.vehicle_class;
  }

  public void setVehicle_class(String vehicle_class) {
    this.vehicle_class = vehicle_class;
  }

  public int getQuota() {
    return this.quota;
  }

  public void setQuota(int quota) {
    this.quota = quota;
  }

  public int getBids_success() {
    return this.bids_success;
  }

  public void setBids_success(int bids_success) {
    this.bids_success = bids_success;
  }

  public int getBids_received() {
    return this.bids_received;
  }

  public void setBids_received(int bids_received) {
    this.bids_received = bids_received;
  }

  public int getPremium() {
    return this.premium;
  }

  public void setPremium(int premium) {
    this.premium = premium;
  }
}
