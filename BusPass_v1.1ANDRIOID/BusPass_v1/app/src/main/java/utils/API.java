package utils;

import com.example.buspass_v1.entity.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    String BASE_URL = "http://192.168.2.126:8080";

    @POST("/service/login")
    Call<JsonObject> loginUser(@Body User user);


    @POST("/service/register")
    Call<JsonObject> registerUser(User user);
}
