package com.ali.jadom.dom;

import java.io.Serializable;

public class Coord implements Serializable{
 
	private static final long serialVersionUID = 8155790927198378390L;
	protected Integer[] points = {0};
	
	public Coord(){		
	}
	
	
	public Coord(Integer[] points){
		this.points =points;
	}


	public final Integer[] getPoints() {
		return points;
	}


	public final void setPoints(Integer[] points) {
		this.points = points;
	}
	
	public void addPoint(Integer point){
		Integer[] temp = new Integer[points.length+1];
		System.arraycopy(points, 0, temp, 0, points.length);
		temp[temp.length-1] = point;
		System.arraycopy(temp, 0, points, 0, temp.length);
	}
	
	@Override
	public String toString(){
		String str ="";
		for(int i=0; i< this.points.length; i++){
			str+=points[i].toString();
			if (i<points.length-1){
				str+=",";
			}
		}
		return str;
		
	}
	
	public  static  String coordsArrayToString(Coord[] coords){
		if(coords ==null) return null;
		String coordsString ="";
		for(int i =0 ; i < coords.length; i++){
			coordsString+= coords[i].toString();
			if(i<coords.length-1){
				coordsString+=", ";
			}
		}
		return coordsString;
	}
	
}
