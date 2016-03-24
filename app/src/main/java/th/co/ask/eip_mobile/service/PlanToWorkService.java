package th.co.ask.eip_mobile.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import th.co.ask.eip_mobile.dao.MsgDao;
import th.co.ask.eip_mobile.dao.PlanToWorkTodoListDao;
import th.co.ask.eip_mobile.dao.PlanToWorkTodoTaskDao;
import th.co.ask.eip_mobile.dao.request.ReWorkPlanRequest;

/**
 * Created by nitiwat.li on 21/03/2559.
 */
public interface PlanToWorkService {

    @GET("module/EIP_Services/planToWork_todoTask/{device}/{comCode}/{code}")
    Call<PlanToWorkTodoTaskDao> planToWork_todoTask(@Path("device") String device,
                                                    @Path("comCode") String comCode,
                                                    @Path("code") String code);

    @GET("module/EIP_Services/planToWork_todoList/{device}/{comCode}/{code}/{todoCode}/{page}/{numPerPage}/{field}/{value}")
    Call<PlanToWorkTodoListDao> planToWork_todoList(@Path("device") String device,
                                            @Path("comCode") String comCode,
                                            @Path("code") String code,
                                            @Path("todoCode") String todoCode,
                                            @Path("page") int page,
                                            @Path("numPerPage") int numPerPage,
                                            @Path("field") String field,
                                            @Path("value") String value);

    @POST("module/EIP_Services/planToWork_todo_reWorkPlan")
    Call<MsgDao> planToWork_todo_reWorkPlan(@Body ReWorkPlanRequest reWorkPlanRequest);

}
