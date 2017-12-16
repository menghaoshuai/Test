package cn.yongqing.base;

import org.springframework.dao.DataAccessException;



public class DaoException extends DataAccessException {
	
	private static final long serialVersionUID = 14654657657567567L;

	public DaoException(String message) {
		super(message);
	}
}
