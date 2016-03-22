package th.co.ask.eip_mobile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.view.state.BundleSavedState;


public class PlanByDateItemViewGroup extends BaseCustomViewGroup {
    private TextView tvName;
    private TextView tvSaleCallNo;
    private TextView tvTodoName;
    private TextView tvNote;

    public PlanByDateItemViewGroup(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PlanByDateItemViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PlanByDateItemViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PlanByDateItemViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.item_plan_by_date, this);
    }

    private void initInstances() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvSaleCallNo = (TextView) findViewById(R.id.tvSaleCallNo);
        tvTodoName = (TextView) findViewById(R.id.tvTodoName);
        tvNote = (TextView) findViewById(R.id.tvNote);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public void setTextData(String textName, String textSaleCallNo, String textTodoName, String textNote) {
        tvName.setText(textName);
        tvSaleCallNo.setText(textSaleCallNo);
        tvTodoName.setText(textTodoName);
        tvNote.setText(textNote);
    }

}
