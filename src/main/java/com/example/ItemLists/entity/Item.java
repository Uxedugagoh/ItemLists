package com.example.ItemLists.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    @JsonBackReference // <- Решение проблемы с рекурсивными ссылками ?
    private ChecklistEntity checklist;

    @Column
    private String name;
    @Column
    private boolean isCheck;
    @Column
    @CreationTimestamp // <- Почему-то не создаёт дату
    private Date createdAt;

}