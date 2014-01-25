package com.andrewreitz.demo.dependencyinjection.annotations;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation for getting application context
 * Example:
 * <code>public void int provideSomething(@ForApplication Context activityContext)...</code>
 * or
 * <code>public Myconstructor(@ForApplication Context activityContext)</code>
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {

}
