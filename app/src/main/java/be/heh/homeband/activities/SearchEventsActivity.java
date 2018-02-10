package be.heh.homeband.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import be.heh.homeband.R;

/**
 * Created by christopher on 03/02/2018.
 */

public class SearchEventsActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:


                    Intent intent = new Intent (getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_place:


                    Intent intent2 = new Intent (getApplicationContext(),SearchGroupeActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_favorite:

                    return true;
                case R.id.navigation_settings:

                    return true;
            }
            return false;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchevents);

        Button next = (Button) findViewById(R.id.btnGroupe);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SearchGroupeActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Switch s = (Switch) findViewById(R.id.switch1);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    EditText Du = (EditText) findViewById(R.id.etDu);
                    EditText Au = (EditText) findViewById(R.id.etAu);
                    TextView Dut = (TextView) findViewById(R.id.textView);
                    TextView Aut = (TextView) findViewById(R.id.textView5);
                    Du.setVisibility(View.VISIBLE);
                    Au.setVisibility(View.VISIBLE);
                    Dut.setVisibility(View.VISIBLE);
                    Aut.setVisibility(View.VISIBLE);
                }
                else   {
                    EditText Du = (EditText) findViewById(R.id.etDu);
                    EditText Au = (EditText) findViewById(R.id.etAu);
                    TextView Dut = (TextView) findViewById(R.id.textView);
                    TextView Aut = (TextView) findViewById(R.id.textView5);
                    Du.setVisibility(View.INVISIBLE);
                    Au.setVisibility(View.INVISIBLE);
                    Dut.setVisibility(View.INVISIBLE);
                    Aut.setVisibility(View.INVISIBLE);
                }


            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

}