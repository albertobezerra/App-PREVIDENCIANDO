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

public class sal_maternidade extends AppCompatActivity implements Runnable{

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salariomaternidade);

        MobileAds.initialize(this, "ca-app-pub-7979689703488774~5803496841");


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inters));
        AdRequest adRequest2 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest2);

        int[] lista = new int[]{

                R.drawable.sec_salariomaternidade_urbano, R.drawable.sec_salariomaternidade_rural



        };

        GridView gv = (GridView) findViewById(R.id.grid_salariomaternidade);

        gv.setAdapter(new adaptador(this, lista));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), sal_maternidade_urbano.class);
                    startActivityForResult(myIntent, 0);
                    displayInterstitial();
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), sal_maternidade_rural.class);
                    startActivityForResult(myIntent, 0);
                    displayInterstitial();
                }

            }


        });



    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, estacionario.class);
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