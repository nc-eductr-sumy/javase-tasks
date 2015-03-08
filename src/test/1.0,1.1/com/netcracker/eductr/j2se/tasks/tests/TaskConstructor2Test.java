package com.netcracker.eductr.j2se.tasks.tests;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskConstructor2Test {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void constructorShouldSetTitle() {
        assertEquals(
                "new Task(\"A\", 42, 100, 5).getTitle()",
                "A",
                new Task("A", 42, 100, 5).getTitle());
    }

    @Test
    public void constructorShouldSetTime() {
        assertEquals(
                "new Task(\"A\", 42, 100, 5).getTime()",
                42,
                new Task("A", 42, 100, 5).getTime());
    }

    @Test
    public void constructorShouldSetRepeated() {
        assertTrue(
                "new Task(\"A\", 42, 100, 5).isRepeated() should be true",
                new Task("A", 42, 100, 5).isRepeated());
    }
    @Test
    public void constructorShouldSetActive() {
        assertFalse(
                "new Task(\"A\", 42, 100, 5).isActive() should be false",
                new Task("A", 42, 100, 5).isActive());
    }
    @Test
    public void constructorShouldSetStartTime() {
        assertEquals(
                "new Task(\"A\", 42, 100, 5).getStartTime()",
                42,
                new Task("A", 42, 100, 5).getStartTime());
    }
    @Test
    public void constructorShouldSetEndTime() {
        assertEquals(
                "new Task(\"A\", 42, 100, 5).getEndTime()",
                100,
                new Task("A", 42, 100, 5).getEndTime());
    }
    @Test
    public void constructorShouldSetRepeatInterval() {
        assertEquals(
                "new Task(\"A\", 42, 100, 5).getRepeatInterval()",
                5,
                new Task("A", 42, 100, 5).getRepeatInterval());
    }
}
