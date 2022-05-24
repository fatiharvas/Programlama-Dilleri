package com.h5200045.fatih_arvas_final.network;

import com.h5200045.fatih_arvas_final.model.ProgramlamaDilleri;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

//GET,POST gibi işlemlerimizi yapabilmemiz için bir tane interface class oluşturulmuştur.
public interface ServiceApi {

    /* Json verisini istemek için Get metodu kullanılmıştır.
     * BASE_URL'in sonuna eklenmesi için @GET metodu içerisine istenilen verinin adresi yazılmıştır.
     * Veriyi dışa aktarmak için Observable kullanılmıştır.
     * Gelen veriyi Bir liste olarak tutulmuştur.
     * Bu verilere ulaşmak istediğimizde getProgrammingLanguages() metodunu çağırıyoruz.
     */
    @GET("programmingLanguages.json")
    Observable<List<ProgramlamaDilleri>> getProgrammingLanguages();

}

