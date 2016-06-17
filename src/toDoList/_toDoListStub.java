package toDoList;


/**
* toDoList/_toDoListStub.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��toDoList.idl
* 2016��6��17�� ������ ����09ʱ24��08�� CST
*/

public class _toDoListStub extends org.omg.CORBA.portable.ObjectImpl implements toDoList
{

  public String register (String name, String password)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("register", true);
                $out.write_string (name);
                $out.write_string (password);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return register (name, password        );
            } finally {
                _releaseReply ($in);
            }
  } // register


  public String deleteItem (int index)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deleteItem", true);
                $out.write_long (index);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return deleteItem (index        );
            } finally {
                _releaseReply ($in);
            }
  } // deleteItem

  public String clearItems ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("clearItems", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return clearItems (        );
            } finally {
                _releaseReply ($in);
            }
  } // clearItems

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:toDoList/toDoList:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }

@Override
public String addItem(long startTime, long endTime, String label) {
	org.omg.CORBA.portable.InputStream $in = null;
    try {
        org.omg.CORBA.portable.OutputStream $out = _request ("addItem", true);
        $out.write_longlong(startTime);
        $out.write_longlong (endTime);
        $out.write_string (label);
        $in = _invoke ($out);
        String $result = $in.read_string ();
        return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
        $in = $ex.getInputStream ();
        String _id = $ex.getId ();
        throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
        return addItem (startTime, endTime, label        );
    } finally {
        _releaseReply ($in);
    }
}

@Override
public String queryItems(long startTime, long endTime) {
	org.omg.CORBA.portable.InputStream $in = null;
    try {
        org.omg.CORBA.portable.OutputStream $out = _request ("queryItems", true);
        $out.write_longlong (startTime);
        $out.write_longlong (endTime);
        $in = _invoke ($out);
        String $result = $in.read_string ();
        return $result;
    } catch (org.omg.CORBA.portable.ApplicationException $ex) {
        $in = $ex.getInputStream ();
        String _id = $ex.getId ();
        throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException $rm) {
        return queryItems (startTime, endTime        );
    } finally {
        _releaseReply ($in);
    }
}
} // class _toDoListStub
