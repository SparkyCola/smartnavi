package com.mattis.sandwich.tools;

/**
 * This class helps to detect TouchEvents on com.mattis.sandwich.GoogleMap
 * and disables the followMe function if user moves the map
 * Thanks to Stackoverflow: Gaucho
 */

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableWrapper extends FrameLayout {

    int touchCounter = 0;

    public TouchableWrapper(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                touchCounter++;
                if (touchCounter >= 10) { //Count for enough motion before disabling followMe
                    com.mattis.sandwich.Map.listHandler.sendEmptyMessage(15); //set followMe=false
                    touchCounter = 0;
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
