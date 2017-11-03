package biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import biz.CountBiz;

import dao.CountDao;

import entity.Count;
import exception.MyException;
@Service
public class CountBizImpl implements CountBiz{
	@Resource
	private CountDao dao;
	

	public CountDao getDao() {
		return dao;
	}

	public void setDao(CountDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean addmoney(Count count, int money) throws MyException {
		
		boolean  b=dao.addmoney(count, money);
		if(b){
			return b;
		}else{
			throw new MyException("查无收钱的账户");
		}	
		
	
	}

	@Override
	public boolean reducemoney(Count count, int money) throws MyException {
		
		// 先查询是否有足够的金额进行减钱操作
	  Count mycount=dao.queryByCount(count.getCount_name());
		if(mycount==null){
			
			throw new MyException("查无账号");
		}else{
			
			int i=mycount.getCount_money();
			if(i<money){
				
				throw new MyException("账户金额不够！！！");
			}
		}
	  
	 
		return dao.reducemoney(count, money);
	}

}
