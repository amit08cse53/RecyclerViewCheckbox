package com.example.amit.recyclerviewcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        ProductFilterRecyclerViewAdapter2 recyclerViewAdapter = new ProductFilterRecyclerViewAdapter2(getBrands(),this);
        brandRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<FilterModel> getBrands(){
        List<FilterModel> modelList = new ArrayList<FilterModel>();


        for (int i = 0; i < 100; i++) {

            modelList.add(new FilterModel("amit  :: "+i, 100+i, false));

        }

        return modelList;
    }

}
