package oop20230503.crud;

import java.util.Scanner;
 
public class CrudEx {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 인스턴스 생성 
        DaoClass dao = new DaoClass();
        
        // 변수선언
        int chNum;
 
        while (true) {
 
            System.out.println("### 실행 하실 작업의 번호를 입력하시오 ###");
            System.out.println(" 1. Insert - 추가 ");
            System.out.println(" 2. Delete - 삭제 ");
            System.out.println(" 3. Search - 검색 ");
            System.out.println(" 4. Update - 수정 ");
            System.out.print(" 5. Exit - 프로그램 종료\n>>>");
 
            chNum = sc.nextInt();
 
            switch (chNum) {
            case 1: // 1. Insert - 추가
                    dao.insert();
                break;
            case 2: // 2. Delete - 삭제
                    dao.delete();
                break;
            case 3: // 3. Search - 검색
                    dao.search();
                break;
            case 4: // 4. Update - 수정
                    dao.update();
                break;
            default: // Exit - 프로그램 종료
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                System.exit(0);
            }
            System.out.println();
        }
 
    }
 

}
