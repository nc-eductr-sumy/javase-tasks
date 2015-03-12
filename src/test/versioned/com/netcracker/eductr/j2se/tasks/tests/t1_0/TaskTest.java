package com.netcracker.eductr.j2se.tasks.tests.t1_0;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void checkThatClassTaskExists() throws ClassNotFoundException {
        assertNotNull(Class.forName("com.netcracker.eductr.j2se.tasks.Task"));
    }
}
