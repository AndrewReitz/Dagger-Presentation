package com.andrewreitz.demo.logging;

public interface Logger {

    void log(Object currentObject, String message);

    void log(String className, String message);

    void log(LogLevel logLevel, Object currentObject, String message);

    void log(LogLevel logLevel, String className, String message);

    void log(LogLevel logLevel, Object currentObject, String message,
            Throwable throwable);

    void log(LogLevel logLevel, String className, String message,
            Throwable throwable);
}
