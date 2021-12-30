package fx.coms;

import application.Person;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class PersonBuilderMapFactory implements BuilderFactory{

	private final JavaFXBuilderFactory jff=new JavaFXBuilderFactory();
	
	@Override
	public Builder<?> getBuilder(Class<?> type) {
		// TODO Auto-generated method stub
		if(type == Person.class) {
			return new PersonBuilderMap();
		}else {
			return jff.getBuilder(type);
		}
	}

}
