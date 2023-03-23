package com.ecomm.inventoryservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.ecomm.inventoryservice.exception.ECommInventoryException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.inventoryservice.dto.InventoryDto;
import com.ecomm.inventoryservice.model.Inventory;
import com.ecomm.inventoryservice.repository.InventoryRepository;
import com.ecomm.inventoryservice.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

	private final InventoryRepository inventoryRepository;
	
	private final ObjectMapper objectMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<InventoryDto> isInStock(String itemCode,String traceId) throws ECommInventoryException{
		Optional<List<Inventory>> inventoryList= inventoryRepository.findAllByItemCode(itemCode);
		List<InventoryDto> inventoryDtoList = null;
		if(inventoryList.isPresent()) {
			//inventoryDtoList=inventoryList.get().stream().map(inventory->mapToDto(inventory)).toList();
		}
		
		return inventoryDtoList;
		
	}

	@Override
	@Transactional
	public InventoryDto addItem(InventoryDto inventoryDto,String traceId) throws ECommInventoryException {
		
		Inventory inventory=Inventory.builder()
		.itemCode(inventoryDto.getItemCode())
		.quantity(inventoryDto.getQuantity())
		.itemDescription(inventoryDto.getItemDescription()).build();
		
		inventory= inventoryRepository.save(inventory);
		return objectMapper.convertValue(inventory, InventoryDto.class);
		
	}
	
	
	private InventoryDto mapToDto(Inventory inventory) {
		InventoryDto inventoryDto=new InventoryDto();
		inventoryDto.setItemCode(inventory.getItemCode());
		inventoryDto.setItemDescription(inventory.getItemDescription());
		inventoryDto.setQuantity(inventory.getQuantity());
		
		return inventoryDto;
	}

}
