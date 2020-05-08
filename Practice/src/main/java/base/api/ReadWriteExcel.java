package base.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	
//	public String[][] readExcel(String excelName) throws IOException {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelName = "Output";
//		XSSFWorkbook wBook = new XSSFWorkbook("./data/TC001.xlsx");
		String flname = "./data/" + excelName + ".xlsx";
		XSSFWorkbook wBook = new XSSFWorkbook(flname);
		XSSFSheet sheet = wBook.getSheet("Sheet1");
		
		//Row Count
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count : " + rowCount);
		
		//Cell count
		short columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column Count : " + columnCount);
		
//		String[][] data = new String[rowCount][columnCount];
		//neglecting header so starting from 1
		// Row iterator

		for (int i = 1; i <= rowCount; i++) {
			
			//Row
			XSSFRow firstRow = sheet.getRow(i);
			
			//Column iterator
			int j;
			for ( j = 0; j < columnCount; j++) {
				//Column
				XSSFCell cell = firstRow.getCell(j);
				// Read data
				
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.NUMERIC))
						{
						double val = cell.getNumericCellValue();
						System.out.println(val);
						}
				else
				{
					String value = cell.getStringCellValue();
					System.out.print(value + " --- ");
				}
				
//				data [i-1][j] = value;
				
			}
			System.out.println();
//			firstRow.createCell(2).setCellValue("row : " +i + " column : " + (j+1));
//			FileOutputStream fos = new FileOutputStream(flname); 
//			wBook.write(fos);
		}
//		wBook.close();
//		return data;
		//read filename from folder
		String downloadPath ="C:\\Users\\BM\\Downloads\\";
		File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    String fileName = "ExportedEstimate (1).xlsx";
	    for (int i = 0; i < dir_contents.length; i++) {
	    	if (dir_contents[i].getName().equals(fileName))
	    		System.out.println(dir_contents[i].getName());
	    }
			
	    }
}
