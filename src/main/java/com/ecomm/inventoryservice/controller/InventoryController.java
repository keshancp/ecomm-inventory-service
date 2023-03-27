package com.ecomm.inventoryservice.controller;

import java.util.List;

import com.ecomm.inventoryservice.exception.ECommInventoryException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.inventoryservice.dto.InventoryDto;
import com.ecomm.inventoryservice.dto.ECommInventoryResponse;
import com.ecomm.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryServiceImpl;
	
	@GetMapping("/{itemCode}")
	@ResponseStatus(HttpStatus.OK)
	public ECommInventoryResponse isInStock(@PathVariable("itemCode") String itemCode, @RequestParam String traceId) throws ECommInventoryException {
		List<InventoryDto> inventoryDtoList = inventoryServiceImpl.isInStock(itemCode,traceId);
		
		if(inventoryDtoList.isEmpty()) {
			return new ECommInventoryResponse(HttpStatus.NOT_FOUND.value(),"Item not available",inventoryDtoList);
			
		}else {
			return new ECommInventoryResponse(HttpStatus.FOUND.value(),"Item Found",inventoryDtoList);
			
		}
		
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ECommInventoryResponse addItem(@RequestBody InventoryDto inventoryDto, @RequestParam String traceId) throws ECommInventoryException{
		
		InventoryDto inventryDto=inventoryServiceImpl.addItem(inventoryDto,traceId);
		
		return new ECommInventoryResponse(HttpStatus.CREATED.value(),"Add to inventry",inventryDto);
		
	}
	
}
