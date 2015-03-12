package com.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.action.GoddessAction;
import com.dao.GoddessDao;
import com.modal.*;

public class View {
	private static final String CONTEXT=
			"欢迎来到女神信息系统：\n"+
	        "下面是女神的信息系统功能列表：\n"
            +"[MAIN/M]:主菜单\n"
	        +"[QUERY/Q]:查看全部女神的详细信息\n"
            +"GET/G:查看某位女神的详细信息\n"
	        +"ADD/A:添加女神\n"
            +"UPDATE/U:更新女神信息\n"
	        +"DELETE/D:查出女神\n"
            +"SEARCH/S:按姓名和电话号码查找女神\n"
	        +"EXIT/E:退去女神信息系统"
            +"BREAK/B:返回主菜单";
	 private static final String OPERATION_MAIN="MIAN";
	 private static final String OPERATION_QUERY="QUERY"; 
	 private static final String OPERATION_GET="GET"; 
	 private static final String OPERATION_ADD="ADD"; 
	 private static final String OPERATION_UPDATE="UPDATE"; 
	 private static final String OPERATION_DELETE="DELETE"; 
	 private static final String OPERATION_SEARCH="SEARCH"; 
	 private static final String OPERATION_EXIT="EXIT"; 
	 private static final String OPERATION_BREAK="BREAK";
	 
   public static void main(String[] args) throws Throwable {
	System.out.println(CONTEXT);
	//怎么一直保持程序执行
	Goddess goddess =new Goddess();
	GoddessAction action =new GoddessAction();
	Scanner scan = new Scanner(System.in);
	String prenious = null;
	Integer step=1;
	while(scan.hasNext()){
		String in = scan.next().toString();
		if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
			System.out.println("您已成功退出女神信息系统！");
			break;
		}else if(OPERATION_QUERY.equals(in.toUpperCase())||OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())){
			try {
				
				List <Goddess> gs=action.query();
				for (int i = 0; i<gs.size();i++){
					System.out.println("姓名："+gs.get(i).getUser_name());
				}
				System.out.println("查询成功！");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("查询失败！");
			}
		
		}else if(OPERATION_GET.equals(in.toUpperCase())||OPERATION_GET.substring(0,1).equals(in.toUpperCase())){
			System.out.println("请输入要查询的女神编号");
			String h = scan.next().toString();
			try{
			Goddess g=action.get(Integer.valueOf(h));
				
			System.out.println("ID: "+g.getId()+"\n"+"名字："+g.getUser_name()+"\n"+"年龄："+g.getAge()+"\n"+"生日：："+
			g.getBirthday()+"\n"+"Email："+g.getEmail()+"\n"+"电话号码：："+g.getMobile()+"\n");
			System.out.println("查询成功！");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("查询失败！");
			}
		}else if(OPERATION_DELETE.equals(in.toUpperCase())||OPERATION_DELETE.substring(0,1).equals(in.toUpperCase())){
			System.out.println("请输入要删除的女神编号");
			String h = scan.next().toString();
			try{
				action.del(Integer.valueOf(h));
				System.out.println("删除女神成功！");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("删除女神失败！");
			}
		}else if(OPERATION_SEARCH.equals(in.toUpperCase())||OPERATION_SEARCH.substring(0,1).equals(in.toUpperCase())){
			System.out.println("请输入要查找女神的名字");
			String N = scan.next().toString();
			System.out.println("请输入要要查找女神的电话号码");
			String M = scan.next().toString();
			
			try{
				List <Goddess> g=action.query(N,M);
				for (int i = 0; i<g.size();i++){
					System.out.println("ID: "+g.get(i).getId()+"\n"+"名字："+g.get(i).getUser_name()+"\n"+"年龄："+g.get(i).getAge()+"\n"+"生日：："+
							g.get(i).getBirthday()+"\n"+"Email："+g.get(i).getEmail()+"\n"+"电话号码：："+g.get(i).getMobile()+"\n");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
			
		}else if(OPERATION_ADD.equals(in.toUpperCase())||OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
				||OPERATION_ADD.equals(prenious)){
			//新增女神
			prenious=OPERATION_ADD;
			if(1==step){
				System.out.println("请输入女神的姓名");
			}else if(2==step){
				goddess.setUser_name(in);
				System.out.println("请输入女神的年龄");
			}else if(3==step){
				goddess.setAge(Integer.valueOf(in));
				System.out.println("请输入女神的生日 格式如： yyyy-MM-dd");
			}else if (4==step){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday =sf.parse(in);
					goddess.setBirthday(birthday);
					System.out.println("请输入女神的Email地址");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("亲， 您输入的格式有误，格式：2015-02-03");
					step=3;
				}
				
			}else if(5==step){
				goddess.setEmail(in);
				System.out.println("请输入女神的性别");
				
			}else if(6==step){
				goddess.setSex(Integer.valueOf(in));
				System.out.println("请输入女神的idel");
			}else if(7==step){
				goddess.setIsdel(Integer.valueOf(in));
				System.out.println("请输入女神的信息创建人");
			}else if(8==step){
				goddess.setCreate_user(in);
				System.out.println("请输入女神的电话号码");
			}else if(9==step){
				goddess.setMobile(in);
				try {
					action.add(goddess);
					System.out.println("增加女神信息成功！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("增加女神信息失败");
				}
				//System.out.println("请输入女神的信息创建时期 格式：yyyy-MM-dd");
			}/*else if (7==step){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date create_date = null;
				try {
					create_date =sf.parse(in);
					goddess.setCreate_date(create_date);
					System.out.println("请输入女神的信息创建人");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("亲， 您输入的格式有误，格式：2015-02-03");
					step=6;
				}
			}else if(8==step){
				goddess.setCreate_user(in);
				System.out.println("请输入女神的isdel值");
			}else if(7==step){
				goddess.setIsdel(Integer.valueOf(in));
				
			}*/
			if(OPERATION_ADD.equals(prenious)){
				step++;
			}
			
		
		}
		
}
	 
}


}
