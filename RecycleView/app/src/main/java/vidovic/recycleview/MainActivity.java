package vidovic.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListe.ItemClickInterface {

    private RecyclerView recyclerView;
    private AdapterListe adapterListe;
    private static final String RESOURCE_OSOBE = "osobe";
    private Button btnDodaj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poveziKomponente();
        dohvatiPodatke();
    }

    private void dohvatiPodatke() {
        adapterListe = new AdapterListe(this);
        adapterListe.setItemClickInterface(this);
        recyclerView.setAdapter(adapterListe);

        String url = getString(R.string.REST_API) + "/" + RESOURCE_OSOBE + "?" + getString(R.string.REST_API_KLJUC);
        Log.d("URL: ", url);

        RESTTask restTask = new RESTTask();
        restTask.execute(url, "", "", "");

    }

    private class RESTTask extends AsyncTask<String, Void, List<Osoba>>{

        @Override
        protected List<Osoba> doInBackground(String... strings) {
            String urlOsobe = strings[0];
            try {
                URL url = new URL(urlOsobe);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();

                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                Odgovor odgovor = new Gson().fromJson(bufferedReader, Odgovor.class);

                bufferedReader.close();
                inputStreamReader.close();

                if(odgovor.getGreska()){
                    return null;
                }

                return  odgovor.getOsobe();

            }catch (Exception e){
                Log.d("REST exception", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Osoba> osobas) {
            if(osobas == null){
                Toast.makeText(getApplicationContext(), getString(R.string.REST_problem), Toast.LENGTH_LONG).show();
                return;
            }
            
            adapterListe.setOsobe(osobas);
            adapterListe.notifyDataSetChanged();
        }
    }



    private void poveziKomponente(){
        recyclerView=findViewById(R.id.rvLista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnDodaj = findViewById(R.id.btnDodaj);
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otvori2aktivnost();
            }
        });

    }
    private void otvori2aktivnost(){
        Intent i = new Intent(this,DodajActivity.class);
        startActivity(i);
    }

    @Override
    public void onItemClick(Osoba osoba) {
        Intent i = new Intent(this, Detalji.class);
        i.putExtra("osoba", osoba);
        startActivity(i);
        Log.wtf("Osoba, ", osoba.getPrezime());
    }
}