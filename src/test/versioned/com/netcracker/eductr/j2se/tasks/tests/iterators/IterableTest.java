package com.netcracker.eductr.j2se.tasks.tests.iterators;

import com.netcracker.eductr.j2se.tasks.Task;
import com.netcracker.eductr.j2se.tasks.TaskList;
import com.netcracker.eductr.j2se.tasks.tests.taskList.TaskListTestsBase;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class IterableTest extends TaskListTestsBase
{
    @Test
    public void iterationOverListShouldReturnAllListItems() {
        TaskList tasks = listOf( taskA, taskB, taskC );
        Iterator<Task> iterator = tasks.iterator();

        assertThat( iterator.hasNext(), is( true ));
        assertThat( iterator.next(), is( tasks.getTask(0) ));

        assertThat( iterator.hasNext(), is( true ));
        assertThat( iterator.next(), is( tasks.getTask(1) ));

        assertThat( iterator.hasNext(), is( true ));
        assertThat( iterator.next(), is( tasks.getTask(2) ));

        assertThat( iterator.hasNext(), is(false));
    }

    @Test
    public void testIteratorRemove() {
        TaskList tasks = listOf( taskA, taskB, taskC );
        Iterator<Task> iterator = tasks.iterator();

        Task first = iterator.next();

        Task second = iterator.next();
        iterator.remove();

        Task third = iterator.next();

        assertThat( iterator.hasNext(), is( false ));
        assertThat( elementsOf( tasks ), both( hasItems( first, third ) ).and( not( hasItem( second ))));
    }

    @Test
    public void iteratorRemoveShouldRemoveLastReturnedItem() {
        TaskList tasks = listOf( taskA, taskB, taskC, taskB, taskD );

        assumeThat( tasks.getTask(1), is( taskB ));
        assumeThat( tasks.getTask(3), is( taskB ));

        Iterator<Task> iterator = tasks.iterator();

        iterator.next(); // 0
        iterator.next(); // 1
        iterator.next(); // 2
        iterator.next(); // 3
        iterator.remove();

        assertThat( tasks.getTask(1), is( taskB ));
        assertThat( tasks.getTask(3), not( taskB ));
    }

    @Test(expected = IllegalStateException.class)
    public void removeWithoutNextShouldThrowException() {
        Iterator<Task> iterator = listOf( taskA, taskB ).iterator();
        iterator.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void nextAfterTheLastShouldThrowException() {
        Iterator<Task> iterator = listOf( taskA, taskB ).iterator();

        iterator.next(); // 0
        iterator.next(); // 1
        iterator.next(); // end of list
    }

    @Test(expected = IllegalStateException.class)
    public void removeCannotBeCalledTwice() {
        Iterator<Task> iterator = listOf( taskA, taskB, taskC ).iterator();
        iterator.next(); // 0
        iterator.next(); // 1
        iterator.remove();
        iterator.remove();
    }

    @Test
    public void taskListShouldAllowTwoIteratorsAtTheSameTime() {
        TaskList tasks = listOf( taskA, taskB, taskC );

        Set<String> taskTitleCombinations = new HashSet<String>();

        for (Task first: tasks) {
            for (Task second: tasks) {
                taskTitleCombinations.add(first.getTitle() + second.getTitle());
            }
        }
        // tasks contains titles A, B and C, so
        assertThat( taskTitleCombinations, hasItems( "AA", "AB", "AC", "BA", "BB", "BC", "CA", "CB", "CC" ));
        assertThat( taskTitleCombinations.size(), is( 3 * 3 ) );
    }
}