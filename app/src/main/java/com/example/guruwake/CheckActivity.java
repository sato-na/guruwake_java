package com.example.guruwake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        // HowManyActivityから値を受け取る
        Intent intent = getIntent();
        final ArrayList<String> memberL = new ArrayList(intent.getStringArrayListExtra("MEMBER_L"));
        final String groupNum = intent.getStringExtra("GROUP_NUM");


        // ツールバーの設定
        Toolbar checkTB = findViewById(R.id.check_tb);
        setSupportActionBar(checkTB);

        getSupportActionBar().setDisplayShowHomeEnabled(true);  // 戻るボタンの表示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // 戻るボタンを押したときの処理


        // メンバーリストを設定
        ListView memberCheckLV = findViewById(R.id.member_check_lv);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, memberL);
        memberCheckLV.setAdapter(adapter);


        // テキストを設定
        TextView checkTxt = findViewById(R.id.check_txt);
        checkTxt.setText("を" + groupNum + "個のグループに分ける");


        // 決定ボタンの遷移
        Button decideBtn = findViewById(R.id.decide_btn);
        decideBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 画面遷移
                Intent intent = new Intent(CheckActivity.this, ResultActivity.class);
                intent.putExtra("MEMBER_L", memberL);       // ResultActivityにmemberLを送る
                intent.putExtra("GROUP_NUM", groupNum);     // ResultActivityにgroupNumを送る
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
}
