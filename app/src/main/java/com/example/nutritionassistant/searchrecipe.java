package com.example.nutritionassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class searchrecipe extends AppCompatActivity {
private TextView textView;
private ImageView imageView;
private ListView listView;
private String appid="1e2c594b", appkey="462255ae23fcd289937474e2d6ddc551";
private int from=0,to=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrecipe);
        textView=(TextView)findViewById(R.id.searchrecipiename);
        imageView=(ImageView)findViewById(R.id.searchrecipiebutton);
        listView=(ListView)findViewById(R.id.listview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.basse_url).addConverterFactory(GsonConverterFactory.create()).build();
                Api api=retrofit.create(Api.class);
                Call<List<recipemodel>>call=api.getRecipie(textView.getText().toString().trim(),appid,appkey,from,to);
                Log.d("list", String.valueOf(call));
                call.enqueue(new Callback<List<recipemodel>>() {
                    @Override
                    public void onResponse(Call<List<recipemodel>> call, Response<List<recipemodel>> response) {
                        List<recipemodel> recipie=response.body();
                        String[] recipe_name=new String[recipie.size()];
                        for (int i=0;i<recipie.size();i++)
                        {
                            //recipe_name[i]=recipie.get(i).getLabel();
                            //Log.d("Name",recipie.get(i).getLabel());
                            Log.d("In for","1");
                        }
                        Log.d("not in for","0");
                        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_expandable_list_item_1,recipe_name));

                    }

                    @Override
                    public void onFailure(Call<List<recipemodel>> call, Throwable t) {
Log.d("In failure block","1");
                    }
                });
            }
        });

    }
}
