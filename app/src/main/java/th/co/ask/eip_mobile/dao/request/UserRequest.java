package th.co.ask.eip_mobile.dao.request;

/**
 * Created by nitiwat.li on 18/03/2559.
 */
public class UserRequest {
    private String device;
    private String userName;
    private String password;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
