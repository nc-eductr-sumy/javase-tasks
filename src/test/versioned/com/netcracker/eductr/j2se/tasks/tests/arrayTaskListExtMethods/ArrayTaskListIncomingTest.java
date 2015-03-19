package com.netcracker.eductr.j2se.tasks.tests.arrayTaskListExtMethods;

import com.netcracker.eductr.j2se.tasks.*;

import static com.netcracker.eductr.j2se.tasks.tests.arrayTaskList.ArrayTaskListUtils.elementsOf;
import static com.netcracker.eductr.j2se.tasks.tests.arrayTaskList.ArrayTaskListUtils.listOf;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;

public class ArrayTaskListIncomingTest {

    @Rule
    public final Timeout TIMEOUT = new Timeout(1000);

    static Task task(int time) {
        Task task = new Task("Title", time);
        task.setActive(true);
        return task;
    }

    static Task task(int start, int end, int interval) {
        Task task = new Task("Title", start, end, interval);
        task.setActive(true);
        return task;
    }

    @Test
    public void testTaskListIncomingMethod() {
        // range: (50 60]
        Task
            simple              = task(55),             // at 55
            simpleBefore        = task(10),
            simpleAtStart       = task(50),
            simpleAfter         = task(70),
            simpleAtEnd         = task(60),             // at 60
            repeatInside        = task(51,  58,  2),    // at 51, 53, 55, 57
            repeatOutside       = task( 0, 100,  5),    // at 55, 50
            repeatOutsideOut    = task( 0, 100, 22),
            repeatBefore        = task( 0,  40,  1),
            repeatAfter         = task(65, 100,  1),
            leftIntersect       = task( 0,  55, 13),    // at 52
            leftIntersectAtEnd  = task( 0,  60, 30),    // at 60
            leftIntersectOut    = task( 0,  55, 22),
            rightIntersect      = task(55, 100, 20);    // at 55

        ArrayTaskList tasks = listOf( simple, simpleBefore, simpleAtStart, simpleAtEnd, simpleAfter,
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
}
