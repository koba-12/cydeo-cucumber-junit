package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {
        String path= "SampleData.xlsx";

        File file=new File(path);

        //to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream=new FileInputStream(file);

        //workbook>sheet>row>cell
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        //<2> Wen need to get spesific sheet from currently opened workbook
        XSSFSheet sheet=workbook.getSheet("Employees");

        //<3> Select row and cell
        //print out mary's cell
        //indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        //print out developer
        System.out.println(sheet.getRow(3).getCell(2));

        //return the count of used cells only
        //starts counting from 1
        int usedRows=sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //TODO create a logic to print Vinod's name
        for (int rowNum=0; rowNum<usedRows;rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum));
            }
        }

        //TODO create a logic to Linda's Job_ID
        //check if name is Linda -->print out of Job_ID linda
        for (int rowNum=0;rowNum<usedRows;rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println("Linda's Job_ID "+ sheet.getRow(rowNum).getCell(2));
            }
        }
    }
}
