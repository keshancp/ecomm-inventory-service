package com.ecomm.inventoryservice.service;

import java.util.List;

import com.ecomm.inventoryservice.dto.InventoryDto;
import com.ecomm.inventoryservice.exception.ECommInventoryException;

public interface InventoryService {

	List<InventoryDto> isInStock(String itemCode,String traceId) throws ECommInventoryException;
	
	InventoryDto addItem(InventoryDto inventoryDto,String traceId) throws ECommInventoryException;
}
