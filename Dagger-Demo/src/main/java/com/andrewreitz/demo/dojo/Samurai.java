package com.andrewreitz.demo.dojo;

import android.content.Context;

import com.andrewreitz.demo.dependencyinjection.annotations.ForActivity;
import com.andrewreitz.demo.dojo.weapon.Weapon;

import javax.inject.Inject;

/**
 * @author areitz
 */
public class Samurai extends Ninja {

    @Inject
    public Samurai(@ForActivity Context context, Weapon weapon) {
        super(weapon);

        if (context == null) {
            throw new RuntimeException("context must not be null");
        }
    }
}
