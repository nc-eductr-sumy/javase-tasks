package com.netcracker.eductr.j2se.tasks.tests.arrayTaskListExceptions;

import com.netcracker.eductr.j2se.tasks.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static com.netcracker.eductr.j2se.tasks.tests.arrayTaskList.ArrayTaskListUtils.listOf;

public class ArrayTaskListExceptionTest {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    Task taskA, taskB;

    @Before
    public void createTasks() {
        taskA = new Task("A", 10);
        taskB = new Task("B", 10);
    }

    @Test(expected = Exception.class)
    public void tryToAddNullTaskToList() throws  Exception {
        new ArrayTaskList().add(null);
    }

    @Test
    public void removingNullFromListIsNotAProblem() throws  Exception {
        new ArrayTaskList().remove(null);
    }

    @Test(expected = Exception.class)
    public void tryToUseNegativeIndexInList() throws  Exception {
        new ArrayTaskList().getTask(-10);
    }

    @Test(expected = Exception.class)
    public void tryToUseInvalidIndexInList() throws  Exception {
        ArrayTaskList tasks = listOf( taskA, taskB );
        tasks.getTask(2);
    }
}
