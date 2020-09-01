package com.pochekuev.application.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.pochekuev.application.OnRecyclerItemClickListener;
import com.pochekuev.application.PreferencesManager;
import com.pochekuev.application.R;
import com.pochekuev.application.models.TeacherStatements;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public MainContract.Presenter presenter;

    private Button logoutButton;
    private ProgressBar progressBar;
    private TextView teacher;
    private RecyclerView recyclerView;
    private MainRecyclerAdapter MainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(PreferencesManager.getInstance(this));
        presenter.attachView(this);

        logoutButton = findViewById(R.id.logoutButton);
        progressBar = findViewById(R.id.progress_bar);
        teacher = findViewById(R.id.teacher);
        recyclerView = findViewById(R.id.statement_recycler_view);

        logoutButton.setOnClickListener(OnLogoutClickListener);

        initRecyclerView();
    }

    private void initRecyclerView() {
        MainRecyclerAdapter = new MainRecyclerAdapter(this);
        recyclerView.setAdapter(MainRecyclerAdapter);
        MainRecyclerAdapter.setOnRecyclerItemClickListener(OnItemClickListener);

        presenter.onRecyclerViewReady();
    }

    // Initialize Click Listener's
    private View.OnClickListener OnLogoutClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onLogoutButtonClicked();
        }
    };

    private OnRecyclerItemClickListener<TeacherStatements> OnItemClickListener = new OnRecyclerItemClickListener<TeacherStatements>() {
        @Override
        public void onItemClick(TeacherStatements itemType) {
            presenter.onStatementClicked(itemType);

        }
    };

    @Override
    public void openStatement(Class<?> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataToRecycler(List<TeacherStatements> teacherStatements) {
        String teacherPlaceholder = String.format("%s | Количество дисциплин: %d", teacherStatements.get(0).getExaminer(), teacherStatements.size());
        teacher.setText(teacherPlaceholder);
        MainRecyclerAdapter.setData(teacherStatements);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void logoutAccount(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
        if(isFinishing()) {
            presenter.destroy();
        }
    }
}