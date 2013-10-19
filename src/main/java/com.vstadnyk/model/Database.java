package com.vstadnyk.model;

/**
 * Date: 10/19/13
 * Time: 1:15 PM
 */
public class Database {
    private String host;
    private String ip;
    private State state = State.NEW;

    public Database(String host, String ip) {
        this.host = host;
        this.ip = ip;
        state = State.INITIALISED;
    }

    public void destroy(){
        this.state = State.DESTROYED;
    }

    public enum State{
        NEW, INITIALISED, IN_USE, DESTROYED
    }

    @Override
    public String toString() {
        return "Database{" +
                "host='" + host + '\'' +
                ", ip='" + ip + '\'' +
                ", state=" + state +
                '}';
    }
}
