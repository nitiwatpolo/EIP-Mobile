package th.co.ask.eip_mobile.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public class ListPlanDao implements Parcelable {
    @SerializedName("CUST_PRE_NAME")
    public String custPreName;
    @SerializedName("NAME_TH")
    public String nameTh;
    @SerializedName("CARD_NO")
    public String cardNo;
    @SerializedName("SALE_CALL_NO")
    public String saleCallNo;
    @SerializedName("TEL")
    public String tel;
    @SerializedName("CUST_PRE_NAME_CODE")
    public String custPreNameCode;
    @SerializedName("TODO_NAME")
    public String todoName;
    @SerializedName("TODO_CODE")
    public String todoCode;
    @SerializedName("NAME_EN")
    public String nameEn;
    @SerializedName("CUS_CODE")
    public String cusCode;
    @SerializedName("COM_CODE")
    public String comCode;
    @SerializedName("MKT_NAME")
    public String mktName;
    @SerializedName("CUST_PRE_NAME_TH")
    public String custPreNameTh;
    @SerializedName("CUST_FIRST_NAME_TH")
    public String custFirstNameTh;
    @SerializedName("CUST_CARD_TYPE_NAME")
    public String custCardTypeName;
    @SerializedName("NOTE")
    public String note;
    @SerializedName("CUST_LAST_NAME_TH")
    public String custLastNameTh;
    @SerializedName("IS_DEALER")
    public String isDealer;
    @SerializedName("CUST_MOBILE_3")
    public String custMobile3;
    @SerializedName("CUST_PRE_NAME_CODE_TH")
    public String custPreNameCodeTh;
    @SerializedName("CUST_MOBILE_1")
    public String custMobile1;
    @SerializedName("CUST_MOBILE_2")
    public String custMobile2;
    @SerializedName("DATE")
    public String date;
    @SerializedName("CUST_CARD_TYPE_CODE")
    public String custCardTypeCode;
    @SerializedName("ACTIVE")
    public String active;
    @SerializedName("IS_DIRECT_APPLY")
    public String isDirectApply;
    @SerializedName("SUB_ID")
    public String subId;
    @SerializedName("TITLE")
    public String title;

    public String getCustPreName() {
        return custPreName;
    }

    public void setCustPreName(String custPreName) {
        this.custPreName = custPreName;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSaleCallNo() {
        return saleCallNo;
    }

    public void setSaleCallNo(String saleCallNo) {
        this.saleCallNo = saleCallNo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCustPreNameCode() {
        return custPreNameCode;
    }

    public void setCustPreNameCode(String custPreNameCode) {
        this.custPreNameCode = custPreNameCode;
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

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getMktName() {
        return mktName;
    }

    public void setMktName(String mktName) {
        this.mktName = mktName;
    }

    public String getCustPreNameTh() {
        return custPreNameTh;
    }

    public void setCustPreNameTh(String custPreNameTh) {
        this.custPreNameTh = custPreNameTh;
    }

    public String getCustFirstNameTh() {
        return custFirstNameTh;
    }

    public void setCustFirstNameTh(String custFirstNameTh) {
        this.custFirstNameTh = custFirstNameTh;
    }

    public String getCustCardTypeName() {
        return custCardTypeName;
    }

    public void setCustCardTypeName(String custCardTypeName) {
        this.custCardTypeName = custCardTypeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustLastNameTh() {
        return custLastNameTh;
    }

    public void setCustLastNameTh(String custLastNameTh) {
        this.custLastNameTh = custLastNameTh;
    }

    public String getIsDealer() {
        return isDealer;
    }

    public void setIsDealer(String isDealer) {
        this.isDealer = isDealer;
    }

    public String getCustMobile3() {
        return custMobile3;
    }

    public void setCustMobile3(String custMobile3) {
        this.custMobile3 = custMobile3;
    }

    public String getCustPreNameCodeTh() {
        return custPreNameCodeTh;
    }

    public void setCustPreNameCodeTh(String custPreNameCodeTh) {
        this.custPreNameCodeTh = custPreNameCodeTh;
    }

    public String getCustMobile1() {
        return custMobile1;
    }

    public void setCustMobile1(String custMobile1) {
        this.custMobile1 = custMobile1;
    }

    public String getCustMobile2() {
        return custMobile2;
    }

    public void setCustMobile2(String custMobile2) {
        this.custMobile2 = custMobile2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustCardTypeCode() {
        return custCardTypeCode;
    }

    public void setCustCardTypeCode(String custCardTypeCode) {
        this.custCardTypeCode = custCardTypeCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIsDirectApply() {
        return isDirectApply;
    }

    public void setIsDirectApply(String isDirectApply) {
        this.isDirectApply = isDirectApply;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(custPreName);
        dest.writeString(nameTh);
        dest.writeString(cardNo);
        dest.writeString(saleCallNo);
        dest.writeString(tel);
        dest.writeString(custPreNameCode);
        dest.writeString(todoName);
        dest.writeString(todoCode);
        dest.writeString(nameEn);
        dest.writeString(cusCode);
        dest.writeString(comCode);
        dest.writeString(mktName);
        dest.writeString(custPreNameTh);
        dest.writeString(custFirstNameTh);
        dest.writeString(custCardTypeName);
        dest.writeString(note);
        dest.writeString(custLastNameTh);
        dest.writeString(isDealer);
        dest.writeString(custMobile3);
        dest.writeString(custPreNameCodeTh);
        dest.writeString(custMobile1);
        dest.writeString(custMobile2);
        dest.writeString(date);
        dest.writeString(custCardTypeCode);
        dest.writeString(active);
        dest.writeString(isDirectApply);
        dest.writeString(subId);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<ListPlanDao> CREATOR
            = new Parcelable.Creator<ListPlanDao>() {
        public ListPlanDao createFromParcel(Parcel in) {
            return new ListPlanDao(in);
        }

        public ListPlanDao[] newArray(int size) {
            return new ListPlanDao[size];
        }
    };

    private ListPlanDao(Parcel in) {
        custPreName = in.readString();
        nameTh = in.readString();
        cardNo = in.readString();
        saleCallNo = in.readString();
        tel = in.readString();
        custPreNameCode = in.readString();
        todoName = in.readString();
        todoCode = in.readString();
        nameEn = in.readString();
        cusCode = in.readString();
        comCode = in.readString();
        mktName = in.readString();
        custPreNameTh = in.readString();
        custFirstNameTh = in.readString();
        custCardTypeName = in.readString();
        note = in.readString();
        custLastNameTh = in.readString();
        isDealer = in.readString();
        custMobile3 = in.readString();
        custPreNameCodeTh = in.readString();
        custMobile1 = in.readString();
        custMobile2 = in.readString();
        date = in.readString();
        custCardTypeCode = in.readString();
        active = in.readString();
        isDirectApply = in.readString();
        subId = in.readString();
        title = in.readString();
    }
}
