package com.kh.jdbc.librarysystem;

import com.kh.jdbc.librarysystem.dao.PostDAO;
import com.kh.jdbc.librarysystem.vo.PostVO;

import java.util.List;
import java.util.Scanner;

public class jdbcMain {
    public static void main(String[] args) {
        menuSelect();
    }

    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        PostDAO dao = new PostDAO();
        while (true) {
            System.out.println();
            System.out.println("======== EMP Table ========");
            System.out.println("메뉴를 선택하세요: ");
            System.out.print("[1]SELECT, [2]INSERT, [3]UPDATE, [4]DELETE, [5]EXIT: ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    List<PostVO> list = dao.postSelect();
                    dao.postSelectPrn(list);
                    break;
                case 2:
                    dao.postInsert();
                    break;
                case 3:
                    dao.postUpdate();
                    break;
                case 4:
                    dao.postDelete();
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다.");
                    return;
            }
        }
    }
}
