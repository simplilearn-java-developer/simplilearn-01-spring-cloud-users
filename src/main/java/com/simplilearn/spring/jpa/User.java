package com.simplilearn.spring.jpa;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.simplilearn.spring.util.Util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="USER")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_USER")
    int idUser;

    @Column(name="FIRST_NAME")
    String firstName;

    @Column(name="LAST_NAME")
    String lastName;

    //@NotDuplicateUsername
    @Column(name="USERNAME")
    String username;

    @Column(name="PASSWORD")
    String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="BIRTH")
    Date birth;

    @Column(name="STATUS")
    String status;

    public User() {
    }

    public User(int idUser, String username) {
        this.idUser = idUser;
        this.username = username;
    }

    public User(int idUser, String firstName, String lastName, String username, String password, Date birth,
            String status) {

        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "User [idUser=%s, username=%s, password=%s, firstName=%s, lastName=%s, birth=%s, status=%s]", idUser,
                username, password, firstName, lastName, Util.formatDate(birth), status);
    }


}
