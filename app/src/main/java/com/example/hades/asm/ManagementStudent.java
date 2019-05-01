package com.example.hades.asm;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.hades.asm.Adapter.ClassSpinnerStudentAdapter;
import com.example.hades.asm.Adapter.StudentAdapter;
import com.example.hades.asm.model.LopHoc;
import com.example.hades.asm.model.Sinhvien;

import java.util.ArrayList;

public class ManagementStudent extends AppCompatActivity {
    Button bt;
    Spinner spn,spn1;
    ListView lv;
    EditText et,et1;
    ArrayList<Sinhvien> dssv=new ArrayList<>();
    ArrayList<LopHoc> ds=new ArrayList<LopHoc>();
    Database db = new Database(this);
    private Dialog dialog;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_management);
        bt=findViewById(R.id.addStudent);
        spn=findViewById(R.id.selectClass);
        lv=findViewById(R.id.showStudent);
        ds=db.showClass();
        ClassSpinnerStudentAdapter adapter1=new ClassSpinnerStudentAdapter(ManagementStudent.this,ds);
        spn.setAdapter(adapter1);
        capnhatgiaodien();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(ManagementStudent.this);
                // khởi tạo dialog
                dialog.setContentView(R.layout.dialog_student);
                // xét layout cho dialog
                dialog.setTitle("AddStudent");
                // xét tiêu đề cho dialog
                Button dialogButton = (Button) dialog.findViewById(R.id.button8);
                spn1=dialog.findViewById(R.id.spinner);
                et=dialog.findViewById(R.id.editText4);
                et1=dialog.findViewById(R.id.editText);
                ds=db.showClass();
                ClassSpinnerStudentAdapter adapter1=new ClassSpinnerStudentAdapter(ManagementStudent.this,ds);
                spn1.setAdapter(adapter1);


                // khai báo control trong dialog để bắt sự kiện
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String StudentName=et.getText().toString();
                        String Email=et1.getText().toString();
                        int index= spn1.getSelectedItemPosition();
                        int _idClass=ds.get(index)._id;
                        Sinhvien sv=new Sinhvien(StudentName,Email,_idClass);
                        db.addStudent(sv);
                        et.setText("");
                        et1.setText("");
                        spn1.setSelection(1);
                        capnhatgiaodien();

                    }
                });
                // bắt sự kiện cho nút đăng kí
                dialog.show();
                // hiển thị dialog
            }
        });
    }
    public void capnhatgiaodien(){

        dssv=db.showStudent();
        StudentAdapter adapter2=new StudentAdapter(ManagementStudent.this,dssv);
        lv.setAdapter(adapter2);
    }
}
