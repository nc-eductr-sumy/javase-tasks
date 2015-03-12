package com.netcracker.eductr.j2se.tasks.tests.t1_1;

import com.netcracker.eductr.j2se.tasks.Task;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskSettersTest {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test
    public void titleShouldBeChangedUsingSetter() {
        Task task = new Task("Old Title", 42);
        assumeThat(task.getTitle(), is("Old Title"));
        task.setTitle("New Title");
        assertThat(task.getTitle(), is("New Title"));
    }

    @Test
    public void activityShouldBeChangedUsingSetter() {
        Task task = new Task("A", 42);
        assumeThat(task.isActive(), is(false));
        task.setActive(true);
        assertThat(task.isActive(), is(true));
    }
}
