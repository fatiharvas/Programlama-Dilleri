package com.h5200045.fatih_arvas_final.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

//İnternetten resim indrmek için oluşturulmuştur.
public class GlideUtil {

    //İnternetten indirilen resimin ilgili image'a import etmek için oluşturulmuştur.
    //Parametre olarak context, indirilecek olan resimin adresi ve gösterilecek olan imageview ister.
    public static void imageDownloadShow(Context context, String imgURL, ImageView imageView) {

        Glide.with(context)
                .load(imgURL)
                .centerCrop()
                .into(imageView);

    }

}
