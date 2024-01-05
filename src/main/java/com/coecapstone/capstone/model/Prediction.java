package com.coecapstone.capstone.model;

public class Prediction {

  private String category;
  private Float prediction;
  private int quota;

  public Prediction() {}

  public Prediction(String category, Float prediction, int quota) {
    this.category = category;
    this.prediction = prediction;
    this.quota = quota;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Float getPrediction() {
    return this.prediction;
  }

  public void setPrediction(Float prediction) {
    this.prediction = prediction;
  }

  public int getQuota() {
    return this.quota;
  }

  public void setQuota(int quota) {
    this.quota = quota;
  }
}
