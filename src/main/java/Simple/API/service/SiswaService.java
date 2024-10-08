package Simple.API.service;

import Simple.API.entity.SiswaEntity;
import Simple.API.repo.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    private final SiswaRepository studentRepository;

    @Autowired
    public SiswaService(SiswaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<SiswaEntity> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(SiswaEntity student) {
        Optional<SiswaEntity> studentOptional = studentRepository
                .findStudentByNisn(student.getNisn());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Nisn Sudah Ada");
        }
        studentRepository.save(student);
    }

    public Optional<SiswaEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Long id, SiswaEntity newSiswaData) {
        SiswaEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(" ID Siswa  " + id + " tidak ada"));

        if (newSiswaData.getNama() != null &&
                !newSiswaData.getNama().isEmpty()) {
            student.setNama(newSiswaData.getNama());
        }

        if (newSiswaData.getNisn() != null &&
                !newSiswaData.getNisn().equals(student.getNisn())) {
            Optional<SiswaEntity> studentOptional = studentRepository.findStudentByNisn(newSiswaData.getNisn());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Nisn Sudah Ada");
            }
            student.setNisn(newSiswaData.getNisn());
        }

        studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("ID Siswa " + id + " tidak ada");
        }
        studentRepository.deleteById(id);
    }



}
