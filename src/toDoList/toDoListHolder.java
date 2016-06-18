package toDoList;

/**
* toDoList/toDoListHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从toDoList.idl
* 2016年6月18日 星期六 上午11时15分39秒 CST
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
