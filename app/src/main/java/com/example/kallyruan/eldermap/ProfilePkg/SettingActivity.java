package com.example.kallyruan.eldermap.ProfilePkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kallyruan.eldermap.AppMenuActivity;
import com.example.kallyruan.eldermap.R;


public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setting);
    }

    /**
     * this is the method to re-direct to ChangeSizeActivity page
     * @param view
     */
    public void changeSize(View view){
        Intent i = new Intent(getApplicationContext(), ChangeSizeActivity.class);
        startActivityForResult(i,1);
    }

    /**
     * this is the method to re-direct to ChangeSizeActivity page for user textsize preference
     * @param view
     */
    public void changeWalking(View view){
        Intent i = new Intent(getApplicationContext(), ChangeWalkActivity.class);
        startActivityForResult(i,1);
    }

    /**
     * this is the method to re-direct to ChangeDataActivity page for user data collection preference
     * @param view
     */
    public void changeData(View view){
        Intent i = new Intent(getApplicationContext(), ChangeDataActivity.class);
        startActivityForResult(i,1);
    }

    /**
     * this is the method to re-direct to ChangePrivilegeActivity page for user privilege request
     * @param view
     */
    public void changePrivilege(View view){
        Intent i = new Intent(getApplicationContext(), ChangePrivilegeActivity.class);
        startActivityForResult(i,1);
    }

    /**
     * this is the method to re-direct to AppMenuActivity page for App main menu
     * @param view
     */
    public void backToMenu(View view){
        Intent i = new Intent(getApplicationContext(), AppMenuActivity.class);
        startActivityForResult(i,1);
    }
}
