package th.co.ask.eip_mobile.dao.request;

/**
 * Created by nitiwat.li on 22/03/2559.
 */
public class ReWorkPlanRequest {
    private String device;
    private String userCode;
    private String comCode;
    private String saleCallNo;
    private String custName;
    private String custCardNo;
    private String planDate;
    private String planNote;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCardNo() {
        return custCardNo;
    }

    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getPlanNote() {
        return planNote;
    }

    public void setPlanNote(String planNote) {
        this.planNote = planNote;
    }
}
