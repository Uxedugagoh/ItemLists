package com.example.ItemLists.model;

import com.example.ItemLists.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistDto {

    private Long id;
    private List<ItemDto> itemList;
    private String name;
    private Date createdAt;
    private Date updatedAt;

    public ChecklistDto(List<ItemDto> itemList, String name) {
        this.itemList = itemList;
        this.name = name;
    }
}
