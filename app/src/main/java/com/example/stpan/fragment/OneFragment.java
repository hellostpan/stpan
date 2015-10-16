package com.example.stpan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stpan.activity.R;

/**
 * 功能：
 * 创建时间:2015/9/22 15:34
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class OneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
