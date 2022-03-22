package com.devops.dxc.devops.model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @param uf
     * @return
     */
    public static int getDxc(int ahorro, int uf){
        if(ahorro<0 || uf<1) return 0;
        if(((ahorro*0.1)/uf) > 150 ){
            return (int) (150*uf) ;
        } else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
            return (int) 1000000;
        } else if( ahorro <=1000000){
            return (int) ahorro;
        } else {
            return (int) (ahorro*0.1);
        }
    }

    /**
     * Método para cacular el saldo restante.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param dxc
     * @return
     */
    public static int getSaldoRestante(int ahorro, int dxc){
        if(ahorro<0 || dxc<0) return 0;
        int tmp = ahorro-dxc;
        return tmp<0?0:tmp;
    }

    /**
     * Método para cacular el el impuesto según el sueldo y la tabla de segmentos  
     * 
     * @param sueldo
     * @param utm
     * @return
     */
    public static long getImpuesto(int sueldo, int utm){
        if(sueldo<0 || utm<0) return 0;
        if(sueldo<=13.5*utm) return 0;
        else if(sueldo<=30*utm) return Math.round(sueldo*0.04-(utm*0.54));
        else if(sueldo<=50*utm) return Math.round(sueldo*0.08f-(utm*1.74));
        else if(sueldo<=70*utm) return Math.round(sueldo*0.135f-(utm*4.49));
        else if(sueldo<=90*utm) return Math.round(sueldo*0.23f-(utm*11.14));
        else if(sueldo<=120f*utm) return Math.round(sueldo*0.304f-(utm*17.8));
        else return Math.round(sueldo*0.35f-(utm*23.32));
    }

    /**
     * Método que retorna el valor de la UTM.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static int getUTM(){
        return 55537;
    }

    /**
 * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
 * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
 * @return
 */
public static int getUf(){
    try {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = formatter.format(date);
        System.out.println("Fecha actual: " + dateStr);
        
        URL url = new URL("https://mindicador.cl/api/uf/" + dateStr);//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            JSONObject coderollsJSONObject = new JSONObject(output);
            JSONArray seriesJSONArray = coderollsJSONObject.getJSONArray("serie");
            JSONObject serieJSONObject = seriesJSONArray.getJSONObject(0);
            int valorUf = serieJSONObject.getInt("valor");
            System.out.println("serie: "+ valorUf +"\n");
            return valorUf;
        }
        conn.disconnect();

    } catch (Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
        return 1;
    }
    return 1;
}
    
}
