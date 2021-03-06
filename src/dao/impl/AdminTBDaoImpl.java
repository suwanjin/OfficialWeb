package dao.impl;

import java.sql.SQLException;

import bean.LoginBean;

import dao.AdminTBDao;
import dao.BaseDao;
import entity.AdminTB;

/**
 * 管理员实现类
 * @author Administrator
 *
 */
public class AdminTBDaoImpl extends BaseDao implements AdminTBDao {
	/**
	 * 登录
	 */
	public AdminTB login(LoginBean login) {
		AdminTB at=null;
		String sql="select * from adminTB where Email=? and pwd=?";
		rs=executeQuery(sql, login.getaEmail(),login.getaPwd());
		try {
			while(rs.next()){
				at=new AdminTB(rs.getString("id"),rs.getString("userName"),rs.getString("Email"),rs.getString("pwd"));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
	}
	/**
	 * 修改管理员账号信息
	 */
	public int updateAdminTB(AdminTB adminTB) {
		String sql="update admintb set userName=?,pwd=? where id=?";
		return executeUpdate(sql,adminTB.getaUserName(),adminTB.getaPwd(),adminTB.getaID());
	}
	

}
