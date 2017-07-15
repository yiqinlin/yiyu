package com.stark.yiyu.UIactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stark.yiyu.R;
import com.stark.yiyu.Util.Status;

public class AutoActivity extends Activity {
    private EditText edtAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        Status.setTranslucentStatus(getWindow());
        Status.setTranslucentStatus(getWindow(), this, (LinearLayout) findViewById(R.id.transfer_title_status));

        Button right = (Button) findViewById(R.id.button_transfer_title_right);
        ImageButton left = (ImageButton) findViewById(R.id.button_transfer_title_left);
        TextView title = (TextView) findViewById(R.id.text_transfer_title);
        edtAuto = (EditText) findViewById(R.id.edtAuto);

        left.setBackgroundResource(R.drawable.title_back);
        right.setText("保存");

        Intent it = getIntent();
        String auto = it.getStringExtra("auto");
        if (auto.equals("") || auto == null) {
            auto = "  ";
        }
        edtAuto.setText(auto);
        edtAuto.setSelection(auto.length());

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title.setText("个性签名");

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("AutoActivity", edtAuto.getText().toString());
                Log.e("AutoActivity", edtAuto.getText().toString());
                String auto = edtAuto.getText().toString();
                Intent it = new Intent();
                it.putExtra("auto", auto);
                setResult(4, it);
                finish();
            }
        });
    }
}
