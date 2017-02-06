/*
 * Copyright (C) 2017 Angel Garcia
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

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    private final String android_version_names[] = {
            "Poster 1",
            "Poster 2",
            "Poster 3",
            "Poster 4",
            "Poster 5",
            "Poster 6",
            "Poster 7",
            "Poster 8",
            "Poster 9",
            "Poster 10",
            "Poster 11",
            "Poster 12",
            "Poster 13",
            "Poster 14",
            "Poster 15"
    };

    private final String android_image_urls[] = {
            "https://image.tmdb.org/t/p/w342/vKSRUwwknhFzY1HRBr0iYc55pVu.jpg",
            "https://image.tmdb.org/t/p/w342/kwJuEkzMhsKxmu1r6X4U1jZovfj.jpg",
            "https://image.tmdb.org/t/p/w342/nHXiMnWUAUba2LZ0dFkNDVdvJ1o.jpg",
            "https://image.tmdb.org/t/p/w342/rXMWOZiCt6eMX22jWuTOSdQ98bY.jpg",
            "https://image.tmdb.org/t/p/w342/bndiUFfJxNd2fYx8XO610L9a07m.jpg",
            "https://image.tmdb.org/t/p/w342/6cbIDZLfwUTmttXTmNi8Mp3Rnmg.jpg",
            "https://image.tmdb.org/t/p/w342/7xbm3OTScvBEfnnpny9JPNWqPlw.jpg",
            "https://image.tmdb.org/t/p/w342/aOJVMCL2EsNeTG7bC3MAjKIiQPE.jpg",
            "https://image.tmdb.org/t/p/w342/iMkl2Akc1f4CSJCieVwczM4KjZR.jpg",
            "https://image.tmdb.org/t/p/w342/wnVHDbGz7RvDAHFAsVVT88FxhrP.jpg",
            "https://image.tmdb.org/t/p/w342/11nrKqhqENWGTlKq8qqN5x5ejxj.jpg",
            "https://image.tmdb.org/t/p/w342/vKSRUwwknhFzY1HRBr0iYc55pVu.jpg",
            "https://image.tmdb.org/t/p/w342/jXDV4Y98kxZcpmnr2JV6CB8OEGr.jpg",
            "https://image.tmdb.org/t/p/w342/hm0Z5tpRlSzPO97U5e2Q32Y0Xrb.jpg",
            "https://image.tmdb.org/t/p/w342/i0t7F6b4R1wURRESAiw9VJNuVoV.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(false);

        int columns = (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT)? 2 : 3;
        RecyclerView.LayoutManager layoutManager
                = new GridLayoutManager(getApplicationContext(), columns);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0; i<android_version_names.length; i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
