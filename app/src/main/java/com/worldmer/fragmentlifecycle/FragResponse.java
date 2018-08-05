package com.worldmer.fragmentlifecycle;

import android.view.View;

/**
 * Created by Yagnik on 05-Aug-18.
 */

public interface FragResponse {
    void onfragClick(View View);
    void onfragBack(int responseCode);
}
