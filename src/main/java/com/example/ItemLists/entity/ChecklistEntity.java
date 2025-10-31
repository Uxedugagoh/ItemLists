package com.example.ItemLists.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    // Добавил cascade и orphanRemoval для решения проблем с отображением дочерних item
    @OneToMany(mappedBy = "checklist", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // <- Решение проблемы с рекурсивными ссылками ?
    private List<Item> itemList;

    @Column(nullable = false)
    private String name;

    @Column
    @CreationTimestamp // <-- Дата создания
    private Date createdAt;

    @Column
    private Date updatedAt;
}