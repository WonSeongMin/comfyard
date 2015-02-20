package com.chatt.demo;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chatt.demo.custom.CustomActivity;
import com.chatt.demo.utils.Const;
import com.chatt.demo.utils.Utils;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class UserStatus extends CustomActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_status);
	
	
	}
	
	private void initiatePopupWindow(){
		try{
			LayoutInflater inflater = (LayoutInflater) UserStatus.this.
					getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
