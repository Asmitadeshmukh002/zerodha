package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public static String excelData(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {
	     FileInputStream file=   new FileInputStream("C:\\Users\\hp\\Desktop\\eclipse notes\\KiteZerodha\\src\\test\\resources\\zerodha.xlsx");
	   String Data=  WorkbookFactory.create(file).getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	return Data;
}
 
}
