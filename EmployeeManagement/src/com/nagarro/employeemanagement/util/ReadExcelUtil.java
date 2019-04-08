package com.nagarro.employeemanagement.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;

import com.nagarro.employeemanagement.model.Employee;

public class ReadExcelUtil {
	final Logger logger = Logger.getLogger("myLogger");
	public List<Employee> readCSV(){
		final String filePath = "C:\\Users\\pooja01\\Desktop\\employeeRecords.xlsx";
		  FileInputStream fileStream = null;
		  List<Employee> employees = new ArrayList<Employee>();
	        try {
	        	fileStream = new FileInputStream(filePath);
	            Workbook workbook = new XSSFWorkbook(fileStream);
	                Sheet sheet = workbook.getSheetAt(0);
	                for(Row row : sheet) {
	 
	                    Employee employee = new Employee();
	                    for(Cell cell: row) {
	                      
	                            if (cell.getColumnIndex() == 0) {
	                                employee.setEmployeeCode((int)cell.getNumericCellValue());
	                            }
	                            else if (cell.getColumnIndex() == 1) {
	                                employee.setEmployeeName(cell.getStringCellValue());
	                            }
	                            else if (cell.getColumnIndex() == 2) {
	                                employee.setLocation(cell.getStringCellValue());
	                            }else if (cell.getColumnIndex() == 3) {
	                                employee.setDob(cell.getStringCellValue());
	                            }else if (cell.getColumnIndex() == 4) {
	                                employee.setEmail(cell.getStringCellValue());
	                            }
	                      
	                    }
	                    employees.add(employee);
	                }
	                fileStream.close();
	 
	        } catch (FileNotFoundException e) {
	            logger.info(e.getMessage());
	        } catch (IOException e) {
	        	logger.info(e.getMessage());
	        }
	        
	       return employees;
	}
	
}
