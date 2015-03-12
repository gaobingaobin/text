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
			"��ӭ����Ů����Ϣϵͳ��\n"+
	        "������Ů�����Ϣϵͳ�����б�\n"
            +"[MAIN/M]:���˵�\n"
	        +"[QUERY/Q]:�鿴ȫ��Ů�����ϸ��Ϣ\n"
            +"GET/G:�鿴ĳλŮ�����ϸ��Ϣ\n"
	        +"ADD/A:���Ů��\n"
            +"UPDATE/U:����Ů����Ϣ\n"
	        +"DELETE/D:���Ů��\n"
            +"SEARCH/S:�������͵绰�������Ů��\n"
	        +"EXIT/E:��ȥŮ����Ϣϵͳ"
            +"BREAK/B:�������˵�";
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
	//��ôһֱ���ֳ���ִ��
	Goddess goddess =new Goddess();
	GoddessAction action =new GoddessAction();
	Scanner scan = new Scanner(System.in);
	String prenious = null;
	Integer step=1;
	while(scan.hasNext()){
		String in = scan.next().toString();
		if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
			System.out.println("���ѳɹ��˳�Ů����Ϣϵͳ��");
			break;
		}else if(OPERATION_QUERY.equals(in.toUpperCase())||OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())){
			try {
				
				List <Goddess> gs=action.query();
				for (int i = 0; i<gs.size();i++){
					System.out.println("������"+gs.get(i).getUser_name());
				}
				System.out.println("��ѯ�ɹ���");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("��ѯʧ�ܣ�");
			}
		
		}else if(OPERATION_GET.equals(in.toUpperCase())||OPERATION_GET.substring(0,1).equals(in.toUpperCase())){
			System.out.println("������Ҫ��ѯ��Ů����");
			String h = scan.next().toString();
			try{
			Goddess g=action.get(Integer.valueOf(h));
				
			System.out.println("ID: "+g.getId()+"\n"+"���֣�"+g.getUser_name()+"\n"+"���䣺"+g.getAge()+"\n"+"���գ���"+
			g.getBirthday()+"\n"+"Email��"+g.getEmail()+"\n"+"�绰���룺��"+g.getMobile()+"\n");
			System.out.println("��ѯ�ɹ���");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("��ѯʧ�ܣ�");
			}
		}else if(OPERATION_DELETE.equals(in.toUpperCase())||OPERATION_DELETE.substring(0,1).equals(in.toUpperCase())){
			System.out.println("������Ҫɾ����Ů����");
			String h = scan.next().toString();
			try{
				action.del(Integer.valueOf(h));
				System.out.println("ɾ��Ů��ɹ���");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ɾ��Ů��ʧ�ܣ�");
			}
		}else if(OPERATION_SEARCH.equals(in.toUpperCase())||OPERATION_SEARCH.substring(0,1).equals(in.toUpperCase())){
			System.out.println("������Ҫ����Ů�������");
			String N = scan.next().toString();
			System.out.println("������ҪҪ����Ů��ĵ绰����");
			String M = scan.next().toString();
			
			try{
				List <Goddess> g=action.query(N,M);
				for (int i = 0; i<g.size();i++){
					System.out.println("ID: "+g.get(i).getId()+"\n"+"���֣�"+g.get(i).getUser_name()+"\n"+"���䣺"+g.get(i).getAge()+"\n"+"���գ���"+
							g.get(i).getBirthday()+"\n"+"Email��"+g.get(i).getEmail()+"\n"+"�绰���룺��"+g.get(i).getMobile()+"\n");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
			
		}else if(OPERATION_ADD.equals(in.toUpperCase())||OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
				||OPERATION_ADD.equals(prenious)){
			//����Ů��
			prenious=OPERATION_ADD;
			if(1==step){
				System.out.println("������Ů�������");
			}else if(2==step){
				goddess.setUser_name(in);
				System.out.println("������Ů�������");
			}else if(3==step){
				goddess.setAge(Integer.valueOf(in));
				System.out.println("������Ů������� ��ʽ�磺 yyyy-MM-dd");
			}else if (4==step){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = null;
				try {
					birthday =sf.parse(in);
					goddess.setBirthday(birthday);
					System.out.println("������Ů���Email��ַ");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ף� ������ĸ�ʽ���󣬸�ʽ��2015-02-03");
					step=3;
				}
				
			}else if(5==step){
				goddess.setEmail(in);
				System.out.println("������Ů����Ա�");
				
			}else if(6==step){
				goddess.setSex(Integer.valueOf(in));
				System.out.println("������Ů���idel");
			}else if(7==step){
				goddess.setIsdel(Integer.valueOf(in));
				System.out.println("������Ů�����Ϣ������");
			}else if(8==step){
				goddess.setCreate_user(in);
				System.out.println("������Ů��ĵ绰����");
			}else if(9==step){
				goddess.setMobile(in);
				try {
					action.add(goddess);
					System.out.println("����Ů����Ϣ�ɹ���");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("����Ů����Ϣʧ��");
				}
				//System.out.println("������Ů�����Ϣ����ʱ�� ��ʽ��yyyy-MM-dd");
			}/*else if (7==step){
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Date create_date = null;
				try {
					create_date =sf.parse(in);
					goddess.setCreate_date(create_date);
					System.out.println("������Ů�����Ϣ������");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ף� ������ĸ�ʽ���󣬸�ʽ��2015-02-03");
					step=6;
				}
			}else if(8==step){
				goddess.setCreate_user(in);
				System.out.println("������Ů���isdelֵ");
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
