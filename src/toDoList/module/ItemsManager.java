package toDoList.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import toDoList.toDoList;

public class ItemsManager {
	//�����û���To-Dolist�б���Ϣ
	Map<String,ToDoList> map = new HashMap<String,ToDoList>();
	//�����û����˺�������Ϣ
	Map<String,String> userInfo = new HashMap<String,String>();
	//�����û��Ƿ��¼����Ϣ
	Map<String,Boolean> isLogedIn = new HashMap<String,Boolean>();
	//String name;
	ThreadLocal<String> userName = new ThreadLocal<String>();
	/**
	 * ע��
	 * @param name �û���
	 * @param password ����
	 * @return ������ʾ��Ϣ
	 */
	public String register(String name,String password){
		String str = null;
		//����û����Ѿ����ڣ���˵���Ѿ���ע��
		if(map.keySet().contains(name)){
			str = "The username has been used, please log in.";
		}
		else{
			ToDoList toDoList = new ToDoList();
			map.put(name, toDoList);
			userInfo.put(name, password);
			isLogedIn.put(name, false);
			str = "Register successful, please login";
			//this.name = name;
		}
		return str;
	}
	/**
	 * ��¼
	 * @param name �û���
	 * @param password ����
	 * @return ������ʾ��Ϣ
	 */
	public String logIn(String name,String password){
		if(!map.keySet().contains(name))
			return "Username doesn't exist";
		//�û��Ѿ���¼��
		if(isLogedIn.get(name))
			return "User is logged in";
		if(!userInfo.get(name).equals(password))
			return "Password is incorrect";
		userName.set(name);
		isLogedIn.put(name, true);
		return "Log in successful";
	}
	
	public String addItem(long startTime,long endTime,String label){
		Item i = new Item();
		i.setStartTime(startTime);
		i.setEndTime(endTime);
		i.setLabel(label);
		String name = userName.get();
		boolean isSuccessful = false;
		try {
			if(isLogedIn.get(name))
				isSuccessful = map.get(name).add(i);
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
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
		String name = userName.get();
		try {
			if(isLogedIn.get(name)){
				ToDoList list = map.get(name);
				ArrayList<Item> itemList = list.query(startTime, endTime);
				sb = new StringBuilder();
				for(Item i:itemList){
					sb.append(i.toString() + "\n");
				}
				if(sb!=null)
					isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return sb.toString();
		else
			return "query items failed";
	}
	
	public String listAll(){
		boolean isSuccessful = false;
		StringBuilder sb = null;
		String name = userName.get();
		try {
			if(isLogedIn.get(name)){
				ArrayList<Item> list = map.get(name).listAll();
				sb = new StringBuilder();
				for(int i = 0;i<list.size();i++){
					sb.append("Index " + i + "--->" + list.get(i).toString() + "\n");
				}
				if(sb!=null)
					isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return sb.toString();
		else
			return "List items failed";
	}
	
	public String deleteItem(int index){
		boolean isSuccessful = false;
		String name = userName.get();
		try {
			if(isLogedIn.get(name)){
				ToDoList list = map.get(name);
				if(list.delete(index))
					isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return "Delete item successful";
		else
			return "Delete item failed";
	}
	
	public String clearAll(){
		boolean isSuccessful = false;
		String name = userName.get();
		try {
			if(isLogedIn.get(name)){
				ToDoList list = map.get(name);
				if(list.clearAll())
					isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return "Clear all items successful";
		else
			return "Clear all items failed";
	}
	public String logOut() {
		boolean isSuccessful = false;
		String name = userName.get();
		try {
			//����Ѿ���¼
			if(isLogedIn.get(name)){
				//��Ϊ�˳���¼
				isLogedIn.put(name, false);
				//ȡ���û����͵�ǰ�̵߳İ�
				userName.remove();
				isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " ���ȵ�½������");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return "Log out successful";
		else
			return "Log out failed";
	}
}
