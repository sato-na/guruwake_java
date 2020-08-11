package com.example.guruwake;

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
    ArrayList<String>memberLR = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);


        // Toolbarの設定
        Toolbar whoTb = findViewById(R.id.who_tb);
        setSupportActionBar(whoTb);

        getSupportActionBar().setDisplayShowHomeEnabled(true);  // 戻るボタンの表示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // 戻るボタンを押したときの処理


        // EditTextからListViewに追加
        final ListView memberLV = findViewById(R.id.member_lv);
        Button addBtn = findViewById(R.id.add_btn);


        // 追加ボタンが押された時の処理
        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 追加ボタンの機能を備えたメソッドの呼び出し
                addStringData();
                memberLV.setAdapter(adapter);

            }
        });


        // 次へボタンの遷移
        Button nextWhoBtn = findViewById(R.id.next_who_btn);
        nextWhoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Collections.reverse(memberL);
                Intent intent = new Intent(WhoActivity.this, HowManyActivity.class);
                intent.putExtra("MEMBER_L", memberL);   // memberLをHowManyActivityに送る
                startActivity(intent);
            }
        });
    }

    // 戻るボタンの処理内容
    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return super.onSupportNavigateUp();
    }

    // 追加ボタンの処理内容
    private void addStringData() {

        EditText memberET = findViewById(R.id.member_et);
        memberL.add(memberET.getText().toString());
        memberET.getEditableText().clear();
        memberLR = (ArrayList<String>) memberL.clone();
        Collections.reverse(memberLR);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, memberLR);  // adapterの設定
    }
}