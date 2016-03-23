package th.co.ask.eip_mobile.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class AllPlanDao implements Parcelable {
    @SerializedName("MSG")public String msg;
    @SerializedName("COM_CODE")public String comCode;
    @SerializedName("LIST_DAY")public List<ListDayDao> listDay;
    @SerializedName("USER_CODE")public String userCode;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public List<ListDayDao> getListDay() {
        return listDay;
    }

    public void setListDay(List<ListDayDao> listDay) {
        this.listDay = listDay;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(msg);
        dest.writeString(comCode);
        dest.writeTypedList(listDay);
        dest.writeString(userCode);
    }
    public static final Parcelable.Creator<AllPlanDao> CREATOR
            = new Parcelable.Creator<AllPlanDao>() {
        public AllPlanDao createFromParcel(Parcel in) {
            return new AllPlanDao(in);
        }

        public AllPlanDao[] newArray(int size) {
            return new AllPlanDao[size];
        }
    };

    private AllPlanDao(Parcel in) {
        msg = in.readString();
        comCode = in.readString();
        in.readTypedList(listDay, ListDayDao.CREATOR);
    }
}
