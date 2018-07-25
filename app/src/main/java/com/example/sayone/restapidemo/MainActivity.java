package com.example.sayone.restapidemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mUsername,mPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.user);
        mPass=findViewById(R.id.password);

    }
     public void login(View view){

        String user, pass;
        user=mUsername.getText().toString().trim();
        pass=mPass.getText().toString().trim();
        Login login = new Login(user,pass);

        ApiInterface apiInterface = ApplicationClass.getClient().create(ApiInterface.class);
         Call<ResponseBody> call = apiInterface.login(login);
         call.enqueue(new Callback<ResponseBody>() {
             @Override
             public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                 if (response.code()==200){
                     Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     Toast.makeText(MainActivity.this, " response : "+response.code(), Toast.LENGTH_SHORT).show();
                     Log.d("RESPONSE : ", ""+response.code());
                 }
             }

             @Override
             public void onFailure(Call<ResponseBody> call, Throwable t) {

             }
         });
     }

     public void getUser(View view){
         ApplicationClass.getClient().create(ApiInterface.class).getUserData().enqueue(
                 new Callback<ResponseBody>() {
                     @Override
                     public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                         if(response.isSuccessful()){
                             Toast.makeText(MainActivity.this, "Successssss",Toast.LENGTH_LONG).show();
                             Log.e("ABCD", response.body().toString() );
                         }

                     }

                     @Override
                     public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {

                     }
                 }
         );
     }



}
