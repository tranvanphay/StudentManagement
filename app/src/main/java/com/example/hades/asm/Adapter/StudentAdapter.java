package com.example.hades.asm.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hades.asm.R;
import com.example.hades.asm.model.Sinhvien;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    ArrayList<Sinhvien> dssv=new ArrayList<Sinhvien>();
    Context c;
    public StudentAdapter(Context c ,ArrayList<Sinhvien> dssv){
        this.c=c;
        this.dssv=dssv;
    }

    @Override
    public int getCount() {
        return dssv.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //gan layout
        LayoutInflater inf=((Activity)c).getLayoutInflater();
        view=inf.inflate(R.layout.one_item_student,null);
        TextView tv_id=view.findViewById(R.id.idSv);
        TextView tv_tensv=view.findViewById(R.id.tenSv);
        TextView tv_email=view.findViewById(R.id.Email);
        TextView tv_idlop=view.findViewById(R.id.idlop);
        Sinhvien sv= dssv.get(i);
        tv_id.setText("StudentCode:"+ sv._id+"");
        tv_tensv.setText("StudentName: "+sv.tensv);
        tv_email.setText("Email: "+sv.email);
        tv_idlop.setText("ClassCode: "+sv._idlop+"");



        return view;
    }
}
