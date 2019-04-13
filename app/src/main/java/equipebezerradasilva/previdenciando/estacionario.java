package equipebezerradasilva.previdenciando;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class estacionario extends AppCompatActivity implements Runnable {

    private InterstitialAd interstitialAd;
    private final  int REQUEST_ACESS_FINE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionario);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_ACESS_FINE);


            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId(getResources().getString(R.string.inters));
            AdRequest adRequest2 = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest2);

            int[] lista = new int[]{

                    R.drawable.agende_aqui, R.drawable.resultado, R.drawable.menu_aposentadorias, R.drawable.menu_auxiliodoenca, R.drawable.menu_salariomaternidade,
                    R.drawable.menu_loas, R.drawable.menu_pensoes, R.drawable.menu_auxilio_acidente, R.drawable.menu_auxilioreclusao, R.drawable.sobre

            };

        GridView gv = (GridView) findViewById(R.id.grid_estacionario);

        gv.setAdapter(new adaptador(this, lista));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), agendamentos.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), resultadopericia.class);
                    startActivityForResult(myIntent, 1);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), aposentadorias.class);
                    startActivityForResult(myIntent, 2);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), aux_doenca.class);
                    startActivityForResult(myIntent, 3);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), sal_maternidade.class);
                    startActivityForResult(myIntent, 4);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), loas.class);
                    startActivityForResult(myIntent, 5);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), pensoes.class);
                    startActivityForResult(myIntent, 6);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), aux_acidentario.class);
                    startActivityForResult(myIntent, 7);
                }

                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), aux_reclusao.class);
                    startActivityForResult(myIntent, 8);
                }

                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), sobre.class);
                    startActivityForResult(myIntent, 9);
                }




            }


        });



    }

    public void voltar_t1(View view) {

        Intent secondActivity = new Intent(this, splash.class);
        startActivity(secondActivity);
    }

    public void displayInterstitial(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }

    @Override
    public void run() {
        displayInterstitial();
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_ACESS_FINE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permitido", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Acesso negado", Toast.LENGTH_LONG).show();
        }
    }
}
