package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class TaskSettersTest {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void titleShouldBeChangedUsingSetter() {
        Task task = new Task("A", 42);
        task.setTitle("B");
        assertEquals(
                "Title after change",
                "B",
                task.getTitle());
    }

    @Test
    public void activityShouldBeChangedUsingSetter() {
        Task task = new Task("A", 42);
        assertFalse(
                "Initially task.isActive() should be false",
                task.isActive());
        task.setActive(true);
        assertTrue(
                "After change task.isActive() should be true",
                task.isActive());
    }
}
