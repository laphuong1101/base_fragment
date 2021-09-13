package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListContactFrg extends BaseFragment<OnMainActCallback> {
    private List<ContactEntity> listContact;
    private LinearLayout lnListContact;
    private int indexSelected = -1;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_list_contact;
    }

    @Override
    protected void initViews() {
        initData();
        lnListContact = rootView.findViewById(R.id.ln_list_contact);
        lnListContact.removeAllViews();

        for (int i = 0; i < listContact.size(); i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_contact, lnListContact, false);
            TextView tvPhone = itemView.findViewById(R.id.tv_phone);
            TextView tvName = itemView.findViewById(R.id.tv_name);
            tvPhone.setText(listContact.get(i).getPhone());
            tvName.setText(listContact.get(i).getName());

            lnListContact.addView(itemView);
            itemView.setTag(listContact.get(i));
            itemView.setOnClickListener(this);
        }

        if (indexSelected != -1) {
            lnListContact.getChildAt(indexSelected).setBackgroundResource(R.color.design_default_color_secondary);
        }
    }

    private void initData() {
        listContact = new ArrayList<>();
        listContact.add(new ContactEntity("La Phuong" , "0975392222"));
        listContact.add(new ContactEntity("Huy Cuong" , "0975292xxx"));
        listContact.add(new ContactEntity("Duc Tung" , "0975192xxx"));
        listContact.add(new ContactEntity("Thanh Mai" , "0975391xxx"));
        listContact.add(new ContactEntity("La Hanh" , "0975390xxx"));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ln_item) {
            //Toast.makeText(mContext,((ContactEntity) view.getTag()).getName(), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < lnListContact.getChildCount(); i++) {
                lnListContact.getChildAt(i).setBackgroundResource(R.color.white);
            }
            view.setBackgroundResource(R.color.design_default_color_secondary);
            callback.showDetailContact((ContactEntity) view.getTag());
            indexSelected = listContact.indexOf((ContactEntity) view.getTag());
        }
    }
}
