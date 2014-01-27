package com.andrewreitz.demo.dependencyinjection.modules;

/**
 * @author areitz
 */

import com.andrewreitz.demo.dependencyinjection.annotations.ForActivity;
import com.andrewreitz.demo.activity.BaseActivity;
import com.andrewreitz.demo.activity.MainActivity;
import com.andrewreitz.demo.dojo.Ninja;
import com.andrewreitz.demo.dojo.Samurai;
import com.andrewreitz.demo.dojo.weapon.Shuriken;
import com.andrewreitz.demo.dojo.weapon.Sword;
import com.andrewreitz.demo.dojo.weapon.Weapon;
import com.andrewreitz.demo.dojo.weapon.Yari;
import com.andrewreitz.demo.fragment.HomeFragment;

import android.content.Context;

import javax.inject.Named;
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
                MainActivity.class,
                HomeFragment.class
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

    @Provides
    @Named("Sword")
    Weapon provideSword() {
        return new Sword();
    }

    @Provides
    @Named("Yari")
    Weapon provideYari() {
        return new Yari();
    }

    @Provides
    Shuriken provideShuriken() {
        return new Shuriken();
    }

    @Provides
    Ninja provideNinja(@Named("Sword") Weapon weapon) {
        return new Ninja(weapon);
    }

    @Provides
    @Named("shuriken-ninja")
    Ninja provideNinja(Shuriken shuriken) {
        return new Ninja(shuriken);
    }

    @Provides
    Samurai provideSamurai(@ForActivity Context context, @Named("Yari") Weapon weapon) {
        return new Samurai(context, weapon);
    }
}
