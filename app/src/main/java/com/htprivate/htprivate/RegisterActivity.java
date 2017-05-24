package com.htprivate.htprivate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    // spinner
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>();

    EditText name;
    EditText phone;
    EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        mail = (EditText) findViewById(R.id.mail);

        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("Select your course");
        mListMenu.add("Android");
        mListMenu.add("Kotlin");
        mListMenu.add("Polymer");
        mListMenu.add("Angular");
        mListMenu.add("JavaScript");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);
    }

    public void onClickButton(View view){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "htprivate@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "New Register - "+name.getText());
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                name.getText()+" - "
                        + mSpinnerMenu.getSelectedItem()
                        + " - "
                        + phone.getText()
                        + " - "
                        + mail.getText()
        );
        try {
            startActivity(Intent.createChooser(emailIntent, "send mail.."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this, "There is no email client installd,", Toast.LENGTH_LONG).show();
        }

    }

}
