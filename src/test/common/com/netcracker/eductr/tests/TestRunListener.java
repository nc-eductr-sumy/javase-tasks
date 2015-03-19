package com.netcracker.eductr.tests;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class TestRunListener extends RunListener {

    private Set<Description> reported = new HashSet<Description>();
    private Set<Class<?>> reportedClasses = new HashSet<Class<?>>();

    private static String decamelize(String name) {
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
            System.out.printf("%s: %s%n",
                    decamelize(e.getClass().getSimpleName()),
                    e.getMessage());
            int line = -1;
            for (StackTraceElement frame : e.getStackTrace()) {
                String strippedName = descr.getMethodName();
                if (strippedName.contains("[")) {
                    strippedName = strippedName.substring(0, strippedName.indexOf('['));
                }
                if (frame.getClassName().equals(descr.getTestClass().getName()) && frame.getMethodName().equals(strippedName)) {
                    line = frame.getLineNumber();
                }
                else if (frame.getClassName().startsWith("com.netcracker.")) {
                    System.out.printf("at %s%n", frame.toString());
                }
            }
            System.out.printf("at %s.java: %s%n%n",
                    descr.getTestClass().getName().replaceAll("\\.", "\\"+ File.separator),
                    line != -1 ? "line "+ line : descr.getMethodName());
        }
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("-------------------------------------------------------");
    }
}
