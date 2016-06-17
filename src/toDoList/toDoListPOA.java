package toDoList;


/**
* toDoList/toDoListPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从toDoList.idl
* 2016年6月17日 星期五 上午09时24分08秒 CST
*/

public abstract class toDoListPOA extends org.omg.PortableServer.Servant
 implements toDoListOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new java.lang.Integer (0));
    _methods.put ("addItem", new java.lang.Integer (1));
    _methods.put ("queryItems", new java.lang.Integer (2));
    _methods.put ("deleteItem", new java.lang.Integer (3));
    _methods.put ("clearItems", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // toDoList/toDoList/register
       {
         String name = in.read_string ();
         String password = in.read_string ();
         String $result = null;
         $result = this.register (name, password);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // toDoList/toDoList/addItem
       {
         long startTime = in.read_longlong() ;
         long endTime = in.read_longlong();
         String label = in.read_string ();
         String $result = null;
         $result = this.addItem (startTime, endTime, label);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // toDoList/toDoList/queryItems
       {
         long startTime = in.read_longlong();
         long endTime = in.read_longlong();
         String $result = null;
         $result = this.queryItems (startTime, endTime);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // toDoList/toDoList/deleteItem
       {
         int index = in.read_long ();
         String $result = null;
         $result = this.deleteItem (index);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // toDoList/toDoList/clearItems
       {
         String $result = null;
         $result = this.clearItems ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:toDoList/toDoList:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public toDoList _this() 
  {
    return toDoListHelper.narrow(
    super._this_object());
  }

  public toDoList _this(org.omg.CORBA.ORB orb) 
  {
    return toDoListHelper.narrow(
    super._this_object(orb));
  }


} // class toDoListPOA
