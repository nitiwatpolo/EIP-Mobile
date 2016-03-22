package th.co.ask.eip_mobile.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 18/03/2559.
 */
public class LoginDao {

    @SerializedName("VAT_RATE")
    public String vatRate;
    @SerializedName("IS_PWD_EXPIRE")
    public String isPwdExpire;
    @SerializedName("CONCISE_BRANCH_CODE")
    public String conciseBranchCode;
    @SerializedName("COM_CODE")
    public String comCode;
    @SerializedName("USER_GRP")
    public String userGrp;
    @SerializedName("FULL_NAMET")
    public String fullNameT;
    @SerializedName("DEVICE")
    public String device;
    @SerializedName("MSG")
    public String msg;
    @SerializedName("FULL_NAMEE")
    public String fullNameE;
    @SerializedName("SECCODE")
    public String secCode;
    @SerializedName("CODE")
    public String code;
    @SerializedName("SALES_EXE")
    public String salesExe;

    public String getVatRate() {
        return vatRate;
    }

    public void setVatRate(String vatRate) {
        this.vatRate = vatRate;
    }

    public String getIsPwdExpire() {
        return isPwdExpire;
    }

    public void setIsPwdExpire(String isPwdExpire) {
        this.isPwdExpire = isPwdExpire;
    }

    public String getConciseBranchCode() {
        return conciseBranchCode;
    }

    public void setConciseBranchCode(String conciseBranchCode) {
        this.conciseBranchCode = conciseBranchCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getUserGrp() {
        return userGrp;
    }

    public void setUserGrp(String userGrp) {
        this.userGrp = userGrp;
    }

    public String getFullNameT() {
        return fullNameT;
    }

    public void setFullNameT(String fullNameT) {
        this.fullNameT = fullNameT;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFullNameE() {
        return fullNameE;
    }

    public void setFullNameE(String fullNameE) {
        this.fullNameE = fullNameE;
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSalesExe() {
        return salesExe;
    }

    public void setSalesExe(String salesExe) {
        this.salesExe = salesExe;
    }
}
