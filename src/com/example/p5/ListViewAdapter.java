package com.example.p5;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<Item> {
	private Activity contexto;
	private ArrayList<Item> lista;
	
	public ListViewAdapter(Activity context, ArrayList<Item> lista) {
		super(context, R.layout.item, lista);
		this.contexto = context;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		return (lista != null)? lista.size(): 0;
	}

	@Override
	public Item getItem(int position) {
		return (Item) ((lista != null)?lista.get(position): 0);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		//Rescatamos layout
		View view = contexto.getLayoutInflater().inflate(R.layout.item, null);
		Item i = lista.get(position);
		
		//Definimos elementos de nuestra fila
		ImageView image = (ImageView) view.findViewById(R.id.imageView);
		TextView titulo = (TextView) view.findViewById(R.id.txtTitulo);
		TextView descripcion = (TextView) view.findViewById(R.id.txtDescripcion);
		CheckBox check = (CheckBox) view.findViewById(R.id.checkBox1);
		check.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton check, boolean isChecked) {
				lista.get(position).setChecked(isChecked);
			}
		});
		
		//Inicializamos cada elemento 
		image.setImageDrawable(contexto.getResources().getDrawable(i.getIdImage()));
		titulo.setText(i.getTitulo());
		descripcion.setText(i.getDescripcion());
		check.setChecked(i.isCheck());
		
		return view;
	}

}
