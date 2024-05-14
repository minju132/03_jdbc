package com.ohgiraffers.section01.statement;

import com.ohgiraffers.common.JDBCTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class Application03 {

    public static void main(String[] args){

        Connection con = JDBCTemplate.getConnection();
        // 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
        Statement stmt = null;
        // select 결과집합을 받아올 용도의 인터페이스
        ResultSet rset = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("200 ~ 222인 사원번호를 입력해주세요. : ");
        int num = sc.nextInt();

        try {
            // sql에 말하는 방식을 만들어줌
            // sql은 sql 문법을 이용해 말함
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID ="+ num);   // + 없어도 똑같이 나옴
            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);


        }

    }
}
