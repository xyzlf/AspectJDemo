package com.xyzlf.aspectjdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new People();

        test("this is tag for test");

    }

    public void test(String test) {
        try {
            throw new IllegalArgumentException("self throw exception");
        } catch (Exception e) {

        }
    }

}
