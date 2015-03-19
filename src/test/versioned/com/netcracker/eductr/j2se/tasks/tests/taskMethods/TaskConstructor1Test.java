package com.netcracker.eductr.j2se.tasks.tests.taskMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskConstructor1Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

	@Test
    public void constructorShouldSetTitle() {
        assertThat(new Task("A", 42).getTitle(), is("A"));
    }

    @Test
    public void constructorShouldSetTime() {
        assertThat(new Task("A", 42).getTime(), is(42));
    }

    @Test
    public void constructor1ShouldCreateNonRepeatedTask() {
        assertThat(new Task("A", 42).isRepeated(), is(false));
    }
    @Test
    public void constructorShouldCreateInactiveTask() {
        assertThat(new Task("A", 42).isActive(), is(false));
    }
    @Test
    public void constructorShouldSetStartTime() {
        assertThat(new Task("A", 42).getStartTime(), is(42));
    }
    @Test
    public void constructorShouldSetEndTime() {
        assertThat(new Task("A", 42).getEndTime(), is(42));
    }
    @Test
    public void constructorShouldSetRepeatInterval() {
        assertThat(new Task("A", 42).getRepeatInterval(), is(0));
    }
}














