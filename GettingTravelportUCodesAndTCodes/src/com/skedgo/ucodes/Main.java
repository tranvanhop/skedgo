package com.skedgo.ucodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	private static final String FILE_PATH = "UCODES.xlsx";
	private static List<UCODES> ucodesList;
	private static FileInputStream in = null;
	private static Workbook workbook;
	private static int numberOfSheets;

	public static void main(String args[]) throws IOException {
		in = new FileInputStream(FILE_PATH);
		workbook = new XSSFWorkbook(in);
		numberOfSheets = workbook.getNumberOfSheets();

		// Method 1 : Get all UCODES from excel file
		// UCODE taken from the list UCODES
		System.out.println("Method 1 : Get all UCODES from excel file\nUCODE taken from the list UCODES");
		ucodesList = getUcodesListFromExcel();
		UCODES uCodesOne = getUcodesFromLatitudeLongitude(43.1959, -79.558);
		if(uCodesOne != null)
			System.out.println(uCodesOne.toString());
		else
			System.out.println("find not found");

		// Method 2: Get UCODES directly from excel file
		System.out.println("Method 2: Get UCODES directly from excel file");
		UCODES uCodesTwo = getUcodesFromExcel(47.8561, 5.3323);
		if(uCodesTwo != null)
			System.out.println(uCodesTwo.toString());
		else
			System.out.println("find not found");
	}
	
	// UCODE taken from the list UCODES
	public static UCODES getUcodesFromLatitudeLongitude(double lat, double lng) {
		for (int i = 0; i < ucodesList.size(); i++) {
			double latitude = Double.parseDouble(ucodesList.get(i)
					.getLatitude().trim());
			double longitude = Double.parseDouble(ucodesList.get(i)
					.getLongitude().trim());
			if (lat == latitude && lng == longitude)
				return ucodesList.get(i);
		}
		return null;
	}

	// Get All UCODES from excel
	private static List<UCODES> getUcodesListFromExcel() {
		List<UCODES> ucodesList = new ArrayList<UCODES>();

		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next();
			while (rowIterator.hasNext()) {
				UCODES ucodes = new UCODES();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						setColumnIndexTypeString(cell, ucodes);
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
						setColumnIndexTypeNumeric(cell, ucodes);
				}
				ucodesList.add(ucodes);
			}
		}
		return ucodesList;
	}

	// Method 2: Get UCODES directly from excel file
	private static UCODES getUcodesFromExcel(double lat, double lng) {
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next();
			while (rowIterator.hasNext()) {
				UCODES ucodes = new UCODES();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						setColumnIndexTypeString(cell, ucodes);
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
						setColumnIndexTypeNumeric(cell, ucodes);
				}
				double latitude = Double.parseDouble(ucodes.getLatitude()
						.trim());
				double longitude = Double.parseDouble(ucodes.getLongitude()
						.trim());
				if (lat == latitude && lng == longitude)
					return ucodes;
			}
		}
		return null;
	}

	// Set the value to a string column
	private static void setColumnIndexTypeString(Cell cell, UCODES ucodes) {
		switch (cell.getColumnIndex()) {
		case UCODES.index_station_code:
			ucodes.setStation_code(cell.getStringCellValue());
			break;
		case UCODES.index_station_name:
			ucodes.setStation_name(cell.getStringCellValue());
			break;
		case UCODES.index_iata_city:
			ucodes.setIata_city(cell.getStringCellValue());
			break;
		case UCODES.index_city_indicator:
			ucodes.setCity_indicator(cell.getStringCellValue());
			break;
		case UCODES.index_rail_distribut_ors:
			ucodes.setRail_distribut_ors(cell.getStringCellValue());
			break;
		case UCODES.index_country_code:
			ucodes.setCountry_code(cell.getStringCellValue());
			break;
		case UCODES.index_state_code:
			ucodes.setState_code(cell.getStringCellValue());
			break;
		case UCODES.index_time_zone:
			ucodes.setTime_zone(cell.getStringCellValue());
			break;
		case UCODES.index_address:
			ucodes.setAddress(cell.getStringCellValue());
			break;

		default:
			break;
		}
	}

	//set the value to a numeric column
	private static void setColumnIndexTypeNumeric(Cell cell, UCODES ucodes) {
		switch (cell.getColumnIndex()) {
		case UCODES.index_no_name:
			ucodes.setNo_name(String.valueOf(cell.getNumericCellValue()));
			break;
		case UCODES.index_latitude:
			ucodes.setLatitude(String.valueOf(cell.getNumericCellValue()));
			break;
		case UCODES.index_longitude:
			ucodes.setLongitude(String.valueOf(cell.getNumericCellValue()));
			break;

		default:
			break;
		}
	}
}
