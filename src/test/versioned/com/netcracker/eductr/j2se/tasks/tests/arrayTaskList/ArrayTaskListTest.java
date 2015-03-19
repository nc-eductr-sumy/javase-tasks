package com.netcracker.eductr.j2se.tasks.tests.arrayTaskList;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ArrayTaskListTest {

    @Test
    public void checkThatClassTaskListExists() throws ClassNotFoundException {
        assertNotNull(Class.forName("com.netcracker.eductr.j2se.tasks.ArrayTaskList"));
    }
}
