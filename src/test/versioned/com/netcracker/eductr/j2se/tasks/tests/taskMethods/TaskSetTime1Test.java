package com.netcracker.eductr.j2se.tasks.tests.taskMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskSetTime1Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void timeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        assumeThat(task.getTime(), is(10));
        task.setTime(42);
        assertThat(task.getTime(), is(42));
    }

    @Test
    public void taskShouldBecameNotRepeated() {
        Task task = new Task("A", 10, 20, 100);
        assumeThat(task.isRepeated(), is(true));
        task.setTime(42);
        assertThat(task.isRepeated(), is(false));
    }

    @Test
    public void startTimeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        assumeThat(task.getStartTime(), is(10));
        task.setTime(42);
        assertThat(task.getStartTime(), is(42));
    }
    @Test
    public void endTimeShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        assumeThat(task.getEndTime(), is(20));
        task.setTime(42);
        assertThat(task.getEndTime(), is(42));
    }
    @Test
    public void repeatIntervalShouldBeChanged() {
        Task task = new Task("A", 10, 20, 100);
        assumeThat(task.getRepeatInterval(), is(100));
        task.setTime(42);
        assertThat(task.getRepeatInterval(), is(0));
    }
}














