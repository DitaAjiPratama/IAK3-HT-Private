package com.htprivate.htprivate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String parameter = getIntent().getStringExtra("choose");

        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);

        if(parameter.equals("android")){
            logo.setImageResource(R.drawable.android);
            title.setText("Android");
            description.setText("Android is a mobile operating system developed by Google, based on the Linux kernel and designed primarily for touchscreen mobile devices such as smartphones and tablets.");
        }
        if(parameter.equals("kotlin")){
            logo.setImageResource(R.drawable.kotlin);
            title.setText("Kotlin");
            description.setText("Statically typed programming language for modern multiplatform applications");
        }
        if(parameter.equals("polymer")){
            logo.setImageResource(R.drawable.polymer);
            title.setText("Polymer");
            description.setText("Polymer is a JavaScript library that helps you create custom reusable HTML elements, and use them to build performant, maintainable apps.");
        }
        if(parameter.equals("angular")){
            logo.setImageResource(R.drawable.angular);
            title.setText("Angular");
            description.setText("Angular is built by a team of engineers who share a passion for making web development feel effortless. We believe that writing beautiful apps should be joyful and fun. We're building a platform for the future.");
        }
        if(parameter.equals("javascript")){
            logo.setImageResource(R.drawable.javascript);
            title.setText("JavaScript");
            description.setText("JavaScript (often shortened to JS) is a lightweight, interpreted, object-oriented language with first-class functions, and is best known as the scripting language for Web pages, but it's used in many non-browser environments as well. It is a prototype-based, multi-paradigm scripting language that is dynamic, and supports object-oriented, imperative, and functional programming styles.");
        }

    }

    public void onClickButton (View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
