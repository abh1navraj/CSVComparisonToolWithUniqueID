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
	 * @return a new SXSSFRow
	 */
	public SXSSFRow createRow(SXSSFSheet sheet, int rowNum) {
		SXSSFRow row = sheet.createRow(rowNum);
		return row;
		
	}
	/**
	 * Creates a SXSSFCell
	 * @param row
	 * @param cellNum
	 * @return a new SXSSFCell
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
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		
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
		overAllStatusCellStyle.setBorderBottom(BorderStyle.THIN);
		overAllStatusCellStyle.setBorderTop(BorderStyle.THIN);
		overAllStatusCellStyle.setBorderLeft(BorderStyle.THIN);
		overAllStatusCellStyle.setBorderRight(BorderStyle.THIN);
		
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
		passedDataCellStyle.setBorderBottom(BorderStyle.THIN);
		passedDataCellStyle.setBorderTop(BorderStyle.THIN);
		passedDataCellStyle.setBorderLeft(BorderStyle.THIN);
		passedDataCellStyle.setBorderRight(BorderStyle.THIN);
		

		return passedDataCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for matched data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createPassedOverallStatusCellStyle(SXSSFWorkbook workbook) {
		CellStyle passedOverallStatusCellStyle = workbook.createCellStyle();
		passedOverallStatusCellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		passedOverallStatusCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		passedOverallStatusCellStyle.setBorderBottom(BorderStyle.THIN);
		passedOverallStatusCellStyle.setBorderTop(BorderStyle.THIN);
		passedOverallStatusCellStyle.setBorderLeft(BorderStyle.THIN);
		passedOverallStatusCellStyle.setBorderRight(BorderStyle.THIN);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		passedOverallStatusCellStyle.setFont(font);
		
		return passedOverallStatusCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for mismatched data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createFailedDataCellStyle(SXSSFWorkbook workbook) {
		CellStyle failedDataCellStyle = workbook.createCellStyle();
		failedDataCellStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		failedDataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedDataCellStyle.setBorderBottom(BorderStyle.THIN);
		failedDataCellStyle.setBorderTop(BorderStyle.THIN);
		failedDataCellStyle.setBorderLeft(BorderStyle.THIN);
		failedDataCellStyle.setBorderRight(BorderStyle.THIN);
		

		return failedDataCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for mismatched data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createFailedOverallStatusCellStyle(SXSSFWorkbook workbook) {
		CellStyle failedOverallStatusCellStyle = workbook.createCellStyle();
		failedOverallStatusCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		failedOverallStatusCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedOverallStatusCellStyle.setBorderBottom(BorderStyle.THIN);
		failedOverallStatusCellStyle.setBorderTop(BorderStyle.THIN);
		failedOverallStatusCellStyle.setBorderLeft(BorderStyle.THIN);
		failedOverallStatusCellStyle.setBorderRight(BorderStyle.THIN);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		failedOverallStatusCellStyle.setFont(font);
		
		return failedOverallStatusCellStyle;
	}
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createTargetMissingDataCellStyle(SXSSFWorkbook workbook) {
		CellStyle targetMissingDataCellStyle = workbook.createCellStyle();
		targetMissingDataCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		targetMissingDataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		targetMissingDataCellStyle.setBorderBottom(BorderStyle.THIN);
		targetMissingDataCellStyle.setBorderTop(BorderStyle.THIN);
		targetMissingDataCellStyle.setBorderLeft(BorderStyle.THIN);
		targetMissingDataCellStyle.setBorderRight(BorderStyle.THIN);
		

		return targetMissingDataCellStyle;
	}
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createTargetMissingOverallStatusCellStyle(SXSSFWorkbook workbook) {
		CellStyle targetMissingOverallStatusCellStyle = workbook.createCellStyle();
		targetMissingOverallStatusCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		targetMissingOverallStatusCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		targetMissingOverallStatusCellStyle.setBorderBottom(BorderStyle.THIN);
		targetMissingOverallStatusCellStyle.setBorderTop(BorderStyle.THIN);
		targetMissingOverallStatusCellStyle.setBorderLeft(BorderStyle.THIN);
		targetMissingOverallStatusCellStyle.setBorderRight(BorderStyle.THIN);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		targetMissingOverallStatusCellStyle.setFont(font);

		return targetMissingOverallStatusCellStyle;
	}
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createSourceMissingDataCellStyle(SXSSFWorkbook workbook) {
		CellStyle sourceMissingDataCellStyle = workbook.createCellStyle();
		sourceMissingDataCellStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		sourceMissingDataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		sourceMissingDataCellStyle.setBorderBottom(BorderStyle.THIN);
		sourceMissingDataCellStyle.setBorderTop(BorderStyle.THIN);
		sourceMissingDataCellStyle.setBorderLeft(BorderStyle.THIN);
		sourceMissingDataCellStyle.setBorderRight(BorderStyle.THIN);
		

		return sourceMissingDataCellStyle;
	}
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new CellStyle
	 */
	public CellStyle createSourceMissingOverallStatusCellStyle(SXSSFWorkbook workbook) {
		CellStyle sourceMissingOverallStatusCellStyle = workbook.createCellStyle();
		sourceMissingOverallStatusCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		sourceMissingOverallStatusCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		sourceMissingOverallStatusCellStyle.setBorderBottom(BorderStyle.THIN);
		sourceMissingOverallStatusCellStyle.setBorderTop(BorderStyle.THIN);
		sourceMissingOverallStatusCellStyle.setBorderLeft(BorderStyle.THIN);
		sourceMissingOverallStatusCellStyle.setBorderRight(BorderStyle.THIN);
		
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		sourceMissingOverallStatusCellStyle.setFont(font);

		return sourceMissingOverallStatusCellStyle;
	}


}
