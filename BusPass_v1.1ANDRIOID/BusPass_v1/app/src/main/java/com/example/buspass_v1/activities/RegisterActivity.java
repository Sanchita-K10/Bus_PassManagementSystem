package com.example.buspass_v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.buspass_v1.R;
import com.example.buspass_v1.entity.User;
import com.google.gson.JsonObject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.RetrofitClient;

public class RegisterActivity extends AppCompatActivity {

    EditText editFirstName,editLastName,editEmail,editMobileNo,editPassword,editConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editMobileNo = findViewById(R.id.editMobileNo);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
    }

    public void register(View view){
        User user = validateUser();
        if(user!=null){
            RetrofitClient.getInstance().getApi().registerUser(user).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.body().getAsJsonObject().get("status").getAsString().equals("success"))
                    {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private User validateUser() {
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();
        if(password.equals(confirmPassword))
        {
            User user = new User();
            user.setFirstName(editFirstName.getText().toString());
            user.setLastName(editLastName.getText().toString());
            user.setPassword(password);
            user.setEmail(editEmail.getText().toString());
            user.setMobileNo(editMobileNo.getText().toString());
            return user;
        }
        else {
            Toast.makeText(this, "passwords do not match", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public void cancel(View view){

    }
}