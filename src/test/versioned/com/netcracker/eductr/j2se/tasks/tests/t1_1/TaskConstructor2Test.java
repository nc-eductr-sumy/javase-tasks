package com.netcracker.eductr.j2se.tasks.tests.t1_1;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskConstructor2Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void constructorShouldSetTitle() {
        assertThat(new Task("A", 10, 120, 8).getTitle(), is("A"));
    }

    @Test
    public void constructorShouldSetTime() {
        assertThat(new Task("A", 10, 120, 8).getTime(), is(10));
    }

    @Test
    public void constructor2ShouldCreateRepeatedTask() {
        assertThat(new Task("A", 10, 120, 8).isRepeated(), is(true));
    }
    @Test
    public void constructorShouldCreateInactiveTask() {
        assertThat(new Task("A", 10, 120, 8).isActive(), is(false));
    }
    @Test
    public void constructorShouldSetStartTime() {
        assertThat(new Task("A", 10, 120, 8).getStartTime(), is(10));
    }
    @Test
    public void constructorShouldSetEndTime() {
        assertThat(new Task("A", 10, 120, 8).getEndTime(), is(120));
    }
    @Test
    public void constructorShouldSetRepeatInterval() {
        assertThat(new Task("A", 10, 120, 8).getRepeatInterval(), is(8));
    }
}














