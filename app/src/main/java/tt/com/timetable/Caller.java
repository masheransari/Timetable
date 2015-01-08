package tt.com.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import tt.com.timetable.comps.se.*;


public  class  Caller extends  ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = this.getIntent().getExtras();
        String[]array =b.getStringArray("key");

        String year = array[0];
        String branch = array[1];
        String batch = array[2];


        if(year.compareTo("Second Year")==0)
            if(branch.compareTo("Computer")==0)
           if(batch.compareTo("Batch A")==0) {

            Intent acts = new Intent(Caller.this, tt.com.timetable.comps.se.Main_A.class);
           Caller.this.startActivity(acts);

           finish();

        }
        if(year.compareTo("Second Year")==0)
            if(branch.compareTo("Computer")==0)
                if(batch.compareTo("Batch B")==0) {

                    Intent acts = new Intent(Caller.this, tt.com.timetable.comps.se.Main_B.class);
                    Caller.this.startActivity(acts);
                    finish();

                }
/////////////////////////////////////////////////////////////////////////////////////
        if(year.compareTo("Third Year")==0)
            if(branch.compareTo("Computer")==0)
                if(batch.compareTo("Batch A")==0) {

                    Intent acts = new Intent(Caller.this, tt.com.timetable.comps.te.Main_A.class);
                    Caller.this.startActivity(acts);
                    finish();

                }
        if(year.compareTo("Third Year")==0)
            if(branch.compareTo("Computer")==0)
                if(batch.compareTo("Batch B")==0) {

                    Intent acts = new Intent(Caller.this, tt.com.timetable.comps.te.Main_B.class);
                    Caller.this.startActivity(acts);
                    finish();

                }
        ////////////////////////////////////////////////////////////////////////////////
        if(year.compareTo("Fourth Year")==0)
            if(branch.compareTo("Computer")==0)
                if(batch.compareTo("Batch A")==0) {

                    Intent acts = new Intent(Caller.this, tt.com.timetable.comps.be.Main_A.class);
                    Caller.this.startActivity(acts);
                    finish();

                }
        if(year.compareTo("Fourth Year")==0)
            if(branch.compareTo("Computer")==0)
                if(batch.compareTo("Batch B")==0) {

                    Intent acts = new Intent(Caller.this, tt.com.timetable.comps.be.Main_B.class);
                    Caller.this.startActivity(acts);
                    finish();

                }
        /////////////////////////////////////////////////////////////////////////////////




    }
}
