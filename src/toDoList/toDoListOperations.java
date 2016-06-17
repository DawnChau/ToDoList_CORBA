package toDoList;


/**
* toDoList/toDoListOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��toDoList.idl
* 2016��6��16�� ������ ����09ʱ10��02�� CST
*/

public interface toDoListOperations 
{
  String register (String name, String password);
  String addItem (long startTime, long endTime, String label);
  String queryItems (long startTime, long endTime);
  String deleteItem (int index);
  String clearItems ();
} // interface toDoListOperations
