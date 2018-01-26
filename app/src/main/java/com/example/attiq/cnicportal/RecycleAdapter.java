package com.example.attiq.cnicportal;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<DataModel> dataModelArrayList;

    public RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView name,fatherName, gender, country, religion, dob;

        public Myholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            fatherName = (TextView) itemView.findViewById(R.id.fName);
            gender = (TextView) itemView.findViewById(R.id.gender);
            country = (TextView) itemView.findViewById(R.id.country);
            religion = (TextView) itemView.findViewById(R.id.religion);
            dob = (TextView) itemView.findViewById(R.id.dob);

        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
         return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);

        holder.name.setText(dataModel.getName());
        holder.fatherName.setText(dataModel.getFatherName());
        holder.gender.setText(dataModel.getGender());
        holder.country.setText(dataModel.getCountry());
        holder.religion.setText(dataModel.getReligion());
        holder.dob.setText(dataModel.getDOB());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
