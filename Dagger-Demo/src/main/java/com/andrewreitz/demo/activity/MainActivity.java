package com.andrewreitz.demo.activity;

import com.andrewreitz.demo.R;
import com.andrewreitz.demo.dojo.Ninja;
import com.andrewreitz.demo.fragment.HomeFragment;

import android.os.Bundle;
import android.view.Menu;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main activity of the application
 */
public class MainActivity extends BaseActivity {

    @Inject
    Ninja mNinja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNinja.attack("pirate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
