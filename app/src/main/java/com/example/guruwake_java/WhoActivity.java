package com.example.guruwake_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class WhoActivity extends AppCompatActivity {


    ArrayList<String>memberL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);


        // ツールバーの設定
        Toolbar whoTb = findViewById(R.id.who_tb);
        setSupportActionBar(whoTb);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // 追加ボタンの処理
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addMember();

            }
        });


        // 次へボタンの遷移
        Button nextWhoBtn = findViewById(R.id.next_who_btn);
        nextWhoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 引き渡す値の調整
                Collections.reverse(memberL);

                // 画面遷移
                Intent intent = new Intent(WhoActivity.this, HowManyActivity.class);
                intent.putExtra("MEMBER_L", memberL);   // memberLをHowManyActivityに送る
                startActivity(intent);
            }
        });
    }


    // 戻るボタンの処理
    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return super.onSupportNavigateUp();
    }


    // 追加ボタンの処理内容
    private void addMember() {

        EditText memberET = findViewById(R.id.member_et);
        ListView memberLV = findViewById(R.id.member_lv);
        memberL.add(memberET.getText().toString());
        memberET.getEditableText().clear();
        ArrayList<String> memberLR = (ArrayList<String>) memberL.clone();
        Collections.reverse(memberLR);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, memberLR);
        memberLV.setAdapter(adapter);
    }
}