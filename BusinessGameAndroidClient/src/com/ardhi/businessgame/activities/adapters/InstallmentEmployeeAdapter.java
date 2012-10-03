package com.ardhi.businessgame.activities.adapters;

import java.util.ArrayList;

import com.ardhi.businessgame.R;
import com.ardhi.businessgame.activities.SectorDetailTabActivity;
import com.ardhi.businessgame.models.InstallmentEmployee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class InstallmentEmployeeAdapter extends BaseAdapter{

	private SectorDetailTabActivity act;
	private ArrayList<InstallmentEmployee> employees;
	private static LayoutInflater inflater = null;
	
	public InstallmentEmployeeAdapter(SectorDetailTabActivity a, ArrayList<InstallmentEmployee> e) {
		act = a;
		employees = e;
		inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount() {
		return employees.size();
	}

	public Object getItem(int pos) {
		return pos;
	}

	public long getItemId(int pos) {
		return pos;
	}

	public View getView(int pos, View newView, ViewGroup parent) {
		View v = newView;
		if(newView == null){
			v = inflater.inflate(R.layout.listrow_installment_employee, null);
		}
		TextView txtEmployee = (TextView)v.findViewById(R.id.txt_employee),
				txtOperational = (TextView)v.findViewById(R.id.txt_operational);
		RatingBar rateQuality = (RatingBar)v.findViewById(R.id.rate_quality);
		Button btnFire = (Button)v.findViewById(R.id.btn_fire);
		
		InstallmentEmployee employee = employees.get(pos);
		
		txtEmployee.setText(employee.getEmployee());
		txtOperational.setText("Operational cost : "+employee.getOperational()+" ZE");
		rateQuality.setRating(employee.getQuality());
		btnFire.setOnClickListener(new OnClickHandler(employee.getId(),employee.getEmployee()));
		return v;
	}
	
	private class OnClickHandler implements View.OnClickListener{
		private String id,em;
		
		public OnClickHandler(String i,String e){
			id = i;
			em = e;
		}
		
		@Override
		public void onClick(View v) {
			act.dialog(2, id, em).show();
		}
	}
}