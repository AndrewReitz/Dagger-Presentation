package com.andrewreitz.demo.dojo.weapon;

import android.util.Log;

/**
 * @author areitz
 */
public class Shuriken implements Weapon {
    @Override
    public void hit(String target) {
        Log.d(
                Shuriken.class.getName(),
                String.format(
                        "Shuriken stuck in %s's belly",
                        target
                )
        );
    }
}
