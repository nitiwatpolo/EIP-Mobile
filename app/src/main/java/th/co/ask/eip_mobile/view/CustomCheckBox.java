package th.co.ask.eip_mobile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.utils.RobotoType;
import th.co.ask.eip_mobile.view.state.BundleSavedState;

public class CustomCheckBox extends AppCompatCheckBox {

    public CustomCheckBox(Context context) {
        super(context);
        init();
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    private void init() {
        setSaveEnabled(true);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (!isInEditMode()) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.RobotoStyle,
                    defStyleAttr, defStyleRes);

            try {
                int typeface = a.getInt(R.styleable.RobotoStyle_typeface, 0);
                setTypeface(typeface);
            } finally {
                a.recycle();
            }
        }
    }

    private void setTypeface(int typeface) {
        super.setTypeface(RobotoType.getInstance().getTypeface(typeface));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

}
