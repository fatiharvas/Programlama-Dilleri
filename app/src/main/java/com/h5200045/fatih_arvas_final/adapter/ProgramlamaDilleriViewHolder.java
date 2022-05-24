package com.h5200045.fatih_arvas_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200045.fatih_arvas_final.R;

//Her itemin içinde bulunan bileşenlerin tanımlama işleminin yapılması için oluşturulmuştur.
//RecyclerView.ViewHolder sınıfından kalıtım alır.
public class ProgramlamaDilleriViewHolder extends RecyclerView.ViewHolder {

    ImageView imgKucukResim, imgBuyukResim;
    TextView txtDetay, txtIsim, txtTasarimci, txtYil;

    //Sınıf çağırıldığı zaman ilk çalışak metotdur.
    //super() ile View sınıfının Constructor'ı çağırılır.
    //Oluşturulan değişkenlerin atama işlemleri yapılır.
    public ProgramlamaDilleriViewHolder(@NonNull View itemView) {
        super(itemView);

        imgKucukResim = itemView.findViewById(R.id.imgKucukResim);
        imgBuyukResim = itemView.findViewById(R.id.imgBuyukResim);
        txtDetay = itemView.findViewById(R.id.txtDetay);
        txtIsim = itemView.findViewById(R.id.txtIsim);
        txtTasarimci = itemView.findViewById(R.id.txtTasarimci);
        txtYil = itemView.findViewById(R.id.txtYil);
    }

}
