package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class ListDayDao {
    @SerializedName("DAY")public String day;
    @SerializedName("DATE")public String date;
    @SerializedName("YEAR")public String year;
    @SerializedName("MONTH")public String month;
    @SerializedName("ACTIVE")public String active;

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
}
