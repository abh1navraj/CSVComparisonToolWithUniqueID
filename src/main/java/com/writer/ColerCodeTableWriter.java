package com.writer;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import com.util.ExcelUtil;

public class ColerCodeTableWriter {
	
	public void writeColorCodeTable(SXSSFWorkbook workbook)
	{
		ExcelUtil excelUtil = new ExcelUtil();
		XSSFCellStyle overAllStatusXSSFCellStyle = excelUtil.createOverAllStatusXSSFCellStyle(workbook);
		overAllStatusXSSFCellStyle.setAlignment(HorizontalAlignment.CENTER);
		XSSFCellStyle headerXSSFCellStyle = excelUtil.createHeaderXSSFCellStyle(workbook);
		XSSFCellStyle generalDataCellStyle = excelUtil.createGeneralDataXSSFCellStyle(workbook);

		ArrayList<XSSFCellStyle> cellStyleList = new ArrayList<XSSFCellStyle>();
		XSSFCellStyle sourceMissingDataXSSFCellStyle = excelUtil.createSourceMissingDataXSSFCellStyle(workbook);
		cellStyleList.add(sourceMissingDataXSSFCellStyle);
		XSSFCellStyle targetMissingDataXSSFCellStyle = excelUtil.createTargetMissingDataXSSFCellStyle(workbook);
		cellStyleList.add(targetMissingDataXSSFCellStyle);
		XSSFCellStyle failedInvalidDateFormatXSSFCellStyle = excelUtil.createFailInvalidDateFormatXSSFCellStyle(workbook);
		cellStyleList.add(failedInvalidDateFormatXSSFCellStyle);
		XSSFCellStyle failedDataXSSFCellStyle = excelUtil.createFailedDataXSSFCellStyle(workbook);
		cellStyleList.add(failedDataXSSFCellStyle);
		XSSFCellStyle passButInvalidDateFormatXSSFCellStyle = excelUtil.createPassInvalidDateFormatXSSFCellStyle(workbook);
		cellStyleList.add(passButInvalidDateFormatXSSFCellStyle);
		XSSFCellStyle passedDataXSSFCellStyle = excelUtil.createPassedDataXSSFCellStyle(workbook);
		cellStyleList.add(passedDataXSSFCellStyle);
		
		HashMap<XSSFCellStyle, String[]> colorCodeMap = new HashMap<XSSFCellStyle, String[]>();
		String[] colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Source Missing";
		colorCodeDetails[1] = "The Records Present in Target CSV is not Present in Source CSV. (Extra Target Records)";
		colorCodeMap.put(sourceMissingDataXSSFCellStyle, colorCodeDetails);
		colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Target Missing";
		colorCodeDetails[1] = "The Records Present in Source CSV is not Present in Target CSV. (Extra Source Records)";
		colorCodeMap.put(targetMissingDataXSSFCellStyle, colorCodeDetails);
		colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Mismatch and Invalid Date Format";
		colorCodeDetails[1] = "There is mismatch between Source and Target Property and also date format are not matching with the format specified in the properties file";
		colorCodeMap.put(failedInvalidDateFormatXSSFCellStyle, colorCodeDetails);
		colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Mismatch";
		colorCodeDetails[1] = "There is mismatch between Source and Target Property.";
		colorCodeMap.put(failedDataXSSFCellStyle, colorCodeDetails);
		colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Match and Invalid Date format";
		colorCodeDetails[1] = "Matched but Date format not matching with specified format in property file";
		colorCodeMap.put(passButInvalidDateFormatXSSFCellStyle, colorCodeDetails);
		colorCodeDetails = new String[2];
		colorCodeDetails[0] = "Match";
		colorCodeDetails[1] = "Matched";
		colorCodeMap.put(passedDataXSSFCellStyle, colorCodeDetails);

		
		SXSSFSheet colorCodeSheet = excelUtil.createSheet(workbook, "Color Code Table");
		colorCodeSheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
		SXSSFRow row = excelUtil.createRow(colorCodeSheet, 1);
		SXSSFCell cell = excelUtil.createCell(row, 1);
		cell.setCellValue("Color Code Table");
		
		cell.setCellStyle(overAllStatusXSSFCellStyle);
		cell = excelUtil.createCell(row, 2);
		cell.setCellStyle(overAllStatusXSSFCellStyle);
		cell = excelUtil.createCell(row, 3);
		cell.setCellStyle(overAllStatusXSSFCellStyle);

		row = excelUtil.createRow(colorCodeSheet, 2);
		cell = excelUtil.createCell(row, 1);
		cell.setCellValue("Priority Order");
		cell.setCellStyle(headerXSSFCellStyle);
		cell = excelUtil.createCell(row, 2);
		cell.setCellValue("Cell Style");
		cell.setCellStyle(headerXSSFCellStyle);
		cell = excelUtil.createCell(row, 3);
		cell.setCellValue("Style Description");
		cell.setCellStyle(headerXSSFCellStyle);
		
		int rowNum = 2, priorityOrder =0;
		for(XSSFCellStyle cellStyle: cellStyleList) {
			
			rowNum++; priorityOrder++;
			String[] colorCode = colorCodeMap.get(cellStyle);
			row = excelUtil.createRow(colorCodeSheet, rowNum);
			cell = excelUtil.createCell(row, 1);
			cell.setCellValue(priorityOrder);
			cell.setCellStyle(generalDataCellStyle);
			
			cell = excelUtil.createCell(row, 2);
			cell.setCellValue(colorCode[0]);
			cell.setCellStyle(cellStyle);
//			cell.setCellStyle(headerXSSFCellStyle);
			cell = excelUtil.createCell(row, 3);
			cell.setCellValue(colorCode[1]);
			cell.setCellStyle(generalDataCellStyle);

//			cell.setCellStyle(headerXSSFCellStyle);
			
			
		}
		
		
	
		
		
		
		
	}

}
