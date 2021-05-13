package ru.package01.core.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.package01.core.model.Student;
import ru.package01.core.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DbServiceStudentImpl implements DbServiceStudent {

    private static final Logger logger = LoggerFactory.getLogger(DbServiceStudentImpl.class);

    private final StudentRepository studentRepository;

    public DbServiceStudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public long saveStudent(String studentString) {
        try {
            Gson gson = new Gson();
            Student student = gson.fromJson(studentString, Student.class);
            if (!student.getFirstName().equals("")
                    && !student.getSecondName().equals("")
                    && !student.getMiddleName().equals("")
                    && !student.getDateOfBirth().equals("")
                    && !student.getStudentGroup().equals("")
            ) {
                studentRepository.save(student);
                logger.info("created student:_____");
            }

            long studentId = student.getId();
            logger.info("created student: {}", studentId);
            return studentId;
        } catch (Exception e) {
            System.out.println("DID NOT CREATE");
            throw new DbServiceException(e);
        }
    }

    @Override
    public long updateStudent(String studentString) {
        try {
            Gson gson = new Gson();
            Student student = gson.fromJson(studentString, Student.class);
            long studentId = student.getId();
            if (!studentRepository.findById(studentId).isPresent()) {
                logger.info("--There is NO student with this name for UPDATING--");

            } else if (student.getFirstName().equals("")
                    || student.getSecondName().equals("")
                    || student.getMiddleName().equals("")
                    || student.getDateOfBirth().equals("")
                    || student.getStudentGroup().equals("")
            ) {
                logger.info("--Fill in all the fields for UPDATING--");
            } else {
                studentRepository.save(student);
                logger.info("student with id= {} has been updated", studentId);
            }
            return studentId;
        } catch (Exception e) {
            System.out.println("DID NOT FIND");
            throw new DbServiceException(e);
        }
    }

    @Override
    public Optional<Student> getStudent(long id) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);
            logger.info("student: {}", studentOptional.orElse(null));
            return studentOptional;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public long deleteStudent(String studentIdString) {
        try {
            Gson gson = new Gson();
            Student student = gson.fromJson(studentIdString, Student.class);

            long studentId = student.getId();
            if (!studentRepository.findById(studentId).isPresent()) {
                logger.info("--There is NO student with this ID for DELETING--");
            } else {
                studentRepository.deleteById(studentId);
                logger.info("student with id= {} has been deleted", studentId);
            }
            return studentId;
        } catch (Exception e) {
            System.out.println("DID NOT DELETE");
            throw new DbServiceException(e);
        }
    }
}
