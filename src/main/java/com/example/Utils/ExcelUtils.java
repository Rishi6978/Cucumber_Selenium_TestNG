package com.example.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

   // XSSFWorkbook workbook=null;
    FileInputStream fis=null;

     public ExcelUtils(String filePath)
    {
        try{
            fis=new FileInputStream(filePath);
        //    workbook= new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


}
