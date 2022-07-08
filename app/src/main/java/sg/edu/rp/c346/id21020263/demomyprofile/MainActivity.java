package sg.edu.rp.c346.id21020263.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);



    }

    @Override
    protected void onPause() {
        super.onPause();
        // get user input
        String strName = etName.getText().toString();
        float strGPA = Float.parseFloat(etGPA.getText().toString());
        // obtaining instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // obtaining instance of SharedPreference Editor
        SharedPreferences.Editor prefEdit = prefs.edit();
        // adding key-value pair to SharedPreferences
        prefEdit.putString("name",strName);
        prefEdit.putFloat("GPA", strGPA);
        // commit to save changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // obtaining instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // retrieving saved data from SharedPreferences
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("GPA", 0.0f);
        // update UI elements with values
        etName.setText(strName);
        etGPA.setText(gpa + "");
    }
}