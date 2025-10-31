package com.example.ItemLists.entity;


import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private ChecklistEntity checklist;

    @Column
    private String name;
    @Column
    private boolean isCheck;
    @Column
    private Date createdAt;

}