package com.pochekuev.application.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.pochekuev.application.OnRecyclerItemClickListener;
import com.pochekuev.application.R;
import com.pochekuev.application.Variables;
import com.pochekuev.application.models.TeacherStatements;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private OnRecyclerItemClickListener<TeacherStatements> onRecyclerItemClickListener;
    private List<TeacherStatements> teacherStatements;
    private Context context;

    public MainRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TeacherStatements> teacherStatements) {
        this.teacherStatements = teacherStatements;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_statements_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(teacherStatements.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerItemClickListener.onItemClick(teacherStatements.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return teacherStatements != null ? teacherStatements.size() : 0;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener<TeacherStatements> onRecyclerItemClickListener) {
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView discipline,
                disciplineType,
                faculty,
                group,
                chair,
                //examiner,
                year,
                semester,
                studentsCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.main_card_view);
            discipline = itemView.findViewById(R.id.discipline);
            disciplineType = itemView.findViewById(R.id.discipline_type);
            faculty = itemView.findViewById(R.id.faculty);
            group = itemView.findViewById(R.id.group);
            chair = itemView.findViewById(R.id.chair);
            //examiner = itemView.findViewById(R.id.examiner);
            year = itemView.findViewById(R.id.year);
            semester = itemView.findViewById(R.id.semester);
            studentsCount = itemView.findViewById(R.id.students_count);
        }

        public void bind(TeacherStatements teacherStatements) {
            discipline.setText(teacherStatements.getDiscipline());
            disciplineType.setText(teacherStatements.getTypeList());

            String facultyPlaceholder = String.format("Факультет: %s", teacherStatements.getListFacult());
            faculty.setText(facultyPlaceholder);

            String groupPlaceholder = String.format("Группа: %s", teacherStatements.getStudGroup());
            group.setText(groupPlaceholder);

            chair.setText(teacherStatements.getListChair());

/*            String examinerPlaceholder = String.format("Преподаватель: %s", teacherStatements.getExaminer());
            examiner.setText(examinerPlaceholder);*/

            String yearPlaceholder = String.format("Год: %d", teacherStatements.getYear());
            year.setText(yearPlaceholder);

            String semesterPlaceholder = String.format("Семестр: %s", teacherStatements.getSemester());
            semester.setText(semesterPlaceholder);

            String studentsCountPlaceholder = String.format("Количество студентов: %d", teacherStatements.getStudentCount());
            studentsCount.setText(studentsCountPlaceholder);

            disciplineType.setTextColor(getColorByDisciplineType(teacherStatements.getTypeList()));

            cardView.setCardBackgroundColor(Variables.getTransparentColor(
                    ContextCompat.getColor(context, R.color.colorSwitch),
                    0.2
            ));
        }

        @ColorInt
        public int getColorByDisciplineType(String disciplineType) {
            switch (disciplineType) {
                case "Экзамен":
                    return Variables.getTransparentColor(
                            ContextCompat.getColor(context, R.color.colorRed),
                            0.5);
                default:
                    return Color.BLACK;
            }
        }
    }
}
