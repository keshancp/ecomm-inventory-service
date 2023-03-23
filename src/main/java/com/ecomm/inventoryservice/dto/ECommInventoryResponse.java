package com.ecomm.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECommInventoryResponse {

	@ApiModelProperty(notes = "Response status code")
	private int statusCode;

	@ApiModelProperty(notes = "Response message")
	private String message;

	@JsonInclude(content = Include.ALWAYS)
	@ApiModelProperty(notes = "Response data")
	private Object data;
	
	
}
