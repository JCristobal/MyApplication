package com.example.jcristobal.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;


/**
 * Created by JCristobal on 23/04/2015.
 */

 public class tabs  extends FragmentActivity {

        private FragmentTabHost tabHost;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tabs);
            tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
            tabHost.setup(this,
                    getSupportFragmentManager(),android.R.id.tabcontent);
            tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("calendario"),
                    Tab1.class, null);
            tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("radio group"),
                    Tab2.class, null);
            tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("reloj"),
                    Tab3.class, null);
        }

}
