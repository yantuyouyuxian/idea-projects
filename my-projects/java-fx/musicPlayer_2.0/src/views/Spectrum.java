/**
 * 
 */
package views;

import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Z H
 *
 */
public class Spectrum {

	/**
	 * @param args
	 */
	
	private HBox hbox;
	
	private double gap=5;
	
	private int number=100;
	
	private ObservableList<SimpleFloatProperty> height;
	
	private double width=10;
	
	
	
	
	public Spectrum() {
		initial();
	}
	
	public void initial(){
		
		
		
		hbox=new HBox(gap);
//		hbox.setPrefHeight(150);
		
		hbox.setScaleY(-1);
		
		height=FXCollections.observableArrayList();
		
		
		for(int i=0;i<number;i++) {
			
			height.add(new SimpleFloatProperty(0));
			
			Rectangle rec=new Rectangle(width,0,Color.DEEPSKYBLUE);
			rec.setOpacity(0.6);
			
			rec.heightProperty().bind(height.get(i));
			
			hbox.getChildren().add(rec);
			
		}
		
	}

	public HBox getHbox() {
		return hbox;
	}

	public ObservableList<SimpleFloatProperty> getHeight() {
		return height;
	}
	
	

}
