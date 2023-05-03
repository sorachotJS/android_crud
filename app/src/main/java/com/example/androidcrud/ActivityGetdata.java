package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidcrud.Interface.InterfaceAPI;
import com.example.androidcrud.Models.UserModel;
import com.example.androidcrud.Service.RetrofitService;

import java.util.List;

import Adapter.MyRecycleAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityGetdata extends AppCompatActivity {
    InterfaceAPI apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        //config layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        apiInterface = RetrofitService.getClient().create(InterfaceAPI.class);
        Call<UserModel> call = apiInterface.getData();
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                UserModel resource = response.body();
                List<UserModel.Datum> datumList = resource.data;
                System.out.println(resource);
                //config Adapter
                String[] strings = {"A","B","C"};
                MyRecycleAdapter adapter = new MyRecycleAdapter(datumList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG);

            }
        });




    }
}