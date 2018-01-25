//package book.io;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import org.apache.poi.hssf.usermodel.*;
//
///**
// * ����Excel�ļ�
// * �����ˣ�     Jefy
// * ��Ŀ����     Book	
// * ������         ExcelFile
// * ����ʱ�䣺 2018��1��19������1:37:01
// * �޸��ˣ�     Jefy
// * ��������
// */
//public class ExcelFile {
//	
//	@SuppressWarnings("unchecked")
//	public void writeExcel(String fileName) {
//		//Ŀ���ļ�
//		File file = new File(fileName);
//		FileOutputStream fOut = null;
//		//�����µ�Excel������
//		HSSFWorkbook workbook =  new HSSFWorkbook();
//		
//		HSSFSheet sheet = workbook.createSheet("Test_Table");
//		 //�������壬��ɫ������
//		HSSFFont font = workbook.createFont();
//		font.setColor(HSSFFont.COLOR_RED);
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		
//		//������Ԫ���ʽ������С�������
//		HSSFCellStyle cellStyle = workbook.createCellStyle();
//		//ˮƽ�����Ͼ��ж���
//		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		//��ֱ�����Ͼ��ж���
//		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		cellStyle.setFont(font);
//		
//		//���潫����һ��4��3�еı���һ��Ϊ��ͷ
//		int rowNum = 0;
//		int colNum = 0;
//		//������ͷ��Ϣ
//		HSSFRow row = sheet.createRow((short)rowNum);//������0��λ�ô�����
//		HSSFCell cell = null;//��Ԫ��
//		for(colNum = 0;colNum < 5 ; colNum++) {
//			//�ڵ�ǰ�е�colNum���ϴ�����Ԫ��
//			cell = row.createCell((short) colNum);
//			//���嵥Ԫ��Ϊ�ַ����ͣ�Ҳ����ָ��Ϊ�������͡���������
//			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//			//������뷽ʽ��Ϊ��֧�����ģ�����ʹ����ENCODING_UTF_16---
//			cell.setCellStyle(cellStyle);
//			cell.setCellValue("ֵ-" + rowNum + "-" + colNum);
//		}
//		rowNum++;
//		for(;rowNum < 5;rowNum++) {
//			//�½���rowNum��
//			row = sheet.createRow((short) rowNum);
//			for(colNum = 0;colNum < 5;colNum++) {
//				//�ڵ�ǰ�е�colNumλ�ô�����Ԫ��
//				cell = row.createCell((short) colNum);
//				cell.setCellStyle(cellStyle);
//				cell.setCellValue("ֵ-" + rowNum + "-" + colNum);
//				
//			}
//		}
//	}
//}
