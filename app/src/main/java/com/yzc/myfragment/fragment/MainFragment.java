package com.yzc.myfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yzc.myfragment.PersonalFragment;
import com.yzc.myfragment.R;

public class MainFragment extends Fragment {

    private ImageView fg_home;
    private ImageView fg_category;
    private ImageView fg_cart;
    private ImageView fg_personal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        fg_home = view.findViewById(R.id.fg_home);
        fg_category = view.findViewById(R.id.fg_category);
        fg_cart = view.findViewById(R.id.fg_cart);
        fg_personal = view.findViewById(R.id.fg_personal);

        resetImageResource(fg_home);
        showFragment(fg_home);

        fg_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFragment(fg_home);


                resetImageResource(fg_home);
            }
        });
        fg_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fg_category);

                resetImageResource(fg_category);
            }
        });
        fg_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fg_cart);

                resetImageResource(fg_cart);
            }
        });
        fg_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fg_personal);


                resetImageResource(fg_personal);
            }
        });
    }
    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonalFragment personalFragment;

    private void showFragment(ImageView icon) {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        if (homeFragment!=null){
            transaction.hide(homeFragment);
        } if (categoryFragment!=null){
            transaction.hide(categoryFragment);
        } if (cartFragment!=null){
            transaction.hide(cartFragment);
        } if (personalFragment!=null){
            transaction.hide(personalFragment);
        }

        if (icon.getId()==R.id.fg_home){
            if (homeFragment==null){
               homeFragment=new HomeFragment();
               transaction.add(R.id.fg_main,homeFragment);
            }else {
                transaction.show(homeFragment);
            }

        }else if (icon.getId()==R.id.fg_category){
            if (categoryFragment==null){
                categoryFragment=new CategoryFragment();
                transaction.add(R.id.fg_main,categoryFragment);
            }else {
                transaction.show(categoryFragment);
            }

        }else if (icon.getId()==R.id.fg_cart){
            if (cartFragment==null){
                cartFragment=new CartFragment();
                transaction.add(R.id.fg_main,cartFragment);
            }else {
                transaction.show(cartFragment);
            }

        }else if (icon.getId()==R.id.fg_personal){
            if (personalFragment==null){
                personalFragment=new PersonalFragment();
                transaction.add(R.id.fg_main,personalFragment);
            }else {
                transaction.show(personalFragment);
            }

        }

        transaction.commit();
    }

    private void resetImageResource(View icon) {

        fg_home.setImageResource(R.mipmap.tab_item_home_normal);
        fg_category.setImageResource(R.mipmap.tab_item_category_normal);
        fg_cart.setImageResource(R.mipmap.tab_item_cart_normal);
        fg_personal.setImageResource(R.mipmap.tab_item_personal_normal);


        if (icon.getId()==R.id.fg_home){
            fg_home.setImageResource(R.mipmap.tab_item_home_focus);
        }else if (icon.getId()==R.id.fg_category){
            fg_category.setImageResource(R.mipmap.tab_item_category_focus);
        }else if (icon.getId()==R.id.fg_cart){
            fg_cart.setImageResource(R.mipmap.tab_item_cart_focus);
        }else if (icon.getId()==R.id.fg_personal){
            fg_personal.setImageResource(R.mipmap.tab_item_personal_focus);
        }

    }
}
