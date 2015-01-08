package tt.com.timetable.comps.te;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

import com.afollestad.materialdialogs.Alignment;
import com.afollestad.materialdialogs.MaterialDialog;
import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;

import tt.com.timetable.R;

/**
 * Created by aditockzz on 02-Jan-15.
 */
public class Main_B extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tabslayout);
        force();
        ViewpagerAdapter adapter;
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        ViewPager pager = (ViewPager)findViewById(R.id.pager);

        toolbar.setTitle("TE Comps B");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.inflateMenu(R.menu.menu_main);
        tabs.setTextColor(getResources().getColor(R.color.white));

        //tabs.setIndicatorColor(getResources().getColor(R.color.material_blue_500));
        adapter = new ViewpagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

        pager.setOffscreenPageLimit(5);
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        }
        catch (Exception e) {
            // presumably, not relevant
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }


    public class ViewpagerAdapter extends FragmentPagerAdapter {

        private final int PAGES = 5;
        private String[] titles={"Monday", "Tuesday", "Wednesday","Thursday","Friday"};

        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Monday_B();
                case 1:
                    return new Tuesday_B();

                case 2:
                    return new Wednesday_B();

                case 3:
                    return new Thursday_B();
                case 4:
                    return new  Friday_B();

                default:
                    throw new IllegalArgumentException("The item position should be less or equal to:" + PAGES);

            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return PAGES;
        }

    }
    void force() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            // presumably, not relevant
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.defaults:
                SharedPreferences checks = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
                SharedPreferences.Editor editor = checks.edit();
                editor.putBoolean("checkbox",false);
                editor.apply();
                return true;

            case R.id.about:
                new MaterialDialog.Builder(this)
                        .contentAlignment(Alignment.LEFT)
                        .title("TimeTable v1.0")
                        .customView(R.layout.aboutandlicense)
                        .positiveText("DISMISS")
                        .build().show();
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
        //return false;
    }


}
