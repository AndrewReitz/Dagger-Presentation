package com.andrewreitz.demo.dojo;

import com.andrewreitz.demo.dojo.weapon.Weapon;

import javax.inject.Inject;

/**
 * @author areitz
 */
public class Ninja {
    private final Weapon mWeapon;

    @Inject
    public Ninja(Weapon weapon) {
        mWeapon = weapon;
    }

    public void attack(String target) {
        mWeapon.hit(target);
    }
}
