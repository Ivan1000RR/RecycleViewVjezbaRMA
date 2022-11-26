package vidovic.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DodajActivity extends AppCompatActivity {

    private Button dodaj;
    private Button odustani;
    private EditText ime;
    private EditText prezime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj);

        poveziKomponente();
        defDogadjaje();
    }



    private void poveziKomponente() {
        dodaj = findViewById(R.id.dodaj);
        odustani = findViewById(R.id.odustaniBtn);
        ime = findViewById(R.id.etDodajIme);
        prezime = findViewById(R.id.etDodajPrezime);
    }

    private void dodajOsobu(){
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void defDogadjaje() {
        odustani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nazad();
            }
        });
    }

    private void nazad(){
        finish();
    }


}