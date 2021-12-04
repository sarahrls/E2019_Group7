package com.example.popup_menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnShow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);

                popup.inflate(R.menu.popup_menu);
                popup.show();
            }
        });
}
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:
// do your code
                return true;
            case R.id.upload_item:
// do your code
                return true;
            case R.id.copy_item:
// do your code
                return true;
            case R.id.print_item:
// do your code
                return true;
            case R.id.share_item:
// do your code
                return true;
            case R.id.bookmark_item:
// do your code
                return true;
            default:
                return false;
        }
    }
}