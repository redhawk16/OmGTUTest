package com.pochekuev.application.statement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pochekuev.application.OnRecyclerItemClickListener;
import com.pochekuev.application.R;
import com.pochekuev.application.models.Student;

import java.util.List;

public class StatementRecyclerAdapter extends RecyclerView.Adapter<StatementRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Student> studentsList;

    private OnRecyclerItemClickListener<Student> onRecyclerItemClickListener;

    public StatementRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Student> studentsList) {
        this.studentsList = studentsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(studentsList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerItemClickListener.onItemClick(studentsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList != null ? studentsList.size() : 0;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener<Student> onRecyclerItemClickListener) {
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView studentFio,
                recordBook,
                mark,
                rating,
                ratingSem,
                ratingAtt,
                ratingRes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            studentFio = itemView.findViewById(R.id.student_fio);
            recordBook = itemView.findViewById(R.id.record_book);
            mark = itemView.findViewById(R.id.mark);
            rating = itemView.findViewById(R.id.rating);
            ratingSem = itemView.findViewById(R.id.rating_sem);
            ratingAtt = itemView.findViewById(R.id.rating_att);
            ratingRes = itemView.findViewById(R.id.rating_res);
        }

        public void bind(Student student) {
            studentFio.setText(student.getFio());
            recordBook.setText(student.getRecordBookNumber());
            mark.setText(student.getMarkString());

            String ratingPlaceholder = String.format("rating: %s", student.getRating());
            rating.setText(ratingPlaceholder);

            String ratingPSemPlaceholder = String.format("ratingSem: %s", student.getRatingsem());
            ratingSem.setText(ratingPSemPlaceholder);

            String ratingAttPlaceholder = String.format("ratingAtt: %s", student.getRatingatt());
            ratingAtt.setText(ratingAttPlaceholder);

            String ratingResPlaceholder = String.format("ratingRes: %s", student.getRatingres());
            ratingRes.setText(ratingResPlaceholder);
        }
    }
}
