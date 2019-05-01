package com.example.hades.asm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button bt1,bt2;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.login);
        bt2=findViewById(R.id.reset);
        et1=findViewById(R.id.username);
        et2=findViewById(R.id.password);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().length()<1|| et2.getText().length()<1){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập tên người dùng hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Bạn đã đăng nhập dưới tên người dùng "+et1.getText(),Toast.LENGTH_SHORT).show();
                    Intent newIntent= new Intent(MainActivity.this,Menu.class);
                    startActivity(newIntent);
                    finish();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et2.setText("");
                et1.setText("");
            }
        });
            }
}
