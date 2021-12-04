package fx.com;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class DanMuService extends ScheduledService<ObservableList<DMData>>{
	private ConnectionDM cdm;
	public DanMuService(ConnectionDM cdm) {
		this.cdm=cdm;
	}
	@Override
	protected Task<ObservableList<DMData>> createTask() {
		// TODO Auto-generated method stub
		
		Task<ObservableList<DMData>> task=new Task <ObservableList<DMData>>() {

			@Override
			protected ObservableList<DMData> call() throws Exception {
				// TODO Auto-generated method stub
				cdm.connection();
				
				String data=cdm.getDMData();
				
				ObservableList<DMData> list=ConnectionDM.findData(data);
				
				return list;
			}
		};
		return task;
	}
}
