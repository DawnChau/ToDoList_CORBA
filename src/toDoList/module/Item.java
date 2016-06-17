package toDoList.module;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Item {
	private int id;
	private String name;
	private long startTime;
	private long endTime;
	private String label;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		//毫秒变成日期
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		startCalendar.setTimeInMillis(startTime);
		endCalendar.setTimeInMillis(endTime);
		
		String str = "Label:" + label + ". StartTime:" + formatter.format(startCalendar.getTime())
		 				+ ". EndTime:" + formatter.format(endCalendar.getTime());
		return str;
	}
}
