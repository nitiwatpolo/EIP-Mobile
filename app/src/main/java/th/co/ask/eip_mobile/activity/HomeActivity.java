package th.co.ask.eip_mobile.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.fragment.MainMenuFragment;
import th.co.ask.eip_mobile.fragment.ProfileFragment;
import th.co.ask.eip_mobile.fragment.WorkingFragment;

public class HomeActivity extends AppCompatActivity implements WorkingFragment.WorkingListener {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivBgToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initInstances();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainerProfile, ProfileFragment.newInstance())
                    .add(R.id.contentContainerMainMenu, MainMenuFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {
        ivBgToolbar = (ImageView) findViewById(R.id.ivBgToolbar);
        Glide.with(this).load(R.drawable.bg_toolbar).into(ivBgToolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        final Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        collapsingToolbarLayout.setCollapsedTitleTypeface(tf);
        collapsingToolbarLayout.setExpandedTitleTypeface(tf);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.activity_home_appbar_title));

    }

    @Override
    public void onMenuClickListener() {
        Intent intent  = new Intent(HomeActivity.this, SaleCallMainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
