package com.school.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.school.entity.Student;
public class ExcelUtility {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { " Name", "Father Name", "Gender","DOB", "Class Id", "Class Name", "Blood Id","Blood Group","Mobile Number", "Contact Address", "Photo Number", "FileName","Type","ImageData"  };
    static String SHEET = "student";
    public static boolean hasExcelFormat(MultipartFile file) {
    	
      if (!TYPE.equals(file.getContentType())) {
        return false;
      }
      return true;
    }
    public static List<Student> excelToStudentList(InputStream is) {
      try {
    	  System.out.println("1");
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("1-1");
        Iterator<Row> rows = sheet.iterator();      
        
        List<Student> studentList = new ArrayList<Student>();
        System.out.println("1-2");
        int rowNumber = 0;
        System.out.println("2");
        while (rows.hasNext()) {
          Row currentRow = rows.next();
          // skip header
          if (rowNumber == 0) {
            rowNumber++;
            continue;
          }
          Iterator<Cell> cellsInRow = currentRow.iterator();
          Student student = new Student();
          int cellIdx = 0;
          System.out.println("3");
          while (cellsInRow.hasNext()) {
            Cell currentCell = cellsInRow.next();
            switch (cellIdx) {
            case 0:{
            	System.out.println("1");
            	student.setStudentName(currentCell.getStringCellValue());
            	System.out.println(student.getStudentName());
              break;
            }
            case 1: 
            {
            	System.out.println("2");	
            	student.setFatherName(currentCell.getStringCellValue());
              break;
            }
            case 2:
            {	System.out.println("3");
                student.setGender(currentCell.getStringCellValue());
              break;
            }
            case 3:
            {
            	System.out.println("4");
             student.setDateOfBirth(currentCell.getDateCellValue());
             System.out.println(student.getDateOfBirth());
             
              break;
            }
            case 4:{
            	System.out.println("5");
            	 Double classId=currentCell.getNumericCellValue();
            	 student.setClassId(classId.longValue());
                 break;
            }            
            case 5:
            {
            	System.out.println("6"); 		
               // student.setClassName(currentCell.getStringCellValue());
              break;
            }
            case 6:
            {
            	System.out.println("7");
           	 Double bloodId=currentCell.getNumericCellValue();
           	 student.setBloodId(bloodId.longValue());
                break;
           }
            case 7:
            { 
            	System.out.println("8"+" "+currentCell);
               // student.setBloodGroupName(currentCell.getStringCellValue());
               // System.out.println(student.getBloodGroupName());
                 break;
            }  
            
            
           case 8:
            {
            	System.out.println("9");
            	String str=currentCell.toString();
            	System.out.println("Current Cell value"+" "+str);
            	student.setMobileNumber(currentCell.getStringCellValue());
            	System.out.println(student.getMobileNumber());
            	
                 break;
            }                    
                
               
            case 9:
            {
            	System.out.println("10");
            	
            	System.out.println(currentCell.getStringCellValue());
                student.setContactAddress(currentCell.getStringCellValue());
                 break;
            }               
               
                 
            case 10:
            {
            	System.out.println("11");
            	 String photoNumber=currentCell.getStringCellValue();
            	 System.out.println("Photo number  "+photoNumber);
               	 student.setPhotoNumber(Integer.parseInt(photoNumber));
                    break;
               }
            
            case 11:
            {
            	System.out.println("12");
                student.setImageFileName(null);
                 break;
            }
               
                 
            case 12:
            {
            	System.out.println("13");
                student.setImageType(null);
                 break;
            }    
               
                 
            case 13:{
            	System.out.println("14");
                student.setImageData(null);
                 break;
            }
               
                    
            default:
              break;
            }
            cellIdx++;
          }
         // studentList.add(student);
        }
        workbook.close();
        return studentList;
      } catch (IOException e) {
        throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
      }
    }

}
