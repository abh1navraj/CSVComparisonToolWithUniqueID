package com.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import com.base.Base;
import com.reader.ReportHeaderReader;
import com.util.ExcelUtil;

public class ExcelReportWriter extends Base {

	public void writeComparisonReportInExcel(String sourceFileName, ArrayList<ArrayList<String[]>> comparisonResult) {
		System.out.println(sourceFileName);
		String sourceFileNameWithoutExtension = sourceFileName.split("\\.")[0];
		ExcelUtil excelUtil = new ExcelUtil();
		SXSSFWorkbook workbook = excelUtil.createWorkbook();

		
		
		XSSFCellStyle headerXSSFCellStyle = excelUtil.createHeaderXSSFCellStyle(workbook);
		XSSFCellStyle overAllStatusXSSFCellStyle = excelUtil.createOverAllStatusXSSFCellStyle(workbook);
		XSSFCellStyle passedDataXSSFCellStyle = excelUtil.createPassedDataXSSFCellStyle(workbook);
//		XSSFCellStyle passedOverallStatusXSSFCellStyle = excelUtil.createPassedOverallStatusXSSFCellStyle(workbook);
		XSSFCellStyle passButInvalidDateFormatXSSFCellStyle = excelUtil.createPassInvalidDateFormatXSSFCellStyle(workbook);

		XSSFCellStyle failedDataXSSFCellStyle = excelUtil.createFailedDataXSSFCellStyle(workbook);
//		XSSFCellStyle failedOverallStatusXSSFCellStyle = excelUtil.createFailedOverallStatusXSSFCellStyle(workbook);
		XSSFCellStyle failedInvalidDateFormatXSSFCellStyle = excelUtil.createFailInvalidDateFormatXSSFCellStyle(workbook);

		XSSFCellStyle targetMissingDataXSSFCellStyle = excelUtil.createTargetMissingDataXSSFCellStyle(workbook);
//		XSSFCellStyle targetMissingOverallStatusXSSFCellStyle = excelUtil.createTargetMissingOverallStatusXSSFCellStyle(workbook);
		XSSFCellStyle sourceMissingDataXSSFCellStyle = excelUtil.createSourceMissingDataXSSFCellStyle(workbook);
//		XSSFCellStyle sourceMissingOverallStatusXSSFCellStyle = excelUtil.createSourceMissingOverallStatusXSSFCellStyle(workbook);

		
		
		
		SXSSFSheet sheet = excelUtil.createSheet(workbook, sourceFileNameWithoutExtension);

		ReportHeaderReader reportHeaderReader = new ReportHeaderReader();
		ArrayList<String> reportHeaders = reportHeaderReader.getReportHeader(sourceFileName);

		SXSSFRow headerRow = excelUtil.createRow(sheet, 0);
		SXSSFCell headerCell = excelUtil.createCell(headerRow, 0);
		
		headerCell.setCellStyle(overAllStatusXSSFCellStyle);
		
		headerCell.setCellValue(reportHeaders.get(0));
		for (int i = 1; i < reportHeaders.size(); i++) {
			headerCell = excelUtil.createCell(headerRow, i);
			headerCell.setCellStyle(headerXSSFCellStyle);
			headerCell.setCellValue(reportHeaders.get(i));
		}
		SXSSFRow row;
		SXSSFCell cell;
		for (int i = 1; i <= comparisonResult.size(); i++) {
			row = excelUtil.createRow(sheet, i);
			int cellNum = 1;
			String overAllStatus = "Pass";

			for (int j = 1; j <= comparisonResult.get(i - 1).size(); j++) {
				if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("Record is not present in Source CSV")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(sourceMissingDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(sourceMissingDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					overAllStatus = "Record is not present in Source CSV";
				}

				else if (comparisonResult.get(i - 1).get(j - 1)[2]
						.equalsIgnoreCase("Record is not present in Target CSV")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(targetMissingDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(targetMissingDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					overAllStatus = "Record is not present in Target CSV";
				}

				else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("FailInvalidBoth")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					overAllStatus = "FailInvalid";
				}

				else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("FailInvalidSource")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					overAllStatus = "FailInvalid";
				}

				else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("FailInvalidTarget")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					overAllStatus = "FailInvalid";
				}

				else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("Fail")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					if (overAllStatus.equals("Pass"))
						overAllStatus = "Fail";
					if (overAllStatus.equals("PassInvalid"))
						overAllStatus = "FailInvalid";
				} else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("PassInvalidBoth")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passButInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passButInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					if (overAllStatus.equals("Pass"))
						overAllStatus = "PassInvalid";
					if (overAllStatus.equals("Fail"))
						overAllStatus = "FailInvalid";
					

				} else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("PassInvalidSource")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passButInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					if (overAllStatus.equals("Pass"))
						overAllStatus = "PassInvalid";
					if (overAllStatus.equals("Fail"))
						overAllStatus = "FailInvalid";
				} else if (comparisonResult.get(i - 1).get(j - 1)[2].equalsIgnoreCase("PassInvalidTarget")) {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passButInvalidDateFormatXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);

					if (overAllStatus.equals("Pass"))
						overAllStatus = "PassInvalid";
					if (overAllStatus.equals("Fail"))
						overAllStatus = "FailInvalid";
				} else {
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[0]);

					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataXSSFCellStyle);
					cell.setCellValue(comparisonResult.get(i - 1).get(j - 1)[1]);
				}
			}

			if (overAllStatus.equalsIgnoreCase("Pass")) {
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Pass");
				cell.setCellStyle(passedDataXSSFCellStyle);
			} 
			else if (overAllStatus.equalsIgnoreCase("PassInvalid")) {
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Pass");
				cell.setCellStyle(passButInvalidDateFormatXSSFCellStyle);

			}
			else if (overAllStatus.equalsIgnoreCase("Record is not present in Target CSV")) {
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Record is not present in Target CSV");
				cell.setCellStyle(targetMissingDataXSSFCellStyle);
			} else if (overAllStatus.equalsIgnoreCase("Record is not present in Source CSV")) {
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Record is not present in Source CSV");
				cell.setCellStyle(sourceMissingDataXSSFCellStyle);
			} 
			else if(overAllStatus.equalsIgnoreCase("FailInvalid")){
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Fail");
				cell.setCellStyle(failedInvalidDateFormatXSSFCellStyle);
			}
			else {
				cell = excelUtil.createCell(row, 0);
				cell.setCellValue("Fail");
				cell.setCellStyle(failedDataXSSFCellStyle);
			}
		}
		
		ColerCodeTableWriter colorCodeTableWriter = new ColerCodeTableWriter();
		colorCodeTableWriter.writeColorCodeTable(workbook);
		
			 
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./Reports/" + sourceFileNameWithoutExtension + ".xlsx");
			workbook.write(fos);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
		System.out.println("========Completed==========");
	}

}
