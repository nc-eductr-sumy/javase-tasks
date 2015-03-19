package com.netcracker.eductr.j2se.tasks.tests.taskList;

import com.netcracker.eductr.j2se.tasks.*;
import com.netcracker.eductr.j2se.tasks.Task;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class TaskListTest extends TaskListTestsBase
{
    @Test
    public void checkThatListSizeDependsOnAdd() {
        TaskList tasks = listOf();
        assertThat(tasks.size(), is(0));

        tasks.add(taskA);
        assertThat(tasks.size(), is(1));

        tasks.add(taskB);
        assertThat( tasks.size(), is(2) );
    }

    @Test
    public void checkThatAddedTasksAreInList() {
        TaskList tasks = listOf(taskA, taskB, taskC);
        assertThat(tasks.size(), is(3));

        assertThat( tasks.getTask(0), either( is(taskA) ).or( is(taskB) ).or( is(taskC) ) );
        assertThat(tasks.getTask(1), either(is(taskA)).or(is(taskB)).or(is(taskC)));
        assertThat(tasks.getTask(2), either(is(taskA)).or(is(taskB)).or(is(taskC)));

        assertThat( elementsOf(tasks), hasItems(taskA, taskB, taskC) );
    }

    @Test
    public void tryToRemoveElement() {
        TaskList tasks = listOf(taskA, taskB, taskC);
        assumeThat( tasks.size(), is( 3 ) );

        Task task = tasks.getTask(1);
        assumeThat( task, either( is(taskA) ).or( is(taskB) ).or( is(taskC) ) );

        tasks.remove(task);
        assumeThat( tasks.size(), is( 2 ) );
        assertThat( elementsOf(tasks), not( hasItem( task ) ) );
    }

    @Test
    public void checkRemoveMethodReturnValue() {
        TaskList tasks = listOf(taskA, taskB, taskC);
        assumeThat( tasks.size(), is( 3 ) );

        assumeThat( elementsOf(tasks), hasItem( taskA ) );
        assertThat(tasks.remove(taskA), is(true));
        assertThat( tasks.size(), is( 2 ) );

        assertThat( elementsOf(tasks), not( hasItem( taskA ) ) );
        assertThat(tasks.remove(taskA), is(false));
        assertThat( tasks.size(), is(2) );
    }

    @Test
    public void checkRemoveOfDuplicatedTask() {
        TaskList tasks = listOf(taskA, taskB, taskA, taskC);
        assumeThat( tasks.size(), is( 4 ) );
        assumeThat( elementsOf(tasks), hasItem( taskA ) );

        assertThat(tasks.remove(taskA), is(true));
        assertThat( tasks.size(), is( 3 ) );
        assertThat(elementsOf(tasks), hasItem(taskA));

        assertThat( tasks.remove(taskA), is( true ) );
        assertThat( tasks.size(), is( 2 ) );
        assertThat( elementsOf(tasks), not(hasItem(taskA)) );

        assertThat( tasks.remove(taskA), is( false ) );
        assertThat( tasks.size(), is(2) );
    }

    @Test
    public void testTaskListIncomingMethod() {
        // range: (50 60]
        Task
                simple              = task( 55),             // at 55
                simpleBefore        = task( 10),
                simpleAtStart       = task( 50),
                simpleAfter         = task( 70),
                simpleAtEnd         = task( 60),             // at 60
                repeatInside        = task( 51,  58,  2),    // at 51, 53, 55, 57
                repeatOutside       = task(  0, 100,  5),    // at 55, 50
                repeatOutsideOut    = task(  0, 100, 22),
                repeatBefore        = task(  0,  40,  1),
                repeatAfter         = task( 65, 100,  1),
                leftIntersect       = task(  0,  55, 13),    // at 52
                leftIntersectAtEnd  = task(  0,  60, 30),    // at 60
                leftIntersectOut    = task(  0,  55, 22),
                rightIntersect      = task( 55, 100, 20);    // at 55

        TaskList tasks = listOf( simple, simpleBefore, simpleAtStart, simpleAtEnd, simpleAfter,
                                repeatInside, repeatOutside, repeatOutsideOut, repeatBefore, repeatAfter,
                                leftIntersect, leftIntersectAtEnd, leftIntersectOut, rightIntersect );

        List<Task> incoming = elementsOf(tasks.incoming(50, 60));

        assertThat( incoming,      hasItem( simple ) );             // at 55
        assertThat( incoming, not( hasItem( simpleBefore ) ) );
        assertThat( incoming, not( hasItem(simpleAtStart)) );
        assertThat( incoming, not( hasItem(simpleAfter)) );
        assertThat( incoming,      hasItem( simpleAtEnd ) );        // at 60
        assertThat( incoming,      hasItem( repeatInside ) );       // at 51, 53, 55, 57
        assertThat( incoming,      hasItem( repeatOutside ) );      // at 55, 50
        assertThat( incoming, not( hasItem( repeatOutsideOut ) ) );
        assertThat( incoming, not( hasItem(repeatBefore)) );
        assertThat( incoming, not( hasItem(repeatAfter)) );
        assertThat( incoming,      hasItem( leftIntersect ) );      // at 52
        assertThat( incoming,      hasItem( leftIntersectAtEnd ) ); // at 60
        assertThat( incoming, not( hasItem(leftIntersectOut)) );
        assertThat( incoming,      hasItem( rightIntersect ) );     // at 55

    }

    @Test(expected = Exception.class)
    public void tryToAddNullTaskToList() throws  Exception {
        listOf( taskA, taskB ).add( null );
    }

    @Test
    public void removingNullFromListIsNotAProblem() throws  Exception {
        listOf( taskA, taskB ).remove( null );
    }

    @Test(expected = Exception.class)
    public void tryToUseNegativeIndexInList() throws  Exception {
        listOf( taskA, taskB ).getTask( -10 );
    }

    @Test(expected = Exception.class)
    public void tryToUseInvalidIndexInList() throws  Exception {
        listOf( taskA, taskB ).getTask( 2 );
    }
}
