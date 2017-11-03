package biz;

import entity.Count;
import exception.MyException;

public interface CountBiz {
	public boolean addmoney(Count count,int money) throws MyException;
	
	public boolean reducemoney(Count count,int money) throws MyException ;
}
