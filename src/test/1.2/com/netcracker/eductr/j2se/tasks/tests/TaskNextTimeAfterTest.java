package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskNextTimeAfterTest {

    final int NEVER = -1;

    @Test
    public void nextTimeAfterShouldNotChangeAnything() {
        Task task = new Task("some", 10);
        task.setActive(true);
        assertEquals(
                "first call Task(\"some\", 10).nextTimeAfter(0)",
                10,
                task.nextTimeAfter(0));
        assertEquals(
                "second call Task(\"some\", 10).nextTimeAfter(0)",
                10,
                task.nextTimeAfter(0));
    }

    @Test
    public void testNextTimeAfterForNonRecurrent() {
        Task task = new Task("some", 10);
        task.setActive(true);
        assertEquals(
                "Task(\"some\", 10).nextTimeAfter(0)",
                10,
                task.nextTimeAfter(0));
        assertEquals(
                "Task(\"some\", 10).nextTimeAfter(9)",
                10,
                task.nextTimeAfter(9));
        assertEquals(
                "Task(\"some\", 10).nextTimeAfter(10)",
                NEVER,
                task.nextTimeAfter(10));
        assertEquals(
                "Task(\"some\", 10).nextTimeAfter(100)",
                NEVER,
                task.nextTimeAfter(100));
    }
    @Test
    public void testNextTimeAfterForRecurrent() {
        Task task = new Task("some", 10, 100, 20);
        task.setActive(true);
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(0)",
                10,
                task.nextTimeAfter(0));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(9)",
                10,
                task.nextTimeAfter(9));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(30)",
                50,
                task.nextTimeAfter(30));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(40)",
                50,
                task.nextTimeAfter(40));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(10)",
                30,
                task.nextTimeAfter(10));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(95)",
                NEVER,
                task.nextTimeAfter(95));
        assertEquals(
                "Task(\"some\", 10, 100, 20).nextTimeAfter(100)",
                NEVER,
                task.nextTimeAfter(100));
    }
    @Test
    public void inactiveTasksShouldNeverBeExecuted() {
        Task task = new Task("some", 10);
        task.setActive(false);
        assertEquals(
                "inactiveTask.nextTimeAfter(0)",
                NEVER,
                task.nextTimeAfter(0));
    }
}
