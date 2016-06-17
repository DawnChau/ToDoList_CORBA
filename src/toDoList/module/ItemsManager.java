package toDoList.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import toDoList.toDoList;

public class ItemsManager {
	Map<String,ToDoList> map = new HashMap<String,ToDoList>();
	String name;
	
	public String register(String name,String password){
		String str = null;
		if(map.keySet().contains(name)){
			str = "the username has been used";
		}
		else{
			ToDoList toDoList = new ToDoList();
			map.put(name, toDoList);
			str = "Register successful";
			this.name = name;
		}
		return str;
	}
	
	public String addItem(long startTime,long endTime,String label){
		Item i = new Item();
		i.setStartTime(startTime);
		i.setEndTime(endTime);
		i.setLabel(label);
		boolean isSuccessful = false;
		try {
			isSuccessful = map.get(name).add(i);
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + "ÇëÏÈµÇÂ½£¡£¡£¡");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return "Add items successful";
		else
			return "Add items failed";
		
	}
	
	public String queryItems(long startTime, long endTime) {
		boolean isSuccessful = false;
		StringBuilder sb = null;
		try {
			ToDoList list = map.get(name);
			ArrayList<Item> itemList = list.query(startTime, endTime);
			sb = new StringBuilder();
			for(Item i:itemList){
				sb.append(i.toString() + "\n");
			}
			if(sb!=null)
				isSuccessful = true;
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + "ÇëÏÈµÇÂ½£¡£¡£¡");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return sb.toString();
		else
			return "query items failed";
	}
}
