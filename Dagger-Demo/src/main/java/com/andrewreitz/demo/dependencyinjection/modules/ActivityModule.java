package com.andrewreitz.demo.dependencyinjection.modules;

/**
 * @author areitz
 */

import com.andrewreitz.demo.dependencyinjection.annotations.ForActivity;
import com.andrewreitz.demo.activity.BaseActivity;
import com.andrewreitz.demo.activity.MainActivity;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This module represents objects which exist only for the scope of a single activity. We can safely
 * create singletons using the activity instance because ths entire object graph will only ever
 * exist inside of that activity.
 */
@Module(
        injects = {
                MainActivity.class
                // TODO: Add what this injects here!
        },
        addsTo = AndroidModule.class,
        library = true
)
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    /**
     * Allow the activity context to be injected but require that it be annotated with {@link
     * {package}.dependencyinjection.annotations.ForActivity @ForActivity} to explicitly differentiate it from
     * application context.
     */
    @Provides
    @Singleton
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }


}
