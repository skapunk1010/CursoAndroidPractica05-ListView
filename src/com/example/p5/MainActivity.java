package com.example.p5;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView listView;
	private ListViewAdapter adapter;
	private ArrayList<Item> lista;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Declarar sus datos
		lista = new ArrayList<Item>();
		lista.add(new Item("Austria","Está en Europa",R.drawable.austria,true));
		lista.add(new Item("Bolivia","Está en sudamérica",R.drawable.bolivia,false));
		lista.add(new Item("Bulgaria","Está en Europa",R.drawable.bulgaria,true));
		lista.add(new Item("Camerun","Esta en áfrica",R.drawable.cameroon,false));
		lista.add(new Item("Costa rica", "Está en el caribe",R.drawable.costa_rica,true));
		lista.add(new Item("Guatemala", "Está en centroamérica",R.drawable.guatemala,false));
		lista.add(new Item("Iran", "Está en asia",R.drawable.iran,true));
		lista.add(new Item("Israel","Está en medio oriente",R.drawable.israel,false));
		lista.add(new Item("Jamaica","Es una isla", R.drawable.jamaica,true));
		lista.add(new Item("Japon","Es una isla y está en asia", R.drawable.japan,false));
		
		//Declarar el adapter
		//adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,R.id.txtTitulo,valores);
		adapter = new ListViewAdapter(this,lista);
		
		//Asignar adapter a listView
		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicion,long id) {
				Toast.makeText(getApplicationContext(), "Posicion:"+posicion, Toast.LENGTH_SHORT).show();    
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
