package com.example.brezeler.projetandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.FavoriDAO;
import DAO.ItemDAO;
import DAO.UsersDAO;
import Model.Favori;
import Model.Item;
import Model.Users;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Test okai !
        Users user = new Users("a@hot.fr", "toto", "NAME", "see");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dueDate = null;
        try {
            dueDate = dateFormat.parse("1999-12-07 12:30:03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Item item = new Item("lien","title",dueDate, "popo","source","description");
        ItemDAO itemDAO = new ItemDAO(this);
        UsersDAO usersDAO = new UsersDAO(this);
        FavoriDAO favoriDAO = new FavoriDAO(this);
        usersDAO.open();
        itemDAO.open();
        favoriDAO.open();
        usersDAO.add(user);
        itemDAO.add(item);
        favoriDAO.addFavori(item.getId(),user.getEmail());
        TextView textView = (TextView)findViewById(R.id.sisi);
        ArrayList<Item> tabitem = favoriDAO.getFavori(user.getEmail());
        textView.setText(tabitem.get(0).getTitle());
        usersDAO.close();
        itemDAO.close();
        favoriDAO.close();
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
