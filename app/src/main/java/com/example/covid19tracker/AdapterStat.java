package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterStat extends RecyclerView.Adapter<AdapterStat.HolderStat> {
    private Context context;
    private ArrayList<ModelStat> statArrayList;

    public AdapterStat(Context context, ArrayList<ModelStat> statArrayList) {
        this.context = context;
        this.statArrayList = statArrayList;
    }

    @NonNull
    @Override
    public HolderStat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //inflate layout row_stat.xml
        View view = LayoutInflater.from(context).inflate(R.layout.row_stat,parent,false);
        return new HolderStat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderStat holder, int position) {
        //get data
        ModelStat modelStat = statArrayList.get(position);
        String country = modelStat.getCountry();
        String totalConfirmed = modelStat.getTotalConfirmed();
        String totalDeaths = modelStat.getTotalDeaths();
        String totalRecovered = modelStat.getTotalRecovered();
        String newConfirmed = modelStat.getNewConfirmed();
        String newDeaths = modelStat.getNewDeaths();
        String newRecovered = modelStat.getNewRecovered();

        //set data
        holder.countryTV.setText(country);
        holder.todayRecoveredTV.setText(newRecovered);
        holder.todayDeathsTv.setText(newDeaths);
        holder.todayCasesTv.setText(newConfirmed);
        holder.recoveredTV.setText(totalRecovered);
        holder.deathsTv.setText(totalDeaths);
        holder.casesTv.setText(totalConfirmed);



    }

    @Override
    public int getItemCount() {
        return statArrayList.size();
    }

    //View holder class
    class HolderStat extends RecyclerView.ViewHolder{
        //UI Views
        TextView countryTV,casesTv,todayCasesTv,deathsTv,todayDeathsTv,recoveredTV,todayRecoveredTV;

        public HolderStat(@NonNull View itemView) {
            super(itemView);
            countryTV = itemView.findViewById(R.id.countryTv);
            casesTv = itemView.findViewById(R.id.casesTv);
            todayCasesTv = itemView.findViewById(R.id.todayCasesTv);
            deathsTv = itemView.findViewById(R.id.deathsTv);
            todayDeathsTv = itemView.findViewById(R.id.todayDeathsTv);
            recoveredTV = itemView.findViewById(R.id.recoveredTV);
            todayRecoveredTV = itemView.findViewById(R.id.todayRecoveredTV);

        }

    }
}
