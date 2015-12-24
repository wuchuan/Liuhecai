package com.liuhecai.wc.liuhecai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private  LinearLayout MainLearnLayout;
    private ArrayList<CheckBox>  AllCheckBox =new ArrayList<>();
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
    }


    @Override
    protected void onResume() {
        super.onResume();
        initViewDeful();
    }

    private void initViewDeful() {
        for(CheckBox i:AllCheckBox){
            i.setChecked(true);
        }

    }


}