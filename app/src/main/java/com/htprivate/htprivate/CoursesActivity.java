package com.htprivate.htprivate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
    }

    public void onClickAndroid (View view){
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("choose","android");
        startActivity(intent);
    }
    public void onClickKotlin (View view){
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("choose","kotlin");
        startActivity(intent);
    }
    public void onClickPolymer (View view){
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("choose","polymer");
        startActivity(intent);
    }
    public void onClickAngular (View view){
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("choose","angular");
        startActivity(intent);
    }
    public void onClickJavaScript (View view){
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("choose","javascript");
        startActivity(intent);
    }
}
