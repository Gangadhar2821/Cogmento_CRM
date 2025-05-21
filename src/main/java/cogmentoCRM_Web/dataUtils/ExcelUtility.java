package cogmentoCRM_Web.dataUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;

public class ExcelUtility {
	public static Object[][] getExcelData(String filePath, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = cell != null ? cell.toString() : "";
				}
			}

			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}
}
