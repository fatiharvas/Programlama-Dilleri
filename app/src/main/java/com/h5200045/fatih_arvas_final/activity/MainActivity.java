package com.h5200045.fatih_arvas_final.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.h5200045.fatih_arvas_final.R;
import com.h5200045.fatih_arvas_final.adapter.ProgramlamaDilleriAdapter;
import com.h5200045.fatih_arvas_final.model.ProgramlamaDilleri;
import com.h5200045.fatih_arvas_final.network.Service;
import com.h5200045.fatih_arvas_final.util.Constants;
import com.h5200045.fatih_arvas_final.util.DialogUtil;
import com.h5200045.fatih_arvas_final.util.GlideUtil;
import com.h5200045.fatih_arvas_final.util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
* Bu sınıf MainActivity ekranıdır.
* Kapak resmini indirmek ve import etmek,
* Geri tuşuna basıldığında dialog penceresini göstermek,
* İtemları recylerview'e yerleştirmek,
* Tıklandığında detay sayfasına veriyi yollamak ve DetailActivity ekranına yönlendirmek için oluşturulmuştur
* */
public class MainActivity extends AppCompatActivity {

    ImageView imgCover;
    RecyclerView recyclerView;

    //Uygulama ilk kez oluşturulduğunda çalışacak metotdur layout olarak activity_main.xml set edilmiştir ve init fonksiyonu çağırılmaktadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //Ana ekranda geri tuşuna basıldığında çalışacak metotdur.
    //DialogUtil sınıfından backPressedDialog fonksiyonuna çağırmaktadır parametre olarak activity gönderilir.
    @Override
    public void onBackPressed() {
        DialogUtil.backPressedDialog(MainActivity.this);
    }

    //Uygulama oluşturulduğunda çalışacak fonksiyonların düzenli olması için tek bir fonksiyon içerisnde olması için oluşturulmuştur.
    //downloadCoverImage ve getProgrammingLanguages fonksyionları çağırılmaktadır.
    private void init() {
        downloadCoverImage();
        getProgrammingLanguages();
    }

    /* Uygulamanın kapak resminin indirilip import edilmesi için oluşturulmuştur.
     * GlideUtil sınıfından imageDownloadShow fonksyionu çağırılmaktadır.
     * Parametre olarak context, indirilecek olan resimin adresi ve gösterilecek olan imageview gönderilmiştir.
    */
    private void downloadCoverImage() {
        imgCover = findViewById(R.id.imgCover);
        GlideUtil.imageDownloadShow(getApplicationContext(), Constants.COVER_IMAGE_URL, imgCover);
    }

    /* İtemları activity_main.xml ekranına yerleştirmek ve itemlara tıklandığında verileri aktarıp DetailActivity erkanına yönlendirmek için oluşturulmuştur.
     * Parametre olarak ProgramlamaDilleri sınıfında bir liste ister.
     * İlk olarak itemların yerleştirileceği recyclerView activity_main ekranından id ile bulunur.
     * Daha sonra ProgramlamaDilleriAdapter sınıfından adapter objesi oluşturulur içerisine olarak parametrik olarak gelen liste, context ve tıklanma özelliği için onItemClick gönderilir.
     * */
    private void initRecyclerView(List<ProgramlamaDilleri> programlamaDilleriList) {
        recyclerView = findViewById(R.id.rcvLanguages);
        ProgramlamaDilleriAdapter adapter = new ProgramlamaDilleriAdapter(programlamaDilleriList, getApplicationContext(), new ProgramlamaDilleriAdapter.OnItemClickListener() {

            //Ana ekranda itemlara tıklanma özelliği verebilmek için oluşturuluştur parametre olarak ProgramlamaDilleri sınıfından bir obje ister
            //Verileri aktarmak ve DetailActivity ekranına yönlendirmek için transferDataBetweenScreens fonksyionu çağırılmaktadır parametrik olarak gelen obje gönderilir.
            @Override
            public void onItemClick(ProgramlamaDilleri tiklananDil) {
                transferDataBetweenScreens(tiklananDil);
            }
        });

        //İtemların nasıl listeleneciği belirtilmiştir alt alta sıralanması için setLayoutManager fonksyionu kullanılmıştır.
        //Son olarak adapter set edilmiştir.
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    /* Tıklanan item'ın verilerini aktarmak ve DetailActivty ekranına yönledirmek için oluşturulmuştur.
     * Parametre olarak ProgramlamaDilleri sınıfında bir obje alır.
     * Gelen objeyi intent sınıfı içerisinde bulunan putExtra fonksyionu ile veriler aktarılır.
     * Aktarılan veriler başlık, resimurl ve detay bilgileridir.
     * Son olarak activity başlatılır.
     */
    private void transferDataBetweenScreens(ProgramlamaDilleri tiklananDil) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("isim", tiklananDil.getProgramlamaDili());
        intent.putExtra("resim",tiklananDil.getBuyukResimUrl());
        intent.putExtra("detay", tiklananDil.getDetay());
        startActivity(intent);
    }

    //JSON üzerindeki verililerin çekilmesi ve servisin çağırılması için oluşturulmuştur.
    void getProgrammingLanguages() {

        new Service().getServiceApi().getProgrammingLanguages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ProgramlamaDilleri>>() {

                    List<ProgramlamaDilleri> programlamaDilleri = new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<ProgramlamaDilleri> programlamaDilleris) {
                        programlamaDilleri = programlamaDilleris;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    //Servis çağırıldıktan sonra programlamaDilleri listesinin içerisinde veri olması durumunda initRecyclerView fonksyionu çağırılmaktadır.
                    //İçerisine oluşturulmuş olan programlamaDilleri listesi gönderilir.
                    @Override
                    public void onComplete() {

                        if (programlamaDilleri.size() > 0) {
                            initRecyclerView(programlamaDilleri);
                        }

                    }
                });

    }

}