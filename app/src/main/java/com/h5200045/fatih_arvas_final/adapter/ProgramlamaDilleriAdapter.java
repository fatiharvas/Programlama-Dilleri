package com.h5200045.fatih_arvas_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200045.fatih_arvas_final.R;
import com.h5200045.fatih_arvas_final.model.ProgramlamaDilleri;
import com.h5200045.fatih_arvas_final.util.GlideUtil;

import java.util.List;

//RecyclerView’de gösterilecek verileri bir RecyclerView Adapter aracılığı ile RecyclerView’e bağlamak için oluşturulmuştur.
//Adapter’ımız RecyclerView.Adapter’dan extend edecek ve arayüz olarakta oluşturduğumuz ProgramlamaDilleri class’ını veriyoruz.
public class ProgramlamaDilleriAdapter extends RecyclerView.Adapter<ProgramlamaDilleriViewHolder> {

    List<ProgramlamaDilleri> programlamaDilleri;
    OnItemClickListener onItemClickListener;
    Context context;

    //Recylerview de tıklanma fonksiyonu olmadığı için bir interface oluşturuyoruz. Tıklanan elemanı alıyor.
    public interface OnItemClickListener {
        void onItemClick(ProgramlamaDilleri tiklananDil);
    }

    //Adapter’ımızın constructor’ına ise itemlerimiz için oluşturacağımız listeyi, context'i ve tıklanma özelliğini kullanmak için onItemClickListener veriyoruz.
    public ProgramlamaDilleriAdapter(List<ProgramlamaDilleri> programlamaDilleri, Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.programlamaDilleri = programlamaDilleri;
        this.onItemClickListener = onItemClickListener;
    }

    // Bu method adaptör oluşturulduğunda oluşturduğumuz ViewHolder'ın başlatılması için çağrılır.
    @NonNull
    @Override
    public ProgramlamaDilleriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_programming_languages, parent, false);
        ProgramlamaDilleriViewHolder programlamaDilleriViewHolder = new ProgramlamaDilleriViewHolder(itemView);

        //Tıklanma özelliği için itemView içerisindeki setOnClickListener metodunu çağırıyoruz içerisine ilgili veriye ulaşmak için position veriyoruz.
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(programlamaDilleri.get(programlamaDilleriViewHolder.getAdapterPosition()));
            }
        });
        return programlamaDilleriViewHolder;
    }

    //onBindViewHolder() metodu içerisinde onCreateViewHolder’dan dönen holder ve position parametre olarak gönderip listenin hangi veri ile dolacağını kontrol ediyoruz.
    //Uygulama içierisindeki resimleri indirmek için GlideUtil sınıfından imageDownloadShow() fonksiyonunu çağırıyoruz.
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ProgramlamaDilleriViewHolder viewHolder, int position) {
        viewHolder.txtIsim.setText(programlamaDilleri.get(position).getProgramlamaDili());
        viewHolder.txtTasarimci.setText(programlamaDilleri.get(position).getTasarimci());
        viewHolder.txtYil.setText(programlamaDilleri.get(position).getCikisTarihi());
        GlideUtil.imageDownloadShow(context, programlamaDilleri.get(position).getKucukLogoUrl(), viewHolder.imgKucukResim);
    }

    //Listemizin eleman sayısını döndüren metottur.
    @NonNull
    @Override
    public int getItemCount() {
        return programlamaDilleri.size();
    }
}
