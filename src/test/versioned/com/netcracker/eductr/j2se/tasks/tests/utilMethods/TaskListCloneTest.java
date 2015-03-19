package com.netcracker.eductr.j2se.tasks.tests.utilMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import com.netcracker.eductr.j2se.tasks.TaskList;
import com.netcracker.eductr.j2se.tasks.tests.taskList.TaskListTestsBase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.*;

public class TaskListCloneTest extends TaskListTestsBase
{
    TaskList original;

    @Before
    public void createOriginalList() {
        original = listOf( taskA, taskB, taskC );
    }

    @Test
    public void cloneShouldNotBeTheSameInstance() throws Exception {
        assertThat( original.clone(), not( sameInstance( original )));
    }

    @Test
    public void cloneShouldHaveTheSameClass() throws Exception {
        assertThat( original.clone(), instanceOf( original.getClass() ));
    }

    @Test
    public void cloneShouldBeEqualToOriginal() throws Exception {
        assertThat( original.clone(), equalTo( original ));
    }

    @Test
    public void cloneShouldBeIndependentFromOriginalOnRemove() throws Exception {
        TaskList clone = original.clone();

        assumeThat( clone, equalTo( original ));
        clone.remove( taskB );
        assertThat( elementsOf( clone ), not( hasItem( taskB )));
        assertThat( elementsOf( original ), hasItems( taskA, taskB, taskC ));
    }

    @Test
    public void cloneShouldBeIndependentFromOriginalOnAdd() throws Exception {
        TaskList clone = original.clone();

        assumeThat( clone, equalTo( original ));
        clone.add( taskD );
        assertThat( elementsOf( clone ), hasItem( taskD ));
        assertThat( elementsOf( original ), both( hasItems( taskA, taskB, taskC )).and( not( hasItem( taskD ))));
    }
}





