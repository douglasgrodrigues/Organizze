package com.example.organizze.helper;

import java.text.SimpleDateFormat;

public class DataUtil {

    private int teste;

    public static String dataAtual(){

        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = simpleDateFormat.format(data);

        return dataString;

    }

    public static String mesAnoDataEscolhida(String data){

        String retornoData[] = data.split("/");  //função que parte a data em diversas posições do array conforme caracter escolhido
        String dia = retornoData[0];  //captura o dia
        String mes = retornoData[1];       //captura o mes
        String ano = retornoData[2];    //captura o ano

        String mesAno = mes + ano;   //captura apenas as informações necessário, neste caso mês e ano
        return mesAno;

    }
}
