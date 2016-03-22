package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 22/03/2559.
 */
public class PlanToWorkTodoTaskDao {
    @SerializedName("MSG")
    public String msg;
    @SerializedName("TODO_NAME")
    public String todoName;
    @SerializedName("TODO_CODE")
    public String todoCode;
    @SerializedName("NUM")
    public String num;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoCode() {
        return todoCode;
    }

    public void setTodoCode(String todoCode) {
        this.todoCode = todoCode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
