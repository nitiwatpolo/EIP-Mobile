package th.co.ask.eip_mobile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.view.state.BundleSavedState;


public class PlanToWorkDetailItemViewGroup extends BaseCustomViewGroup {
    private TextView tvName;
    private TextView tvCustNo;
    private TextView tvSaleCallNo;

    public PlanToWorkDetailItemViewGroup(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PlanToWorkDetailItemViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PlanToWorkDetailItemViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PlanToWorkDetailItemViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.item_plan_to_work_detail, this);
    }

    private void initInstances() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvCustNo = (TextView) findViewById(R.id.tvCustNo);
        tvSaleCallNo = (TextView) findViewById(R.id.tvSaleCallNo);
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

    public void setTextData(String textName, String textCustNo, String textSaleCallNo) {
        tvName.setText(textName);
        tvCustNo.setText(textCustNo);
        tvSaleCallNo.setText(textSaleCallNo);
    }

}
