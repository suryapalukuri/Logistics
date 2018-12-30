package com.example.admin.logistics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter{
  String[] vehicletype;
  int[] vehicleimage;
  Context context;



    public CustomAdapter(Context context, int[] vehicleImages, String[] vehicletype) {
        super(context,R.layout.custom_layout);
        this.vehicleimage=vehicleImages;
        this.vehicletype=vehicletype;
        this.context=context;
    }
    @Override
    public int getCount() {
        return vehicletype.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }
    private View createItemView(int position, View convertView, ViewGroup parent){
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_layout, parent, false);
            mViewHolder.vehicleimages = (ImageView) convertView.findViewById(R.id.vehicleimage);
            mViewHolder.vehicletype = (TextView) convertView.findViewById(R.id.vehiclename);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.vehicleimages.setImageResource(vehicleimage[position]);
        mViewHolder.vehicletype.setText(vehicletype[position]);

        return convertView;
    }
    private static class ViewHolder {
        ImageView vehicleimages;
        TextView vehicletype;
    }
}
