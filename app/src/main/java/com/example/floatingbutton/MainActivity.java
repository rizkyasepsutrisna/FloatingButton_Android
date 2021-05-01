package com.example.floatingbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements CustomDialog.CustomDialogInterface {

    TextView txtEmail, txtSubject, txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.tvEmail);
        txtSubject = findViewById(R.id.tvSubject);
        txtContent = findViewById(R.id.tvContent);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Compose new email ?",
                        Snackbar.LENGTH_LONG)
                        .setAction("NEW", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CustomDialog customdialog = new CustomDialog();
                                customdialog.show(getSupportFragmentManager(),"");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.white))
                        .show();
            }
        });

    }

    @Override
    public void applyTexts(String textEmail, String textSubject, String textContent) {
        txtEmail.setText(textEmail);
        txtSubject.setText(textSubject);
        txtContent.setText(textContent);
    }
}