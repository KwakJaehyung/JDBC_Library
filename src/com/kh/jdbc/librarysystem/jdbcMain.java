package com.kh.jdbc.librarysystem;

import com.kh.jdbc.librarysystem.dao.PCommentDAO;
import com.kh.jdbc.librarysystem.dao.PostDAO;
import com.kh.jdbc.librarysystem.vo.PCommentVO;
import com.kh.jdbc.librarysystem.vo.PostVO;

import java.util.List;
import java.util.Scanner;

public class jdbcMain {
    public static void main(String[] args) {
        menuSelect();
    }

    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        PostDAO postDAO = new PostDAO();
        PCommentDAO pCommentDAO = new PCommentDAO();

        List<PostVO> pList = postDAO.postSelect();
        System.out.println();
        postDAO.postSelectPrn(pList);

        while (true) {

            System.out.print("[1] 게시글 작성하기, [2] 게시글 조회하기, [5] 메인 메뉴로 돌아가기 : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    postDAO.postInsert();

                    //List<PCommentVO> cList = pCommentDAO.commentSelect();
                    //pCommentDAO.commentSelectPrn(cList);
                    break;
                case 2:
                    System.out.print("원하는 게시글 번호를 입력: ");
                    int num = sc.nextInt();
                    postDAO.postShow(pList, num);
                    break;
                case 3:
                    //dao.postUpdate();
                    break;
                case 4:
                    //dao.postDelete();
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다.");
                    return;
            }
        }
    }
}
