package Dataprvder_testng;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;

public class Example_with_External_Data_Source {

    // Example this is a  External Data Source frome  (Excel)

    //NOTE;
       // this must be use only login fuction ... like u have username and password then u can use this excell data provider and muiltpile time run automatilcaly till all data run out.
    //   output this:
      // | Username                                      | Password |
    //| --------------------------------------------- | -------- |
    //| [admin@example.com](mailto:admin@example.com) | admin123 |
    //| [user1@example.com](mailto:user1@example.com) | user123  |
    //| [user2@example.com](mailto:user2@example.com) | user456  |



    public class LoginExcelTest {
// this sencond clas which menas inside it has anther class

        @Test(dataProvider = "excelData")
        public void loginTest(String username, String password) {

            // this is step defincation or page action ..we can implement any method  in this
            System.out.println("Testing login with: " + username + " / " + password);
            // Add Selenium steps here
        }

        @DataProvider(name = "excelData")
        public Object[][] getExcelData() throws Exception {
            FileInputStream fis = new FileInputStream(new File("src/test/resources/Excelldata/Logindata.xlsx"));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

            workbook.close();
            return data;
        }
    }

}
