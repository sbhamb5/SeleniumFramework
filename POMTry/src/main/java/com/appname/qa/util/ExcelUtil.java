package com.appname.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static FileInputStream stream;
	private static XSSFWorkbook workbook;
	private static XSSFSheet workSheet;

	public ExcelUtil(String path) throws IOException {
		stream = new FileInputStream(path);
		workbook = new XSSFWorkbook(stream);
		workSheet = workbook.getSheetAt(0);
	}

	public ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> data = new ArrayList<Object[]>();

		Iterator<Row> rowIterator = workSheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue;
			}

			String login = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			Object[] obj = { login, password };
			data.add(obj);
		}

		return data;
	}

}
