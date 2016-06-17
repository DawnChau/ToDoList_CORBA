package toDoList;


/**
* toDoList/toDoListOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从toDoList.idl
* 2016年6月16日 星期四 下午09时10分02秒 CST
*/

public interface toDoListOperations 
{
  String register (String name, String password);
  String addItem (long startTime, long endTime, String label);
  String queryItems (long startTime, long endTime);
  String deleteItem (int index);
  String clearItems ();
} // interface toDoListOperations
