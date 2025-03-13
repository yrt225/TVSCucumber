package com.tvsmotors.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtil {
	
	public static Map<String, String> readExcelData(String sheetName, String keyValue)
	{
		
		Map<String,String> dataMap = new HashMap<>();
		try {
			FileInputStream fileInputStream = new FileInputStream("src/main/resources/testdata/excel/testdata.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow headerRow = sheet.getRow(0);
			for(Row row: sheet)
			{
				Cell keyCell = row.getCell(0);
				
				if(keyCell.getStringCellValue().equals(keyValue))
				{
					for(Cell cell: row)
					{
						
						String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
						String value = cell.getStringCellValue();
						dataMap.put(header, value);
								
						
					}
					break;			
					
				}
		
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return dataMap;
	}
	
	public static Map<String, String> readUserData(String keyValue )
	
	{
		return readExcelData("UserDetails", keyValue);
		
	}
	
	public static Map<String, String> readDeadlerData(String keyValue)
	{
		
		return readExcelData("DealerAddress", keyValue);
	}

}
