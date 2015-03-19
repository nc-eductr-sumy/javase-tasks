package com.netcracker.eductr.j2se.tasks.tests.taskList;

import com.netcracker.eductr.j2se.tasks.ArrayTaskList;
import com.netcracker.eductr.j2se.tasks.LinkedTaskList;
import com.netcracker.eductr.j2se.tasks.Task;
import com.netcracker.eductr.j2se.tasks.TaskList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class TaskListTestsBase {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Parameterized.Parameters(name = "testing {1}")
    public static Iterable<Object[]> classesToTest() {
        return Arrays.asList(new Object[][]{
                {ArrayTaskList.class,  "ArrayTaskList"},
                {LinkedTaskList.class, "LinkedTaskList"}
        });
    }

    @Parameterized.Parameter(0)
    public Class<? extends TaskList> classToTest;

    @Parameterized.Parameter(1)
    public String classToTestTitle;

    protected Task taskA, taskB, taskC, taskD;

    @Before
    public void createTasks() {
        taskA = new Task("A", 0);
        taskB = new Task("B", 0);
        taskC = new Task("C", 0);
        taskD = new Task("D", 0);
    }


    protected Task task(int time) {
        Task task = new Task("Title", time);
        task.setActive(true);
        return task;
    }

    protected Task task(int start, int end, int interval) {
        Task task = new Task("Title", start, end, interval);
        task.setActive(true);
        return task;
    }

    protected TaskList listOf(Task... tasks) {
        try {
            TaskList ts = classToTest.newInstance();
            for (Task task: tasks) {
                ts.add(task);
            }
            return ts;
        }
        catch (ReflectiveOperationException e) {
            throw new AssertionError("Cannot create instance of "+ classToTest +" using default constructor", e);
        }
    }

    protected List<Task> elementsOf(TaskList tasks) {
        Task[] elements = new Task[tasks.size()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = tasks.getTask(i);
        }
        return Arrays.asList(elements);
    }
}
