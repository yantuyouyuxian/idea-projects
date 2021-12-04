package fx.com;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data2 {

	private SimpleStringProperty name=new SimpleStringProperty();
	private SimpleIntegerProperty age=new SimpleIntegerProperty();
	private SimpleDoubleProperty score=new SimpleDoubleProperty();
	private SimpleBooleanProperty is=new SimpleBooleanProperty();
	
	public Data2(String name,int age,double score,boolean is) {
		this.name.set(name);
		this.age.set(age);
		this.score.set(score);
		this.is.set(is);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);;
	}

	public double getScore() {
		return score.get();
	}

	public void setScore(double score) {
		this.score.set(score);;
	}

	public boolean getIs() {
		return is.get();
	}

	public void setIs(boolean is) {
		this.is.set(is);;
	}

	
	
	public SimpleStringProperty getNameProperty() {
		return name;
	}

	public SimpleIntegerProperty getAgeProperty() {
		return age;
	}

	public SimpleDoubleProperty getScoreProperty() {
		return score;
	}

	public SimpleBooleanProperty getIsProperty() {
		return is;
	}

	
	
	
	
}
