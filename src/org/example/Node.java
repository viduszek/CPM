package org.example;

import java.util.List;

public class Node {
    private List<Node> prev_nodes;
    private int id;
    private double earliest_start;
    private double latest_start;
    private double reserve;
    private double time;

    public List<Node> getPrev_nodes() {
        return prev_nodes;
    }

    public int getId() {
        return id;
    }

    public double getTime() {
        return time;
    }

    public double getEarliest_start() {
        return earliest_start;
    }

    public void setEarliest_start(double earliest_start) {
        this.earliest_start = earliest_start;
    }

    @Override
    public String toString() {
        return "Node{" +
                "prev_nodes=" + prev_nodes +
                ", id=" + id +
                ", time=" + time +
                '}';
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

    public Node(List<Node> prev_nodes, int id, double time) {
        this.prev_nodes = prev_nodes;
        this.id = id;
        this.time = time;
    }
}
