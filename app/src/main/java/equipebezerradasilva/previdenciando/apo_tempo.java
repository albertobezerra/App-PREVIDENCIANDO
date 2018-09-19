package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class apo_tempo extends AppCompatActivity implements Runnable {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apo_tempo);

        MobileAds.initialize(this, "ca-app-pub-7979689703488774~5803496841");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inters));
        AdRequest adRequest2 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest2);

        int[] lista = new int[]{

                R.drawable.ter_aposentadoria_tempo_integral, R.drawable.ter_aposentadoria_tempo_proporcional, R.drawable.ter_aposentadoria_tempo_especial,
                R.drawable.ter_aposentadoria_tempo_professor, R.drawable.ter_aposentadoria_tempo_deficiente



        };

        GridView gv = (GridView) findViewById(R.id.grid_apo_tempo);

        gv.setAdapter(new adaptador(this, lista));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), apo_tempo_integral.class);
                    startActivityForResult(myIntent, 0);
                    displayInterstitial();
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), apo_tempo_proporcional.class);
                    startActivityForResult(myIntent, 1);
                    displayInterstitial();
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), apo_tempo_especial.class);
                    startActivityForResult(myIntent, 2);
                    displayInterstitial();
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), apo_tempo_professor.class);
                    startActivityForResult(myIntent, 3);
                    displayInterstitial();
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), apo_tempo_deficiente.class);
                    startActivityForResult(myIntent, 4);
                    displayInterstitial();
                }

            }


        });



    }

    public void voltar_aposentadorias(View view) {

        Intent secondActivity = new Intent(this, aposentadorias.class);
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
}
