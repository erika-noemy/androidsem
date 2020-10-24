package com.example.guifinalprojecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guifinalprojecto.adapters.HomeAdapter;
import com.example.guifinalprojecto.adapters.ResAdapter;
import com.example.guifinalprojecto.adapters.structRests;
import com.example.guifinalprojecto.interfaces.RetrofitClient;
import com.example.guifinalprojecto.utils.UserDataServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listMyRests extends AppCompatActivity {
    private listMyRests root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_my_rests);
       ListView listR = findViewById(R.id.myrest);
  /*     ArrayList<String> datos= new ArrayList<>();
       datos.add("1");
        datos.add("2");
        datos.add("3");
        datos.add("4");
        datos.add("5");
       ArrayAdapter<String> adapter= new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
       listR.setAdapter(adapter); */
       Call<ArrayList<structRests>> call = RetrofitClient
                .getInstance()
                .getApi().getMyRests(UserDataServer.TOKEN);

        call.enqueue(new Callback<ArrayList<structRests>>() {
            @Override
            public void onResponse(Call<ArrayList<structRests>> call, Response<ArrayList<structRests>> response) {

             /*   if(response.isSuccessful()){
                    if(response.body().getNombre()!=null){
                        TextView textRest=findViewById(R.id.callRest);
                        textRest.setText("No tiene Restaurants");
                    }
                    else{*/
                        ArrayList<structRests> data = response.body();
                        ResAdapter adapter = new ResAdapter(data, getApplicationContext());
                        listR.setAdapter(adapter);
                  //  }}

            }
            @Override
            public void onFailure(Call<ArrayList<structRests>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    }

