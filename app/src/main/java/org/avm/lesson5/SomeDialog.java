package org.avm.lesson5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;

public class SomeDialog extends DialogFragment {
    public static final String TAG = "[SomeDialog]";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "The onCreateDialog() handler was called");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_fragment, null))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Log.d(TAG, "Click OK on dialog");
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG, "Click CANCEL on dialog");
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() handler was called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() handler was called");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() handler was called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() handler was called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() handler was called");
    }
}
