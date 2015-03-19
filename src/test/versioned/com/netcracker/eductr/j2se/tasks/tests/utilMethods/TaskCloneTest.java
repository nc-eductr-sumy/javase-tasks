package com.netcracker.eductr.j2se.tasks.tests.utilMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import com.netcracker.eductr.j2se.tasks.TaskList;
import com.netcracker.eductr.j2se.tasks.tests.taskList.TaskListTestsBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class TaskCloneTest
{
    @DataPoint
    public static Task simple = new Task("Title", 10);
    @DataPoint
    public static Task recurrent = new Task("Title", 10, 100, 5);

    @Test
    public void cloneShouldNotBeTheSameInstance(Task original) throws Exception {
        assertThat( original.clone(), not(sameInstance(original)));
    }

    @Test
    public void cloneShouldHaveTheSameClass(Task original) throws Exception {
        assertThat( original.clone(), instanceOf(original.getClass()));
    }

    @Test
    public void cloneShouldBeEqualToOriginal(Task original) throws Exception {
        assertThat( original.clone(), equalTo(original));
    }

    @Test
    public void cloneShouldBeIndependentFromOriginal(Task original) throws Exception {
        int originalTime = original.getTime();
        Task clone = original.clone();

        assumeThat( clone, equalTo( original ));
        clone.setTime(20);
        assertThat( clone.getTime(), is( 20 ));
        assertThat( original.getTime(), is( originalTime ));
    }
}





