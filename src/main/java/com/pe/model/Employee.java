package com.pe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Empl;
    private String name_Empl;
    private String surname_Empl;
    private String email_Empl;

    public Employee() {
    }

    public Employee(String name_Empl, String surname_Empl, String email_Empl) {
        this.name_Empl = name_Empl;
        this.surname_Empl = surname_Empl;
        this.email_Empl = email_Empl;
    }

    public int getCod_Empl() {
        return cod_Empl;
    }

    public void setCod_Empl(int cod_Empl) {
        this.cod_Empl = cod_Empl;
    }

    public String getName_Empl() {
        return name_Empl;
    }

    public void setName_Empl(String name_Empl) {
        this.name_Empl = name_Empl;
    }

    public String getSurname_Empl() {
        return surname_Empl;
    }

    public void setSurname_Empl(String surname_Empl) {
        this.surname_Empl = surname_Empl;
    }

    public String getEmail_Empl() {
        return email_Empl;
    }

    public void setEmail_Empl(String email_Empl) {
        this.email_Empl = email_Empl;
    }
}