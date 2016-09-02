package com.wishstore.bntarek.wish_store;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BnTarek on 2/9/2016.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> mProductList;
    private MainActivity.ProductItemListener mItemListener;

    public ProductsAdapter(List<Product> productList, MainActivity.ProductItemListener itemListener) {
        mProductList = productList;
        mItemListener = itemListener;
    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.item_product, parent, false);

        return new ViewHolder(productView, mItemListener);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
        Product product = mProductList.get(position);

        holder.name.setText(product.getName());
        holder.description.setText(product.getDescription());
        holder.thumbnail.setImageResource(product.getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public Product getItem(int position) {
        return mProductList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageView thumbnail;

        private MainActivity.ProductItemListener mItemListener;

        public ViewHolder(final View itemView, MainActivity.ProductItemListener listener) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.product_item_title);
            description = (TextView) itemView.findViewById(R.id.product_item_description);
            thumbnail = (ImageView) itemView.findViewById(R.id.product_item_thumbnail);

            mItemListener = listener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Product product = getItem(position);
                    mItemListener.onProductClick(product);
                }
            });
        }
    }
}

