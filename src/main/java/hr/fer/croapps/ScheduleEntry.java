package hr.fer.croapps;

import java.io.Serializable;

public class ScheduleEntry implements Serializable {
    private String room;
    private String title;
    private String time;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScheduleEntry{" +
                "room='" + room + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
