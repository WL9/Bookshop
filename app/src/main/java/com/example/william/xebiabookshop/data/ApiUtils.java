package com.example.william.xebiabookshop.data;

import com.example.william.xebiabookshop.data.remote.RetrofitClient;
import com.example.william.xebiabookshop.data.remote.Service;

public class ApiUtils {

    public static final String BASE_URL = "http://henri-potier.xebia.fr/";

    public static Service getService() {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}