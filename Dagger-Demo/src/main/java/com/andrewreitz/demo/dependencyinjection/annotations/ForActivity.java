package com.andrewreitz.demo.dependencyinjection.annotations;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation for getting activity context.
 * Example:
 * <code>public void int provideSomething(@ForActivity Context activityContext)...</code>
 * or
 * <code>public Myconstructor(@ForActivity Context activityContext)</code>
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForActivity {

}
