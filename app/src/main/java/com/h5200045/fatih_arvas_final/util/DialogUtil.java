package com.h5200045.fatih_arvas_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import com.h5200045.fatih_arvas_final.R;
import com.h5200045.fatih_arvas_final.activity.MainActivity;

//DialogUtil classı uygulama içerisinde gösterilecek olan dialoglar için oluşturulmuştur.
public class DialogUtil {

    //İnternet olmadığında gösterilecek dialog için oluşturulmuştur. Parametre olarak activty ister.
    //Metot içinde positive ve negative butonları için iki adet fonksiyon çağırılır ve parametre olarak builder ve activty gönderilir.
    public static void internetControlDialog(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(R.string.internetDialog_title));
        builder.setMessage(activity.getResources().getString(R.string.internetDialog_message));
        builder.setIcon(activity.getResources().getDrawable(R.drawable.logo));
        builder.setCancelable(false);
        internetControlDialogSetNegativeButton(builder, activity);
        internetControlDialogSetPositiveButton(builder,activity);
        builder.show();
    }

    //Dialoğun positive buttonu için oluşturulmuştur çağırıldığı zaman switchBetweenScreens fonksiyonu çağrılır ve parametre olarak activity gönderilir.
    private static void internetControlDialogSetPositiveButton(AlertDialog.Builder builder, Activity activity) {

        builder.setPositiveButton(activity.getResources().getString(R.string.internetDialog_positiveButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switchBetweenScreens(activity);
            }
        });
    }

    //Dialoğun negative butonu için oluşturulmuştur çağırıldığı zaman dialog penceresini kapatır ve activityi öldürür.
    private static void internetControlDialogSetNegativeButton(AlertDialog.Builder builder, Activity activity) {

        builder.setNegativeButton(activity.getResources().getString(R.string.internetDialog_negativeButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                activity.finish();
            }
        });
    }

    //İnternet ayarlarına götürülmesi için oluşturulmuştur çağırıldığı zaman kullanıcıyı wifi ayarlarına yönlendirir. Parametre olarak activity ister.
    private static void switchBetweenScreens(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        activity.startActivity(intent);
    }

    //Ana ekranda çıkmak istenildiği zaman gösterilecek dialog için oluşturulmuştur.
    //Metot içerisinde positive ve negative butonları için iki adet fonksiyon çağırılır ve parametre olarak builder ve activty gönderilir.
    public static void backPressedDialog(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(R.string.backPressedDialog_title));
        builder.setMessage(activity.getResources().getString(R.string.backPressedDialog_message));
        builder.setIcon(activity.getResources().getDrawable(R.drawable.logo));
        builder.setCancelable(false);
        backPressedDialogSetPositiveButton(builder, activity);
        backPressedDialogSetNegativeButton(builder, activity);
        builder.show();

    }

    //Dialoğun positive buttonu için oluşturulmuştur çağırıldığı zaman dialog penceresini kapatır ve activityi öldürür.
    private static void backPressedDialogSetPositiveButton(AlertDialog.Builder builder, Activity activity) {

        builder.setPositiveButton(activity.getResources().getString(R.string.backPressedDialog_positiveButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                activity.finish();
            }
        });
    }

    //Dialoğun negative butonu için oluşturulmuştur çağırıldığı zaman dialog penceresini kapatır.
    private static void backPressedDialogSetNegativeButton(AlertDialog.Builder builder, Activity activity){

        builder.setNegativeButton(activity.getResources().getString(R.string.backPressedDialog_negativeButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
