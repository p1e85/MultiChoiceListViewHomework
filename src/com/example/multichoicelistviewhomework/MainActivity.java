package com.example.multichoicelistviewhomework;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ArrayList<String> arrayList = new ArrayList<String>();
		final ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_list_item_multiple_choice, arrayList);
		final ListView list = (ListView) findViewById(R.id.list);
		Button addBtn = (Button) findViewById(R.id.btnAdd);
		Button deleteBtn = (Button) findViewById(R.id.btnDelete);
		CheckBox cBox = (CheckBox) findViewById(android.R.id.text1);

		list.setAdapter(adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Random rand = new Random();
				
				Integer randomInt = rand.nextInt();
				arrayList.add(randomInt.toString());
				adapter.notifyDataSetChanged();

			}
		});

		deleteBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				   SparseBooleanArray checkedItemPositions = list.getCheckedItemPositions();
		             int itemCount = list.getCount();

		             for(int i=itemCount-1; i >= 0; i--){
		                 if(checkedItemPositions.get(i)){
		                     adapter.remove(arrayList.get(i));
		                 }
		             }
		             checkedItemPositions.clear();
		             adapter.notifyDataSetChanged();
				
				}
		});
		
		

		/*
		 * list.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { SparseBooleanArray sparseArray =
		 * list.getCheckedItemPositions();
		 * 
		 * for (int i = 0; i < sparseArray.size(); i++) { //Log.i("", "i:  " +
		 * i); if (sparseArray.valueAt(i))
		 * //arrayList.remove(adapter.getItem(arrayList.size() -1)); Log.i("",
		 * "Checked at position " + sparseArray.keyAt(i)); }
		 * 
		 * } });
		 */

	}
	
	
}