package th.co.ask.eip_mobile;

import android.app.Application;

import th.co.ask.eip_mobile.manager.Contextor;

/**
 * Created by nitiwat.li on 14/03/2559.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
