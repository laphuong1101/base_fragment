package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMainActCallback {
    private ImageView ivContact, ivInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ivContact = findViewById(R.id.iv_contact);
        ivInfo = findViewById(R.id.iv_info);
        changeTab(ivContact, ivInfo);
        ivInfo.setOnClickListener(this);
        ivContact.setOnClickListener(this);
        FragmentFactory.getInstance().showFragment(ListContactFrg.class.getName(), this, getSupportFragmentManager(), R.id.ln_main);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_contact) {
            changeTab(ivContact, ivInfo);
            FragmentFactory.getInstance().showFragment(ListContactFrg.class.getName(), this, getSupportFragmentManager(), R.id.ln_main);
        } else if (view.getId() == R.id.iv_info) {
            changeTab(ivInfo, ivContact);
            FragmentFactory.getInstance().showFragment(DetailContactFrg.class.getName(), this, getSupportFragmentManager(), R.id.ln_main);
        }
    }

    private void changeTab(ImageView selectTab, ImageView unselectTab) {
        selectTab.setBackgroundResource(R.color.white);
        selectTab.setColorFilter(ContextCompat.getColor(this, R.color.design_default_color_primary),
                android.graphics.PorterDuff.Mode.SRC_IN);
        unselectTab.setBackgroundResource(R.color.design_default_color_primary);
        unselectTab.setColorFilter(ContextCompat.getColor(this, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void showDetailContact(ContactEntity contactEntity) {
        DetailContactFrg frg = ((DetailContactFrg) FragmentFactory.getInstance().getFragment(DetailContactFrg.class.getName(), this));
        frg.setContactEntity(contactEntity);
        FragmentFactory.getInstance().showFragment(DetailContactFrg.class.getName(), this, getSupportFragmentManager(), R.id.ln_main);
    }
}