package com.chatt.demo;

import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Status extends Activity{
	public Button btnStatus;
	public Button btnFriendList;
	public Button btnSetting;
	public Button btnPeopleList;
	public static ParseUser user;
	public static String selectLearn;
	public static String selectTeach;
	public static String selectSex;


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);


		btnStatus = (Button) findViewById(R.id.statusBtn);
		btnFriendList = (Button) findViewById(R.id.friendBtn);
		btnSetting = (Button) findViewById(R.id.settingBtn);
		btnPeopleList = (Button) findViewById(R.id.peopleBtn);

		Spinner LearnSpinner = (Spinner) findViewById(R.id.LearnSpinner);
		Spinner TeachSpinner = (Spinner) findViewById(R.id.TeachSpinner);
		Spinner SexSpinner = (Spinner) findViewById(R.id.SexSpinner);


		//Learn
		ArrayAdapter LearnAdapter = ArrayAdapter.createFromResource(
				this, R.array.category, android.R.layout.simple_spinner_item);
		LearnAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		LearnSpinner.setAdapter(LearnAdapter);
		LearnSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,View view,int position
					,long id){
				selectLearn = parent.getItemAtPosition(position).toString();
				updateLearn(selectLearn);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});


		//Teach
		ArrayAdapter TeachAdapter = ArrayAdapter.createFromResource(
				this, R.array.category, android.R.layout.simple_spinner_item);
		TeachAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		TeachSpinner.setAdapter(TeachAdapter);
		TeachSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,View view,int position
					,long id){
				selectTeach = parent.getItemAtPosition(position).toString();
				updateTeach(selectTeach);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});


		//Sex
		ArrayAdapter SexAdapter = ArrayAdapter.createFromResource(
				this, R.array.sex, android.R.layout.simple_spinner_item);
		SexAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		SexSpinner.setAdapter(SexAdapter);
		SexSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,View view,int position
					,long id){
				selectSex = parent.getItemAtPosition(position).toString();
				updateSex(selectSex);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});


		btnStatus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Status.this, Status.class);
				startActivity(intent);
			}
		});

		btnFriendList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Status.this, FriendList.class);
				startActivity(intent);
			}
		});

		btnSetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Status.this, Setting.class);
				startActivity(intent);
			}
		});

		btnPeopleList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){
				Intent intent = new Intent(Status.this, UserList.class);
				startActivity(intent);
			}
		});
	}

	private void updateSex(String sex){
		user.put("sex", sex);
		user.saveEventually();
	}
	private void updateLearn(String learn){
		user.put("learn", learn);
		user.saveEventually();
	}
	private void updateTeach(String teach){
		user.put("teach", teach);
		user.saveEventually();
	}
}
