package com.example.sugaranalysis;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterTime extends BaseAdapter {

    private Context context;
    public static ArrayList<TimeItemCmp> timeItemAL;
    //this is public static so we can use it in any activity

    public AdapterTime(Context context, ArrayList<TimeItemCmp> timeItemAL) {

        this.context = context;
        this.timeItemAL = timeItemAL;
        //using an ArrayList of the objects of the EditModel class
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return timeItemAL.size();
    }

    @Override
    public Object getItem(int position) {
        return timeItemAL.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);
            holder.timeView = (TextView) convertView.findViewById(R.id.timeBox);
            holder.editTime = (EditText) convertView.findViewById(R.id.timeEdit);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        holder.timeView.setText(timeItemAL.get(position).getTitle());
        holder.editTime.setText(timeItemAL.get(position).getEditTextValue());

        holder.editTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            } //the initial state of the edittext

            //when the user enters any text value, this method is called
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                timeItemAL.get(position).setEditTextValue(holder.editTime.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView timeView;
        EditText editTime;

    }



}
