package com.andrewreitz.demo.logging;

/**
 * A enum for the log levels, this is written as a convenience as to not require two imports.
 * One for Logger and another for Android's Log class.
 *
 * @author areitz
 */
public enum LogLevel {
    DEBUG, ERROR, INFO, VERBOSE, WARN, WTF
}
