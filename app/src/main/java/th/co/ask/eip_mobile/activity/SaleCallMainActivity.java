package th.co.ask.eip_mobile.activity;


import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialize.util.UIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.fragment.PlanToWorkFragment;
import th.co.ask.eip_mobile.fragment.WorkPlanFragment;
import th.co.ask.eip_mobile.manager.CrossfadeWrapper;

public class SaleCallMainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Drawer result = null;
    private MiniDrawer miniResult = null;
    private Crossfader crossFader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_call_main);
        initInstances(savedInstanceState);
    }

    private void initInstances(Bundle savedInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("SALE CALL SYSTEM");


        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withDrawerItems(generateListDrawer())
                 .withGenerateMiniDrawer(true)
                .withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(drawerItemClickListener)
                .buildView();

        miniResult = result.getMiniDrawer().withInRTL(true);

        //get the widths in px for the first and second panel
        int firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        int secondWidth = (int) UIUtils.convertDpToPixel(72, this);

        crossFader = new Crossfader()
                .withContent(findViewById(R.id.rootContent))
                .withFirst(result.getSlider(), firstWidth)
                .withSecond(miniResult.build(this), secondWidth)
                .withSavedInstance(savedInstanceState)
                .build();

        miniResult.withCrossFader(new CrossfadeWrapper(crossFader));
        crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
        crossFader.getCrossFadeSlidingPaneLayout().setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.colorAccent));
    }

    private List<IDrawerItem> generateListDrawer() {
        List<IDrawerItem> mStickyDrawerItems = new ArrayList<>();
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("WORKPLAN").withName("Work Plan").withIcon(GoogleMaterial.Icon.gmd_event).withIdentifier(1));
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("PlanToWork").withName("Plan to Work").withIcon(GoogleMaterial.Icon.gmd_timer).withIdentifier(2));
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("TODO").withName("To do").withIcon(GoogleMaterial.Icon.gmd_contact_phone).withIdentifier(3));
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("SEARCH").withName("SEARCH").withIcon(GoogleMaterial.Icon.gmd_search).withIdentifier(4));
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("MKT REPORT").withName("KT REPORT").withIcon(GoogleMaterial.Icon.gmd_insert_chart).withIdentifier(5));
        mStickyDrawerItems.add(new PrimaryDrawerItem().withTag("WORK PLAN REPORT").withName("WORK PLAN REPORT").withIcon(GoogleMaterial.Icon.gmd_assignment).withIdentifier(6));

        return mStickyDrawerItems;
    }

    private void initFragment(String tag) {
        if (tag.equals("WORKPLAN")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, WorkPlanFragment.newInstance()).commit();
        } else if (tag.equals("PlanToWork")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, PlanToWorkFragment.newInstance()).commit();

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState = result.saveInstanceState(outState);
        outState = crossFader.saveInstanceState(outState);

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    Drawer.OnDrawerItemClickListener drawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            if (drawerItem instanceof Nameable) {
                Toast.makeText(SaleCallMainActivity.this, ((Nameable) drawerItem).getName().getText(SaleCallMainActivity.this)
                        , Toast.LENGTH_SHORT).show();
                initFragment(drawerItem.getTag().toString());
                result.closeDrawer();
            }
            return false;
        }
    };
}
