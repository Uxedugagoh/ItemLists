package com.example.ItemLists.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checklist")
public class ChecklistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "checklist")
    private List<Item> itemList;

    @Column(nullable = false)
    private String name;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;
}