package com.netcracker.eductr.j2se.tasks.tests.arrayTaskList;

import com.netcracker.eductr.j2se.tasks.ArrayTaskList;
import com.netcracker.eductr.j2se.tasks.Task;

import java.util.Arrays;
import java.util.List;

public class ArrayTaskListUtils {

    /**
     * Creates list of given tasks
     */
    public static ArrayTaskList listOf(Task... tasks) {
        ArrayTaskList ts = new ArrayTaskList();
        for (Task task: tasks) {
            ts.add(task);
        }
        return ts;
    }

    /**
     * Extracts tasks from list
     */
    public static List<Task> elementsOf(ArrayTaskList tasks) {
        Task[] elements = new Task[tasks.size()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = tasks.getTask(i);
        }
        return Arrays.asList(elements);
    }
}
