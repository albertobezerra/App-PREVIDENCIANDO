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

public class apo_idade extends AppCompatActivity implements Runnable {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apo_idade);

        MobileAds.initialize(this, "ca-app-pub-7979689703488774~5803496841");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inters));
        AdRequest adRequest2 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest2);

        int[] lista = new int[]{

                R.drawable.ter_aposentadoria_idade_urbana, R.drawable.ter_aposentadoria_idade_rural, R.drawable.ter_aposentadoria_idade_deficiente



        };

        GridView gv = (GridView) findViewById(R.id.grid_apo_idade);

        gv.setAdapter(new adaptador(this, lista));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), apo_idade_urbana.class);
                    startActivityForResult(myIntent, 0);
                    displayInterstitial();
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), apo_idade_rural.class);
                    startActivityForResult(myIntent, 1);
                    displayInterstitial();
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), apo_idade_deficiente.class);
                    startActivityForResult(myIntent, 2);
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
