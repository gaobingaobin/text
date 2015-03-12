package com.action;



import java.util.Date;
import java.util.List;

import com.dao.GoddessDao;
import com.modal.Goddess;

public class GoddessAction {
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.addgoddess(goddess);
	}
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
		
	}
	public void del(Integer id) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(id);
	}
	public List<Goddess> query() throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	public List<Goddess>  query(String name, String mobile) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query(name, mobile);
	}
	public Goddess get(Integer id) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
		
	}
	/*public static void main(String[] args) throws Exception {
	GoddessDao g = new GoddessDao();
		Goddess g1=new Goddess();
		g1.setUser_name("美美");
		g1.setAge(25);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("MEIMEI@IMOOC.COM");
		g1.setMobile("18720989549");
		g1.setUpdate_user("ADM");
		g1.setIsdel(1);
		g1.setId(6);
		
		g.addgoddess(g1);
	//g.updateGoddess(g1);
	//Goddess g2=g.get(7);
	//System.out.println(g2.toString());
		
		GoddessDao g = new GoddessDao();
		List <Goddess> gs=g.query("美美","18729549");
		for (int i = 0; i<gs.size();i++){
			System.out.println(gs.get(i).toString());
		}
		
	}*/

}
