package dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.CountDao;
import entity.Count;
import exception.MyException;
@Repository
public class CountDaoImpl implements CountDao{
	
	@Resource(name="jdbc")
	private JdbcTemplate util;

	
	
	
	public JdbcTemplate getUtil() {
		return util;
	}

	public void setUtil(JdbcTemplate util) {
		this.util = util;
	}

	@Override
	public boolean addmoney(Count count, int money) {
		// TODO Auto-generated method stub
		
	
		return util.update("update t_count set count_money=count_money+? where count_name=?", money,count.getCount_name())>0;
	}

	@Override
	public boolean reducemoney(Count count, int money) {
		// TODO Auto-generated method stub
		return util.update("update t_count set count_money=count_money-? where count_name=?", money,count.getCount_name())>0;
	}

	@Override
	public Count queryByCount(String count) {
	
		return util.queryForObject("select * from t_count where count_name=?", new Object[]{count},new CountRowMapper());
	}

}
