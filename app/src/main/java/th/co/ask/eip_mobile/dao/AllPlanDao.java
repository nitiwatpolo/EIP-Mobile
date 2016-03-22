package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class AllPlanDao {
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
}
