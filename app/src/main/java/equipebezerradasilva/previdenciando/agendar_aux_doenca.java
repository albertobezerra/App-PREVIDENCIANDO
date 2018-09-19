package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class agendar_aux_doenca extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_aux_doenca);

    }

    public void agendar_ax1(View view){
        Intent browserInternt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www2.dataprev.gov.br/sabiweb/agendamento/inicio.view#sabiweb"));
        startActivity(browserInternt);
    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, agendamentos.class);
        startActivity(secondActivity);
    }
}
