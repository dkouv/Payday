package model;

import javax.swing.JFrame;

import controller.Controller;

public abstract class Position<T> extends JFrame{

	public enum Day { 
		SUNDAY,	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY    
	}
	
	String icon;
	Day day;
	int id; //it is a number between  1-31 represent day of month
	
	
	public Position(String icon) {
		this.icon = icon;
		this.day = Day.SUNDAY;
		this.id = 1;
	}
	
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcon() {
		return this.icon;
	}

	
	public void performAction(Controller c) {
		
	}

}
