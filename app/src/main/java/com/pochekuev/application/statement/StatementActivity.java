package com.pochekuev.application.statement;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.pochekuev.application.R;

public class StatementActivity extends AppCompatActivity implements StatementContract.View {

    private StatementContract.Presenter presenter;

    private RecyclerView recyclerView;
    private StatementRecyclerAdapter statementRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        Bundle bundle = getIntent().getExtras();
        String nrec = "";
        if(bundle != null && getIntent().hasExtra("nrec")) {
            nrec = bundle.getString("nrec");
        }

        presenter = new StatementPresenter();
        presenter.attachView(this);

        recyclerView = findViewById(R.id.statement_recycler_view);
    }

    private void initRecyclerView() {
        statementRecyclerAdapter = new StatementRecyclerAdapter();
        recyclerView.setAdapter(statementRecyclerAdapter);
    }

}
