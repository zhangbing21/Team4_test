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
			throw new MyException("������Ǯ���˻�");
		}	
		
	
	}

	@Override
	public boolean reducemoney(Count count, int money) throws MyException {
		
		// �Ȳ�ѯ�Ƿ����㹻�Ľ����м�Ǯ����
	  Count mycount=dao.queryByCount(count.getCount_name());
		if(mycount==null){
			
			throw new MyException("�����˺�");
		}else{
			
			int i=mycount.getCount_money();
			if(i<money){
				
				throw new MyException("�˻�����������");
			}
		}
	  
	 
		return dao.reducemoney(count, money);
	}

}
