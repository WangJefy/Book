//package book.io;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import org.apache.poi.hssf.usermodel.*;
//
///**
// * 操作Excel文件
// * 创建人：     Jefy
// * 项目名：     Book	
// * 类名：         ExcelFile
// * 创建时间： 2018年1月19日下午1:37:01
// * 修改人：     Jefy
// * 类描述：
// */
//public class ExcelFile {
//	
//	@SuppressWarnings("unchecked")
//	public void writeExcel(String fileName) {
//		//目标文件
//		File file = new File(fileName);
//		FileOutputStream fOut = null;
//		//创建新的Excel工作簿
//		HSSFWorkbook workbook =  new HSSFWorkbook();
//		
//		HSSFSheet sheet = workbook.createSheet("Test_Table");
//		 //创建字体，红色、粗体
//		HSSFFont font = workbook.createFont();
//		font.setColor(HSSFFont.COLOR_RED);
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		
//		//创建单元格格式，如居中、左对齐等
//		HSSFCellStyle cellStyle = workbook.createCellStyle();
//		//水平方向上居中对齐
//		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		//垂直方向上居中对齐
//		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		cellStyle.setFont(font);
//		
//		//下面将建立一个4行3列的表，第一行为表头
//		int rowNum = 0;
//		int colNum = 0;
//		//建立表头信息
//		HSSFRow row = sheet.createRow((short)rowNum);//在索引0的位置创建行
//		HSSFCell cell = null;//单元格
//		for(colNum = 0;colNum < 5 ; colNum++) {
//			//在当前行的colNum列上创建单元格
//			cell = row.createCell((short) colNum);
//			//定义单元格为字符类型，也可以指定为日期类型、数字类型
//			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//			//定义编码方式，为了支持中文，这里使用了ENCODING_UTF_16---
//			cell.setCellStyle(cellStyle);
//			cell.setCellValue("值-" + rowNum + "-" + colNum);
//		}
//		rowNum++;
//		for(;rowNum < 5;rowNum++) {
//			//新建第rowNum行
//			row = sheet.createRow((short) rowNum);
//			for(colNum = 0;colNum < 5;colNum++) {
//				//在当前行的colNum位置创建单元格
//				cell = row.createCell((short) colNum);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("值-" + rowNum + "-" + colNum);
//				
//			}
//		}
//	}
//}
