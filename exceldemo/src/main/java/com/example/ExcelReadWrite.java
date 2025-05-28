package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReadWrite 
{

    public static void writeXLS(String filePath, String message){
        try(Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(message);

            try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
                workbook.write(fileOutputStream);
                System.out.println("Write a file"+filePath);
            }
            
        } catch (IOException e) {
            System.err.println("Error while writing a Excel file"+e.getMessage());
        }
    }

    public static void readXLS(String filePath){
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(fileInputStream))
        {
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){
                for(Cell cell : row){
                    System.out.print(cell.toString()+"\t");
                }
                System.out.println();
            }
            
        } catch (IOException e) {
            System.err.println("Error while reading Excel file"+e.getMessage());
        }
    }
    public static void main( String[] args )
    {
        String filePath = "test.xlsx";
        writeXLS(filePath, "Demo");
        System.out.println("Reading from XLS");
        readXLS(filePath);
    }
}
