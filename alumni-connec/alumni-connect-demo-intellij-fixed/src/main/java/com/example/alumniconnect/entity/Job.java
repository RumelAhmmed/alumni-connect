package com.example.alumniconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job")  // optional but good to specify
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)  // Optional: allows longer descriptions
    private String description;

    @Column(nullable = false)
    private String company;

    // Default constructor required by JPA
    public Job() {
    }

    // Constructor with fields (except id because it's auto-generated)
    public Job(String title, String description, String company) {
        this.title = title;
        this.description = description;
        this.company = company;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
