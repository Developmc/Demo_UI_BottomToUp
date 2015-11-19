package com.example.multiable.bottomtoup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.multiable.bottomtoup.CustomView.MainUI;

public class MainActivity extends AppCompatActivity {

    private MainUI mainUI ;
    private BottomFragment bottomFragment ;
    private MiddleFragment middleFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mainUI = new MainUI(this) ;
        setContentView(R.layout.activity_main);

        mainUI = (MainUI)findViewById(R.id.mainUI) ;
        Button buttonOpen = (Button)findViewById(R.id.open) ;
        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainUI.openBar();
                Toast.makeText(MainActivity.this,mainUI.getStatus()+"",Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonClose = (Button)findViewById(R.id.close) ;
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainUI.closeBar();
                Toast.makeText(MainActivity.this,mainUI.getStatus()+"",Toast.LENGTH_SHORT).show();
            }
        });

        bottomFragment = new BottomFragment();
        getSupportFragmentManager().beginTransaction().add(
                MainUI.BOTTOM_ID,bottomFragment).commit();

        middleFragment = new MiddleFragment();
        getSupportFragmentManager().beginTransaction().add(
                MainUI.MIDDLE_ID,middleFragment).commit();
//        mainUI.openBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
