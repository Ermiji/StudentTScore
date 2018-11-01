package me.ermias.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fname;
    private String lname;
    private String major;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<TestScore> tscores;

    public Student(String fname, String lname, String major, Set<TestScore> tscores) {
        this.fname = fname;
        this.lname = lname;
        this.major = major;
        this.tscores = tscores;
    }

    public Student() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<TestScore> getTscores() {
        return tscores;
    }

    public void setTscores(Set<TestScore> tscores) {
        this.tscores = tscores;
    }
}

