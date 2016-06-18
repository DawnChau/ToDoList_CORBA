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
		System.out.println("客户端正在连接服务器...");

		// 初始化ip和端口号，-ORBInitialHost 127.0.0.1 -ORBInitialPort 1050
		String args[] = new String[4];
		args[0] = "-ORBInitialHost";
		// server端的IP地址，在HelloServer中定义的
		args[1] = "127.0.0.1";
		args[2] = "-ORBInitialPort";
		// server端的端口，在HelloServer中定义的
		args[3] = "1050";

		// 创建一个ORB实例
		ORB orb = ORB.init(args, null);

		// 获取根名称上下文
		org.omg.CORBA.Object objRef = null;
		try {
			objRef = orb.resolve_initial_references("NameService");
		} catch (InvalidName e) {
			e.printStackTrace();
		}
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);

		String name = "Hello";

		// 通过ORB拿到了server实例化好的实现类
		try {
			todoListImpl = toDoListHelper.narrow(neRef.resolve_str(name));
		} catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}

		System.out.println("客户端已经成功连接服务器");
	}

	public static void main(String args[]) throws Exception {
		boolean isRun = true;
		while(isRun){
			System.out.println("请选择您要进行的操作：");
			System.out.println("1.注册");
			System.out.println("2.登陆");
			System.out.println("3.添加项");
			System.out.println("4.查询项");
			System.out.println("5.查看当前已有项");
			System.out.println("6.删除项");
			System.out.println("7.删除所有项");
			System.out.println("8.退出登录");
			int choice;
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			switch(choice){
			case REGISTER:
				System.out.println("请输入您的姓名：");
				String name = sc.next();
				System.out.println("请输入你的密码：");
				String passWord = sc.next();
				System.out.println(todoListImpl.register(name, passWord));
				break;
			case LOGIN:
				System.out.println("请输入您的姓名：");
				String logInName = sc.next();
				System.out.println("请输入你的密码：");
				String logInPassWord = sc.next();
				System.out.println(todoListImpl.logIn(logInName, logInPassWord));
				break;
			case ADDITEM:
				System.out.println("请输入您要添加的项的开始时间：（格式：yyyy-MM-dd HH:mm:ss）");
				//这个地方必须要加一个sc.nextLine();
				sc.nextLine();
				String start = sc.nextLine();
				//System.out.println(start);
				System.out.println("请输入您要添加项的结束时间：（格式：yyyy-MM-dd HH:mm:ss）");
				String end = sc.nextLine();
				System.out.println("请输入您要添加项的标签：");
				String label = sc.nextLine();
				long startTime = sdf.parse(start).getTime();
				long endTime = sdf.parse(end).getTime();
				System.out.println(todoListImpl.addItem(startTime, endTime, label));
				break;
			case QUERY:
				System.out.println("请输入您要查询的项的开始时间：（格式：yyyy-MM-dd HH:mm:ss）");
				//这个地方必须要加一个sc.nextLine();
				sc.nextLine();
				String startQueryTimeString = sc.nextLine();
				//System.out.println(start);
				System.out.println("请输入您要查询的项的结束时间：（格式：yyyy-MM-dd HH:mm:ss）");
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
				System.out.println("请输入您要删除的索引号：");
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
