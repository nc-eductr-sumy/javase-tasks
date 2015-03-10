package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TaskSetTime1Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void timeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        task.setTime(42);
        assertEquals(
                "task.getTime()",
                42,
                new Task("A", 42).getTime());
    }

    @Test
    public void isRepeatedShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        task.setTime(42);
        assertFalse(
                "task.isRepeated() should be false",
                new Task("A", 42).isRepeated());
    }

    @Test
    public void startTimeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        task.setTime(42);
        assertEquals(
                "task.getStartTime()",
                42,
                new Task("A", 42).getStartTime());
    }
    @Test
    public void endTimeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        task.setTime(42);
        assertEquals(
                "task.getEndTime()",
                42,
                new Task("A", 42).getEndTime());
    }
    @Test
    public void repeatIntervalShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        task.setTime(42);
        assertEquals(
                "task.getRepeatInterval()",
                0,
                new Task("A", 42).getRepeatInterval());
    }
}














