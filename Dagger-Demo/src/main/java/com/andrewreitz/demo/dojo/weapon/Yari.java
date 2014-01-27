package com.andrewreitz.demo.dojo.weapon;

import android.util.Log;

/**
 * @author areitz
 */
public class Yari implements Weapon {
    @Override
    public void hit(String target) {
        Log.d(
                Yari.class.getName(),
                String.format(
                        "Yari speared the %s",
                        target
                )
        );
    }
}
