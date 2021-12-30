package fx.com;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {
	
	private SimpleBooleanProperty boo=new SimpleBooleanProperty();
	private SimpleStringProperty data_value=new SimpleStringProperty();
	
	public Data(boolean boo,String data_value) {
		this.boo.set(boo);
		this.data_value.set(data_value);
	}

	public boolean getBoo() {
		return this.boo.get();
	}

	public void setBoo(boolean boo) {
		this.boo.set(boo);;
	}

	public String getData_value() {
		return this.data_value.get();
	}

	public void setData_value(String data_value) {
		this.data_value.set(data_value);;
	}
	
	public SimpleBooleanProperty getBooProperty(){
		return this.boo;
	}

	
	
}
