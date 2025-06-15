package com.example;

import java.io.File;
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
        // File file = new File(filePath);
        // Workbook workbook = null;
        Sheet sheet = null;

        try {
            if (file.exists()) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    workbook = new HSSFWorkbook(fileInputStream);
                }
                sheet = workbook.getSheetAt(0);
            } else {
                workbook = new HSSFWorkbook();
                sheet = workbook.createSheet("Sheet1");
            }

            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum == 0 && sheet.getRow(0) == null) {
                lastRowNum = -1;
            }
            Row newRow = sheet.createRow(lastRowNum + 1);
            Cell cell = newRow.createCell(0);
            cell.setCellValue("Build successful!");

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                workbook.write(fileOutputStream);
            }

            System.out.println("Build message logged into Excel file.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
