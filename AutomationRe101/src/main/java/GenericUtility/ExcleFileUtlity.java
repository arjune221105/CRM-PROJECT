package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.events.EventException;

public class ExcleFileUtlity {

	public String toReadDataFromExcleFile(String sheetname, int row, int col) throws EventException, IOException {
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\Qjspiderdata.xlsx");

		Workbook wb = WorkbookFactory.create(efis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(col).toString();
		return value;

	}

}
