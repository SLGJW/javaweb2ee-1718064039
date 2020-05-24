package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
  
import entity.Student;

public class StudentDao {
    /**
     * 查询所有
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Student> findAll() throws ClassNotFoundException, SQLException{
        ArrayList<Student> emps=new ArrayList<Student>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        con=DBUtil.getConnection();
        ps=con.prepareStatement("select * from t_emp");
        rs=ps.executeQuery();

        while(rs.next()){
            Student emp=new Student(rs.getInt("id"),
                    rs.getString("name"),rs.getInt("snumber"),rs.getInt("age"),rs.getString("ssex"));
            emps.add(emp);
            //System.out.println(emp);
        }

        DBUtil.close(con);
        return emps;
    }


    //增加员工
    public void save(Student emp) throws ClassNotFoundException, SQLException{
        Connection con=null;
        PreparedStatement ps=null;

        con=DBUtil.getConnection();
        ps=con.prepareStatement("insert into t_emp(name,snumber,age,ssex) values(?,?,?,?)");

        ps.setString(1, emp.getName());
        ps.setDouble(2, emp.getSnumber());
        ps.setInt(3, emp.getAge());
        ps.setString(4, emp.getSsex());
        ps.executeUpdate();

        DBUtil.close(con);

    }

    //删除员工
    public void delete(int id) throws ClassNotFoundException, SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        con=DBUtil.getConnection();
        String sql="delete from t_emp where id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        DBUtil.close(con);
    }
    //修改员工信息
    public void modify(Student emp) throws ClassNotFoundException, SQLException{
        Connection con=null;
        PreparedStatement ps=null;

        con=DBUtil.getConnection(); 
        String sql="update t_emp set name=?,snumber=?,age=?,ssex=? where id=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, emp.getName());
        ps.setInt(2, emp.getSnumber());
        ps.setInt(3, emp.getAge());
        ps.setString(4, emp.getSsex());
        ps.setInt(5, emp.getId());
        ps.executeUpdate();

        DBUtil.close(con);

    }

    //根据id查询员工
    public Student findById(int id) throws ClassNotFoundException, SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student emp=null;

        con=DBUtil.getConnection();
        String sql="select * from t_emp where id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        rs=ps.executeQuery();
        if(rs.next()){
            emp=new Student(rs.getInt("id"),
                    rs.getString("name"),rs.getInt("snumber"),rs.getInt("age"),rs.getString("ssex"));
        }
        DBUtil.close(con);
        return emp;

    }
}
