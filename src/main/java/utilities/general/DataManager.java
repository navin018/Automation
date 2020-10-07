package utilities.general;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.SimpleFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

public class DataManager {

	Map<String, Integer> excelMetaData = new HashMap<String, Integer>();

	private void loadMetaData() {
		excelMetaData.put("nino", 0);
		excelMetaData.put("firstname", 1);
		excelMetaData.put("lastname", 2);
		excelMetaData.put("date", 3);
		excelMetaData.put("month", 3);
		excelMetaData.put("year", 3);
		excelMetaData.put("postcode", 4);
		excelMetaData.put("address", 5);
		excelMetaData.put("town", 6);
		excelMetaData.put("agentid", 8);
		excelMetaData.put("gender", 10);
		excelMetaData.put("title", 7);

	}

	/**
	 * gets test data from json files
	 */
	public static <T> T getData(String path, String dataGroup, Class<T> clazz)
			throws IOException {
		String filePath = path + dataGroup + ".json";
		Gson gson = new Gson();
		File file = new File(filePath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			// br = new BufferedReader(new InputStreamReader(new
			// FileInputStream(file),
			// Property.getProperty("testdataencoding")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return gson.fromJson(br, clazz);

	}

	/**
	 * gets test data from a given sheet in excel returning all rows and columns
	 * matching the supplied recordset (col A)
	 */
	public static ArrayList<ArrayList<Object>> getData(String filepath,
			String worksheet, String recordSet) throws IOException {

		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		FileInputStream file = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(worksheet);
		int maxDataCount = 0;
		// Iterate through each rows one by one

		try {
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				// Skip the first row beacause it will be header and also get
				// column count
				if (row.getRowNum() == 0) {
					maxDataCount = row.getLastCellNum();
					continue;
				}

				// if row is empty then break the loop,do not go further
				if (isRowEmpty(row, maxDataCount)) {
					break;
				}

				ArrayList<Object> singleRows = new ArrayList<Object>();

				// For each row, iterate through all the columns

				for (int c = 0; c < maxDataCount; c++) {

					Cell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							singleRows.add(new SimpleDateFormat("yyyy-MM-dd")
									.format(cell.getDateCellValue()));
						} else {
							singleRows.add(cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_STRING:
						singleRows.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						singleRows.add(null);
						break;
					default:
						singleRows.add(cell.getStringCellValue());
					}
				}

				data.add(singleRows);

			}

			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	
	public static void obtainFileLock(FileInputStream file){
		try{
			java.nio.channels.FileLock lock = file.getChannel().lock();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void releaseFileLock(FileInputStream file){
		try {
			file.getChannel().lock().release();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getData(Class<?> clazz) throws IntrospectionException,
			IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException, ParseException {
		loadMetaData();
		List<Object> rowValues = new ArrayList<Object>();
		FileInputStream file = new FileInputStream("C://nino.xlsx");
//		obtainFileLock(file);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> sheetIterator = sheet.iterator();
		int rowNum = 0;
		int colNum = 0;
		while (sheetIterator.hasNext() && rowValues.size() !=1) {

			Row row1 = sheetIterator.next();
			Row row = sheetIterator.next();
			rowNum = row.getRowNum();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
					continue;
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						rowValues.add(new SimpleDateFormat("yyyy-MM-dd")
								.format(cell.getDateCellValue()));
					} else {
						rowValues.add(new BigDecimal(cell.getNumericCellValue()));
					}
					break;
				case Cell.CELL_TYPE_STRING:
					rowValues.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BLANK:
					rowValues.add(null);
					break;
				default:
					rowValues.add(cell.getStringCellValue());
				}
				colNum = cell.getColumnIndex();
				if ("Y".equals(rowValues.get(rowValues.size()-1))) {
					rowValues.clear();
					break;
				}
			}
		}
		FileOutputStream outfile = null;
		if(!clazz.getCanonicalName().equals("com.acn.uc.cukes.dataobjects.LoginInfoDO")){
			Cell updatedCell = sheet.getRow(rowNum).getCell(colNum);
			
			updatedCell.setCellValue("Y");
			
			outfile = new FileOutputStream(new File("C://nino.xlsx"));
			workbook.write(outfile);
		}
//		releaseFileLock(file);
		file.close();
		if(outfile != null)
			outfile.close();

		BeanInfo info = Introspector.getBeanInfo(clazz);
		Constructor<?> constructor = clazz.getConstructor();
		Object obj = constructor.newInstance();
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			Method setterMethod = pd.getWriteMethod();
			if (setterMethod == null)
				continue;
			String field = pd.getDisplayName();
			Iterator entry = excelMetaData.entrySet().iterator();
			while (entry.hasNext()) {
				Map.Entry pair = (Entry) entry.next();
				if(field.equalsIgnoreCase("NiNumber")){
					setterMethod.invoke(obj, rowValues.get(0));
				}
				if (field.equalsIgnoreCase((String) pair.getKey())) {
					if(field.equalsIgnoreCase("gender")){
						setterMethod.invoke(obj, Math.random() % 2 == 0 ? "Male" : "Female");
					}else if(field.equalsIgnoreCase("date")||field.equalsIgnoreCase("month")||field.equalsIgnoreCase("year")){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date1 = sdf.parse(rowValues.get(Integer.parseInt(pair.getValue().toString())).toString());
						String date = sdf.format(date1);
						String dob[] = date.split("-");
						String data="";
						if(field.equalsIgnoreCase("date"))
							data = dob[2];
						else if(field.equalsIgnoreCase("month"))data=dob[1];
						else data=dob[0];
						setterMethod.invoke(obj, data);
						break;
					} else {
						setterMethod.invoke(obj, (Object) rowValues.get(Integer
								.parseInt(pair.getValue().toString())));
						break;
					}
				} else if (field.toLowerCase().contains((String) pair.getKey())
						|| ((String) pair.getKey()).contains(field.toLowerCase())) {
					setterMethod.invoke(obj, (Object)rowValues.get(Integer.parseInt(pair.getValue().toString())));
					break;
				}
			}
		}
		return obj;
	}

	public static boolean isRowEmpty(Row row, int lastcellno) {

		for (int c = row.getFirstCellNum(); c < lastcellno; c++) {
			Cell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
				return false;
			}
		}
		return true;
	}

}
