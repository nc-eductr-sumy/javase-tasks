package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class TaskConstructor1Test
{
    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

	@Test
    public void constructorShouldSetTitle() {
        assertEquals(
                "new Task(\"A\", 42).getTitle()",
                "A",
                new Task("A", 42).getTitle());
    }

    @Test
    public void constructorShouldSetTime() {
        assertEquals(
                "new Task(\"A\", 42).getTime()",
                42,
                new Task("A", 42).getTime());
    }

    @Test
    public void constructorShouldSetRepeated() {
        assertFalse(
                "new Task(\"A\", 42).isRepeated() should be false",
                new Task("A", 42).isRepeated());
    }
    @Test
    public void constructorShouldSetActive() {
        assertFalse(
                "new Task(\"A\", 42).isActive() should be false",
                new Task("A", 42).isActive());
    }
    @Test
    public void constructorShouldSetStartTime() {
        assertEquals(
                "new Task(\"A\", 42).getStartTime()",
                42,
                new Task("A", 42).getStartTime());
    }
    @Test
    public void constructorShouldSetEndTime() {
        assertEquals(
                "new Task(\"A\", 42).getEndTime()",
                42,
                new Task("A", 42).getEndTime());
    }
    @Test
    public void constructorShouldSetRepeatInterval() {
        assertEquals(
                "new Task(\"A\", 42).getRepeatInterval()",
                0,
                new Task("A", 42).getRepeatInterval());
    }
}














