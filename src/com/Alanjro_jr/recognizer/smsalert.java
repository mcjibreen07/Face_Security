package com.Alanjro_jr.recognizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class smsalert {

    public String sendGet(String phone, String sms) throws Exception {

        String url = "http://api.smartsmssolutions.com/smsapi.php?username=mcjibreen07@gmail.com&password=109218912&sender=jb&recipient=" + phone + "&message=" + sms + "";
        //   String url="http://api.smartsmssolutions.com/smsapi.php?username=mcjibreen07@gmail.com&password=109218912&balance=true";
        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");
        int responseCode = httpClient.getResponseCode();
        try ( BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
            //  return  response.toString();;
        }

    }

  
}
