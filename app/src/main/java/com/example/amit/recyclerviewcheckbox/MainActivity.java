package com.example.amit.recyclerviewcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

public class MainActivity extends AppCompatActivity{
    private RecyclerView brandRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandRecyclerView = (RecyclerView) findViewById(R.id.brands_lst);

        //RecyclerView layout manager
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        brandRecyclerView.setLayoutManager(recyclerLayoutManager);

        //RecyclerView item decorator
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(brandRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        brandRecyclerView.addItemDecoration(dividerItemDecoration);

        //RecyclerView adapater
//        ProductFilterRecyclerViewAdapter recyclerViewAdapter = new ProductFilterRecyclerViewAdapter(getBrands(),this);
//        ProductFilterRecyclerViewAdapter2 recyclerViewAdapter = new ProductFilterRecyclerViewAdapter2(getBrands(),this);
//        brandRecyclerView.setAdapter(recyclerViewAdapter);







        ProductFilterRecyclerViewAdapter2 mAdapter = new ProductFilterRecyclerViewAdapter2(getBrands(),this, new MyAdapterListener() {
            @Override
            public void iconTextViewOnClick(View v, int position) {

                Toast.makeText(MainActivity.this, "productCount :: "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void iconImageViewOnClick(View v, int position) {
                Toast.makeText(MainActivity.this, "brandName :: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        brandRecyclerView.setAdapter(mAdapter);



    }

    private List<FilterModel> getBrands(){
        List<FilterModel> modelList = new ArrayList<FilterModel>();


        for (int i = 0; i < 100; i++) {

            modelList.add(new FilterModel("amit  :: "+i, 100+i, false));

        }

        return modelList;
    }

}
