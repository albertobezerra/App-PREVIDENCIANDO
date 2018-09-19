package equipebezerradasilva.previdenciando;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onesignal.OneSignal;

public class splash extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        Handler handler = new Handler();
        handler.postDelayed(this, 2000);

        //SharedPreferences preferences =
                //getSharedPreferences("user_preferences", MODE_PRIVATE);

        //if (preferences.contains("ja_abriu_app")) {
            //mostrarLogin();
        //} else {
            //adicionarPreferenceJaAbriu(preferences);
            //mostrarSplash();
        //}
    }

    //private void mostrarLogin() {
        //startActivity(new Intent(this, estacionario.class));
   // }

   // private void mostrarSplash() {
       // Handler handle = new Handler();
        //handle.postDelayed(new Runnable() {
           // @Override
           // public void run() {
            //    mostrarLogin();
          //  }
       // }, 3000);
    //}

   // private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
      //  SharedPreferences.Editor editor = preferences.edit();
        //editor.putBoolean("ja_abriu_app", true);
      //  editor.commit();
    //}

    @Override
    public void run() {
        startActivity(new Intent(this, estacionario.class));
        finish();
    }

}