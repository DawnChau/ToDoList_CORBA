package toDoList;

/**
* toDoList/toDoListHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��toDoList.idl
* 2016��6��18�� ������ ����11ʱ15��39�� CST
*/

public final class toDoListHolder implements org.omg.CORBA.portable.Streamable
{
  public toDoList value = null;

  public toDoListHolder ()
  {
  }

  public toDoListHolder (toDoList initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = toDoListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    toDoListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return toDoListHelper.type ();
  }

}
