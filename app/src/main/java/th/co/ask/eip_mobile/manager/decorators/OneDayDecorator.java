package th.co.ask.eip_mobile.manager.decorators;

import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.manager.Contextor;

/**
 * Created by Polo on 20/3/2559.
 */
public class OneDayDecorator implements DayViewDecorator {
    private CalendarDay date;

    public OneDayDecorator() {
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return  date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.4f));
        view.addSpan(new ForegroundColorSpan(ContextCompat.getColor(Contextor.getInstance().getContext(),
                R.color.colorPrimary)) );
    }

    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
