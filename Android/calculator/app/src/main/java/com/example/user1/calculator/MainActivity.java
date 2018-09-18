package com.example.user1.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    EditText show,etresult;

    Button add,sub,mul,div,del;
    Button result;

    //이번 연산의 결과를 저장
    String sum = "";
    //피연산자1
    String num1 = "";
    //피연산자2
    String num2 = "";

    //어떤 연산자가 선택되었는지 확인하기 위한 int형 type변수
    int type;

    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    double d1;
    double d2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.show);
        etresult = findViewById(R.id.etresult);
        etresult.setText("");
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        del = findViewById(R.id.btn_del);

        result = findViewById(R.id.btn_result);

        add.setOnClickListener(mListener);
        sub.setOnClickListener(mListener);
        mul.setOnClickListener(mListener);
        div.setOnClickListener(mListener);
        result.setOnClickListener(mListener);
        del.setOnClickListener(mListener);


        //리셋 시킨거
        Button clear = findViewById(R.id.btn_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               show.setText("");
               etresult.setText("");
               d1 = d2 = 0;
               sum = num1 = num2 = "";
            }
        });

    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(etresult.getText().toString() == null)
            {
                Toast.makeText(MainActivity.this,"수를 입력하세요",Toast.LENGTH_SHORT).show();
            }
            switch (v.getId()) {
                case R.id.btn_add :
                    num1 = etresult.getText().toString();
                    sum = etresult.getText().toString() + " + ";
                    show.setText(sum);
                    etresult.setText("");

                    type = ADD;
                    break;

                case R.id.btn_sub :
                    num1 = etresult.getText().toString();
                    sum = etresult.getText().toString() + " - ";
                    show.setText(sum);
                    etresult.setText("");

                    type = SUB;
                    break;

                case R.id.btn_mul :
                    num1 = etresult.getText().toString();
                    sum = etresult.getText().toString() + " * ";
                    show.setText(sum);
                    etresult.setText("");

                    type = MUL;
                    break;

                case R.id.btn_div :
                    num1 = etresult.getText().toString();
                    sum = etresult.getText().toString() + " / ";
                    show.setText(sum);
                    etresult.setText("");

                    type = DIV;
                    break;


                case R.id.btn_del :

                    String del_number = etresult.getText().toString();
                    Toast.makeText(MainActivity.this,del_number,Toast.LENGTH_SHORT).show();
                    etresult.setText(del_number.substring(0,del_number.length() - 1));
                    break;

                case R.id.btn_result :
                    double result = 0;
                    Toast.makeText(MainActivity.this, "결과", Toast.LENGTH_SHORT).show();
                    num2 = etresult.getText().toString();
                    sum = sum + etresult.getText().toString();
                    show.setText(sum);

                    d1 = Double.parseDouble(num1);
                    d2 = Double.parseDouble(num2);

                    if(type == ADD) {
                        result = d1 + d2;
                        etresult.setText("" + result);
                    } else if (type == SUB) {
                        result = d1 - d2;
                        etresult.setText("" + result);
                    }else if (type == MUL) {
                        result = d1 * d2;
                        etresult.setText("" + result);
                    }else if (type == DIV) {
                        result = d1 / d2;
                        etresult.setText("" + result);
                    }

                    num1 = etresult.getText().toString();
                    break;
            }
        }
    };

    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.btn0 : etresult.setText(etresult.getText().toString() + 0); break;
            case R.id.btn1 : etresult.setText(etresult.getText().toString() + 1); break;
            case R.id.btn2 : etresult.setText(etresult.getText().toString() + 2); break;
            case R.id.btn3 : etresult.setText(etresult.getText().toString() + 3); break;
            case R.id.btn4 : etresult.setText(etresult.getText().toString() + 4); break;
            case R.id.btn5 : etresult.setText(etresult.getText().toString() + 5); break;
            case R.id.btn6 : etresult.setText(etresult.getText().toString() + 6); break;
            case R.id.btn7 : etresult.setText(etresult.getText().toString() + 7); break;
            case R.id.btn8 : etresult.setText(etresult.getText().toString() + 8); break;
            case R.id.btn9 : etresult.setText(etresult.getText().toString() + 9); break;
            case R.id.btndot :etresult.setText(etresult.getText().toString() + "."); break;
        }
    }


}
