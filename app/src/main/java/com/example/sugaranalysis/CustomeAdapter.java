package com.example.sugaranalysis;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.sugaranalysis.SettingsFragment.PREFERENCE_HEIGHT;
import static com.example.sugaranalysis.SettingsFragment.PREFERENCE_WEIGHT;

public class CustomeAdapter extends BaseAdapter {

    private Context context;
    public static ArrayList<EditModel> editModelArrayList;
    //this is public static so we can use it in any activity

    public CustomeAdapter(Context context, ArrayList<EditModel> editModelArrayList) {

        this.context = context;
        this.editModelArrayList = editModelArrayList;
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
        return editModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return editModelArrayList.get(position);
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
            holder.textView = (TextView) convertView.findViewById(R.id.title);
            holder.editText = (EditText) convertView.findViewById(R.id.editText);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(editModelArrayList.get(position).getTitle());
        holder.editText.setText(editModelArrayList.get(position).getEditTextValue());

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            } //the initial state of the edittext

            //when the user enters any text value, this method is called
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editModelArrayList.get(position).setEditTextValue(holder.editText.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return convertView;
    }

    private class ViewHolder {
         TextView textView;
         EditText editText;

    }



}
