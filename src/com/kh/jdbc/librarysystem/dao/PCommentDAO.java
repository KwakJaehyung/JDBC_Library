package com.kh.jdbc.librarysystem.dao;

import com.kh.jdbc.librarysystem.util.Common;
import com.kh.jdbc.librarysystem.vo.PCommentVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PCommentDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<PCommentVO> commentSelect() {
        List<PCommentVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM PCOMMENT";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int comNo = rs.getInt("COM_NO");
                int postNo = rs.getInt("POST_NO");
                String userID = rs.getString("USER_ID");
                String comment = rs.getString("PCOMMENT");
                Date comDate = rs.getDate("COM_DATE");
                PCommentVO vo = new PCommentVO(comNo, postNo, userID, comment, comDate);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void commentSelectPrn(List<PCommentVO> list) {
        System.out.println("댓글 번호      글 번호      작성자      댓글 내용      작성 일자");
        System.out.println("---------------------------------------------------------");
        for (PCommentVO e : list) {
            System.out.print(e.getComNo() + " ");
            System.out.print(e.getPostNo() + " ");
            System.out.print(e.getUserID() + " ");
            System.out.print(e.getComment() + " ");
            System.out.println(e.getComDate());
        }
        System.out.println("---------------------------------------------------------");
    }

}
