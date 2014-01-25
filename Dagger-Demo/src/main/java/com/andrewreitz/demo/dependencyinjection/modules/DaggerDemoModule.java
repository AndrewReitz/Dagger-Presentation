package com.andrewreitz.demo.dependencyinjection.modules;

import dagger.Module;

/**
 * For compile-time validation of Dagger Modules, other than this file doesn't really do much
 */
@Module(
        includes = {
                AndroidModule.class,
                ActivityModule.class
                /* ADD MORE MODULES HERE FOR CHECKING */
        }
)
public class DaggerDemoModule {

}
