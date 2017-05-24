package com.htprivate.htprivate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed(){
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }
        if(!doubleBackToExitPressedOnce){
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this,"Tap again for exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            },2000);
        }
        else{
            super.onBackPressed();
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton (View view){
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.about:
                intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.courses:
                intent = new Intent(this,CoursesActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
