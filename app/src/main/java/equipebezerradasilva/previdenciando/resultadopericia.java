package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class resultadopericia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadopericia);

    }

    public void resultado(View view){
        Intent browserInternt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www2.dataprev.gov.br/sabiweb/relatorio/imprimirCRER.view?acao=imprimir_CRER"));
        startActivity(browserInternt);
    }

    public void voltar_estacionario(View view) {

        Intent secondActivity = new Intent(this, estacionario.class);
        startActivity(secondActivity);
    }
}