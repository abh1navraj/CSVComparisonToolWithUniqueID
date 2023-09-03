package com.util;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createHeaderXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle headerXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		headerXSSFCellStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
		headerXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		headerXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		headerXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		headerXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(true);
		headerXSSFCellStyle.setFont(font);

		return headerXSSFCellStyle;
	}
	
	/**
	 * Creates a cell styel for overall status cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createOverAllStatusXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle overAllStatusXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		overAllStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		overAllStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		overAllStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		overAllStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		overAllStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		overAllStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(true);
		overAllStatusXSSFCellStyle.setFont(font);

		return overAllStatusXSSFCellStyle;
	}
	
	/**
	 * Creates a cell style for matched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createPassedDataXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle passedDataXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		passedDataXSSFCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		passedDataXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		passedDataXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		passedDataXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		passedDataXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		passedDataXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		

		return passedDataXSSFCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for matched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createPassedOverallStatusXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle passedOverallStatusXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		passedOverallStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		passedOverallStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		passedOverallStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		passedOverallStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		passedOverallStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		passedOverallStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(true);
		passedOverallStatusXSSFCellStyle.setFont(font);
		
		return passedOverallStatusXSSFCellStyle;
	}
	
	/**
	 * Creates a Passed date with Invalid date format cell style for matched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createPassInvalidDateFormatXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle passInvalidDateFormatXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		passInvalidDateFormatXSSFCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		passInvalidDateFormatXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		passInvalidDateFormatXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		passInvalidDateFormatXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		passInvalidDateFormatXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		passInvalidDateFormatXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(false);
		font.setColor(HSSFColorPredefined.RED.getIndex());
		passInvalidDateFormatXSSFCellStyle.setFont(font);
		
		return passInvalidDateFormatXSSFCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for mismatched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createFailedDataXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle failedDataXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		failedDataXSSFCellStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		failedDataXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedDataXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		failedDataXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		failedDataXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		failedDataXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		

		return failedDataXSSFCellStyle;
	}
	
	/**
	 * Creates a overall status cell style for mismatched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createFailedOverallStatusXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle failedOverallStatusXSSFCellStyle = (XSSFCellStyle) ((SXSSFWorkbook) workbook).createCellStyle();
		failedOverallStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		failedOverallStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedOverallStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(false);
		failedOverallStatusXSSFCellStyle.setFont(font);
		
		return failedOverallStatusXSSFCellStyle;
	}
	
	/**
	 * Creates a Fail Invalid Date Format cell style for mismatched data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createFailInvalidDateFormatXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle failedOverallStatusXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		failedOverallStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		failedOverallStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		failedOverallStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		failedOverallStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(false);
		font.setColor(HSSFColorPredefined.DARK_RED.getIndex());
		failedOverallStatusXSSFCellStyle.setFont(font);
		
		return failedOverallStatusXSSFCellStyle;
	}
	
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createTargetMissingDataXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle targetMissingDataXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		targetMissingDataXSSFCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		targetMissingDataXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		targetMissingDataXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		targetMissingDataXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		targetMissingDataXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		targetMissingDataXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		

		return targetMissingDataXSSFCellStyle;
	}
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createTargetMissingOverallStatusXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle targetMissingOverallStatusXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		targetMissingOverallStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		targetMissingOverallStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		targetMissingOverallStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		targetMissingOverallStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		targetMissingOverallStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		targetMissingOverallStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(true);
		targetMissingOverallStatusXSSFCellStyle.setFont(font);

		return targetMissingOverallStatusXSSFCellStyle;
	}
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createSourceMissingDataXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle sourceMissingDataXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		sourceMissingDataXSSFCellStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		sourceMissingDataXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		sourceMissingDataXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		sourceMissingDataXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		sourceMissingDataXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		sourceMissingDataXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		

		return sourceMissingDataXSSFCellStyle;
	}
	
	/**
	 * Creates a cell style for target missing data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createSourceMissingOverallStatusXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle sourceMissingOverallStatusXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		sourceMissingOverallStatusXSSFCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		sourceMissingOverallStatusXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		sourceMissingOverallStatusXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		sourceMissingOverallStatusXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		sourceMissingOverallStatusXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		sourceMissingOverallStatusXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		Font font = workbook.createFont();
		font.setBold(true);
		sourceMissingOverallStatusXSSFCellStyle.setFont(font);

		return sourceMissingOverallStatusXSSFCellStyle;
	}
	
	/**
	 * Creates a cell style for general data cell
	 * @param workbook
	 * @return a new XSSFCellStyle
	 */
	public XSSFCellStyle createGeneralDataXSSFCellStyle(SXSSFWorkbook workbook) {
		XSSFCellStyle generalDataXSSFCellStyle = (XSSFCellStyle) workbook.createCellStyle();
		generalDataXSSFCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		generalDataXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		generalDataXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
		generalDataXSSFCellStyle.setBorderTop(BorderStyle.THIN);
		generalDataXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
		generalDataXSSFCellStyle.setBorderRight(BorderStyle.THIN);
		
		

		return generalDataXSSFCellStyle;
	}
	
	public XSSFFont getHeaderFont() {
		XSSFFont font = new XSSFFont();
		font.setBold(true);
		
		return font;

	}


}
