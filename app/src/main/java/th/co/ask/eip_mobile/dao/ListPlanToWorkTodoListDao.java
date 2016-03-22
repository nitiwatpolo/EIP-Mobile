package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 22/03/2559.
 */
public class ListPlanToWorkTodoListDao {
    @SerializedName("CUST_NAME")public String custName;
    @SerializedName("PLAN_DATE")public String planDate;
    @SerializedName("COM_CODE")public String comCode;
    @SerializedName("SALE_CALL_NO")public String saleCallNo;
    @SerializedName("CUST_CARD_NO")public String custCardNo;
    @SerializedName("PLAN_NOTE")public String planNote;
    @SerializedName("CUST_CODE")public String custCode;
    @SerializedName("TODO_CODE")public String todoCode;
    @SerializedName("SUB_ID")public String subId;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

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

    public String getSaleCallNo() {
        return saleCallNo;
    }

    public void setSaleCallNo(String saleCallNo) {
        this.saleCallNo = saleCallNo;
    }

    public String getCustCardNo() {
        return custCardNo;
    }

    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }

    public String getPlanNote() {
        return planNote;
    }

    public void setPlanNote(String planNote) {
        this.planNote = planNote;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getTodoCode() {
        return todoCode;
    }

    public void setTodoCode(String todoCode) {
        this.todoCode = todoCode;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }
}
