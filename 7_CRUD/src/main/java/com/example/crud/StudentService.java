package com.example.crud;

import com.example.crud.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class StudentService {
    // 복수의 StudentDto를 담는 변수
    List<StudentDto> studentDtoList = new ArrayList<>();
    private Long nextId = 1L;

    // 새로운 Student를 생성하는 메소드
    public StudentDto createStudent(String name, String email){
        StudentDto studentDto = new StudentDto(nextId++, name, email);
        studentDtoList.add(studentDto);
        return studentDto;
    }

    public List<StudentDto> readStudentAll(){
        return studentDtoList;
    }

    // Service에서 단일 StudenDto 를 주는 메소드
    public StudentDto readStudent(Long id){
//        return studentDtoList.get(id.intValue());
//        for(StudentDto studentDto : studentDtoList){
//            if(studentDto.getId().equals(id)) return studentDto;
//        }
//        return  null;

        return studentDtoList
                .stream()
                .filter(studentDto -> studentDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public StudentDto updateStudent(Long id, String name, String email){
//        int target = -1;
//        for (int i = 0; i < studentDtoList.size(); i++) {
//            if(studentDtoList.get(i).getId().equals(id)){
//                target = i; break;
//            }
//        }
//        if(target != -1){
//            studentDtoList.get(target).setName(name);
//            studentDtoList.get(target).setEmail(email);
//            return studentDtoList.get(target);
//        }
//        else return null;
        return studentDtoList.stream()
                .filter(studentDto -> studentDto.getId().equals(id))
                .peek(studentDto -> {
                    studentDto.setName(name);
                    studentDto.setEmail(email);
                })
                .findFirst().orElse(null);
    }

    public boolean deleteStudent(Long id){
//        int target = -1;
//        for (int i = 0; i < studentDtoList.size(); i++) {
//            if(studentDtoList.get(i).getId().equals(id)) {
//                target = i; break;
//            }
//        }
//        if(target != 1){
//            studentDtoList.remove(target);
//            return true;
//        }
//        return false; // Not Found
        OptionalInt idx = IntStream.range(0, studentDtoList.size())
                .filter(i -> studentDtoList.get(i).getId().equals(id))
                .findFirst();
        if(idx.isPresent()){
            studentDtoList.remove(idx.getAsInt());
            return true;
        }
        return false; // Not Found
    }

}
