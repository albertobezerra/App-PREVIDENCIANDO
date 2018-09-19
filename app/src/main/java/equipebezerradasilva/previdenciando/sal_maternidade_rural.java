package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class sal_maternidade_rural extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sal_maternidade_rural);

        AdView mAdView = (AdView) findViewById(R.id.sal_maternidade_rural);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView txt = (TextView) findViewById(R.id.texto_fonte);
        TextView txt2 = (TextView) findViewById(R.id.texto_fonte2);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto.ttf");
        txt.setTypeface(font); txt2.setTypeface(font);
    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, sal_maternidade.class);
        startActivity(secondActivity);
    }
}
