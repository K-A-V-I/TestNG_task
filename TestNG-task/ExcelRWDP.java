package testNG;

import org.testng.annotations.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelRWDP {
    private String excelFilePath = "D://loginData.xlsx"; 
    private Workbook workbook;
    private Sheet sheet;

    @BeforeMethod
    public void setUp() throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Sheet1"); 
    }

    @Test
    public void readDataFromExcel() {
        // Read data from cell A1 (User Name)
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        String userName = cell.getStringCellValue();
        System.out.println("User Name: " + userName);

        // Read data from cell B1 (Password)
        cell = row.getCell(1);
        String password = cell.getStringCellValue();
        System.out.println("Password: " + password);
    }

    @Test(dependsOnMethods = "readDataFromExcel")
    public void writeDataToExcel() {
        // Write data to cell A2
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(0);
        cell.setCellValue("jessi");

        // Write data to cell B2
        cell = row.createCell(1);
        cell.setCellValue("pass");

        // Save the changes to the Excel file
        try {
            FileOutputStream fos = new FileOutputStream(excelFilePath);
            workbook.write(fos);
            fos.close();
            System.out.println("Data written to Excel file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
    }
}
