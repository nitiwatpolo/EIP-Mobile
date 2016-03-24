package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 22/03/2559.
 */
public class PlanToWorkTodoListDao {
    @SerializedName("MSG")
    public String msg;
    @SerializedName("COM_CODE")
    public String comCode;
    @SerializedName("DETAIL")
    public List<ListPlanToWorkTodoDetailDao> detail;
    @SerializedName("TODO_CODE")
    public String todoCode;

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

    public List<ListPlanToWorkTodoDetailDao> getDetail() {
        return detail;
    }

    public void setDetail(List<ListPlanToWorkTodoDetailDao> detail) {
        this.detail = detail;
    }

    public String getTodoCode() {
        return todoCode;
    }

    public void setTodoCode(String todoCode) {
        this.todoCode = todoCode;
    }
}
