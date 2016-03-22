package th.co.ask.eip_mobile.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import th.co.ask.eip_mobile.dao.LoginDao;
import th.co.ask.eip_mobile.dao.request.UserRequest;

/**
 * Created by nitiwat.li on 18/03/2559.
 */
public interface CommonService {

    @GET("module/CommonServices/userLogin/{device}/{user}/{pwd}")
    Call<LoginDao> userLogin(@Path("device") String device, @Path("user") String user, @Path("pwd") String pwd);

    @POST("module/CommonServices/logout")
    Call<ResponseBody> logout(@Body UserRequest userRequest);

    @POST("module/CommonServices/UpdateExpireDateByCode")
    Call<LoginDao> UpdateExpireDateByCode(@Body UserRequest userRequest);

    @GET("module/CommonServices/checkVersionWithUserGroup/{device}/{version}/{group}")
    Call<LoginDao> checkVersionWithUserGroup(@Path("version") String device,@Path("version") String version, @Path("group") String group);

      /*
    @GET("webask/saleservices/checkVersionWithUserGroup?device=Web")
    Call<CheckVersionDao> checkVersion(@Query("user") String user, @Query("pwd") String pwd,
                                       @Query("ver") String version, @Query("USER_GRP") String user_grp);
    @GET("")
    @Streaming
    Call<ResponseBody> downloadApk(@Url String url);
*/
}
