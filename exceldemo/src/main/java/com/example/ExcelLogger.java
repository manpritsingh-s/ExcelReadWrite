package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelLogger {

    public static void main(String[] args) {
        String filePath = "test.xls";

        try (FileInputStream fileInputStream = new FileInputStream(filePath); 
        Workbook workbook = new HSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();

            Row newRow = sheet.createRow(lastRowNum + 1);
            Cell cell = newRow.createCell(0);
            cell.setCellValue("Build successful!");

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }

            System.out.println("Build message executed into xlx file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
