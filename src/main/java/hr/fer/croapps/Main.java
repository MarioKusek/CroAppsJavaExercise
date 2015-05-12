package hr.fer.croapps;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // created list
        List<ScheduleEntry> list = new LinkedList<ScheduleEntry>();

        // fill in list with 10 objects
        for (int i = 0; i < 10; i++) {
            ScheduleEntry entry = new ScheduleEntry();
            entry.setTitle("title-" + i);
            entry.setRoom("A-" + i);
            entry.setTime("12:0" + i);
            list.add(entry);
        }

        // print list
        for(ScheduleEntry e: list) {
            System.out.println(e);
        }
    }
}
