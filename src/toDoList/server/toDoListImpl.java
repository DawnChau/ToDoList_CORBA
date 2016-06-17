package toDoList.server;

import toDoList.toDoListPOA;
import toDoList.module.ItemsManager;

public class toDoListImpl extends toDoListPOA{
	private ItemsManager im = new ItemsManager();

	@Override
	public String register(String name, String password) {
		return im.register(name, password);
	}

	@Override
	public String addItem(long startTime, long endTime, String label) {
		return im.addItem(startTime, endTime, label);
	}

	@Override
	public String deleteItem(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String clearItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryItems(long startTime, long endTime) {
		return im.queryItems(startTime, endTime);
	}
	

}
