package com.netcracker.eductr.j2se.tasks.tests.arrayTaskListMethods;

import com.netcracker.eductr.j2se.tasks.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

import com.netcracker.eductr.j2se.tasks.tests.arrayTaskList.ArrayTaskListUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ArrayTaskListTest
{

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    Task taskA, taskB, taskC;

    @Before
    public void createTasks() {
        taskA = new Task("A", 0);
        taskB = new Task("B", 0);
        taskC = new Task("C", 0);
    }

    @Test
    public void checkThatListSizeDependsOnAdd() {
        ArrayTaskList tasks = new ArrayTaskList();
        assertThat(tasks.size(), is(0));

        tasks.add(taskA);
        assertThat(tasks.size(), is(1));

        tasks.add(taskB);
        assertThat( tasks.size(), is(2) );
    }

    @Test
    public void checkThatAddedTasksAreInList() {
        ArrayTaskList tasks = ArrayTaskListUtils.listOf(taskA, taskB, taskC);
        assertThat(tasks.size(), is(3));

        assertThat( tasks.getTask(0), either( is(taskA) ).or( is(taskB) ).or( is(taskC) ) );
        assertThat(tasks.getTask(1), either(is(taskA)).or(is(taskB)).or(is(taskC)));
        assertThat(tasks.getTask(2), either(is(taskA)).or(is(taskB)).or(is(taskC)));

        assertThat( ArrayTaskListUtils.elementsOf(tasks), hasItems(taskA, taskB, taskC) );
    }

    @Test
    public void tryToRemoveElement() {
        ArrayTaskList tasks = ArrayTaskListUtils.listOf(taskA, taskB, taskC);
        assumeThat( tasks.size(), is( 3 ) );

        Task task = tasks.getTask(1);
        assumeThat( task, either( is(taskA) ).or( is(taskB) ).or( is(taskC) ) );

        tasks.remove(task);
        assumeThat( tasks.size(), is( 2 ) );
        assertThat( ArrayTaskListUtils.elementsOf(tasks), not( hasItem( task ) ) );
    }

    @Test
    public void checkRemoveMethodReturnValue() {
        ArrayTaskList tasks = ArrayTaskListUtils.listOf(taskA, taskB, taskC);
        assumeThat( tasks.size(), is( 3 ) );

        assumeThat( ArrayTaskListUtils.elementsOf(tasks), hasItem( taskA ) );
        assertThat(tasks.remove(taskA), is(true));
        assertThat( tasks.size(), is( 2 ) );

        assertThat( ArrayTaskListUtils.elementsOf(tasks), not( hasItem( taskA ) ) );
        assertThat(tasks.remove(taskA), is(false));
        assertThat( tasks.size(), is(2) );
    }

    @Test
    public void checkRemoveOfDuplicatedTask() {
        ArrayTaskList tasks = ArrayTaskListUtils.listOf(taskA, taskB, taskA, taskC);
        assumeThat( tasks.size(), is( 4 ) );
        assumeThat( ArrayTaskListUtils.elementsOf(tasks), hasItem( taskA ) );

        assertThat(tasks.remove(taskA), is(true));
        assertThat( tasks.size(), is( 3 ) );
        assertThat(ArrayTaskListUtils.elementsOf(tasks), hasItem(taskA));

        assertThat( tasks.remove(taskA), is( true ) );
        assertThat( tasks.size(), is( 2 ) );
        assertThat( ArrayTaskListUtils.elementsOf(tasks), not(hasItem(taskA)) );

        assertThat( tasks.remove(taskA), is( false ) );
        assertThat( tasks.size(), is(2) );
    }

}
