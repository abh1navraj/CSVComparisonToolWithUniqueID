package com.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.reader.ReportHeaderReader;
import com.util.ExcelUtil;

public class ExcelReportWriter {
	
	public void writeComparisonReportInExcel(String sourceFileName, ArrayList<ArrayList<String[]>> comparisonResult)
	{
		System.out.println(sourceFileName);
		String sourceFileNameWithoutExtension = sourceFileName.split("\\.")[0];
		ExcelUtil excelUtil = new ExcelUtil();
		SXSSFWorkbook workbook = excelUtil.createWorkbook();
		
		CellStyle headerCellStyle = excelUtil.createHeaderCellStyle(workbook);
		CellStyle overAllStatusCellStyle = excelUtil.createOverAllStatusCellStyle(workbook);
		CellStyle passedDataCellStyle  = excelUtil.createPassedDataCellStyle(workbook);
		CellStyle passedOverallStatusCellStyle  = excelUtil.createPassedOverallStatusCellStyle(workbook);

		CellStyle failedDataCellStyle = excelUtil.createFailedDataCellStyle(workbook);
		CellStyle failedOverallStatusCellStyle = excelUtil.createFailedOverallStatusCellStyle(workbook);

		CellStyle targetMissingDataCellStyle = excelUtil.createTargetMissingDataCellStyle(workbook);
		CellStyle targetMissingOverallStatusCellStyle = excelUtil.createTargetMissingOverallStatusCellStyle(workbook);
		CellStyle sourceMissingDataCellStyle = excelUtil.createSourceMissingDataCellStyle(workbook);
		CellStyle sourceMissingOverallStatusCellStyle = excelUtil.createSourceMissingOverallStatusCellStyle(workbook);
		
		
		SXSSFSheet sheet = excelUtil.createSheet(workbook, sourceFileNameWithoutExtension);

		ReportHeaderReader reportHeaderReader = new ReportHeaderReader();
		ArrayList<String> reportHeaders= reportHeaderReader.getReportHeader();
		
		SXSSFRow headerRow = excelUtil.createRow(sheet, 0);
		SXSSFCell headerCell = excelUtil.createCell(headerRow, 0);
		headerCell.setCellStyle(overAllStatusCellStyle);
		headerCell.setCellValue(reportHeaders.get(0));
		for(int i =1; i<reportHeaders.size(); i++)
		{
			headerCell = excelUtil.createCell(headerRow, i);
			headerCell.setCellStyle(headerCellStyle);
			headerCell.setCellValue(reportHeaders.get(i));
		}
		SXSSFRow row;
		SXSSFCell cell;
		for(int i =1; i<=comparisonResult.size(); i++)
		{
			row = excelUtil.createRow(sheet, i);
			int cellNum =1;
			String overAllStatus ="Pass";
			
			for(int j = 1; j<=comparisonResult.get(i-1).size(); j++)
			{
				if(comparisonResult.get(i-1).get(j-1)[2].equalsIgnoreCase("Pass"))
				{
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[0]);
					
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(passedDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[1]);
				}
				
				else if(comparisonResult.get(i-1).get(j-1)[2].equalsIgnoreCase("Record is not present in Target CSV"))
				{
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(targetMissingDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[0]);
					
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(targetMissingDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[1]);
					
					overAllStatus = "Record is not present in Target CSV";
				}
				else if(comparisonResult.get(i-1).get(j-1)[2].equalsIgnoreCase("Record is not present in Source CSV"))
				{
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(sourceMissingDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[0]);
					
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(sourceMissingDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[1]);
					
					overAllStatus = "Record is not present in Source CSV";
				}
				
				else 
				{
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[0]);
					
					cell = excelUtil.createCell(row, cellNum);
					cellNum++;
					cell.setCellStyle(failedDataCellStyle);
					cell.setCellValue(comparisonResult.get(i-1).get(j-1)[1]);
					
					overAllStatus = "Fail";
				}
			}
			
			if(overAllStatus.equalsIgnoreCase("Pass"))
			{
				cell = excelUtil.createCell(row, 0);
				cell.setCellStyle(passedOverallStatusCellStyle);
				cell.setCellValue("Pass");
			}
			else if(overAllStatus.equalsIgnoreCase("Record is not present in Target CSV"))
			{
				cell = excelUtil.createCell(row, 0);
				cell.setCellStyle(targetMissingOverallStatusCellStyle);
				cell.setCellValue("Record is not present in Target CSV");
			}
			else if(overAllStatus.equalsIgnoreCase("Record is not present in Source CSV"))
			{
				cell = excelUtil.createCell(row, 0);
				cell.setCellStyle(sourceMissingOverallStatusCellStyle);
				cell.setCellValue("Record is not present in Source CSV");
			}
			else
			{
				cell = excelUtil.createCell(row, 0);
				cell.setCellStyle(failedOverallStatusCellStyle);
				cell.setCellValue("Fail");
			}
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./Reports/" + sourceFileNameWithoutExtension + ".xlsx");
			workbook.write(fos); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
		
	
	}

}
