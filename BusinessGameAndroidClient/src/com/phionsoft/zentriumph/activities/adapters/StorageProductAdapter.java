package com.phionsoft.zentriumph.activities.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.phionsoft.zentriumph.R;
import com.phionsoft.zentriumph.activities.StorageTabActivity;
import com.phionsoft.zentriumph.models.StorageProduct;

public class StorageProductAdapter extends BaseAdapter{

	private StorageTabActivity act;
	private ArrayList<StorageProduct> products;
	private static LayoutInflater inflater = null;
	
	public StorageProductAdapter(StorageTabActivity a, ArrayList<StorageProduct> p) {
		act = a;
		products = p;
		inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount() {
		return products.size();
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
			v = inflater.inflate(R.layout.listrow_storage_product, null);
		}
		ImageView img = (ImageView)v.findViewById(R.id.img);
		TextView txtProduct = (TextView)v.findViewById(R.id.txt_product),
				txtSize = (TextView)v.findViewById(R.id.txt_size);
		RatingBar rateQuality = (RatingBar)v.findViewById(R.id.rate_quality);
		Button btnSell = (Button)v.findViewById(R.id.btn_sell);
		
		StorageProduct product = products.get(pos);
		
		img.setImageResource(product.getDraw());
		txtProduct.setText(product.getProduct());
		txtSize.setText("Size : "+(product.getSize()));
		rateQuality.setRating(product.getQuality());
		btnSell.setOnClickListener(new OnClickHandler(product.getId(), product.getSize()));
		return v;
	}
	
	private class OnClickHandler implements View.OnClickListener{
		private String id;
		private double size;
		
		public OnClickHandler(String i, double s){
			id = i;
			size = s;
		}
		
		@Override
		public void onClick(View v) {
			act.showSellDialog(2, id, size);
		}
	}
}
