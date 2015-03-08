package com.netcracker.eductr.tests;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.*;

public class TestRunListener extends RunListener {

    private Set<Description> reported = new HashSet<Description>();
    private Set<Class<?>> reportedClasses = new HashSet<Class<?>>();

    @Override
    public void testStarted(Description description) throws Exception { /*
        if (reportedClasses.add(description.getTestClass())) {
            System.out.println("-------------------------------------------------------");
            System.out.printf("%2d. %s%n",
                    reportedClasses.size(),
                    decamelize(description.getTestClass().getSimpleName()));
        }*/
    }

    @Override
    public void testFinished(Description description) throws Exception {
//        showRunInfo(description, null);
    }

    private String decamelize(String name) {
        StringBuilder sb = new StringBuilder();
        for (char c: name.toCharArray()) {
            if (Character.isUpperCase(c) && sb.length() > 0) {
                sb.append(" ").append(Character.toLowerCase(c));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        showRunInfo(failure.getDescription(), failure);
    }

    private void showRunInfo(Description descr, Failure fail) {
        if (! reported.add(descr))
            return;
        System.out.printf("%n%s %s%n",
                fail == null ? "[SUCCESS]" : "[ERROR]",
                decamelize(descr.getMethodName()));
        if (fail != null) {
            Throwable e = fail.getException();
            System.out.printf("\t%s \"%s\"%n",
                    decamelize(e.getClass().getSimpleName()),
                    e.getMessage());
            for (StackTraceElement frame : e.getStackTrace()) {
                if (frame.getClassName().startsWith("com.netcracker.")) {
                    System.out.printf("\tat %s%n", frame.toString());
                }
            }
            System.out.println();
        }
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("-------------------------------------------------------");
    }
}
