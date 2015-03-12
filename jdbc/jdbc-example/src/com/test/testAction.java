package com.test;

import java.util.List;

import com.action.GoddessAction;
import com.modal.Goddess;

public class testAction {
   public static void main(String[] args) throws Exception {
	GoddessAction action= new GoddessAction();
	action.del(4);
	List<Goddess> result=action.query("√¿√¿","18729549");
	for (int i = 0; i < result.size(); i++) {
		System.out.println(result.get(i).getId()+" "+result.get(i).getUser_name());
	}
	
}
}
