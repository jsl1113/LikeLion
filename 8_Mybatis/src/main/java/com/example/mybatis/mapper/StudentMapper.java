package com.example.mybatis.mapper;

import com.example.mybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper  // MyBatis 가 Mapper 가 붙은 클래스를 데이터베이스 통신에 사용할 준비
public interface StudentMapper {
    // TODO INSERT INTO students (name, age, phone, email) VALUES (?, ?, ?, ?) 를 실행할 메소드
    @Insert("INSERT INTO students (name, age, phone, email) " +
    "VALUES (#{name}, #{age}, #{phone}, #{email})")
    void insertStudent(Student student);

    // TODO Select * FROM students 를 실행할 메소드
    // 복수 개의 Students -> return 타입은 List<Student>
    @Select("SELECT * FROM students")
    List<Student> selectStudentAll();

    // TODO Select * FROM students WHERE id = ? 를 실행할 메소드
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectStudent(Long id);
    // dml  SELECT, INSERT, UPDATE, DELETE

    //  TODO UPDATE students SET name = ?, age = ?, phone = ?, email = ? WHERE id = ? 를 실행할 메소드
    @Update("UPDATE students SET " +
            "name = #{name}," +
            "age = #{age}," +
            "phone = #{phone}," +
            "email = #{email}" +
            "WHERE id = #{id}")
    void updateStudent(Student student);

    // TODO DELETE FROM students WHERE id = ? 을 실행할 메소드
    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteStudent(Long id);
}
