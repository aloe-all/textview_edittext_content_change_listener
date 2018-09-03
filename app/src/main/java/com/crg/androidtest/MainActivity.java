package com.crg.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edittext);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG", "TAG:== CharSequence  beforeTextChanged:     s= " + s + "    ||int start " +   start + "   ||int count: " + count + "   ||int after: " + after + "\n");
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                String deleteText = s.toString().substring(start + 1 - count, start + 1);
                Log.d("TAG", "TAG:== CharSequence  beforeTextChanged deleteText:" + deleteText);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TAG", "TAG:== CharSequence  onTextChanged:         s= " + s + " ||int start " +   start + " ||int before: " + before + "  ||int count: " +  count + "\n");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TAG", "TAG:== CharSequence afterTextChanged        s= " + s.toString());
            }
        });
    }
}
