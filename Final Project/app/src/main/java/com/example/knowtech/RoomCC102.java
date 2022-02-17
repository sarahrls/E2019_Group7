package com.example.knowtech;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class RoomCC102 extends AppCompatActivity {
    /*TabLayout tabLayout;
    ViewPager viewPager;

    private CardView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_cc102);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tabLayout = findViewById(R.id.main_tab_layout);
        viewPager = findViewById(R.id.main_view_pager);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayList<String> titles = new ArrayList<>();

        titles.add("Feed");


        tabLayout.setupWithViewPager(viewPager);

        prepareViewPager(viewPager, titles);
    }



    private void prepareViewPager(ViewPager viewPager, ArrayList<String> titles) {
        SessionManagement sessionManagement = new SessionManagement(this);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        RoomCC102F mainFragment = new RoomCC102F(sessionManagement, this);

        for (int i = 0; i < titles.size();i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", titles.get(i));
            mainFragment.setArguments(bundle);
            adapter.addFragment(mainFragment, titles.get(i));
            mainFragment = new RoomCC102F( sessionManagement, this);
        }

        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        int[] imageList =  {R.drawable.ic_round_post};

        public void addFragment(Fragment fragment, String s) {
            fragments.add(fragment);
            strings.add(s);
        }

        public  MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), imageList[position]);
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            SpannableString spannableString = new SpannableString("   " + strings.get(position));
            ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
            spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;
        }
    }*/
}