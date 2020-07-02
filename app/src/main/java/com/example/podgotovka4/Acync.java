package com.example.podgotovka4;

import android.content.Context;
import android.os.AsyncTask;

import androidx.fragment.app.FragmentManager;

public class Acync extends AsyncTask<Integer,Integer,Void> {
ProgressFragment fragment;
FragmentManager fragmentManager;

Lisener lisener;
    public Acync(FragmentManager fragmentManager , Lisener lisener ){
        this.fragmentManager=fragmentManager;
        this.lisener=lisener;
    }
    @Override
    protected Void doInBackground(Integer... integers) {

        int values = integers[0];

        for(int i = values ; i>0 ;i--){
            try {
                publishProgress(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        fragment=fragment.newInstance();
        fragment.setCancelable(false);


        fragment.show(fragmentManager, "dialog");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
       fragment.dismiss();
       lisener.Res("");


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int value = values[0];
        fragment.update(value);
    }
}
