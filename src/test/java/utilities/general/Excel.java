package utilities.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class Excel {

    int rowIndex;

    public  void Excelmethod() throws IOException {
//obtaining input bytes from a file
        FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));
//creating workbook instance that refers to .xls file
        HSSFWorkbook wb=new HSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
        HSSFSheet sheet=wb.getSheetAt(0);
        String PaymentType= "One";

        int totalrows= sheet.getPhysicalNumberOfRows();
        int actualrecords=0;
        int blankrecords=0;
//evaluating cell type
        if (PaymentType.equalsIgnoreCase("One")){
            rowIndex =3;
        }
        else if (PaymentType.equalsIgnoreCase("Two")){
            rowIndex = 5;
        }
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        for(Row row: sheet)     //iteration over row using for each loop
        {
            for(Cell cell: row)    //iteration over cell using for each loop
            {

                if(row.getRowNum()>rowIndex) {
                    switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type
//getting the value of the cell as a number
                            //System.out.print(cell.getNumericCellValue() + "\t\t");
                            actualrecords++;
                            break;
                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
//getting the value of the cell as a string
                            //System.out.print(cell.getStringCellValue() + "\t\t");
                            actualrecords++;
                            break;



                    }
                }
            }
            System.out.println();
        }
        blankrecords= totalrows-(actualrecords+rowIndex);
    }
}

