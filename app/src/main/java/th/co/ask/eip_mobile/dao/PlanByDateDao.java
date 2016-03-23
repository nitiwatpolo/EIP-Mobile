package th.co.ask.eip_mobile.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class PlanByDateDao implements Parcelable {
    @SerializedName("PLAN_DATE")
    public String planDate;
    @SerializedName("COM_CODE")
    public String comCode;
    @SerializedName("LIST_PLAN")
    public List<ListPlanDao> listPlan;
    @SerializedName("PLAN_NUM")
    public String planNum;

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public List<ListPlanDao> getListPlan() {
        return listPlan;
    }

    public void setListPlan(List<ListPlanDao> listPlan) {
        this.listPlan = listPlan;
    }

    public String getPlanNum() {
        return planNum;
    }

    public void setPlanNum(String planNum) {
        this.planNum = planNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(planDate);
        dest.writeString(comCode);
        dest.writeTypedList(listPlan);
        dest.writeString(planNum);
    }

    public static final Parcelable.Creator<PlanByDateDao> CREATOR
            = new Parcelable.Creator<PlanByDateDao>() {
        public PlanByDateDao createFromParcel(Parcel in) {
            return new PlanByDateDao(in);
        }

        public PlanByDateDao[] newArray(int size) {
            return new PlanByDateDao[size];
        }
    };

    private PlanByDateDao(Parcel in) {
        planDate = in.readString();
        comCode = in.readString();
        in.readTypedList(listPlan, ListPlanDao.CREATOR);
        planNum = in.readString();
    }
}
