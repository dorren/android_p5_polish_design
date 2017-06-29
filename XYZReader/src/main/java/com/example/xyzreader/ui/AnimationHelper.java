package com.example.xyzreader.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import com.example.xyzreader.R;

/**
 * Created by dorrenchen on 6/29/17.
 */


public class AnimationHelper {
    /**
     * slide viewGroup's children up from given offset Id,
     *
     * @param context current activity
     * @param root root of children to be animated, usually a layout.
     * @param offsetId resource id, usually stored in dimens.xml, eg,
     *                 <dimen name="offset_y">300dp</dimen>
     */
    public static void slideUp(Context context, ViewGroup root, int offsetId) {
        int count = root.getChildCount();
        float offset = context.getResources().getDimensionPixelSize(offsetId);
        Interpolator interpolator =
                AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);

        // loop over the children setting an increasing translation y but the same animation
        // duration + interpolation
        for (int i = 0; i < count; i++) {
            View view = root.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setTranslationY(offset);
            view.setAlpha(0.85f);
            // then animate back to natural position
            view.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(1000L)
                    .start();
            // increase the offset distance for the next view
            offset *= 1.5f;
        }
    }
}
