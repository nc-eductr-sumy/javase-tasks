package com.netcracker.eductr.j2se.tasks.tests.taskExceptions;

import com.netcracker.eductr.j2se.tasks.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.fail;

public class TaskExceptionsTest {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    @Test(expected = Exception.class)
    public void taskConstructor1ShouldCheckTitle() throws Exception {
        new Task(null, 10);
    }

    @Test(expected = Exception.class)
    public void taskConstructor2ShouldCheckTitle() throws Exception {
        new Task(null, 10, 100, 5);
    }

    @Test(expected = Exception.class)
    public void taskConstructor1ShouldCheckTime() throws Exception {
        new Task("Title", -10);
    }

    @Test(expected = Exception.class)
    public void taskConstructor2ShouldCheckStart() throws Exception {
        new Task("Title", -10, 100, 5);
    }

    @Test(expected = Exception.class)
    public void taskConstructor2ShouldCheckEnd() throws Exception {
        new Task("Title", 100, 10, 5);
    }

    @Test(expected = Exception.class)
    public void taskConstructor2ShouldCheckInterval() throws Exception {
        new Task("Title", 10, 100, 0);
    }

    @Test(expected = Exception.class)
    public void taskShouldCheckTitle() throws Exception {
        Task task = new Task("Title", 10);
        task.setTitle(null);
    }

    @Test(expected = Exception.class)
    public void taskShouldCheckTime() throws Exception {
        Task task = new Task("Title", 10);
        task.setTime(-10);
    }

    @Test(expected = Exception.class)
    public void taskShouldCheckStart() throws Exception {
        Task task = new Task("Title", 10);
        task.setTime(-10, 100, 5);
    }

    @Test(expected = Exception.class)
    public void taskShouldCheckEnd() throws Exception {
        Task task = new Task("Title", 10);
        task.setTime(100, 10, 5);
    }

    @Test(expected = Exception.class)
    public void taskShouldCheckInterval() throws Exception {
        Task task = new Task("Title", 10);
        task.setTime(10, 100, 0);
    }

    @Test(expected = Exception.class)
    public void taskNextTimeAfterShouldCheckTime() throws Exception {
        Task task = new Task("Title", 10);
        task.nextTimeAfter(-10);
    }

}
