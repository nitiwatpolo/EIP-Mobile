package th.co.ask.eip_mobile.utils;

import android.content.Context;

import th.co.ask.eip_mobile.manager.Contextor;

/**
 * Created by nitiwat.li on 18/03/2559.
 */
public class ServiceEndPoint {
    private static ServiceEndPoint instance;
    private Context mContext;
    private String baseUrlProduction = "http://27.254.21.111:8088/AskJsonWebServices/";
    private String baseUrlApp15 = "http://27.254.21.119:8088/AskJsonWebServicesApp15/";
    private String baseUrlApp16 = "http://27.254.21.119:8088/AskJsonWebServicesApp16/";
    private String baseUrlSelect = "";

    public static ServiceEndPoint getInstance() {
        if (instance == null)
            instance = new ServiceEndPoint();
        return instance;
    }

    private ServiceEndPoint() {
        mContext = Contextor.getInstance().getContext();
        if (baseUrlSelect.equals("")) {
            setBaseUrlApp16();
        }
    }

    public void setBaseUrlProduction() {
        baseUrlSelect = baseUrlProduction;
    }

    public void setBaseUrlApp15() {
        baseUrlSelect = baseUrlApp15;
    }

    public void setBaseUrlApp16() {
        baseUrlSelect = baseUrlApp16;
    }

    public String getBaseUrlSelect() {
        return baseUrlSelect;
    }
}
