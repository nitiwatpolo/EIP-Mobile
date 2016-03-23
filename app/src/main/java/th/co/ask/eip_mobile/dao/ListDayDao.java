package th.co.ask.eip_mobile.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class ListDayDao implements Parcelable {
    @SerializedName("DAY")
    public String day;
    @SerializedName("DATE")
    public String date;
    @SerializedName("YEAR")
    public String year;
    @SerializedName("MONTH")
    public String month;
    @SerializedName("ACTIVE")
    public String active;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(date);
        dest.writeString(year);
        dest.writeString(month);
        dest.writeString(active);
    }

    public static final Parcelable.Creator<ListDayDao> CREATOR
            = new Parcelable.Creator<ListDayDao>() {
        public ListDayDao createFromParcel(Parcel in) {
            return new ListDayDao(in);
        }

        public ListDayDao[] newArray(int size) {
            return new ListDayDao[size];
        }
    };

    private ListDayDao(Parcel in) {
        day = in.readString();
        date = in.readString();
        year = in.readString();
        month = in.readString();
        active = in.readString();
    }
}
