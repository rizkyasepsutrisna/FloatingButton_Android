package com.example.floatingbutton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.resources.CancelableFontCallback;

import java.util.zip.Inflater;

public class CustomDialog extends AppCompatDialogFragment {

    EditText etEmail, etSubject, etContent;
    CustomDialogInterface dialogInterface;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                })
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textEmail = etEmail.getText().toString();
                        String textSubject = etSubject.getText().toString();
                        String textContent = etContent.getText().toString();
                        dialogInterface.applyTexts(textEmail, textSubject, textContent);
                    }
                });



        etEmail = view.findViewById(R.id.etEmail);
        etSubject = view.findViewById(R.id.etSubject);
        etContent = view.findViewById(R.id.etContent);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        dialogInterface = (CustomDialogInterface) context;

    }

    public interface CustomDialogInterface {
        void applyTexts(String textEmail, String textSubject, String textContent);
    }

}
