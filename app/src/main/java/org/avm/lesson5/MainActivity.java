package org.avm.lesson5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.avm.lesson5.presenter.MainPresenter;
import org.avm.lesson5.presenter.MainPresenterImpl;
import org.avm.lesson5.view.MainView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    public static final String KEY_DIALOG = "dialog";
    public static final String KEY_ACTIVITY = "activity";

    private MainPresenter mainPresenter;
    private Map<String, String> map;
    private int activityCount = 0;
    private int activityCountForMap = 0;
    private int dialogCount = 0;
    private int dialogCountForMap = 0;

    public static final String TAG = "[MainActivity]";

    @BindView(R.id.activityCount)
    TextView txtActivityCount;

    @BindView(R.id.activityCountFromMap)
    TextView txtActivityCountFromMap;

    @BindView(R.id.dialogCount)
    TextView txtDialogCount;

    @BindView(R.id.dialogCountFromMap)
    TextView txtDialogCountFromMap;

    @OnClick(R.id.openActivity)
    void onOpenActivityClick() {
        Log.d(TAG, "Click on open second activity button");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        activityCount++;
        activityCountForMap++;
        map.put(KEY_ACTIVITY, String.valueOf(activityCountForMap));
        setTextForActivityCount();
    }


    @OnClick(R.id.openDialog)
    void onOpenDialogClick() {
        Log.d(TAG, "Click on open dialog button");
        SomeDialog someDialog = new SomeDialog();
        someDialog.show(getSupportFragmentManager(), "someDialog");
        dialogCount++;
        dialogCountForMap++;
        map.put(KEY_DIALOG, String.valueOf(dialogCountForMap));
        setTextForDialogCount();
    }

    private void setTextForActivityCount() {
        txtActivityCount.setText(String.format("%s%s", getResources()
                .getString(R.string.activity), activityCount));
        txtActivityCountFromMap.setText(String.format("%s%s", getResources()
                .getString(R.string.activity_from_map), map.get(KEY_ACTIVITY)));
    }

    private void setTextForDialogCount() {
        txtDialogCount.setText(String.format("%s%s", getResources()
                .getString(R.string.dialog), dialogCount));
        txtDialogCountFromMap.setText(String.format("%s%s", getResources()
                .getString(R.string.dialog_from_map), map.get(KEY_DIALOG)));
    }

    @OnClick(R.id.exit)
    void onExitClick() {
        Log.d(TAG, "Click on exit button");
        this.finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl(this);
        dialogCountForMap = mainPresenter.getSaveValue(KEY_DIALOG);
        activityCountForMap = mainPresenter.getSaveValue(KEY_ACTIVITY);
        Object object =  getLastCustomNonConfigurationInstance();
        if (object instanceof Map) {
            map = (Map<String, String>) object;
        } else {
            map = new HashMap<>();
            map.put(KEY_ACTIVITY, String.valueOf(activityCountForMap));
            map.put(KEY_DIALOG, String.valueOf(dialogCountForMap));
        }
        Log.d(TAG, "The onCreate () handler was called");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "The onPostCreate() handler was called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() handler was called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() handler was called");
        setTextForActivityCount();
        setTextForDialogCount();
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
        mainPresenter.saveValue(KEY_DIALOG, String.valueOf(dialogCountForMap));
        mainPresenter.saveValue(KEY_ACTIVITY, String.valueOf(activityCountForMap));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() handler was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "The onRestart() handler was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() handler was called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("activity", activityCount);
        Log.d(TAG, "The onSaveInstanceState() handler was called");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        activityCount = savedInstanceState.getInt("activity");
        Log.d(TAG, "The onRestoreInstanceState() handler was called");
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Log.d(TAG, "The onRetainCustomNonConfigurationInstance() handler was called");
        return map;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
