package com.example.hades.asm;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hades.asm.Adapter.ClassAdapter;
import com.example.hades.asm.model.LopHoc;

import java.util.ArrayList;

public class ManagerClass extends AppCompatActivity {
    Button bt;
    private Dialog dialog;
    ListView lv;
    Database db;
    EditText etAdd;
    ArrayList<LopHoc> ds=new ArrayList<LopHoc>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_manager);
        bt=findViewById(R.id.button6);
        lv=findViewById(R.id.listview);
        db=new Database(ManagerClass.this);
        updateUI();
        registerForContextMenu(lv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(ManagerClass.this);
                // khởi tạo dialog
                dialog.setContentView(R.layout.dialog_class);
                // xét layout cho dialog
                dialog.setTitle("AddClass");
                // xét tiêu đề cho dialog
                Button dialogButton = dialog.findViewById(R.id.button7);
                etAdd = dialog.findViewById(R.id.editText3);
                // khai báo control trong dialog để bắt sự kiện

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ClassName = etAdd.getText().toString();
                        LopHoc lh=new LopHoc(ClassName);
                        db.addClass(lh);
                        etAdd.setText("");
                        updateUI();
                        Toast.makeText(ManagerClass.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });
                // bắt sự kiện cho nút đăng kí
                dialog.show();

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       int index=lv.getSelectedItemPosition();
        int i=ds.get(index)._id;

        if(item.getItemId()==R.id.edit){
            Toast.makeText(ManagerClass.this,"Edit",Toast.LENGTH_SHORT).show();

        }
        if(item.getItemId()==R.id.delete){
            Toast.makeText(ManagerClass.this,"Deleted "+i,Toast.LENGTH_SHORT).show();
            db.deleteClass(i);
        }
        return super.onContextItemSelected(item);
    }

    //Hàm show class lên ListView và cập nhật giao diện
    public void updateUI(){
        ds=db.showClass();
        ClassAdapter adapter=new ClassAdapter(ManagerClass.this,ds);
        lv.setAdapter(adapter);
    }
}
