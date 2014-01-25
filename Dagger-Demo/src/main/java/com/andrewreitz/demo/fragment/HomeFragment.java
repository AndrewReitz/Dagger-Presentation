package com.andrewreitz.demo.fragment;

import com.andrewreitz.demo.R;
import com.andrewreitz.demo.logging.Logger;
import com.andrewreitz.demo.activity.BaseActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {

    @Inject
    Logger mLogger;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        ((BaseActivity) getActivity()).inject(this);

        return view;
    }
}
