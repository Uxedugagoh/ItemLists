package com.example.ItemLists.model;

import lombok.Data;
import java.util.Date;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private boolean check;
    private Date createdAt;


}