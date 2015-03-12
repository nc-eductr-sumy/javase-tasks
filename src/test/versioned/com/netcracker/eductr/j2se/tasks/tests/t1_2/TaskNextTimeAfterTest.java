package com.netcracker.eductr.j2se.tasks.tests.t1_2;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskNextTimeAfterTest {

    static final int NEVER = -1;

    @Test
    public void nextTimeAfterShouldNotChangeAnything() {
        Task task = new Task("some", 10);
        task.setActive(true);
        assumeThat(task.nextTimeAfter(0), is(10));
        assertThat(task.nextTimeAfter(0), is(10));
    }

    @Test
    public void testNextTimeAfterForNonRecurrent() {
        Task task = new Task("some", 10);
        task.setActive(true);
        assertThat(task.nextTimeAfter(  0), is(   10));
        assertThat(task.nextTimeAfter(  9), is(   10));
        assertThat(task.nextTimeAfter( 10), is(NEVER));
        assertThat(task.nextTimeAfter(100), is(NEVER));
    }
    @Test
    public void testNextTimeAfterForRecurrent() {
        Task task = new Task("some", 10, 100, 20);
        task.setActive(true);
        assertThat(task.nextTimeAfter(0), is(10));
        assertThat(task.nextTimeAfter(  9),   is(10));
        assertThat(task.nextTimeAfter(10),   is(10 + 20));
        assertThat(task.nextTimeAfter( 15),   is(10 + 20));
        assertThat(task.nextTimeAfter( 30),   is(10 + 20 + 20));
        assertThat(task.nextTimeAfter( 40),   is(10 + 20 + 20));
        assertThat(task.nextTimeAfter( 95),   is(NEVER));
        assertThat(task.nextTimeAfter(100),   is(NEVER));
    }
    @Test
    public void inactiveTasksShouldNeverBeExecuted() {
        Task task = new Task("some", 10);
        task.setActive(true);
        assumeThat(task.nextTimeAfter(0), is(10));
        task.setActive(false);
        assertThat(task.nextTimeAfter(0), is(NEVER));
    }
}
