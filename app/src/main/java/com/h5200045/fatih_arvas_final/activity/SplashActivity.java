package com.h5200045.fatih_arvas_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5200045.fatih_arvas_final.R;
import com.h5200045.fatih_arvas_final.util.DialogUtil;
import com.h5200045.fatih_arvas_final.util.NetworkUtil;

//Bu sınıf Splash ekranıdır internet kontrolü ve MainActivity ekranına yönlendirmek için oluşturulmuştur
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    //Uygulama ilk kez oluşturulduğunda çalışacak metotdur layout olarak activity_splash.xml set edilmiştir ve holdScreen fonksiyonu çağırılmaktadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        holdScreen();
    }

    /*
    * Uygulama arka plana atıldıktan sonra tekrar açıldığında çalışacak metotdur.
    * Amacı kullanıcının internet ayarlarına yönledirildiği zaman bağlantıyı sağlamadan uygulamaya girmeye çalıştığında tekrar
    * internet kontrolü yapılması için oluşturulmuştur
    * internetControl fonksiyonu çağırılmaktadır. Parametre olarak activity ve context gönderilir
    */
    @Override
    protected void onRestart() {
        super.onRestart();
        internetControl(SplashActivity.this, getApplicationContext());
    }

    //Bu fonksiyon ekranın 3 saniyelik bekletip internet kontrolü yapıldıktan sonra MainActivity ekranına gidebilmek için oluşturulmuştur.
    //internetControl fonksiyonu çağırılmaktadır. Parametre olarak activity ve context gönderilir
    private void holdScreen() {

        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                internetControl(SplashActivity.this, getApplicationContext());
            }
        }.start();

    }

    /* İnternet bağlantısı kontrol etmek için oluşturulmuştur. Parametre olarak activity ve context ister.
     * İlk olarak NetworkUtil sınıfından isInternetConnection fonksyionu çağrılmıştır ve parametrik olarak gelen context gönderilmiştir
     * True değer dönmesi halinde switchBetweenScreens fonksiyonu çağırılır, parametrik olarak gelen activity gönderilir ve SplashActivity ekranı öldürülür.
     * False değer dönmesi halinde DialogUtil sınıfından internetControlDialog fonksiyonu çağırılır, parametrik olarak gelen activity gönderilir.
     */
    private void internetControl(Activity activity, Context context) {

        if (NetworkUtil.isInternetConnection(context)) {

            switchBetweenScreens(activity);
            finish();

        }else {
            DialogUtil.internetControlDialog(activity);
        }

    }

    //İnternet kontrolünün ardından MainActivity ekranına yönlendirmek için oluşturulmuştur. Parametre olarak activity ister.
    private void switchBetweenScreens(Activity activity){

        Intent intent = new Intent(activity, MainActivity.class);
        startActivity(intent);

    }
}