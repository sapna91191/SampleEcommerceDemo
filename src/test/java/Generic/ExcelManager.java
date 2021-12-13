package Generic;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	public XSSFWorkbook wb;
	
	public ExcelManager(String Path) throws IOException
	{
		FileInputStream fis = new FileInputStream(Path);
		wb = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public int GetRowCount(String sheetname)
	{
		int RowCount;
		RowCount = wb.getSheet(sheetname).getLastRowNum();
		return RowCount;
	}
	
	public int GetColumnCount(String sheetname, int RowNumber)
	{
		int ColumnCount;
		ColumnCount = wb.getSheet(sheetname).getRow(RowNumber).getLastCellNum();
		return ColumnCount;
	}
	
	public String GetCellValue(String sheetname,int RowNumber,int ColumnNumber)
	{
		String cellValue = null;
		XSSFCell cell = wb.getSheet(sheetname).getRow(RowNumber).getCell(ColumnNumber);
		
		if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
		{
			boolean blnValue;
			blnValue = cell.getBooleanCellValue();
			cellValue = String.valueOf(blnValue);
		}
		else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
		{
			cellValue = null;
		}
		else if(cell.getCellType() == Cell.CELL_TYPE_STRING)
		{
			cellValue = cell.getStringCellValue();
		}
		else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
		{
			double cellVle;
			if(DateUtil.isCellDateFormatted(cell))
			{
				SimpleDateFormat format = new SimpleDateFormat("MM-DD-YYYY");
				cellValue = format.format(cell);
			}
			else
			{
				cellVle = cell.getNumericCellValue();
				cellValue = String.valueOf(cellVle);
			}
		}
		
		return cellValue;
	}
	
	public void SetCellValue(String sheetname , int RowNumber , int ColumnNumber , String cellValue)
	{
		XSSFRow row = wb.getSheet(sheetname).getRow(RowNumber);
		
		if(row == null)
		{
			wb.getSheet(sheetname).createRow(RowNumber);
		}
		
		XSSFCell cell = wb.getSheet(sheetname).getRow(RowNumber).getCell(ColumnNumber);
		
		if(cell == null)
		{
			wb.getSheet(sheetname).getRow(RowNumber).createCell(ColumnNumber);
		}
		
		wb.getSheet(sheetname).getRow(RowNumber).getCell(ColumnNumber).setCellValue(cellValue);
	}
	
	public void SaveExcel(String path) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}
	

}
