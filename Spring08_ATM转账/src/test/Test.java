package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.MyController;
import exception.MyException;

public class Test {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext  ctx=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		MyController con=(MyController) ctx.getBean("myController");
		
		try {
			con.zhuan();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
