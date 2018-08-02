package org.avm.lesson5.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import org.avm.lesson5.view.MainView;

public class MainPresenterImpl implements MainPresenter {
    final private String NAME_SHARED_PREFERENCE = "lesson5";

    private SharedPreferences sharedPreferences;

    public MainPresenterImpl(MainView mainView) {
        sharedPreferences = mainView.getContext()
                .getSharedPreferences(NAME_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public int getSaveValue(String key) {
        return Integer.parseInt(sharedPreferences.getString(key, "0"));
    }

    @Override
    public void saveValue(String key, String value) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply();
    }
}
