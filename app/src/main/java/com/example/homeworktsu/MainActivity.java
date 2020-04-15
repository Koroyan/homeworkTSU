package com.example.homeworktsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.homeworktsu.model.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView sakitxi;
    TextView qula;
    List<Test> tests=new ArrayList<>();
    SharedPreferences sharedPref;
    int i=0;
    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        btn1=findViewById(R.id.btn_pasuxi1);
        btn2=findViewById(R.id.btn_pasuxi2);
        btn3=findViewById(R.id.btn_pasuxi3);
        btn4=findViewById(R.id.btn_pasuxi4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        sakitxi=findViewById(R.id.sakitxi);
        qula=findViewById(R.id.qula);
        tests.add(new Test("120+150=?","270", Arrays.asList("10","252","270","169")));
        tests.add(new Test("12+150=?","162", Arrays.asList("220","182","170","162")));
        tests.add(new Test("120+15=?","135", Arrays.asList("105","135","145","109")));
        tests.add(new Test("5*15=?","75", Arrays.asList("70","22","75","19")));
        tests.add(new Test("100/4?","25", Arrays.asList("20","25","17","16")));
        tests.add(new Test("250/5=?","50", Arrays.asList("10","52","50","69")));
        tests.add(new Test("11*11=?","121", Arrays.asList("110","121","175","189")));
        show(0,0);
         sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        count = sharedPref.getInt(getString(R.string.preference_file_key), 0);
        qula.setText(String.valueOf(count));
        count=0;
    }

    public void show(int i,int count){
        if(i<tests.size()) {
            sakitxi.setText(tests.get(i).getSakitxi());
            btn1.setText(tests.get(i).getPasuxebi().get(0));
            btn2.setText(tests.get(i).getPasuxebi().get(1));
            btn3.setText(tests.get(i).getPasuxebi().get(2));
            btn4.setText(tests.get(i).getPasuxebi().get(3));
        }else{
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(getString(R.string.preference_file_key), count);
            editor.apply();
            count = sharedPref.getInt(getString(R.string.preference_file_key), 0);
            qula.setText(String.valueOf(count));
        }
    }

    @Override
    public void onClick(View view) {
        Log.d("clicked", "onClick: ");
        if(i<tests.size()){
        Button a=(Button)view;
        if(tests.get(i).sworiaPasuxi(a.getText().toString())){
            count++;
            Toast.makeText(this,"სწორია",Toast.LENGTH_SHORT).show();
        }
            i++;
            show(i,count);
        }

    }
}
