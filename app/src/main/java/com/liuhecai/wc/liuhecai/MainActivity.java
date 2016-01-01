package com.liuhecai.wc.liuhecai;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{

    private  LinearLayout MainLearnLayout;
    private ArrayList<CheckBox>  AllCheckBox =new ArrayList<>();

    private Button  button_start_close ;
    private Button  button_number_statistics ;
    private EditText text_result ;
    private EditText text_history ;
    private EditText duan_start ;
    private EditText duan_end ;

    private final String TAG ="MainActivity" ;

    private final String[] ALLNUMBER ={ "1","2","3","4","5","6","7","8","9","10"
                                       ,"11","12","13","14","15","16","17","18","19","20"
                                       ,"21","22","23","24","25","26","27","28","29","30"
                                       ,"31","32","33","34","35","36","37","38","39","40"
                                       ,"41","42","43","44","45","46","47","48","49"};

    ArrayList<String> SELECTNUMBER=new ArrayList<>();
    ArrayList<String> RESULTNUMBER=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainLearnLayout = (LinearLayout)findViewById(R.id.main_learn);
        initView();
    }

    private void initView() {
        for(int i=0;i<MainLearnLayout.getChildCount();i++)
        {
            if(MainLearnLayout.getChildAt(i)instanceof LinearLayout){
                for(int j=0;j<MainLearnLayout.getChildCount();j++)
                {
                    if(MainLearnLayout.getChildAt(j)instanceof CheckBox){
                        AllCheckBox.add((CheckBox) MainLearnLayout.getChildAt(j));
                    }
                    if(MainLearnLayout.getChildAt(j)instanceof LinearLayout){
                        for(int t=0;t<((LinearLayout) MainLearnLayout.getChildAt(j)).getChildCount();t++)
                        {
                            if(((LinearLayout) MainLearnLayout.getChildAt(j)).getChildAt(t)instanceof CheckBox){
                                AllCheckBox.add((CheckBox) ((LinearLayout) MainLearnLayout.getChildAt(j)).getChildAt(t));
                            }
                        }
                    }
                }
            }
        }
        button_start_close=(Button)findViewById(R.id.button_start_close);
        button_number_statistics=(Button)findViewById(R.id.button_number_statistics);

        text_result=(EditText)findViewById(R.id.text_result);
        text_history=(EditText)findViewById(R.id.text_history);
        duan_start=(EditText)findViewById(R.id.duan_start);
        duan_end=(EditText)findViewById(R.id.duan_end);

        button_start_close.setOnClickListener(this);
        button_number_statistics.setOnClickListener(this);
        duan_start.addTextChangedListener(new TextWatcher() {
                                              @Override
                                              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                              }

                                              @Override
                                              public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                  if(!s.toString().isEmpty())
                                                  if (Integer.valueOf(s.toString()) < 1 || Integer.valueOf(s.toString()) > 49) {
                                                      duan_start.setText("");
                                                      Toast.makeText(getBaseContext(), "请填写1到49的数值", Toast.LENGTH_SHORT).show();
                                                  }
                                              }

                                              @Override
                                              public void afterTextChanged(Editable s) {


                                              }
                                          }
        );
        duan_end.addTextChangedListener(new TextWatcher() {
                                            @Override
                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                            }

                                            @Override
                                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                if (!s.toString().isEmpty())
                                                    if (Integer.valueOf(s.toString()) < 1 || Integer.valueOf(s.toString()) > 49) {
                                                        duan_end.setText("");
                                                        Toast.makeText(getBaseContext(), "请填写1到49的数值", Toast.LENGTH_SHORT).show();
                                                    }

                                            }

                                            @Override
                                            public void afterTextChanged(Editable s) {


                                            }
                                        }
        );


        for(int i=1;i<50;i++){

            RESULTNUMBER.add(String.valueOf(i));
//            SELECTNUMBER.add(String.valueOf(i));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        initViewDeful();


    }

    private void initViewDeful() {
        for(CheckBox i:AllCheckBox){
            i.setChecked(true);
            Log.d(TAG, "=======" + i.getTag());
//            text_result.setText(i.getTag().toString());
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start_close:
                selectNumber();
                resultCurnt();
                showRelsut();
                Log.d(TAG,"======hello");
            break;
            case R.id.button_number_statistics:
                text_history.setText("button_number_statistics");
                Log.d(TAG,"======");
            break;
        }


    }




    private void selectNumber() {
        // 1选择段
        selectduan();
        // 2提取checkbox

    }

    private void selectduan() {
        String duan_start_number;
        String duan_end_number;
        duan_start_number=duan_start.getText().toString();
        duan_end_number=duan_end.getText().toString();
        if (!duan_start_number.isEmpty()&&!duan_end_number.isEmpty()){
            int start=Integer.valueOf(duan_start_number);
            int end = Integer.valueOf(duan_end_number);
            if(start>end){
                duan_start.setText("");
                duan_end.setText("");
                Toast.makeText(getBaseContext(), "请按顺序输入", Toast.LENGTH_SHORT).show();
                return;
            }
            Log.d("wuchuan1","start===="+start+"end===="+end);
            for (int i= start; end-i>=0;i++){
                Log.d("wuchuan1","start===="+start+"end===="+end+"   i====="+i);
                SELECTNUMBER.add(String.valueOf(i));
            }

        }
    }

    private void showRelsut() {
        String result ="";
        for (String i : RESULTNUMBER){
            result=result +i+"-";
            Log.d(TAG+"wuchuan","============="+result);
        }
        Log.d(TAG+"result","============="+result);
        text_result.setText(result.toString());
    }

    private void resultCurnt() {
         for(String i:ALLNUMBER){
             Log.d(TAG+"resultCurnt","============="+i);
             if(SELECTNUMBER.contains(i)){
                 Log.d(TAG+"select","============="+i);
                 RESULTNUMBER.remove(i);
             }
         }
    }

}