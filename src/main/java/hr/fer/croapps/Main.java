package hr.fer.croapps;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // created list
        List<ScheduleEntry> list;

        HttpScheduleReader reader = new HttpScheduleReader();
        reader.fetchSchedule();
        list = reader.getList();

        // print list
        for(ScheduleEntry e: list) {
            System.out.println(e);
        }
    }
}
