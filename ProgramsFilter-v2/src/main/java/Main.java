import model.PMCP;
import service.ReadExcel;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String excelFilePath = "data/input/3. PM được phép.xls";
        ReadExcel readExcel = new ReadExcel();
        List<PMCP> pmcps = readExcel.readExcelPMCP(excelFilePath);
        for (PMCP p: pmcps) {
            System.out.println(p);
        }
    }
}
