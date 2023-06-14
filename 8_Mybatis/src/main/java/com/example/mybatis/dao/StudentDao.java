package com.example.mybatis.dao;

import com.example.mybatis.mapper.StudentMapper;
import com.example.mybatis.mapper.StudentXmlMapper;
import com.example.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    private final SqlSessionFactory sessionFactory;

    public StudentDao(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> readStudentsAll(){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            return studentMapper.selectStudentAll();
        }
    }

    public Student readStudent(Long id){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            return studentMapper.selectStudent(id);
        }
    }

    public void createStudent(Student student){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
        }
    }

    public List<Student> readAllXml(){
        try(SqlSession session = sessionFactory.openSession()){
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            return studentXmlMapper.selectStudentAll();
        }
    }
}
