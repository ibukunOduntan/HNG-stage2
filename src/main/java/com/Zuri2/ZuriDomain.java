package com.Zuri2;

import jakarta.persistence.*;

@Entity
@Table
public class ZuriDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public ZuriDomain(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ZuriDomain(String name) {
        this.name = name;
    }

    public ZuriDomain() {
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
