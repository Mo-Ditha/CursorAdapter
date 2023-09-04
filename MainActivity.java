package com.example.cursoradapter;



import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Create a cursor that queries the countries table
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://com.example.cursoradapter.provider/countries"),
                null, null, null, null);

        // Create a CursorAdapter
        adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, cursor,
                new String[]{"name"}, new int[]{android.R.id.text1});

        // Set the adapter on the ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,"You clicked" +item,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
