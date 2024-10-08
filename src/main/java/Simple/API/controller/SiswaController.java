package Simple.API.controller;

import Simple.API.entity.SiswaEntity;
import Simple.API.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/simpleAPI")
public class SiswaController {

    private final SiswaService studentService;

    @Autowired
    public SiswaController(SiswaService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<SiswaEntity> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody SiswaEntity student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody SiswaEntity newSiswaData) {
        studentService.updateStudent(id, newSiswaData);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
