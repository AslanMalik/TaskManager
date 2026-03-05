package kz.tasks.application.db;

import kz.tasks.application.entity.Task;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static int id = 1;
    @Getter
    private static ArrayList<Task> list = new ArrayList<>();

    public static void addTask(Task s) {
        s.setId(id);
        id++;
        list.add(s);
    }

    public static ArrayList<Task> getTasks() {
        return list;
    }


    public static void replaceTask(Task t) {
        for (Task s: list) {
            if(t.getId() == s.getId()) {
                s.setName(t.getName());
                s.setDeadlineDate(t.getDeadlineDate());
                s.setCompleted(t.isCompleted());
            }
        }
    }

    public static void deleteTask(int id) {
        list.removeIf(id1 -> id1.getId() == id );
    }

    public static Task getTaskById(int id) {
        return list.stream().filter(s-> s.getId()==id).findFirst().get();
    }


}