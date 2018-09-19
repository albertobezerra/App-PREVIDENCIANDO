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

public class pensao_por_morte extends AppCompatActivity implements Runnable{

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensao_por_morte);

        MobileAds.initialize(this, "ca-app-pub-7979689703488774~5803496841");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inters));
        AdRequest adRequest2 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest2);

        int[] lista = new int[]{

                R.drawable.ter_pensaopormorteurbana, R.drawable.ter_pensaopormorterural



        };

        GridView gv = (GridView) findViewById(R.id.grid_pensao_por_morte);

        gv.setAdapter(new adaptador(this, lista));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), pensao_por_morte_urbana.class);
                    startActivityForResult(myIntent, 0);

                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), pensao_por_morte_rural.class);
                    startActivityForResult(myIntent, 0);

                }

            }


        });



    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, pensoes.class);
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