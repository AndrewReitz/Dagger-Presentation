package com.andrewreitz.demo.logging;

import com.andrewreitz.demo.BuildConfig;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author bkurinsk, areitz
 */
public class LogCatLogger implements Logger {

    private final String mLogTag;
    private static final boolean DEBUG = BuildConfig.DEBUG;

    /**
     * Constructor
     *
     * @param context - application context
     */
    @Inject
    public LogCatLogger(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }

        mLogTag = context.getPackageName();
    }

    /**
     * Prints a debug level log with the given class name and message. Ex: Logger.log(this, "Here is
     * my message.");
     *
     * @param currentObject a reference to the calling object
     * @param message       the message to log
     */
    @Override
    public void log(Object currentObject, String message) {
        log(LogLevel.DEBUG, currentObject, message);
    }

    /**
     * Prints a debug level log with the given class name and message. Ex:
     * Logger.log("BESTBUYDIGITAL.ANDROID.ItemLocator.activity.PlayerActivity", "Here is my
     * message.");
     *
     * @param className the name of the current class with package
     * @param message   the message to log
     */
    @Override
    public void log(String className, String message) {
        log(LogLevel.DEBUG, className, message);
    }

    /**
     * Prints a message to the log with the given level, class name, and message. Ex:
     * Logger.log(Logger.WARN, this, "This is my message.");
     *
     * @param logLevel      the log level as a {@link com.andrewreitz.demo.core.logging.LogLevel} enum object
     * @param currentObject a reference to the calling object
     * @param message       the message to log
     */
    @Override
    public void log(LogLevel logLevel, Object currentObject, String message) {
        createLogMessage(logLevel, currentObject.getClass().getName(), message, null);
    }

    /**
     * Prints a message to the log with the given level, class name, and message. Ex:
     * Logger.log(Logger.WARN, "BESTBUYDIGITAL.ANDROID.ItemLocator.activity.PlayerActivity", "Here
     * is my message.");
     *
     * @param logLevel  the log level as a {@link com.andrewreitz.demo.core.logging.LogLevel} enum object
     * @param className the name of the current class with package
     * @param message   the message to log
     */
    @Override
    public void log(LogLevel logLevel, String className, String message) {
        createLogMessage(logLevel, className, message, null);
    }

    /**
     * Prints a message to the log with the given level, class name, and message. Ex:
     * Logger.log(Logger.WARN, this, "This is my message.", throwable);
     *
     * @param logLevel      the log level as a {@link com.andrewreitz.demo.core.logging.LogLevel} enum object
     * @param currentObject a reference to the calling object
     * @param message       the message to log
     * @param throwable     a throwable to log
     */
    @Override
    public void log(
            LogLevel logLevel,
            Object currentObject,
            String message,
            Throwable throwable
    ) {
        createLogMessage(logLevel, currentObject.getClass().getPackage().getName(), message,
                throwable);
    }

    /**
     * Prints a message to the log with the given level, class name, and message. Ex:
     * Logger.log(Logger.WARN, "BESTBUYDIGITAL.ANDROID.ItemLocator.activity.PlayerActivity", "Here
     * is my message.", throwable);
     *
     * @param logLevel  the log level as a {@link com.andrewreitz.demo.core.logging.LogLevel} enum object
     * @param className the name of the current class with package
     * @param message   the message to log
     * @param throwable a throwable to log
     */
    @Override
    public void log(
            LogLevel logLevel,
            String className,
            String message,
            Throwable throwable
    ) {
        createLogMessage(logLevel, className, message, throwable);
    }

    private void createLogMessage(
            LogLevel logLevel,
            String className,
            String message,
            Throwable t
    ) {
        if (DEBUG) {
            String logMessage = className + ": " + message;

            switch (logLevel) {
                case DEBUG:
                    Log.d(mLogTag, logMessage, t);
                    break;
                case ERROR:
                    Log.e(mLogTag, logMessage, t);
                    break;
                case INFO:
                    Log.i(mLogTag, logMessage, t);
                    break;
                case VERBOSE:
                    Log.v(mLogTag, logMessage, t);
                    break;
                case WARN:
                    Log.w(mLogTag, logMessage, t);
                    break;
                case WTF:
                    Log.wtf(mLogTag, logMessage, t);
                default:
                    throw new IllegalArgumentException("Unknown LogLevel " + logLevel.toString());
            }
        }
    }

}
