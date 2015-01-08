package tt.com.timetable;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerTabStrip;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.Alignment;
import com.afollestad.materialdialogs.MaterialDialog;


public class MainActivity extends ActionBarActivity {

   // Boolean ischecked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Boolean  ischecked =  getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("checkbox",false);
     // Boolean isclicked =   getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("clicked",false);
      Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE) .getBoolean("isfirstrun", false);


        if(isFirstRun)
        {
            new MaterialDialog.Builder(this)
                    .title("TimeTable 1.0")
                    .content("The 'data' in the application" +
                            "belongs to Datta Meghe College " +
                            "of Engineering,Airoli and the same" +
                            "reserves the right to change any timetable entry." +
                            "The author will try his best to keep up with latest timetable.")

                    .positiveText("OK")
                    .build().show();
        }


        if (isFirstRun | !ischecked  ) {
            System.out.println("1stif="+ischecked);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isfirstrun", false).commit();
            Intent i = new Intent(MainActivity.this, Defaults.class);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            MainActivity.this.startActivity(i);
            finish();
            System.exit(0);
        }
        else

               {

                   SharedPreferences strings = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                   String year = strings.getString("Year","");
                   String branch = strings.getString("Branch","");
                   String batch = strings.getString("Batch","");

                   Bundle b = new Bundle();
                   b.putStringArray("key",new String[]{year,branch,batch});

                   Intent call =  new Intent(MainActivity.this,Caller.class);
                   call.putExtras(b);

                   startActivity(call);
                   finish();
               /*
            System.out.println("else="+ischecked);
            Intent i = new Intent(MainActivity.this, Defaults.class);
            MainActivity.this.startActivity(i);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            System.exit(0);
            */


        }


    }


}