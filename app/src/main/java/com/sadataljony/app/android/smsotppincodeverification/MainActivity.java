package com.sadataljony.app.android.smsotppincodeverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditText01, mEditText02, mEditText03, mEditText04;
    private Button mButtonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        mEditText01 = findViewById(R.id.editText01);
        mEditText01.requestFocus();
        mEditText02 = findViewById(R.id.editText02);
        mEditText03 = findViewById(R.id.editText03);
        mEditText04 = findViewById(R.id.editText04);
        mEditText01.addTextChangedListener(new GenericTextWatcher(mEditText01));
        mEditText02.addTextChangedListener(new GenericTextWatcher(mEditText02));
        mEditText03.addTextChangedListener(new GenericTextWatcher(mEditText03));
        mEditText04.addTextChangedListener(new GenericTextWatcher(mEditText04));
        mButtonShow = findViewById(R.id.buttonShow);
        mButtonShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == mButtonShow) {
            if (mEditText01.getText().toString().trim().equalsIgnoreCase("")) {
                mEditText01.setError("This field can not be blank");
            } else if (mEditText02.getText().toString().trim().equalsIgnoreCase("")) {
                mEditText02.setError("This field can not be blank");
            } else if (mEditText03.getText().toString().trim().equalsIgnoreCase("")) {
                mEditText03.setError("This field can not be blank");
            } else if (mEditText04.getText().toString().trim().equalsIgnoreCase("")) {
                mEditText04.setError("This field can not be blank");
            } else {
                String str01 = mEditText01.getText().toString().trim();
                String str02 = mEditText02.getText().toString().trim();
                String str03 = mEditText03.getText().toString().trim();
                String str04 = mEditText04.getText().toString().trim();
                String strFinal = str01 + str02 + str03 + str04;
                Toast.makeText(MainActivity.this, strFinal, Toast.LENGTH_LONG).show();
                mEditText01.setText("");
                mEditText02.setText("");
                mEditText03.setText("");
                mEditText04.setText("");
                mEditText01.requestFocus();
            }
        }
    }

    public class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // TODO Auto-generated method stub
            String text = editable.toString();
            switch (view.getId()) {

                case R.id.editText01:
                    if (text.length() == 1)
                        mEditText02.requestFocus();
                    break;
                case R.id.editText02:
                    if (text.length() == 1)
                        mEditText03.requestFocus();
                    else if (text.length() == 0)
                        mEditText01.requestFocus();
                    break;
                case R.id.editText03:
                    if (text.length() == 1)
                        mEditText04.requestFocus();
                    else if (text.length() == 0)
                        mEditText02.requestFocus();
                    break;
                case R.id.editText04:
                    if (text.length() == 0)
                        mEditText03.requestFocus();
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }
    }

}