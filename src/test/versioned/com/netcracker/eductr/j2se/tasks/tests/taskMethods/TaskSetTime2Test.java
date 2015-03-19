package com.netcracker.eductr.j2se.tasks.tests.taskMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskSetTime2Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void timeShouldBeChanged() {
        Task task = new Task("A", 42);
        assumeThat(task.getTime(), is(42));
        task.setTime(10, 120, 8);
        assertThat(task.getTime(), is(10));
    }

    @Test
    public void taskShouldBecameRepeated() {
        Task task = new Task("A", 42);
        assumeThat(task.isRepeated(), is(false));
        task.setTime(10, 120, 8);
        assertThat(task.isRepeated(), is(true));
    }

    @Test
    public void startTimeShouldBeChanged() {
        Task task = new Task("A", 42);
        assumeThat(task.getStartTime(), is(42));
        task.setTime(10, 120, 8);
        assertThat(task.getStartTime(), is(10));
    }
    @Test
    public void endTimeShouldBeChanged() {
        Task task = new Task("A", 42);
        assumeThat(task.getEndTime(), is(42));
        task.setTime(10, 120, 8);
        assertThat(task.getEndTime(), is(120));
    }
    @Test
    public void repeatIntervalShouldBeChanged() {
        Task task = new Task("A", 42);
        assumeThat(task.getRepeatInterval(), is(0));
        task.setTime(10, 120, 8);
        assertThat(task.getRepeatInterval(), is(8));
    }
}














