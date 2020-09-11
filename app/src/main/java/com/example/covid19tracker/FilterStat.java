package com.example.covid19tracker;

import android.widget.Filter;
import java.util.ArrayList;

public class FilterStat extends Filter {
    private AdapterStat adapter;
    public ArrayList<ModelStat> filterList;

    public FilterStat(AdapterStat adapter, ArrayList<ModelStat> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
        protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //check rang buoc
        if(constraint != null && constraint.length() > 0){
            //change to upcase
            constraint = constraint.toString().toUpperCase();
            // store out filtered records
            ArrayList<ModelStat> filteredModels = new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                if(filterList.get(i).getCountry().toUpperCase().contains(constraint)){
                    filteredModels.add(filterList.get(i));
                }
            }
            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.statArrayList = (ArrayList<ModelStat>) results.values;
        //refresh list
        adapter.notifyDataSetChanged();
    }
}
