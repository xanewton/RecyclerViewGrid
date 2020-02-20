/*
 * Copyright (C) 2017 Angel Newton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xengar.android.recyclerviewgrid;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private Context context;


    public DataAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android.get(i).getAndroid_version_name());
        Picasso.with(context)
                .load(android.get(i).getAndroid_image_url())
                .error(R.drawable.disk_reel)
                //.resize(127, 196)
                .resize(342, 513)
                .into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_android;
        private ImageView img_android;

        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView) view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(context, "Click item: " + tv_android.getText(),
            //        Toast.LENGTH_SHORT).show();
            Snackbar.make(view, "Click item: " + tv_android.getText() , Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

}