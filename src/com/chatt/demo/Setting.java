package com.chatt.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Setting extends Activity{
	public Button btnStatus;
	public Button btnFriendList;
	public Button btnSetting;
	public Button btnPeopleList;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);

		btnStatus = (Button) findViewById(R.id.statusBtn);
		btnFriendList = (Button) findViewById(R.id.friendBtn);
		btnSetting = (Button) findViewById(R.id.settingBtn);
		btnPeopleList = (Button) findViewById(R.id.peopleBtn);

		btnStatus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Setting.this, MyStatus.class);
				startActivity(intent);
			}
		});

		btnFriendList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Setting.this, FriendList.class);
				startActivity(intent);
			}
		});

		btnSetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Setting.this, Setting.class);
				startActivity(intent);
			}
		});

		btnPeopleList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Setting.this, UserList.class);
				startActivity(intent);
			}
		});
	}
}


