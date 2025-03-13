package com.tvsmotors.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	static ObjectMapper objectMapper;
	
	public static JsonNode getDataFromJson(String fileName,String arrayName,String key,String value)
	
	{

		try
		{ 
			 objectMapper = new ObjectMapper();
			FileInputStream fileInputStream = new FileInputStream(fileName);
			JsonNode rootNode = objectMapper.readTree(fileInputStream);
		
			for(JsonNode node : rootNode.get(arrayName))
			{
				if(node.get(key).asText().equals(value))
				{
					return node;
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public static JsonNode getUserDataByUsername(String userName)
	{
		return getDataFromJson("src/main/resources/testdata/json/userDetails.json", "Users","UserName", userName);
		
	}
	
	public static JsonNode getDealerDataByDealerName(String dealerName )
	{
		
		return getDataFromJson("src/main/resources/testdata/json/dealerAddress.json", "DealerAddresses", "DealerName", dealerName);
	}
	
	

}

