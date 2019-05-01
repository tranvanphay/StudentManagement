package com.example.hades.asm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
Button bt1,bt2;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        bt1=findViewById(R.id.StudentManager);
        bt2=findViewById(R.id.ClassManager);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new  Intent(Menu.this,ManagementStudent.class);
                startActivity(newIntent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent1= new Intent(Menu.this,ManagerClass.class);
                startActivity(newIntent1);
            }
        });
    }
}
