package com.example.comandas;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toogle;
    private GestureDetectorCompat gest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer_menu2,R.string.close_drawer_menu2);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        this.gest = new GestureDetectorCompat(this, new GestureListener());
        //gest.setOnDoubleTapListener(this);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new FragmentTelaInicial1()).commit();
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(MainActivity.this,"fling",Toast.LENGTH_SHORT).show();
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(MainActivity.this,"fling",Toast.LENGTH_SHORT).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(MainActivity.this,"fling",Toast.LENGTH_SHORT).show();
            return super.onSingleTapConfirmed(e);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gest.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_item_menu2_one:
                Intent it1 = new Intent(this, ComandasActivity.class);
                startActivity(it1);
                break;

            case R.id.nav_item_menu2_two:
                Intent it2 = new Intent(this, CardapioActivity.class);
                startActivity(it2);
                break;

            case R.id.nav_item_menu2_three:
                Intent it3 = new Intent(this, VendasActivity.class);
                startActivity(it3);
                break;

            case R.id.nav_item_menu2_four:
                Intent it4 = new Intent(this, ClienteActivity.class);
                startActivity(it4);
                break;

            case R.id.nav_item_menu2_five:
                Intent it5 = new Intent(this, ConfigActivity.class);
                startActivity(it5);
                break;

            case R.id.nav_item_menu2_six:
                Intent it6 = new Intent(this, ContatoActivity.class);
                startActivity(it6);
                break;

            case R.id.nav_item_menu2_seven:
                Intent it7 = new Intent(this, LoginActivity.class);
                startActivity(it7);
                finish();
                break;

            default:
                Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
