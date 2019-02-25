package ru.sberbank.homework14.presentation.ui.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ru.sberbank.homework14.R;

class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView tempTextView;
    private TextView dateTextView;
    private TextView conditionTextView;
    private TextView dayOfWeekTextView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tempTextView = itemView.findViewById(R.id.tempTextView);
        dateTextView = itemView.findViewById(R.id.date_textView);
        conditionTextView = itemView.findViewById(R.id.conditionTextView);
        dayOfWeekTextView = itemView.findViewById(R.id.dayOfWeekTextView);
    }

    public void setTempTextView(String s) {
        tempTextView.setText(s);
    }

    public void setDateTextView(String s) {
        dateTextView.setText(s);
    }

    public void setConditionTextView(String s) {
        conditionTextView.setText(s);
    }

    public void setDayOfWeekTextView(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Locale locale = new Locale("ru");
        String dayOfWeek = new SimpleDateFormat("EEEE", locale).format(date);
        dayOfWeek = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
        dayOfWeekTextView.setText(dayOfWeek);

    }
}
