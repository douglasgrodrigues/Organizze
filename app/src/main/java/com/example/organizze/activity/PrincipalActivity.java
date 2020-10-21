package com.example.organizze.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.organizze.config.ConfiguracaoFirebase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.organizze.R;
import com.google.firebase.auth.FirebaseAuth;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class PrincipalActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;
    private TextView textoSaudacao, textoSaldo;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //Modifica o titulo da toolbar
        toolbar.setTitle("Organizze");
        setSupportActionBar(toolbar);

        calendarView = findViewById(R.id.calendarView);
        textoSaudacao = findViewById(R.id.textSaldo);
        textoSaldo = findViewById(R.id.textSaldo);
        configuraCalendarView();


       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    //onCreateOptionsMenu cria o menu Sair
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Deslogas uruario
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menuSair:
                autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                autenticacao.signOut();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void adicionarDespesa(View view){
        startActivity(new Intent(this, DespesasActivity.class));

    }

    public void adicionarReceita(View view){
        startActivity(new Intent(this, ReceitasActivity.class));

    }

    public void  configuraCalendarView(){
        //Mudando para portugues os mese e dias da semana
        CharSequence meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro"};
        calendarView.setTitleMonths(meses);

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
               // Log.i("data", "valor" + (date.getMonth() + 1) + "/" + date.getYear());
            }
        });

    }

}