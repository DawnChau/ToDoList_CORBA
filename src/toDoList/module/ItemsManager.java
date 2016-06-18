package toDoList.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import toDoList.toDoList;

public class ItemsManager {
	//保存用户的To-Dolist列表信息
	Map<String,ToDoList> map = new HashMap<String,ToDoList>();
	//保存用户的账号密码信息
	Map<String,String> userInfo = new HashMap<String,String>();
	//保存用户是否登录的信息
	Map<String,Boolean> isLogedIn = new HashMap<String,Boolean>();
	//String name;
	ThreadLocal<String> userName = new ThreadLocal<String>();
	/**
	 * 注册
	 * @param name 用户名
	 * @param password 密码
	 * @return 返回提示信息
	 */
	public String register(String name,String password){
		String str = null;
		//如果用户名已经存在，则说明已经被注册
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
	 * 登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 返回提示信息
	 */
	public String logIn(String name,String password){
		if(!map.keySet().contains(name))
			return "Username doesn't exist";
		//用户已经登录了
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
			System.out.println(e.toString() + " 请先登陆！！！");
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
			System.out.println(e.toString() + " 请先登陆！！！");
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
			System.out.println(e.toString() + " 请先登陆！！！");
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
			System.out.println(e.toString() + " 请先登陆！！！");
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
			System.out.println(e.toString() + " 请先登陆！！！");
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
			//如果已经登录
			if(isLogedIn.get(name)){
				//变为退出登录
				isLogedIn.put(name, false);
				//取消用户名和当前线程的绑定
				userName.remove();
				isSuccessful = true;
			}
			else
				return "Please log in first";
		} catch (NullPointerException e) {
			System.out.println("---------------------------");
			System.out.println(e.toString() + " 请先登陆！！！");
			System.out.println("---------------------------");
			e.printStackTrace();
		}
		if(isSuccessful)
			return "Log out successful";
		else
			return "Log out failed";
	}
}
