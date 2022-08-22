package service;

import common.Constant;
import model.PMCP;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

    public List<PMCP> readExcelPMCP(String excelFilePath) throws IOException {
        List<PMCP> listBooks = new ArrayList<>();
        XSSFWorkbook workbook = getWorkbook(excelFilePath);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.rowIterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            PMCP pmcp = new PMCP();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String result = new DataFormatter().formatCellValue(cell);
                if (result == null || result.isEmpty()) {
                    continue;
                }
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case Constant.PMCP_COLUMN_INDEX_NAME:
                        pmcp.setName(result);
                        break;
                    case Constant.PMCP_COLUMN_INDEX_VERSION:
                        pmcp.setVersion(result);
                        break;
                    case Constant.PMCP_COLUMN_INDEX_RULE:
                        pmcp.setRule(result);
                        break;
                    case Constant.PMCP_COLUMN_INDEX_PUBLISHER:
                        pmcp.setPublisher(result);
                        break;
                    default:
                        break;
                }
            }
            listBooks.add(pmcp);
        }
        workbook.close();
        return listBooks;
    }

    private static XSSFWorkbook getWorkbook(String excelFilePath) {
        try(InputStream inputStream = new FileInputStream(excelFilePath)){
            XSSFWorkbook xssfWorkbook;
            if (excelFilePath.endsWith("xlsx") || excelFilePath.endsWith("xls")) {
                xssfWorkbook = new XSSFWorkbook(inputStream);
            } else {
                throw new IllegalArgumentException("The specified file is not Excel file");
            }

            return xssfWorkbook;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
