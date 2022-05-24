package com.h5200045.fatih_arvas_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5200045.fatih_arvas_final.R;
import com.h5200045.fatih_arvas_final.util.GlideUtil;

//Bu sınıf DetailActivty ekranıdır.
//MainActivty ekranından gelen verileri yerleştirmek için oluşturulmuştur.
public class DetailActivity extends AppCompatActivity {

    ImageView imgBuyukResim;
    TextView txtBaslik, txtDetay;

    //Uygulama ilk kez oluşturulduğunda çalışacak metotdur layout olarak activity_detail.xml set edilmiştir ve init fonksiyonu çağırılmaktadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    //Uygulama oluşturulduğunda çalışacak fonksiyonların düzenli olması için tek bir fonksiyon içerisnde olması için oluşturulmuştur.
    //downloadCoverImage, setBaslik, setDetay fonksyionları çağırılmaktadır.
    private void init() {
        downloadCoverImage();
        setBaslik();
        setDetay();
    }

    //MainActivty ekranında gelen veriyi activity_detail ekranında başlık bölümüne yerleştirmek için oluşturulmuştur.
    //Intent sınıfında bulunan getIntent fonksyionu ile gelen veri bir değişkene atanıp daha sonra set edilmiştir.
    private void setBaslik() {

        txtBaslik = findViewById(R.id.txtBaslik);
        String txt_baslik = getIntent().getExtras().getString("isim");
        txtBaslik.setText(txt_baslik);

    }

    /* MainActivty ekranında gelen veriyi activity_detail ekranında detay bölümüne yerleştirmek için oluşturulmuştur.
     * Intent sınıfında bulunan getIntent fonksyionu ile gelen veri bir değişkene atanıp daha sonra set edilmiştir.
     * Html olarak gelen attributeları gösterebilmek için öncelikle sdk kontrolü yapıldıktan sonra set edilmiştir.
     */
    private void setDetay() {

        String txt_detay = getIntent().getExtras().getString("detay");
        txtDetay = findViewById(R.id.txtDetay);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            txtDetay.setText(Html.fromHtml(txt_detay, Html.FROM_HTML_MODE_LEGACY));

        }else{
            txtDetay.setText(Html.fromHtml(txt_detay));
        }

    }

    /* Uygulamanın kapak resminin indirilip import edilmesi için oluşturulmuştur.
     * GlideUtil sınıfından imageDownloadShow fonksyionu çağırılmaktadır.
     * Parametre olarak context, indirilecek olan resimin adresi ve gösterilecek olan imageview gönderilmiştir.
     * MainActivty ekranında gelen veriyi activity_detail ekranında kapak bölümüne yerleştirmek için oluşturulmuştur.
     * Intent sınıfında bulunan getIntent fonksyionu ile gelen veri bir değişkene atanıp daha sonra set edilmiştir.
     */
    private void downloadCoverImage() {
        imgBuyukResim = findViewById(R.id.imgBuyukResim);
        String resimUrl = getIntent().getExtras().getString("resim");
        GlideUtil.imageDownloadShow(getApplicationContext(), resimUrl, imgBuyukResim);
    }
}