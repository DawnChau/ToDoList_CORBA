package toDoList.client;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import toDoList.toDoList;
import toDoList.toDoListHelper;
import toDoList.server.toDoListImpl;

public class toDoListClient {
	private static final int REGISTER = 1;
	private static final int LOGIN = 2;
	private static final int ADDITEM = 3;
	private static final int QUERY = 4;
	private static final int LISTALL = 5;
	private static final int DELETE = 6;
	private static final int CLEARALL = 7;
	private static final int LOGOUT = 8;
	
	
	
	
	static toDoList todoListImpl;

	static {
		System.out.println("�ͻ����������ӷ�����...");

		// ��ʼ��ip�Ͷ˿ںţ�-ORBInitialHost 127.0.0.1 -ORBInitialPort 1050
		String args[] = new String[4];
		args[0] = "-ORBInitialHost";
		// server�˵�IP��ַ����HelloServer�ж����
		args[1] = "127.0.0.1";
		args[2] = "-ORBInitialPort";
		// server�˵Ķ˿ڣ���HelloServer�ж����
		args[3] = "1050";

		// ����һ��ORBʵ��
		ORB orb = ORB.init(args, null);

		// ��ȡ������������
		org.omg.CORBA.Object objRef = null;
		try {
			objRef = orb.resolve_initial_references("NameService");
		} catch (InvalidName e) {
			e.printStackTrace();
		}
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);

		String name = "Hello";

		// ͨ��ORB�õ���serverʵ�����õ�ʵ����
		try {
			todoListImpl = toDoListHelper.narrow(neRef.resolve_str(name));
		} catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}

		System.out.println("�ͻ����Ѿ��ɹ����ӷ�����");
	}

	public static void main(String args[]) throws Exception {
		boolean isRun = true;
		while(isRun){
			System.out.println("��ѡ����Ҫ���еĲ�����");
			System.out.println("1.ע��");
			System.out.println("2.��½");
			System.out.println("3.�����");
			System.out.println("4.��ѯ��");
			System.out.println("5.�鿴��ǰ������");
			System.out.println("6.ɾ����");
			System.out.println("7.ɾ��������");
			System.out.println("8.�˳���¼");
			int choice;
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			switch(choice){
			case REGISTER:
				System.out.println("����������������");
				String name = sc.next();
				System.out.println("������������룺");
				String passWord = sc.next();
				System.out.println(todoListImpl.register(name, passWord));
				break;
			case LOGIN:
				System.out.println("����������������");
				String logInName = sc.next();
				System.out.println("������������룺");
				String logInPassWord = sc.next();
				System.out.println(todoListImpl.logIn(logInName, logInPassWord));
				break;
			case ADDITEM:
				System.out.println("��������Ҫ��ӵ���Ŀ�ʼʱ�䣺����ʽ��yyyy-MM-dd HH:mm:ss��");
				//����ط�����Ҫ��һ��sc.nextLine();
				sc.nextLine();
				String start = sc.nextLine();
				//System.out.println(start);
				System.out.println("��������Ҫ�����Ľ���ʱ�䣺����ʽ��yyyy-MM-dd HH:mm:ss��");
				String end = sc.nextLine();
				System.out.println("��������Ҫ�����ı�ǩ��");
				String label = sc.nextLine();
				long startTime = sdf.parse(start).getTime();
				long endTime = sdf.parse(end).getTime();
				System.out.println(todoListImpl.addItem(startTime, endTime, label));
				break;
			case QUERY:
				System.out.println("��������Ҫ��ѯ����Ŀ�ʼʱ�䣺����ʽ��yyyy-MM-dd HH:mm:ss��");
				//����ط�����Ҫ��һ��sc.nextLine();
				sc.nextLine();
				String startQueryTimeString = sc.nextLine();
				//System.out.println(start);
				System.out.println("��������Ҫ��ѯ����Ľ���ʱ�䣺����ʽ��yyyy-MM-dd HH:mm:ss��");
				String endQueryTimeString = sc.nextLine();
				long startQueryTimeLong = sdf.parse(startQueryTimeString).getTime();
				long endQueryTimeLong = sdf.parse(endQueryTimeString).getTime();
				System.out.println(todoListImpl.queryItems(startQueryTimeLong, endQueryTimeLong));
				break;
			case LISTALL:
				System.out.println(todoListImpl.listAll());
				break;
			case DELETE:
				//sc.nextLine();
				System.out.println(todoListImpl.listAll());
				System.out.println("��������Ҫɾ���������ţ�");
				int index = sc.nextInt();
				System.out.println(todoListImpl.deleteItem(index));
				break;
			case CLEARALL:
				System.out.println(todoListImpl.clearItems());
				break;
			case LOGOUT:
				String result = todoListImpl.logOut();
				if(result.equals("Log out successful"))
					isRun = false;
				System.out.println(result);
				break;
			}
		}
	}

}
