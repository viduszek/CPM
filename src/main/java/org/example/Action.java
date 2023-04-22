package org.example;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private String next_action;
    private int time, id;
    private List<Action> next_actions;
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
        return next_action;
    }

    public void setPrev_action(String next_action) {
        this.next_action = next_action;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Action(String next_action, int time, String action_name) {
        this.next_action = next_action;
        this.time = time;
        this.action_name = action_name;
    }

    public Action() {
        this.action_name = "";
        this.time = 0;
        this.next_action = "";
        this.next_actions = new ArrayList<>();
        this.id = -1;
    }

    public String[] robocza_nazwa_1() {
        String[] tmp = new String[] { Integer.toString(id), action_name, Integer.toString(time), next_action };
        return tmp;
    }

    @Override
    public String toString() {
        return "Action{" +
                "next_action='" + next_action + '\'' +
                ", time=" + time +
                ", action_name='" + action_name + '\'' +
                '}';
    }

    public void set_id(int new_id) {
        this.id = new_id;
    }

    public int get_id() {
        return id;
    }

    public void convert_next() {
        List<Action> tmp1 = new ArrayList<>();
        String[] tmp2 = next_action.split(" ");
        int i = 0;
        for (String s : tmp2) {
            tmp1.add(new Action());
            tmp1.get(i).set_id(Integer.parseInt(s));
        }
        this.next_actions = tmp1;
    }
}
