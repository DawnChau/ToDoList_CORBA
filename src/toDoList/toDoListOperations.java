package toDoList;


/**
* toDoList/toDoListOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��toDoList.idl
* 2016��6��18�� ������ ����11ʱ15��39�� CST
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
