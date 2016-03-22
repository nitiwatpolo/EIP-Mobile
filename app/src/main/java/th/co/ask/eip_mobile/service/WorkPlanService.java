package th.co.ask.eip_mobile.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import th.co.ask.eip_mobile.dao.AllPlanDao;
import th.co.ask.eip_mobile.dao.MsgDao;
import th.co.ask.eip_mobile.dao.PlanByDateDao;
import th.co.ask.eip_mobile.dao.request.WorkPlanRequest;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public interface WorkPlanService {

    @GET("module/EIP_Services/workPlan_allPlan/{device}/{comCode}/{code}")
    Call<AllPlanDao> workPlan_allPlan(@Path("device")String device,
                                      @Path("comCode") String comCode,
                                      @Path("code") String code);

    @GET("module/EIP_Services/workPlan_PlanByDate/{device}/{comCode}/{code}/{date}")
    Call<PlanByDateDao> workPlan_PlanByDate(@Path("device")String device,
                                            @Path("comCode") String comCode,
                                            @Path("code") String code,
                                            @Path("date") String date);

    @POST("module/EIP_Services/workPlan_NewWorkPlan")
    Call<MsgDao> workPlan_NewWorkPlan(@Body WorkPlanRequest workPlanRequest);

    @GET("module/EIP_Services/workPlan_onLoadNewPlan/{device}/{comCode}")
    Call<PlanByDateDao> workPlan_onLoadNewPlan(@Path("device")String device,
                                               @Path("comCode") String comCode);
}
