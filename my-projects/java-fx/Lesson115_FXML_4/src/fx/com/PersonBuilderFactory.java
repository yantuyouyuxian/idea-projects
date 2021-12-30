package fx.com;

import application.Person;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class PersonBuilderFactory implements BuilderFactory{

	private final JavaFXBuilderFactory jff=new JavaFXBuilderFactory();
	
	@Override
	public Builder<?> getBuilder(Class<?> type) {
		// TODO Auto-generated method stub
		if(type == Person.class) {
			return new PersonBuilder();
		}else {
			return jff.getBuilder(type);
		}
	}

}
