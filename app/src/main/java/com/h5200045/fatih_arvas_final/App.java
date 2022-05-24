package com.h5200045.fatih_arvas_final;

import android.app.Application;

//Gövdesi boş olan Activity ve servisler gibi bileşenleri içeren temel bir sınıftır.
//Uygulamamız çalıştırıldığında ilk olarak çalışacak olan sınıf Application sınıfıdır
public class App extends Application {

    App instance = null;

    public App getApp(){

        if (instance == null){
            instance = this;
        }
        return instance;
    }

}
