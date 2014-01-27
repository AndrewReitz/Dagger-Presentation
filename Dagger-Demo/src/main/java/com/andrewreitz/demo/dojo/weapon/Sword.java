package com.andrewreitz.demo.dojo.weapon;

import android.util.Log;

/**
 * @author areitz
 */
public class Sword implements Weapon {
    @Override
    public void hit(String target) {
        Log.d(
                Sword.class.getName(),
                String.format(
                        "Sword chopped %s in half",
                        target
                )
        );
    }
}
