package com.example.amit.recyclerviewcheckbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductFilterRecyclerViewAdapter2 extends RecyclerView.Adapter<ProductFilterRecyclerViewAdapter2.ViewHolder> {

    private List<FilterModel> filterList;
    private Context context;


    public MyAdapterListener onClickListener;






    private SparseBooleanArray itemStateArray= new SparseBooleanArray();

    public ProductFilterRecyclerViewAdapter2(List<FilterModel> filterModelList, Context ctx,MyAdapterListener listener) {
        filterList = filterModelList;
        context = ctx;
        onClickListener = listener;
    }

    @Override
    public ProductFilterRecyclerViewAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filter_brand_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final FilterModel filterM = filterList.get(position);
        holder.brandName.setText(filterM.getString());
        holder.productCount.setText("" + filterM.getAnInt());


        if (!itemStateArray.get(position, false)) {
            holder.selectionState.setChecked(false);
        }
        else  {
            holder.selectionState.setChecked(true);

        }



        holder.selectionState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!itemStateArray.get(position, false)) {
                    holder.selectionState.setChecked(true);
                    itemStateArray.put(position, true);
                }
                else  {
                    holder.selectionState.setChecked(false);
                    itemStateArray.put(position, false);

                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView brandName;
        public TextView productCount;
        public CheckBox selectionState;



        public ViewHolder(View view) {
            super(view);
            brandName = (TextView) view.findViewById(R.id.brand_name);
            productCount = (TextView) view.findViewById(R.id.product_count);
            selectionState = (CheckBox) view.findViewById(R.id.brand_select);


            productCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.iconTextViewOnClick(v, getAdapterPosition());
                }
            });
            brandName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.iconImageViewOnClick(v, getAdapterPosition());
                }
            });






            //item click event listener
//            view.setOnClickListener(this);

            //checkbox click event handling
//            selectionState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView,
//                                             boolean isChecked) {
//                    if (isChecked) {
//                        Toast.makeText(ProductFilterRecyclerViewAdapter2.this.context,"selected brand is " + brandName.getText(), Toast.LENGTH_LONG).show();
//                    } else {
//
//                    }
//                }
//            });
        }
    }
}