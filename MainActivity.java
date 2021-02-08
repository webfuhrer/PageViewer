package com.example.pruebasviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends FragmentActivity {
ViewPager2 vp=null;
FragmentStateAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp=findViewById(R.id.viewPager);
        adapter=new AdaptadorPager(this);
        vp.setAdapter(adapter);
    }

    private class AdaptadorPager extends FragmentStateAdapter{

        public AdaptadorPager(@NonNull FragmentActivity fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment f=null;
            switch (position)
            {
                case 0:
                    f=new Fragmento_1();
                    break;
                case 1:
                    f=new Fragmento_2();
                    break;
                case 2:
                    f=new Fragmento_3();
                    break;
            }
            return f;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}