package anhtester.common.helpers;

//import org.apache.poi.ss.usermodel.*;
//import org.testng.annotations.Test;
//
//import java.awt.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Excel {
//
//    private FileInputStream fis;
//    private FileOutputStream fileOut;
//    private Workbook wb;
//    private Sheet sh;
//    private Cell cell;
//    private Row row;
//    private CellStyle cellstyle;
//    private Color mycolor;
//    private String excelFilePath;
//    private Map<String, Integer> columns = new HashMap<>();
//
//    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
//        try {
//            File f = new File(ExcelPath);
//
//            if (!f.exists()) {
//                f.createNewFile();
//                System.out.println("File doesn't exist, so created!");
//            }
//
//            fis = new FileInputStream(ExcelPath);
//            wb = WorkbookFactory.create(fis);
//            sh = wb.getSheet(SheetName);
//            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
//            if (sh == null) {
//                sh = wb.createSheet(SheetName);
//            }
//
//            this.excelFilePath = ExcelPath;
//
//            //adding all the column header names to the map 'columns'
//            sh.getRow(0).forEach(cell -> {
//                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
//            });
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public String getCellData(int rownum, int colnum) throws Exception {
//        try {
//            cell = sh.getRow(rownum).getCell(colnum);
//            String CellData = null;
//            switch (cell.getCellType()) {
//                case STRING:
//                    CellData = cell.getStringCellValue();
//                    break;
//                case NUMERIC:
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        CellData = String.valueOf(cell.getDateCellValue());
//                    } else {
//                        CellData = String.valueOf((long) cell.getNumericCellValue());
//                    }
//                    break;
//                case BOOLEAN:
//                    CellData = Boolean.toString(cell.getBooleanCellValue());
//                    break;
//                case BLANK:
//                    CellData = "";
//                    break;
//            }
//            return CellData;
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    //G???i ra h??m n??y n??
//    public String getCellData(String columnName, int rownum) throws Exception {
//        return getCellData(rownum, columns.get(columnName));
//    }
//
//    public void setCellData(String text, int rownum, int colnum) throws Exception {
//        try {
//            row = sh.getRow(rownum);
//            if (row == null) {
//                row = sh.createRow(rownum);
//            }
//            cell = row.getCell(colnum);
//
//            if (cell == null) {
//                cell = row.createCell(colnum);
//            }
//            cell.setCellValue(text);
//
//            fileOut = new FileOutputStream(excelFilePath);
//            wb.write(fileOut);
//            fileOut.flush();
//            fileOut.close();
//        } catch (Exception e) {
//            throw (e);
//        }
//    }
//
//    @Test
//    public void signInPage() throws Exception {
//
//        // Setup ???????ng d???n c???a file excel
//        excel.setExcelFile("src/test/resources/Book1.xlsx", "Sheet1");
//
//        signInPage = new SignInPage(driver);
//        driver.get("https://crm.anhtester.com");
//
//        // ?????c data t??? file excel
//        signInPage.signIn(excel.getCellData("username", 2), excel.getCellData("password", 2));
//
//        //Ghi data v??o file excel
//        excel.setCellData("anhtester.com", 5, 0);
//
//        // Ch?? ??: d??ng v?? c???t trong code n?? hi???u b???t ?????u t??? 0
//
//        Thread.sleep(2000);
//    }
//}

