package ru.package01.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.package01.core.model.Student;
import ru.package01.core.service.DbServiceStudent;

import java.util.List;

@Controller
public class StudentController {
    private final SimpMessagingTemplate messagingTemplate;
    private final DbServiceStudent dbServiceStudent;

    public StudentController(SimpMessagingTemplate messagingTemplate, DbServiceStudent dbServiceStudent) {
        this.messagingTemplate = messagingTemplate;
        this.dbServiceStudent = dbServiceStudent;
    }

    @MessageMapping("/chat.addStudent")
    public void studentSave(String studentString) {
        long id = dbServiceStudent.saveStudent(studentString);
        if (id != 0) {
            messagingTemplate.convertAndSend("/topic/students", dbServiceStudent.getStudent(id));
        }
    }

    @MessageMapping("/chat.updateStudent")
    public void studentUpdate(String studentString) {
        long id = dbServiceStudent.updateStudent(studentString);
        if (id != 0) {
            messagingTemplate.convertAndSend("/topic/students", dbServiceStudent.getStudent(id));
        }
    }

    @MessageMapping("/chat.deleteStudent")
    public void studentDelete(String studentIdString) {
        long id = dbServiceStudent.deleteStudent(studentIdString);
    }

    @MessageMapping("/chat.getAllStudents")
    public void getAll() {
        List<Student> students = dbServiceStudent.getAll();
        messagingTemplate.convertAndSend("/topic/getAllStudents", students);
    }
}
