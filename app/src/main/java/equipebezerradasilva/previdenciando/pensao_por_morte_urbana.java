package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class pensao_por_morte_urbana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensao_por_morte_urbana);

        AdView mAdView = (AdView) findViewById(R.id.pensao_por_morte_urbana);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView txt = (TextView) findViewById(R.id.texto_fonte);
        TextView txt2 = (TextView) findViewById(R.id.texto_fonte2);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto.ttf");
        txt.setTypeface(font); txt2.setTypeface(font);
    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, pensao_por_morte.class);
        startActivity(secondActivity);
    }
}
