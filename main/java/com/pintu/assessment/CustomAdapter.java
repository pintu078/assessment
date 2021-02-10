package com.pintu.assessment;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;

public class CustomAdapter implements ListAdapter {
    ArrayList<MyData> arrayList;
    ListView listV;
    Context c;

    public CustomAdapter(ArrayList<MyData> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }



    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyData myData = arrayList.get(position);
//        if(convertView==null)
//        {
            LayoutInflater layoutInflater=LayoutInflater.from(c);
            convertView=layoutInflater.inflate(R.layout.activity_list_item,null);
            final TextView Fnameli = convertView.findViewById(R.id.fnameli);
            final TextView Lnameli = convertView.findViewById(R.id.lnameli);

            final TextView Genderli = convertView.findViewById(R.id.genderli);
            final TextView Statusli = convertView.findViewById(R.id.statusli);
            final TextView Qualifyli = convertView.findViewById(R.id.qualifyli);


            final TextView Emailli = convertView.findViewById(R.id.emailli);
            final TextView Mobileli = convertView.findViewById(R.id.mobileli);
            ImageButton delBtn = convertView.findViewById(R.id.del);
            ImageButton editBtn = convertView.findViewById(R.id.edit);
            //listV.findViewById(R.id.listv);
            Fnameli.setText(myData.fNameC);
            Lnameli.setText(myData.lNameC);

            Genderli.setText(myData.genderC);
            Statusli.setText(myData.statusC);
            Qualifyli.setText(myData.qualifC);

            Emailli.setText(myData.emailC);
            Mobileli.setText(myData.mobileC);

            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppConstant.mydatas.remove(arrayList.get(position));

                }
            });
            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Form_1.class);
                    intent.putExtra("posi",position);
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Custom "+position);
                    //AppConstant.mydatas.remove((arrayList.get(position)));
                    intent.putExtra("fn", Fnameli.getText().toString());
                    intent.putExtra("ln",Lnameli.getText().toString());

//                    String gen = myData.getGenderC();
//                    String sta = myData.getStatusC();
//
//                    intent.putExtra("gen",gen);
//                    intent.putExtra("stat",sta);
                    intent.putExtra("gen",Genderli.getText().toString());
                    intent.putExtra("stat",Statusli.getText().toString());
                    intent.putExtra("quali",Qualifyli.getText().toString());

                    intent.putExtra("mob",Mobileli.getText().toString());
                    intent.putExtra("ema",Emailli.getText().toString());

                    v.getContext().startActivity(intent);
                    }
            });

//        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
