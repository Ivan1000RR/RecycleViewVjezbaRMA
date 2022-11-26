package vidovic.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalji extends AppCompatActivity {

    private TextView tvIme;
    private TextView tvPrezime;
    private Button btnNazad;
    private ImageView ivSlika;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        poveziKomponente();
        defDogadjaje();
    }

    private void defDogadjaje() {
        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nazad();
            }
        });
        Intent i = getIntent();
        Osoba o = (Osoba) i.getSerializableExtra("osoba");
        tvIme.setText(o.getIme());
        tvPrezime.setText(o.getPrezime());
        new DownloadImageTask(ivSlika).execute(o.getUrlSlika());
    }

    private void nazad() {
        finish();
    }

    private void poveziKomponente() {
        tvIme = findViewById(R.id.tvIme);
        tvPrezime = findViewById(R.id.tvPrezime);
        btnNazad = findViewById(R.id.btnNazad);
        ivSlika = findViewById(R.id.ivSlika);
    }


}