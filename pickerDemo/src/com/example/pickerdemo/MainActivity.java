package com.example.pickerdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bigkoo.pickerview.TimePickerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv_time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_time = (TextView) findViewById(R.id.tv_time);
		tv_time.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showTime(tv_time, MainActivity.this);
			}
		});
	}
	
	/**
	 * 日历选择
	 * 
	 * @param tet
	 * @param time
	 * @param context
	 */
	@SuppressLint("SimpleDateFormat")
	public static void showTime(final TextView tet, Context context) {
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TimePickerView timePickerView = new TimePickerView(context, TimePickerView.Type.YEAR_MONTH_DAY);
		timePickerView.setTime(new Date());
		timePickerView.setCancelable(true);
		timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
			@Override
			public void onTimeSelect(Date date) {
				String str = formatter.format(date);
				// L.e("选择的时间" + str);
				if (tet != null) {
					tet.setText(str);
					tet.setTextSize(14);
				}

			}
		});
		timePickerView.show();
	}
}
