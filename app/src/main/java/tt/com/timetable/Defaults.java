package tt.com.timetable;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import tt.com.timetable.Caller;

public class Defaults extends Activity {
    String year;
    String branch = "Computer";
    String batch;
    List<String> BatchArray;
    CheckBox check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defaults);
        check = (CheckBox)findViewById(R.id.defaultcheck);
        SharedPreferences checks = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        check.setChecked(checks.getBoolean("checkbox",false));
       // check.setChecked(checks.getBoolean("checkbox"));
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences checks = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
                SharedPreferences.Editor editor = checks.edit();
                editor.putBoolean("checkbox", check.isChecked());
                editor.apply();
                check.setChecked(checks.getBoolean("checkbox", false));


            }
        });



        BatchArray  = new ArrayList<>();

        String fonts = "fonts/Roboto-Medium.ttf";   //set font
        TextView text = (TextView) findViewById(R.id.Details);
        Typeface tf = Typeface.createFromAsset(getAssets(), fonts);
        text.setTypeface(tf);

        String headfont  = "fonts/Roboto-Medium.ttf";
        TextView heads = (TextView)findViewById(R.id.headtitles);
        Typeface fs = Typeface.createFromAsset(getAssets(),headfont);
        heads.setTypeface(fs);

      final  tt.com.timetable.FloatingActionButton fab;   //Code for FAB
          fab = new tt.com.timetable.FloatingActionButton.Builder(this)
                .withButtonColor(Color.parseColor("#536DFE"))
                .withButtonSize(72)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_done))
                .withGravity(Gravity.RIGHT )
                .withMargins(90, 100, 16, 0)
                .create();


        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f, //FAB animation
                5000.0f, 0.0f);
        animation.setDuration(700);
        animation.setFillAfter(true);

        fab.startAnimation(animation);

         Spinner Year = (Spinner) findViewById(R.id.Year); // item listener for Year
         year = Year.getItemAtPosition(0).toString();      // set default position to 0th location
         Year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                  year =  parent.getItemAtPosition(pos).toString();

             }

             public void onNothingSelected(AdapterView<?> parent) {

             }

         });
        BatchArray.add("Batch A");
        BatchArray.add("Batch B");
        add();
        /*
         final Spinner Branch  = (Spinner)findViewById(R.id.Branch); //item listener for Branch
        branch = Branch.getItemAtPosition(0).toString();
        Branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                branch = parent.getItemAtPosition(pos).toString();
                if ((year.compareTo("First Year")) == 0) {
                    if ((branch.compareTo("Computer")) == 0)
                        {   Clear();
                            BatchArray.add("Batch A");
                            BatchArray.add("Batch B");
                            add();
                        }
                    else
                    if ((branch.compareTo("Electronics")) == 0)
                    {
                        Clear();
                        BatchArray.add("Batch c");
                        BatchArray.add("Batch d");
                        add();
                    }
                    else
                    if ((branch.compareTo("IT")) == 0)
                    {
                        Clear();
                        BatchArray.add("Batch e");
                        BatchArray.add("Batch f");
                        add();
                    }

                }

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
            //Items will get added to Spinner Batch based on content of Spinners
            // Year and Branch respectively
            */

        final Spinner Batch = (Spinner)findViewById(R.id.Batch); // item listener for Batch
        Batch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?>parent,View view,int pos,long id)
            {
                batch = (String)parent.getItemAtPosition(pos);

            }
            public void onNothingSelected(AdapterView<?>parent){

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedYear = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedYear.edit();

                editor.putString("Year",year).apply();
                editor.putString("Branch",branch).apply();
                editor.putString("Batch",batch).apply();

                Bundle b = new Bundle();
                b.putStringArray("key",new String[]{year,branch,batch});

                Intent call =  new Intent(Defaults.this,Caller.class);
                call.putExtras(b);
                startActivity(call);
                if(check.isChecked())
                finish();
            }
        });

    }

    public void add()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,BatchArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.Batch);
        sItems.setAdapter(adapter);
    }
    public void Clear()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,new String[0]);

            BatchArray.removeAll(BatchArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.Batch);
        sItems.setAdapter(adapter);
    }



}


