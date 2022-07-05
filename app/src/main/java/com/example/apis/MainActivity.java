package com.example.apis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apis.Client1.RetrofitClient1;
import com.example.apis.Client2.RetrofitClient2;
import com.example.apis.Entity1.Message1;
import com.example.apis.Entity2.Message2;
import com.example.apis.Service1.RetrofitApiService1;
import com.example.apis.Service2.RetrofitApiService2;
import com.example.apis.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private TextView mTextView2;
    private ActivityMainBinding binding;
    private RetrofitApiService1 apiService1;
    private RetrofitApiService2 apiService2;
    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //coronavirus
        initView();
        initValues();
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random death = new Random();
                getMessage1(death.nextInt(5));
            }
        });


        //on water
        initView2();
        initValues2();
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Random lat = new Random();
                Double latitud = -10.0 +  lat.nextDouble() * 20.0;
                Random lon = new Random();
                Double longitud = -10.0 + lon.nextDouble() * 20.0;
                getMessage2(latitud, longitud);
            }
        });



    }
    private void initView(){ //api coronavirus

        mTextView = findViewById(R.id.TextViewCoron);
        mButton1 = findViewById(R.id.btnCovid);
    }
    private void initValues(){
        apiService1 = RetrofitClient1.getApiService();
    }
    private void getMessage1(int id){
        apiService1.getMessageId().enqueue(new Callback<List<Message1>>() {
            @Override
            public void onResponse(Call<List<Message1>> call, Response<List<Message1>> response) {
                List<Message1> message1 = response.body();
                mTextView.setText("Muertos Coivd: "+message1.get(id).getDeath().toString()+" Hospitalizados: "+message1.get(id).getHospitalized().toString());
            }

            @Override
            public void onFailure(Call<List<Message1>> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }

    //one water
    private  void initView2(){
        mTextView2 = findViewById(R.id.TextViewOnWater);
        mButton2 = findViewById(R.id.btnOnWater);
    }
    private void initValues2(){
        apiService2 = RetrofitClient2.getApiService();
    }
    private void getMessage2(Double lat, Double lon){
        apiService2.getMessageId(lat, lon).enqueue(new Callback<Message2>() {
            @Override
            public void onResponse(Call<Message2> call, Response<Message2> response) {
                Message2 message2 = response.body();
                mTextView2.setText("Agua: "+message2.getWater().toString()+"\n Latitud:  "+ message2.getLat().toString());
            }

            @Override
            public void onFailure(Call<Message2> call, Throwable t) {
                mTextView2.setText(t.getMessage());

            }
        });
    }
}