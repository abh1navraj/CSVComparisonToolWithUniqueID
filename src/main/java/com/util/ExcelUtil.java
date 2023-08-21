package com.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class ExcelUtil {
	/**
	 * creates a SXSSFWorkbook
	 * @return a new SXSSFWorkbook
	 */
	public SXSSFWorkbook createWorkbook() {
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);
		workbook.setCompressTempFiles(true);
		return workbook;
		
	}
	/**
	 * creates a SXSSFSheet
	 * @param workbook
	 * @param sheetName
	 * @return a new SXSSFSheet
	 */
	public SXSSFSheet createSheet(SXSSFWorkbook workbook, String sheetName) {
		SXSSFSheet sheet = workbook.createSheet(sheetName);
		return sheet;
	}
	/**
	 * Creates a SXSSFRow
	 * @param sheet
	 * @param rowNum
	 * @return a new XSSFRow
	 */
	public SXSSFRow createRow(SXSSFSheet sheet, int rowNum) {
		SXSSFRow row = sheet.createRow(rowNum);
		return row;
		
	}
	/**
	 * Creates a SXSSFCell
	 * @param row
	 * @param cellNum
	 * @return a new XSSFCell
	 */
	public SXSSFCell createCell(SXSSFRow row, int cellNum) {
		SXSSFCell cell = row.createCell(cellNum);
		return cell;
	}
	
	/**
	 * creates a header cell style
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createHeaderCellStyle(SXSSFWorkbook workbook) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerCellStyle.setBorderBottom(BorderStyle.THICK);
		headerCellStyle.setBorderTop(BorderStyle.THICK);
		headerCellStyle.setBorderLeft(BorderStyle.THICK);
		headerCellStyle.setBorderRight(BorderStyle.THICK);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		headerCellStyle.setFont(font);

		return headerCellStyle;
	}
	
	/**
	 * Creates a cell styel for overall status cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createOverAllStatusCellStyle(SXSSFWorkbook workbook) {
		CellStyle overAllStatusCellStyle = workbook.createCellStyle();
		overAllStatusCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		overAllStatusCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		overAllStatusCellStyle.setBorderBottom(BorderStyle.THICK);
		overAllStatusCellStyle.setBorderTop(BorderStyle.THICK);
		overAllStatusCellStyle.setBorderLeft(BorderStyle.THICK);
		overAllStatusCellStyle.setBorderRight(BorderStyle.THICK);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		overAllStatusCellStyle.setFont(font);

		return overAllStatusCellStyle;
	}
	
	/**
	 * Creates a cell style for matched data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createPassedDataCellStyle(SXSSFWorkbook workbook) {
		CellStyle passedDataCellStyle = workbook.createCellStyle();
		passedDataCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		passedDataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		passedDataCellStyle.setBorderBottom(BorderStyle.THICK);
		passedDataCellStyle.setBorderTop(BorderStyle.THICK);
		passedDataCellStyle.setBorderLeft(BorderStyle.THICK);
		passedDataCellStyle.setBorderRight(BorderStyle.THICK);
		

		return passedDataCellStyle;
	}
	
	/**
	 * Creates a cell style for mismatched data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createFailedDataCellStyle(SXSSFWorkbook workbook) {
		CellStyle failedDataCellStyle = workbook.createCellStyle();
		failedDataCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		failedDataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedDataCellStyle.setBorderBottom(BorderStyle.THICK);
		failedDataCellStyle.setBorderTop(BorderStyle.THICK);
		failedDataCellStyle.setBorderLeft(BorderStyle.THICK);
		failedDataCellStyle.setBorderRight(BorderStyle.THICK);
		

		return failedDataCellStyle;
	}

}
