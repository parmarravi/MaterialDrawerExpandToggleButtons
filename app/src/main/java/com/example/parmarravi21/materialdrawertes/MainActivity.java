package com.example.parmarravi21.materialdrawertes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class MainActivity extends AppCompatActivity {

    public Drawer deviceAdd;
    SecondaryDrawerItem about, itemAdd;
    public SwitchDrawerItem lamp, lightStrip, smartLightStrip, lamp1, lightStrip1, smartLightStrip1;
    public ExpandableDrawerItem LampEX, SmartLightEX, SimpleLightEX;
    Toolbar toolbar;
    //save our header or result
    private AccountHeader headerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sideNavigation(savedInstanceState);
    }

    private void sideNavigation(Bundle savedInstanceState) {
        Log.v("Side navigation", "Called");
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.header2)
                .withSavedInstance(savedInstanceState).build();

        about = new SecondaryDrawerItem()
                .withName("About")
                .withIconColor(getResources().getColor(R.color.white))
                .withIcon(FontAwesome.Icon.faw_info);
        itemAdd = new SecondaryDrawerItem()
                .withName("Add")
                .withIconColor(getResources().getColor(R.color.white))
                .withIcon(FontAwesome.Icon.faw_plus);

        lamp = new SwitchDrawerItem()
                .withName("lamp")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);

        smartLightStrip = new SwitchDrawerItem()
                .withName("smartLightStrip")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);

        lightStrip = new SwitchDrawerItem()
                .withName("lightStrip")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);


        lamp1 = new SwitchDrawerItem()
                .withName("lamp2")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);

        smartLightStrip1 = new SwitchDrawerItem()
                .withName("smartLightStrip2")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);

        lightStrip1 = new SwitchDrawerItem()
                .withName("lightStrip2")
                .withIconColor(getResources().getColor(R.color.white))
                .withOnCheckedChangeListener(onCheckedChangeListener)
                .withChecked(true)
                .withIcon(FontAwesome.Icon.faw_lightbulb_o);


        LampEX = new ExpandableDrawerItem()
                .withName("LampEX")
                .withIconColor(getResources().getColor(R.color.white))
                .withSubItems(new SwitchDrawerItem()
                        .withName("lightStrip")
                        .withIconColor(getResources().getColor(R.color.white))
                        .withOnCheckedChangeListener(onCheckedChangeListener)
                        .withChecked(true)
                        .withIcon(FontAwesome.Icon.faw_lightbulb_o));

        SmartLightEX = new ExpandableDrawerItem()
                .withName("SmartLightEX")
                .withIconColor(getResources().getColor(R.color.white))
                .withSubItems(new SwitchDrawerItem()
                        .withName("smartLight")
                        .withIconColor(getResources().getColor(R.color.white))
                        .withOnCheckedChangeListener(onCheckedChangeListener)
                        .withChecked(true)
                        .withIcon(FontAwesome.Icon.faw_lightbulb_o));

        SimpleLightEX = new ExpandableDrawerItem()
                .withName("SimpleLightEX")
                .withIconColor(getResources().getColor(R.color.white))
                .withSubItems(new SwitchDrawerItem()
                        .withName("SimpleLightEX")
                        .withIconColor(getResources().getColor(R.color.white))
                        .withOnCheckedChangeListener(onCheckedChangeListener)
                        .withChecked(true)
                        .withIcon(FontAwesome.Icon.faw_lightbulb_o));

        deviceAdd = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator())
                .withAccountHeader(headerResult)
                .withScrollToTopAfterClick(true)
                .withFooterDivider(true)
                .addDrawerItems(lamp, smartLightStrip, lightStrip)
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(LampEX, SmartLightEX, SimpleLightEX)
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(lamp1, smartLightStrip1, lightStrip1)
                .addDrawerItems(new DividerDrawerItem())
                .addStickyDrawerItems(about, itemAdd)
                .withOnDrawerNavigationListener(new Drawer.OnDrawerNavigationListener() {
                    @Override
                    public boolean onNavigationClickListener(View clickedView) {
                        MainActivity.this.finish();
                        Log.e("Navigation", " triggered");
                        //return true if we have consumed the event
                        return true;
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() //this will enabled only when the item is clicked in navigation bar
                {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {

                            if (((Nameable) drawerItem).getName().getText().equals("Add")) {
                            } else if (((Nameable) drawerItem).getName().getText().equals("About")) {

                            } else {
                                String DeviceName = ((Nameable) drawerItem).getName().getText().toString();
                            }

                        }
                        return true;
                    }
                })
                .withSliderBackgroundDrawable(getResources().getDrawable(R.drawable.customcolornav))
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                if (((Nameable) drawerItem).getName() != null) {
                    Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
                } else {
                    Log.i("material-drawer", "toggleChecked: " + isChecked);
                }
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = deviceAdd.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (deviceAdd != null && deviceAdd.isDrawerOpen()) {
            deviceAdd.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
