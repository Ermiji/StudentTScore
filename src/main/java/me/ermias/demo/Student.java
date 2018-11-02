package me.ermias.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fName;
    private String lName;
    private String major;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<TestScore> tscores;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

