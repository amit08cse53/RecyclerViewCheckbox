package com.example.amit.recyclerviewcheckbox;

import android.view.View;

public interface MyAdapterListener {

        void iconTextViewOnClick(View v, int position);
        void iconImageViewOnClick(View v, int position);
    }