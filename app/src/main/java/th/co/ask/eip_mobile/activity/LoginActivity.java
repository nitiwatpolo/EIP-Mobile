package th.co.ask.eip_mobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.fragment.IntroduceFragment;
import th.co.ask.eip_mobile.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainerIntroduce, IntroduceFragment.newInstance())
                    .add(R.id.contentContainerLogin, LoginFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onClickListener() {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
