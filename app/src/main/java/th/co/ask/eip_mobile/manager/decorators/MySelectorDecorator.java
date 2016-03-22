package th.co.ask.eip_mobile.manager.decorators;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import th.co.ask.eip_mobile.R;

/**
 * Created by Polo on 20/3/2559.
 */
public class MySelectorDecorator implements DayViewDecorator {
   // private final Drawable drawable;

    public MySelectorDecorator(Context context) {
        //drawable = ContextCompat.getDrawable(context,R.drawable.selector_plan_to_work);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
       // view.setSelectionDrawable(drawable);
    }
}
