package com.duque.dev.testeunitario;

import android.content.Context;

public class ClassUnderTest {

    public Context mContext;

    public ClassUnderTest(Context context){

        mContext = context;

    }

    public String getHelloWordString(){
        return mContext.getString(R.string.text_hello_word);
    }

    public String trocarValorAEMostrarValorResultante(String str){
        if (str.length() <= 2){
            return str.replaceAll("A", "");
        }

        String primeiros2Chars = str.substring(0,2);
        String stringMenosPrimeiros2Charates = str.substring(2);

        return primeiros2Chars.replaceAll("A", "")+stringMenosPrimeiros2Charates;
    }

    public boolean saoOsPrimeirosEOsUltimos2CaractersIguais(String str){

        if (str.length() <= 1)
            return false;
        if (str.length() == 2)
            return true;

        String first2Chars = str.substring(0, 2);

        String last2Chars = str.substring(str.length() - 2);

        return first2Chars.equals(last2Chars);
    }
}
