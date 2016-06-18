package toDoList.module;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	private ArrayList<Item> toDoList  = new ArrayList<Item>();
	
	public boolean add(Item i){
		if(toDoList.add(i))
			return true;
		return false;
	}
	
	public boolean delete(int index){
		Item i = toDoList.get(index);
		if(toDoList.remove(i))
			return true;
		return false;
	}
	
	public ArrayList<Item> query(long startTime,long endTime){
		ArrayList<Item> list = new ArrayList<Item>();
		for(Item i:toDoList){
			//在指定的开始时间之后,在制定的结束时间之前
			if(i.getStartTime()>=startTime && i.getEndTime()<= endTime)
				list.add(i);
		}
		return list;
	}
	
	public ArrayList<Item> listAll(){
		return toDoList;
	}
	
	public boolean clearAll(){
		toDoList.clear();
		if(toDoList.isEmpty())
			return true;
		else
			return false;
	}
}
