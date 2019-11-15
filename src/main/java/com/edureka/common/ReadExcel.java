package com.edureka.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	static File file = null;
	static FileInputStream fin = null;
	static Workbook wb = null;
	static Sheet sheet = null;
	static Row headerRow = null;
	static Row dataRow = null;
	
	public static HashMap<String, String> fetchData(String filePath, String fileName, String sheetName)
	{
		try
		{
			file = new File(filePath + fileName);
			fin = new FileInputStream(file);
			wb = new XSSFWorkbook(fin);
			sheet = wb.getSheet(sheetName);
			headerRow = sheet.getRow(0);
			dataRow = sheet.getRow(1);
			
			DataFormatter df = new DataFormatter();
			String headerCell = null;
			String dataCell = null;
			
			HashMap<String, String> data = new HashMap<String, String>();
			for(int index = 0; index<headerRow.getLastCellNum(); index++)
			{
				headerCell = df.formatCellValue(headerRow.getCell(index));
				dataCell = df.formatCellValue(dataRow.getCell(index));
				data.put(headerCell, dataCell);
			}
			return data;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
