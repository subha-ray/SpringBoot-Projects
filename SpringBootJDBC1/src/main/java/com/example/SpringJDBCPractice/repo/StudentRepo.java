package com.example.SpringJDBCPractice.repo;

import com.example.SpringJDBCPractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql="insert into student (rollno,name,marks) values(?,?,?)";
        int rows=jdbc.update(sql,s.getRoll(),s.getName(),s.getMarks());
        System.out.println(rows+"rows effected.........");
    }

    public List<Student> findAll() {
        String sql="select * from student";
        RowMapper<Student> mapper=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s=new Student();
                s.setRoll(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }

        };
        return jdbc.query(sql,mapper);
    }
    public void delete(Student s) {
        String sql="DELETE FROM student WHERE rollno=?";
        int rows=jdbc.update(sql,s.getRoll());
        System.out.println(rows+"rows effected.........");
    }

}
