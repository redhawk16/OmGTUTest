package com.pochekuev.application.statement;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.pochekuev.application.OnRecyclerItemClickListener;
import com.pochekuev.application.R;
import com.pochekuev.application.models.Statement;
import com.pochekuev.application.models.Student;

import java.util.List;

public class StatementActivity extends AppCompatActivity implements StatementContract.View {

    private StatementContract.Presenter presenter;

    private ProgressBar progressBar;
    private TextView discipline,
            chair,
            faculty,
            group,
            semester,
            disciplineType,
            hoursTotal,
            hours,
            examiner;

    private RecyclerView recyclerView;
    private StatementRecyclerAdapter statementRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        presenter = new StatementPresenter();
        presenter.attachView(this);

        initViews();
        initRecyclerView();

        presenter.onActivityReady(getIntent().getExtras());
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.statement_recycler_view);
        discipline = findViewById(R.id.discipline);
        chair = findViewById(R.id.chair);
        faculty = findViewById(R.id.faculty);
        group = findViewById(R.id.group);
        semester = findViewById(R.id.semester);
        disciplineType = findViewById(R.id.discipline_type);
        hoursTotal = findViewById(R.id.hours_total);
        hours = findViewById(R.id.hours);
        examiner = findViewById(R.id.examiner);
    }

    private void initRecyclerView() {
        statementRecyclerAdapter = new StatementRecyclerAdapter(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(statementRecyclerAdapter);

        statementRecyclerAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener<Student>() {
            @Override
            public void onItemClick(Student itemType) {
                Toast.makeText(StatementActivity.this, String.format("Selected: %s", itemType.getFio()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setDataToRecycler(List<Student> studentsList) {
        statementRecyclerAdapter.setData(studentsList);
    }

    @Override
    public void setDataToViews(Statement statement) {
        String disciplinePlaceholder = String.format("Дисциплина: %s", statement.getDiscipline());
        discipline.setText(disciplinePlaceholder);

        String chairPlaceholder = String.format("Направление: %s", statement.getListChair());
        chair.setText(chairPlaceholder);

        String facultyPlaceholder = String.format("Факультет: %s", statement.getListFacult());
        faculty.setText(facultyPlaceholder);

        String groupPlaceholder = String.format("Группа: %s", statement.getStudGroup());
        group.setText(groupPlaceholder);

        String semesterPlaceholder = String.format("Номер семестра: %s", statement.getSemester());
        semester.setText(semesterPlaceholder);

        disciplineType.setText(statement.getFormAttestationList());

        String hoursTotalPlaceholder = String.format("audHoursTotalList: %s", statement.getAudHoursTotalList());
        hoursTotal.setText(hoursTotalPlaceholder);

        String hoursPlaceholder = String.format("audHoursList: %s", statement.getAudHoursList());
        hours.setText(hoursPlaceholder);

        String examinerPlaceholder = String.format("Преподаватель: %s", statement.getExaminerFio());
        examiner.setText(examinerPlaceholder);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
