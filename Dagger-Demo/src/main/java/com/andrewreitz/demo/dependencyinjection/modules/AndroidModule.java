package com.andrewreitz.demo.dependencyinjection.modules;

import com.andrewreitz.demo.DaggerDemoApplication;
import com.andrewreitz.demo.dependencyinjection.annotations.ForApplication;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A module for Android-specific dependencies which require a {@link android.content.Context} or
 * {@link android.app.Application} to create.  Also may be used for singleton objects, such as the
 * logger
 */
@Module(library = true)
public class AndroidModule {

    /**
     * SharedPreferences name
     */
    public static final String PREFERENCE_NAME = AndroidModule.class
            .getPackage()
            .getName() +
            "Preferences";

    private final DaggerDemoApplication mApplication;

    public AndroidModule(DaggerDemoApplication application) {
        mApplication = checkNotNull(application);
    }

    /**
     * Allow the application context to be injected but require that it be annotated with {@link
     * com.andrewreitz.demo.dependencyinjection.annotations.ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return mApplication.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }
}
