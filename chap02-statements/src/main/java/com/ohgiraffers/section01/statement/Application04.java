package com.ohgiraffers.section01.statement;
import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application04 {

    public static void main(String[] args){
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력해주세요 : ");
        int empId = sc.nextInt();
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empId;
        EmployeeDTO employeeDTO = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()){
                employeeDTO = new EmployeeDTO();
                employeeDTO.setEmpId(rset.getString("EMP_ID"));
                employeeDTO.setEmpName(rset.getString("EMP_NAME"));
                employeeDTO.setEmpNo(rset.getString("EMP_NO"));
                employeeDTO.setEmail(rset.getString("EMAIL"));
                employeeDTO.setPhone(rset.getString("PHONE"));
                employeeDTO.setDeptCode(rset.getString("DEPT_CODE"));
                employeeDTO.setJobCode(rset.getString("JOB_CODE"));
                employeeDTO.setSalLevel(rset.getString("SAL_LEVEL"));
                employeeDTO.setSalary(rset.getInt("SALARY"));
                employeeDTO.setBonus(rset.getDouble("BONUS"));
                employeeDTO.setManagerId(rset.getString("MANAGER_ID"));
                employeeDTO.setHireDate(rset.getDate("HIRE_DATE"));
                employeeDTO.setEntDate(rset.getDate("ENT_DATE"));
                employeeDTO.setEntYn(rset.getString("ENT_YN"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(con);
            close(stmt);
        }
        System.out.println("select emp : " + employeeDTO);
    }
}
