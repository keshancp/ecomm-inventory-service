package com.ecomm.inventoryservice.service;

import java.util.List;

import com.ecomm.inventoryservice.dto.InventoryDto;

public interface InventoryService {

	List<InventoryDto> isInStock(String itemCode,String traceId);
	
	InventoryDto addItem(InventoryDto inventoryDto,String traceId) ;
}
