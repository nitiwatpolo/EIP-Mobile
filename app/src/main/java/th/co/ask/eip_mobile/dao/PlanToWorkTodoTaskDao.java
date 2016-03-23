package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 22/03/2559.
 */
public class PlanToWorkTodoTaskDao {
    @SerializedName("MSG")
    public String msg;
    @SerializedName("COM_CODE")
    public String comCode;
    @SerializedName("DETAIL")
    public List<ListPlanToWorkTodoTaskDao> detail;

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

    public List<ListPlanToWorkTodoTaskDao> getDetail() {
        return detail;
    }

    public void setDetail(List<ListPlanToWorkTodoTaskDao> detail) {
        this.detail = detail;
    }
}
