package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailContactFrg extends BaseFragment<OnActionCallback> {
    private ContactEntity contactEntity;
    private TextView tvName;
    private TextView tvPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_detail_contact;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }


    @Override
    protected void initViews() {
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);

        if (contactEntity != null) {
            tvName.setText(contactEntity.getName());
            tvPhone.setText(contactEntity.getPhone());
        }
    }
}
