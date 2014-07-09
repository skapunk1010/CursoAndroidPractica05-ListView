package com.example.p5;

public class Item {
	private int idImagen;
	private String titulo;
	private String descripcion;
	private boolean check;
	
	public Item(String titulo, String d, int idImagen, boolean check){
		this.titulo = titulo;
		this.descripcion = d;
		this.idImagen = idImagen;
		this.check = check;
	}
	
	public int getIdImage(){
		return this.idImagen;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public boolean isCheck(){
		return check;
	}
	
}
