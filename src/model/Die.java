package model;

import java.util.Random;



public class Die {
	int zaria=0;
	
	public void roll(){
		int value = 0;
		Random rn=new Random();
		value = rn.nextInt(6)+1; 
	    this.zaria = value;
	}
	
	public int getZaria() {
		return this.zaria;
	}

}