package id.ac.poliban.dts.alfin.lat012;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName  = findViewById(R.id.etLastName);
        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);
        TextView tvResult =findViewById(R.id.tvResult);


        btSave.setOnClickListener(v -> {
            SharedPreferences sp =getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            String Iname,fname;
            Iname = etFirstName.getText().toString();
            fname = etLastName.getText().toString();

            edit.putString("Iname", Iname);
            edit.putString("fname", fname);
            edit.apply();

            Toast.makeText(this, "data has been saved it", Toast.LENGTH_SHORT).show();


        });

        btLoad.setOnClickListener(v -> {
            SharedPreferences sp =getPreferences(Context.MODE_PRIVATE);
            String Iname = sp.getString("Iname","na");
            String Fname = sp.getString("Fname","na");
            tvResult.setText(String.format("%s %s", Fname,Iname));
        });
    }
}
