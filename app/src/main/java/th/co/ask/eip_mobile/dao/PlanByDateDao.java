package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class PlanByDateDao {
    @SerializedName("PLAN_DATE")public String planDate;
    @SerializedName("COM_CODE")public String comCode;
    @SerializedName("LIST_PLAN")public List<ListPlanDao> listPlan;
    @SerializedName("PLAN_NUM")public String planNum;

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
}
