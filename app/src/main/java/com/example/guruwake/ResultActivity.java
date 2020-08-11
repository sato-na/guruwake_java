package com.example.guruwake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        // CheckActivityから値を受け取る
        Intent intent = getIntent();
        final ArrayList<String> memberL = new ArrayList(intent.getStringArrayListExtra("MEMBER_L"));
        final String groupNum = intent.getStringExtra("GROUP_NUM");


        // グループ分けをして表示する
        String rTxt = "";
        int groupNumI = Integer.parseInt(groupNum);
        int memberNum = memberL.size();
        TextView resultTxt = findViewById(R.id.result_txt);
        Collections.shuffle(memberL);
        for (int n = 1; n <= groupNumI; n++) {
            rTxt += "グループ" + n + "\n";
            int p = memberNum / groupNumI;
            if (n <= memberNum % groupNumI) {
                p++;
            }
            int i = 0;
            for (int q = 0; q < p; q++) {
                rTxt += "  " + memberL.get(i) + "\n";
                memberL.remove(i);
                i++;
            }
        }
        resultTxt.setText(rTxt);


        // タイトルボタンの遷移
        Button titleBtn = findViewById(R.id.title_btn);
        titleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}