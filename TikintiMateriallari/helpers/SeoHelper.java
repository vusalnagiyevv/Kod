package com.example.TikintiMateriallari.helpers;

public class SeoHelper {
    public static String createSeoUrl(String name){

        String seoUrl = name.toLowerCase()
                .replace(" " , "-")
                .replace("ə" , "e")
                .replace("ö" , "o")
                .replaceAll("[^a-zA-Z0-9 ]" , "");;


        return seoUrl;
    }


}
