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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MyStatus extends Activity{
	public static ParseUser user;
	public static String selectLearn;
	public static String selectTeach;
	public static String selectSex;
	public static String selectCountry;
	public Button btnSave;
	public EditText hobbyText;
	public EditText introduceText;
	public CheckBox chkEmail;
	public CheckBox chkText;
	public CheckBox chkVoice;
	public CheckBox chkInperson;
	public boolean booEmail;
	public boolean booText;
	public boolean booVoice;
	public boolean booInperson;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);


		Button btnStatus = (Button) findViewById(R.id.statusBtn);
		Button btnFriendList = (Button) findViewById(R.id.friendBtn);
		Button btnSetting = (Button) findViewById(R.id.settingBtn);
		Button btnPeopleList = (Button) findViewById(R.id.peopleBtn);
		btnSave = (Button) findViewById(R.id.saveBtn);

		Spinner LearnSpinner = (Spinner) findViewById(R.id.LearnSpinner);
		Spinner TeachSpinner = (Spinner) findViewById(R.id.TeachSpinner);
		Spinner SexSpinner = (Spinner) findViewById(R.id.SexSpinner);
		Spinner CountrySpinner = (Spinner) findViewById(R.id.CountrySopinner);

		hobbyText = (EditText)this.findViewById(R.id.hobbyText);
		introduceText = (EditText)this.findViewById(R.id.IntroduceText);

		chkEmail =(CheckBox) findViewById(R.id.chkText);
		chkText =(CheckBox) findViewById(R.id.chkText);
		chkVoice =(CheckBox) findViewById(R.id.chkVoice);
		chkInperson =(CheckBox) findViewById(R.id.chkInperson);

		chkEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				booEmail = isChecked;
			}
		});
		
		chkText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				booText = isChecked;
			}
		});
		chkVoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				booVoice = isChecked;
			}
		});
		chkInperson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				booInperson = isChecked;
			}
		});
		
		
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
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});


		//Sex, Gender
		ArrayAdapter SexAdapter = ArrayAdapter.createFromResource(
				this, R.array.sex, android.R.layout.simple_spinner_item);
		SexAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		SexSpinner.setAdapter(SexAdapter);
		SexSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,View view,int position
					,long id){
				selectSex = parent.getItemAtPosition(position).toString();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});


		ArrayAdapter CountryAdapter = ArrayAdapter.createFromResource(
				this, R.array.country, android.R.layout.simple_spinner_item);
		CountryAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		CountrySpinner.setAdapter(CountryAdapter);
		CountrySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,View view,int position
					,long id){
				selectCountry = parent.getItemAtPosition(position).toString();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0){
			}
		});



		btnStatus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MyStatus.this, MyStatus.class);
				startActivity(intent);
			}
		});

		btnFriendList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MyStatus.this, FriendList.class);
				startActivity(intent);
			}
		});

		btnSetting.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MyStatus.this, Setting.class);
				startActivity(intent);
			}
		});

		btnPeopleList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MyStatus.this, UserList.class);
				startActivity(intent);
			}
		});

		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				updateAll(selectSex, selectLearn, selectTeach, selectCountry, 
						hobbyText.getText().toString(),introduceText.getText().toString(),
						booEmail, booText, booVoice, booInperson);
				Toast.makeText(MyStatus.this, "Save", Toast.LENGTH_LONG).show();
			}
		});
	}



	private void updateAll(String sex, String learn, String teach, String country, 
			String hobby, String introduce, boolean email, boolean text, boolean voice, boolean inperson){
		user.put("sex", sex);
		user.put("learn", learn);
		user.put("teach", teach);
		user.put("country", country);
		user.put("hobby", hobby);
		user.put("introduce", introduce);
		user.put("eemail", email);
		user.put("textchat", text);
		user.put("voicechat",voice);
		user.put("inperson", inperson);
		user.saveEventually();
	}
}
