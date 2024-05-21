package com.chenyv.demo.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TxtToExcelConverter {

    public static void main(String[] args) {
        // TXT文件路径
        String txtFilePath = "/Users/chenyu/code/springboot3/work-demo/src/jieguo.txt";
        // Excel文件输出路径
        String excelFilePath = "/Users/chenyu/code/springboot3/work-demo/src/jieguo.xlsx";

        try {
            convertTxtToExcel(txtFilePath, excelFilePath);
            System.out.println("TXT文件已成功转换为Excel文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertTxtToExcel(String txtFilePath, String excelFilePath) throws IOException {
        FileInputStream fis = new FileInputStream(txtFilePath);
        Scanner scanner = new Scanner(fis);

        // 创建Excel工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet("Data");

        int rowNum = 0;
        while (scanner.hasNextLine()) {
            Row row = sheet.createRow(rowNum++);
            String[] data = scanner.nextLine().split(",");

            for (int i = 0; i < data.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data[i].trim().replaceAll("^\"|\"$", ""));
            }
        }

        FileOutputStream fos = new FileOutputStream(excelFilePath);
        workbook.write(fos);

        scanner.close();
        fis.close();
        fos.close();
        workbook.close();
    }

}