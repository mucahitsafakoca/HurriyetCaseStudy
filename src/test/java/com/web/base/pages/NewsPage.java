package com.web.base.pages;

import com.web.base.driver.Driver;
import com.web.base.utils.WebTestMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsPage extends Driver {
    private final WebTestMethods methods;

    public NewsPage() {
        this.methods = new WebTestMethods();
    }

    public static void statusCheck() {
        String url = webDriver.getCurrentUrl();

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Response Kod Olarak 200 Dondu");
            } else {
                System.out.println("Response " + responseCode + " Olarak Geldi");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

