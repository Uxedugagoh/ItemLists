package com.example.ItemLists.repository;

import com.example.ItemLists.entity.ChecklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long> {

}