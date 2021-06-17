package com.krn.actitime.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public String fr(String Sheetname, int Rownum, int Cellnum) {
		String ret=null;
		try {
			FileInputStream fis = new FileInputStream("D:\\Eclipse Oxygen\\Eclipse Workspace\\Actitime2\\RequiredData\\data.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(Sheetname);
			Row r=sh.getRow(Rownum);
			Cell c=r.getCell(Cellnum);
			ret=c.getStringCellValue();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;		
	}
	
	
	public int lstRw(String sheetNm) {
		int ret=0;
		try {
			FileInputStream fis=new FileInputStream("D:\\Eclipse Oxygen\\Eclipse Workspace\\Actitime2\\RequiredData\\data.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetNm);
			ret=s.getLastRowNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
		
	}

}
