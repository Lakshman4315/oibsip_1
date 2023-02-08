package com.example.oibsip_1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.oibsip_1.CurrencyFragment;
import com.example.oibsip_1.LengthFragment;
import com.example.oibsip_1.TemperatureFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabTitles = new String[]{"Length","Temperature","Currency"};

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LengthFragment lengthFragment = new LengthFragment();
                return lengthFragment;
            case 1:
                TemperatureFragment temperatureFragment = new TemperatureFragment();
                return temperatureFragment;
            case 2:
                CurrencyFragment currencyFragment = new CurrencyFragment();
                return currencyFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
}
