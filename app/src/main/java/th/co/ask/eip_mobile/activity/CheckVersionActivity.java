package th.co.ask.eip_mobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import th.co.ask.eip_mobile.R;

public class CheckVersionActivity extends AppCompatActivity {
    private ImageView ivBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_version);
        initInstances();
    }

    private void initInstances() {
        ivBg = (ImageView) findViewById(R.id.ivBg);
        Glide.with(this).load(R.drawable.bg_check_update).into(ivBg);

        //TODO: Call Service
        goToLogin();
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
