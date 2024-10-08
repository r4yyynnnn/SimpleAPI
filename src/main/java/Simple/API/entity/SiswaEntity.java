package Simple.API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DataSiswa")
public class SiswaEntity {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    //type data
    private Long id;
    private Integer nisn;
    private String nama;
    private String alamat;
    private String kelas;

    public SiswaEntity() {
    }

    public SiswaEntity(Integer nisn, String nama, String alamat, String kelas) {
        this.nisn = nisn;
        this.nama = nama;
        this.alamat = alamat;
        this.kelas = kelas;
    }

    public SiswaEntity(String nama, String alamat, String kelas) {
        this.nama = nama;
        this.alamat = alamat;
        this.kelas = kelas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNisn() {
        return nisn;
    }

    public void setNisn(Integer nisn) {
        this.nisn = nisn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                "nisn=" + nisn +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", kelas=" + kelas +
                '}';
    }
}
