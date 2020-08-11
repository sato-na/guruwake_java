package com.example.guruwake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class HowManyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many);


        // WhoActivityから値を受け取る
        Intent intent = getIntent();
        final ArrayList<String> memberL = new ArrayList(intent.getStringArrayListExtra("MEMBER_L"));


        // ツールバーの設定
        Toolbar hmTB = findViewById(R.id.hm_tb);
        setSupportActionBar(hmTB);

        getSupportActionBar().setDisplayShowHomeEnabled(true);  // 戻るボタンの表示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // 戻るボタンを押したときの処理


        // 次へボタンの遷移
        Button nextHMBtn = findViewById(R.id.next_hm_btn);
        nextHMBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // グループの個数を保存
                EditText groupNum = findViewById(R.id.group_num_et);

                // 画面遷移
                Intent intent = new Intent(HowManyActivity.this, CheckActivity.class);
                intent.putExtra("MEMBER_L", memberL);         // memberLをCheckActivityに送る
                intent.putExtra("GROUP_NUM", groupNum.getText().toString());    // groupNumをCheckActivityに送る
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
