package com.kh.jdbc.librarysystem.dao;

import com.kh.jdbc.librarysystem.util.Common;
import com.kh.jdbc.librarysystem.vo.PostVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs =null;
    Scanner sc = new Scanner(System.in);

    public List<PostVO> postSelect() {
        List<PostVO>list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM POST";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int postNo = rs.getInt("POST_NO");
                String title = rs.getString("TITLE");
                String userID = rs.getString("USER_ID");
                String content = rs.getString("PCONTENT");
                Date postDate = rs.getDate("POST_DATE");
                PostVO vo = new PostVO(postNo, title, userID, content, postDate);
                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void postSelectPrn(List<PostVO> list) {
        System.out.println("======================== 게시판 ========================");
        System.out.println("글 번호              글 제목           글 작성자    글 작성 일자");
        System.out.println("-------------------------------------------------------");
        for (PostVO e : list) {
            System.out.print(e.getPostNo() + "       ");
            System.out.print(e.getTitle() + "     ");
            System.out.print(e.getUserID() + " ");
            //System.out.print(e.getpContent() + " ");
            System.out.print(e.getPostDate() + " ");
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }

    public void postShow(List<PostVO> list, int num) {

        String sql = "SELECT * FROM POST WHERE POST_NO = " + num;

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println();
                System.out.print("게시글 번호: " + rs.getInt("POST_NO") + " ");
                System.out.print("제목: " + rs.getString("TITLE") + " ");
                System.out.println("작성자: " + rs.getString("USER_ID") + " ");
                System.out.println("내용: " + rs.getString("PCONTENT"));
                System.out.println("---------------------------------------------------------");
                System.out.println("댓글: ");
                System.out.print("댓글 작성자: ");
                System.out.println("댓글 작성일: ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void postInsert() {
        System.out.println("글 정보를 입력하세요.");
        System.out.print("게시글 번호: ");
        int postNo = sc.nextInt();
        System.out.print("글 제목: ");
        String title = sc.next();
        System.out.print("글 작성자: ");
        String userID = sc.next();
        System.out.print("글 내용: ");
        String content = sc.next();
        System.out.print("글 작성일: ");
        String postDate = sc.next();

        String sql = "INSERT INTO POST VALUES(?,?,?,?,?)";

        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, postNo);
            pStmt.setString(2, title);
            pStmt.setString(3, userID);
            pStmt.setString(4, content);
            pStmt.setString(5, postDate);
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
    }

    public void postUpdate() {

    }

    public void postDelete() {
        System.out.print("삭제할 글 번호를 입력: ");
        String postNo = sc.next();
        String sql = "DELETE FROM POST WHERE POST_NO = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, postNo);
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
    }
}
