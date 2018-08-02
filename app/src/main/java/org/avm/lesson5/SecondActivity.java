package org.avm.lesson5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "[SecondActivity]";

    @OnClick(R.id.closeActivity)
    void onCloseActivityClick() {
        Log.d(TAG, "The onCloseActivityClick() handler was called");
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        Log.d(TAG, "The onCreate () handler was called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() handler was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The OnResume() handler was called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "The onPostResume() handler was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() handler was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() handler was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() handler was called");
    }


}
