package dao;

import entity.Count;
import exception.MyException;

public interface CountDao {
	
	public boolean addmoney(Count count,int money);
	
	public boolean reducemoney(Count count,int money);
	
	public Count queryByCount(String count);

}
