package toDoList;


/**
* toDoList/toDoListOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从toDoList.idl
* 2016年6月18日 星期六 上午11时15分39秒 CST
*/

public interface toDoListOperations 
{
  String register (String name, String password);
  String logIn (String name, String password);
  String addItem (long startTime, long endTime, String label);
  String queryItems (long startTime, long endTime);
  String deleteItem (int index);
  String listAll ();
  String logOut ();
  String clearItems ();
} // interface toDoListOperations
