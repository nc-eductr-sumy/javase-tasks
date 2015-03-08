package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskSetTime2Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void timeShouldBeChanged() {
        Task task = new Task("A", 42);
        task.setTime(10, 20, 5);
        assertEquals(
                "task.getTime()",
                10,
                task.getTime());
    }

    @Test
    public void isRepeatedShouldBeChanged() {
        Task task = new Task("A", 42);
        task.setTime(10, 20, 5);
        assertTrue(
                "task.isRepeated() should be true",
                task.isRepeated());
    }

    @Test
    public void startTimeShouldBeChanged() {
        Task task = new Task("A", 42);
        task.setTime(10, 20, 5);
        assertEquals(
                "task.getStartTime()",
                10,
                task.getStartTime());
    }
    @Test
    public void endTimeShouldBeChanged() {
        Task task = new Task("A", 42);
        task.setTime(10, 20, 5);
        assertEquals(
                "task.getEndTime()",
                20,
                task.getEndTime());
    }
    @Test
    public void repeatIntervalShouldBeChanged() {
        Task task = new Task("A", 42);
        task.setTime(10, 20, 5);
        assertEquals(
                "task.getRepeatInterval()",
                5,
                task.getRepeatInterval());
    }
}














