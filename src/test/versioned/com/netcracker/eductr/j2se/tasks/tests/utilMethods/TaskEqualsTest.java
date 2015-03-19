package com.netcracker.eductr.j2se.tasks.tests.utilMethods;

import com.netcracker.eductr.j2se.tasks.Task;
import com.netcracker.eductr.j2se.tasks.TaskList;
import com.netcracker.eductr.j2se.tasks.tests.taskList.TaskListTestsBase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

public class TaskEqualsTest extends TaskListTestsBase
{
    @Test
    public void taskWithEqualPropertiesShouldBeEqual() {
        Task first = new Task("Title", 10);
        Task second = new Task("Title", 10);

        assertThat( first, equalTo( second ));
    }

    @Test
    public void objectShouldBeComparedWithEqualsMethod() {
        String firstTitle  = new String("Title");
        String secondTitle = new String("Title");

        Task firstTask  = new Task(firstTitle, 10);
        Task secondTask = new Task(firstTitle, 10);

        assumeThat( firstTitle, equalTo( secondTitle ));
        assertThat( firstTask,  equalTo( secondTask ));
    }

    // a.equals(a) if a != null
    @Test
    public void objectShouldBeEqualToItself() {
        Task task = new Task("Title", 10);
        assertThat( task, equalTo( task ));
    }

    // a = b <=> b = a
    @Test
    public void ifAEqualsBThenBShouldBeEqualToA() {
        Task first  = new Task("Title", 10);
        Task second = new Task("Title", 10);

        assumeThat( first,  equalTo( second ));
        assertThat( second, equalTo( first ));
    }

    @Test
    public void noObjectShouldBeEqualToNull() {
        Task task = new Task("Title", 10);
        assertThat( task.equals(null), is( false ));
    }


    @Test
    public void modificationShouldNotAffectEquality() {
        Task first = new Task("Title", 10);
        Task second = new Task("Title", 10);

        assumeThat( first, equalTo( second ));

        first.setActive( true );
        assumeThat( second.isActive(), is( false ));
        assertThat( first, not(equalTo(second)));

        second.setActive( true );
        assertThat(first, equalTo(second));

        first.setTime(10, 20, 5);
        assertThat(first, not(equalTo(second)));

        second.setTime(10, 20, 5);
        assertThat(first, equalTo(second));

        first.setTitle("New Title");
        assertThat( first, not( equalTo( second )));
    }

    @Test
    public void hashCodeOfEqualObjectsShouldBeEqual() {
        Task first  = new Task("Title", 10);
        Task second = new Task("Title", 10);
        Task third  = new Task("Title", 10, 20, 5);

        assumeThat( first,  equalTo( second ));
        assertThat( first.hashCode(), is( second.hashCode() ));

        assumeThat( first, not( equalTo( third )));
        assertThat( first.hashCode(), not( third.hashCode() ));
    }
}