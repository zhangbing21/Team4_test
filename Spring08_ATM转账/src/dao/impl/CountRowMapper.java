package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Count;

public class CountRowMapper implements RowMapper<Count> {

	@Override
	public Count mapRow(ResultSet rs, int index) throws SQLException {
		Count count=new Count();
		count.setCount_id(rs.getInt("count_id"));
		count.setCount_name(rs.getString("count_name"));
		count.setCount_money(rs.getInt("count_money"));
		
		return count;
	}

}
