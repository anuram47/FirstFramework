package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilClass {

	/**
	 * 
	 * @param path 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropFile(String path, String key) throws Throwable {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fis);
		String value  =pro.getProperty(key);
		return value;
	}

	/**
	 * 
	 * @param path
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readingDataFromExcel(String path, String sheetname, int rowNum, int colNum) 
			throws EncryptedDocumentException, IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(path);
		Workbook book= WorkbookFactory.create(file);
		String data = book.getSheet(sheetname).getRow(rowNum).getCell(colNum).getStringCellValue().toString();
		return data;
	}

	/**
	 * 
	 * @param path
	 * @param sheetname
	 * @param rowNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String [][] toReadMultipleRowColData(String path, String sheetname) throws EncryptedDocumentException, IOException {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook workBook = WorkbookFactory.create(fis);

		int numOfRows = workBook.getSheet(sheetname).getPhysicalNumberOfRows();
		int numOfCol = workBook.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
		String [][] data= new String[numOfRows][numOfCol];
		for (int i = 0; i < numOfRows; i++) {

			for (int j = 0; j < numOfCol; j++) {
				data[i][j] = workBook.getSheet(sheetname).getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

	/**
	 * 
	 * @param path
	 * @param sheetname
	 * @param rowNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String [] toReadSigleRowData(String path, String sheetname, int rowNum) throws EncryptedDocumentException, IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book= WorkbookFactory.create(fis);
		int numOfCol = book.getSheet(sheetname).getRow(rowNum).getPhysicalNumberOfCells();

		String [] data= new String[numOfCol];
		for (int j = 0; j < numOfCol; j++) {
			data[j] = book.getSheet(sheetname).getRow(rowNum).getCell(j).toString();
		}
		return data;
	}
	/**
	 * 
	 * @param path
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public static String [][] toReadMultipleData(String path, String sheetname) throws EncryptedDocumentException, IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book= WorkbookFactory.create(fis);
		int noOfRow = book.getSheet(sheetname).getPhysicalNumberOfRows();
		int noOfCol = book.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
		String [][] data = new String[noOfRow][noOfCol];

		for (int i = 0; i < noOfRow; i++) {
			for (int j = 0; j < noOfCol; j++) {
				data[i][j] = book.getSheet(sheetname).getRow(i).getCell(j).getStringCellValue().toString();
			}

		}
		return data;
	}

}
