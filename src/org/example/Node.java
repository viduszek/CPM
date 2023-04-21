package org.example;

import java.util.List;

public class Node {
    private int id;
    private double earliest_start;
    private double latest_start;
    private double reserve;

    public int getId() {
        return id;
    }

    public double getEarliest_start() {
        return earliest_start;
    }

    public void setEarliest_start(double earliest_start) {
        this.earliest_start = earliest_start;
    }

    public double getLatest_start() {
        return latest_start;
    }

    public void setLatest_start(double latest_start) {
        this.latest_start = latest_start;
    }

    public double getReserve() {
        return reserve;
    }

    public void setReserve(double reserve) {
        this.reserve = reserve;
    }

}
