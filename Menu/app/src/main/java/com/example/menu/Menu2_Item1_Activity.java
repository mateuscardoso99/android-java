package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Menu2_Item1_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2__item1_);

        toolbar = (Toolbar) findViewById(R.id.toolbar_menu2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer_menu2,R.string.close_drawer_menu2);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_item_menu2_one:
                Intent inter = new Intent(this,Menu2Activity.class);
                startActivity(inter);
                this.finish();
                break;

            case R.id.nav_item_menu2_two:
                Toast.makeText(this,"item 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_item_menu2_three:
                Toast.makeText(this,"item 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_item_menu2_four:
                Toast.makeText(this,"item 4", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Menu Default",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
