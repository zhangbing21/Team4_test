package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import biz.CountBiz;

import entity.Count;
import exception.MyException;

@Controller
public class MyController {
	
	@Resource
	private CountBiz  biz;
	
	
	public CountBiz getBiz() {
		return biz;
	}

	public void setBiz(CountBiz biz) {
		this.biz = biz;
	}


    @Transactional(rollbackFor=Exception.class)
	public String zhuan() throws MyException{
		
		String name="lijing";  //ת�˵���
		String name1="zyy123";    //��Ǯ����
		int money=500;   //ת�˺���Ǯ�Ľ��
		
		Count count=new Count();
		count.setCount_name(name);
		
		biz.reducemoney(count, money);
		
		count.setCount_name(name1);
		
		biz.addmoney(count, money);
		
		return "";
	}

}
