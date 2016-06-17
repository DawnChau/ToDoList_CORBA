package toDoList;


/**
* toDoList/toDoListHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从toDoList.idl
* 2016年6月17日 星期五 上午09时24分08秒 CST
*/

abstract public class toDoListHelper
{
  private static String  _id = "IDL:toDoList/toDoList:1.0";

  public static void insert (org.omg.CORBA.Any a, toDoList that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static toDoList extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (toDoListHelper.id (), "toDoList");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static toDoList read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_toDoListStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, toDoList value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static toDoList narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof toDoList)
      return (toDoList)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _toDoListStub stub = new _toDoListStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static toDoList unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof toDoList)
      return (toDoList)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _toDoListStub stub = new _toDoListStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
