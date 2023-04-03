package PackageMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	XSSFSheet sh;
	
	public String readData(int i, int j) {
		Row  r=sh.getRow(i);
		Cell c=r.getCell(j);//0 numeric, 1 String
		int celltype=c.getCellType();
		switch(celltype) {
		case Cell.CELL_TYPE_NUMERIC:
		{
			double a=c.getNumericCellValue();
			return String.valueOf(a);
		}
		case Cell.CELL_TYPE_STRING:
		{
			return c.getStringCellValue();
		}
		}
		return null;
		}

	public Excel() throws IOException {
		FileInputStream f=new FileInputStream("C:\\Users\\anura\\Documents\\ExcelRead.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(f);
		sh=workbook.getSheet("Sheet1");

	}
	}
