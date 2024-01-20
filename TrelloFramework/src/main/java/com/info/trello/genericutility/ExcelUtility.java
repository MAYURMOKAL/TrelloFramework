package com.info.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * to read the data from excel workbook
 * @author MAYUR
 *
 */
public class ExcelUtility {
/**
 * this method is used to read the String data from excel sheet.
 * @param sheetName
 * @param rowIndex
 * @param cellIndex
 * @return cellValue - String
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readStringData(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trelloExcelFileData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
/**
 * this method is used to read the Numeric data from excel sheet.
 * @param sheetName
 * @param rowIndex
 * @param cellIndex
 * @return cellValue - double
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public double readNumericData(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trelloExcelFileData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
		return value;
	}
	
}
