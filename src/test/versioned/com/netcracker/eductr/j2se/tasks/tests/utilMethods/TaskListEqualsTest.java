package com.netcracker.eductr.j2se.tasks.tests.utilMethods;

import com.netcracker.eductr.j2se.tasks.TaskList;
import com.netcracker.eductr.j2se.tasks.tests.taskList.TaskListTestsBase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.*;

public class TaskListEqualsTest extends TaskListTestsBase
{
    @Test
    public void taskListsWithEqualTasksShouldBeEqual() {
        assumeTrue( taskA.equals(taskA) );
        assumeTrue( taskB.equals(taskB) );
        assumeTrue( taskC.equals(taskC) );

        TaskList first  = listOf( taskA, taskB, taskC );
        TaskList second = listOf( taskA, taskB, taskC );

        assertThat( first, equalTo( second ));
    }

    // a.equals(a) if a != null
    @Test
    public void objectShouldBeEqualToItself() {
        TaskList tasks = listOf( taskA, taskB, taskC );
        assertThat( tasks, is( tasks ));
    }

    // a = b <=> b = a
    @Test
    public void ifAEqualsBThenBShouldBeEqualToA() {
        TaskList first  = listOf( taskA, taskB, taskC );
        TaskList second = listOf( taskA, taskB, taskC );

        assumeThat( first,  equalTo( second ));
        assertThat( second, equalTo( first ));
    }

    @Test
    public void noObjectShouldBeEqualToNull() {
        TaskList first  = listOf( taskA, taskB, taskC );
        assertThat( first.equals(null), is( false ));
    }


    @Test
    public void listModificationShouldNotAffectEquality() {
        TaskList first  = listOf( taskA, taskB, taskC );
        TaskList second = listOf( taskA, taskB, taskC );

        // (A,B,C) == (A,B,C)
        assumeThat( first,  equalTo( second ));

        first.remove( taskC );
        second.remove( taskC );

        // (A,B) == (A,B)
        assertThat( first,  equalTo( second ));

        first.add( taskC );
        second.add( taskD );

        // (A,B,C) != (A,B,D)
        assertThat( first, not( equalTo( second )));

        first.remove( taskC );
        first.add( taskD );

        // (A,B,D) == (A,B,D)
        assertThat( first,  equalTo( second ));
    }

    @Test
    public void hashCodeOfEqualObjectsShouldBeEqual() {
        TaskList first  = listOf( taskA, taskB, taskC );
        TaskList second = listOf( taskA, taskB, taskC );
        TaskList third  = listOf( taskA, taskB, taskD );

        assumeThat( first,  equalTo( second ));
        assertThat( first.hashCode(), is( second.hashCode() ));

        assumeThat( first, not( equalTo( third )));
        assertThat( first.hashCode(), not( third.hashCode() ));
    }
}