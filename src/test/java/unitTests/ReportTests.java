package unitTests;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import com.util.ExcelUtil;
import com.writer.ColerCodeTableWriter;

public class ReportTests {
	
	@Test
	public void testColorCodeMethod()
	{
		ExcelUtil excelUtil = new ExcelUtil();
		SXSSFWorkbook workbook = excelUtil.createWorkbook();
		
		ColerCodeTableWriter colorCodeTableWriter = new ColerCodeTableWriter();
		colorCodeTableWriter.writeColorCodeTable(workbook);
	
	}

}
