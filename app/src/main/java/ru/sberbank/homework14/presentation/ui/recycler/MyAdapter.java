package ru.sberbank.homework14.presentation.ui.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework14.R;
import ru.sberbank.homework14.domain.entity.Forecast;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Forecast> mData = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    public void setData(List<Forecast> forecasts) {
        mData.clear();
        mData.addAll(forecasts);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.setConditionTextView(mData.get(i).getParts().getDay().getCondition());
        myViewHolder.setDateTextView(mData.get(i).getDate());
        myViewHolder.setTempTextView(String.valueOf(mData.get(i).getParts().getDay().getTempAvg() + "°"));
        myViewHolder.setDayOfWeekTextView(mData.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public Forecast getItemForecast(int position) {
        return mData.get(position);
    }
}
