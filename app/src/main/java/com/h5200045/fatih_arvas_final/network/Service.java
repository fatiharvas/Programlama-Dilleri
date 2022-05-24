package com.h5200045.fatih_arvas_final.network;

import com.h5200045.fatih_arvas_final.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//Github üzerinde oluşturulmuş olan JSON verilerini çekmek için oluşturulmuştur.
public class Service {

    private static Retrofit retrofit;

    //Ağ üzerinden JSON verilerini sorunsuz bir şekilde alınmasını için oluşturulmuştur.
    //Ayrıca uygulama ve sunucu arasındaki ileretişimi sağlamaktadır.
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;

    }

    static OkHttpClient okHttpClient;

    //Web'den veri göndermek ve almak için oluşturulmuştur.
    private static OkHttpClient getOkHttpClient() {

        if(okHttpClient == null) {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }
        return okHttpClient;

    }

    ServiceApi serviceApi;

    //GET işlemi için oluşturulmuş olan serviceapi interface kullanmak için oluşturulmuştur.
    public ServiceApi getServiceApi() {

        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }
        return serviceApi;

    }

}
