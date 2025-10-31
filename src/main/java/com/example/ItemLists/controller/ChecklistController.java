package com.example.ItemLists.controller;

import com.example.ItemLists.entity.ChecklistEntity;
import com.example.ItemLists.entity.Item;
import com.example.ItemLists.model.ChecklistDto;
import com.example.ItemLists.model.ItemDto;
import com.example.ItemLists.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {
    @Autowired
    private ChecklistRepository checklistRepository;

    @GetMapping
    public List<ChecklistDto> findAll() {
        // JPA repos
        List<ChecklistEntity> entities = checklistRepository.findAll();
        return entities.stream().map(this::checklistToDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody - получить из тела post запроса
    public ChecklistDto create(@RequestBody ChecklistDto checklistDto) {
        ChecklistEntity save = checklistRepository.save(dtoToChecklist(checklistDto));
        return checklistToDto(save);
    }
    /*
    TODO
      1. UPdate checklist (PUT)
      2. DELETE with all items
      3. PUT /checklist/1 - see PathVariable
      3. POST /checklists/1/item принимает 1 item и добавляет в чеклист id=1
      4. DELETE /checklists/1/item/{itemId}
      5. PUT /checklist/1/item/2

     */

    private ChecklistEntity dtoToChecklist(ChecklistDto checklistDto) {

        ChecklistEntity checklistEntity = new ChecklistEntity();
        checklistEntity.setName(checklistDto.getName());
        // Проблема была в том, что при маппинге списка DTO в список Entity не устанавливалась
        // ссылка на родительский checklist, из-за чего при GET запросе не отображался корректный itemList.
        checklistEntity.setItemList(checklistDto.getItemList().stream().map(itemDto -> {
            Item item = itemDtoToItemEntity(itemDto);
            item.setChecklist(checklistEntity);
            return item;
        }).toList());
        return checklistEntity;
    }

    private ChecklistDto checklistToDto(ChecklistEntity checklistEntity) {
        ChecklistDto checklistDto = new ChecklistDto();
        checklistDto.setId(checklistEntity.getId());
        checklistDto.setName(checklistEntity.getName());
        checklistDto.setItemList(checklistEntity.getItemList().stream().map(this::itemEntityToItemDto).toList());
        checklistDto.setCreatedAt(checklistEntity.getCreatedAt());
        checklistDto.setUpdatedAt(checklistEntity.getUpdatedAt());
        return checklistDto;
    }

    private Item itemDtoToItemEntity(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setCheck(itemDto.isCheck());
        return item;
    }

    private ItemDto itemEntityToItemDto(Item itemEntity) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName(itemEntity.getName());
        itemDto.setCheck(itemEntity.isCheck());
        return itemDto;
    }
}