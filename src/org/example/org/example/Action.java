package org.example;

import java.util.List;

public class Action {
    private String prev_action;
    private int time;

    private boolean is_critical;
    private String action_name;

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public boolean getIs_critical() {
        return is_critical;
    }

    public void setIs_critical(boolean is_critical) {
        this.is_critical = is_critical;
    }

    public String getPrev_action() {
        return prev_action;
    }

    public void setPrev_action(String prev_action) {
        this.prev_action = prev_action;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Action(String prev_action, int time, String action_name) {
        this.prev_action = prev_action;
        this.time = time;
        this.action_name = action_name;
    }

    public String[] robocza_nazwa_1() {
        String[] tmp = { action_name, Integer.toString(time), prev_action};
        return tmp;
    }

    @Override
    public String toString() {
        return "Action{" +
                "prev_action='" + prev_action + '\'' +
                ", time=" + time +
                ", action_name='" + action_name + '\'' +
                '}';
    }
}
