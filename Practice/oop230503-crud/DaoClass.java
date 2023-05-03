package oop20230503.crud;
import java.util.Scanner;

// Data Access object    (책)
public class DaoClass {
    Scanner sc = new Scanner(System.in);
 
    DtoClass dtoArr[] = new DtoClass[20];
 
    // 변수(필드)선언
    private boolean swit[] = new boolean[20];
    private int pageNum;
    private String check;
 
    // init in mainProcess
    public DaoClass() {
        init();
    }
 
    // init
    public void init() {
        for (int i = 0; i < swit.length; i++) {
            swit[i] = false;
        }
    }
 
    // Insert - 추가
    public void insert() {
        System.out.println(); // 개행
        for (int i = 0; i < dtoArr.length; i++) {
            if (swit[dtoArr.length - 1] == true) {
                System.out.println("더 이상 페이지를 추가 할 수 없습니다");
                return;
            } else if (swit[i] == false) {
                System.out.println((i + 1) + " 번 페이지에 작성 하실 수 있습니다.\n");
                break;
            }
        }
 
        System.out.print("# 나이\n>>>");
        int age = sc.nextInt();
        System.out.print("# 이름\n>>>");
        String name = sc.next();
        System.out.print("# 생년월일\n>>>");
        String birth = sc.next();
        System.out.print("# 주소\n>>>");
        String address = sc.next();
 
        for (int i = 0; i < dtoArr.length; i++) {
            if (swit[i] == false) {
                swit[i] = true;
                pageNum = i + 1;
                dtoArr[i] = new DtoClass(pageNum, age, name, birth, address);
                System.out.println("\n" + pageNum + " 번째 페이지가 작성되었습니다");
                break;
            }
        }
 
    }
 
    // Delete - 삭제
    public void delete() {
        System.out.print("\n삭제하고 싶은 책의 쪽수를 입력하시오(1 ~ 20)\n>>>");
        pageNum = sc.nextInt();
        if (dtoArr[pageNum - 1] == null) {
            System.out.println("\n작성된 페이지가 없는 쪽수입니다");
            return;
        }
        System.out.println("\n삭제하고 싶은 " + pageNum + "페이지의 내용입니다.");
        System.out.println(dtoArr[pageNum - 1].toString());
        System.out.print("페이지를 삭제하고 싶으시면 'Y'아니면 'N'를 입력하시오\n>>>");
        check = sc.next();
        if (check.equals("y") || check.equals("Y")) {
            swit[pageNum - 1] = false;
            dtoArr[pageNum - 1] = null;
            System.out.println("\n페이지가 삭제되었습니다.");
        } else {
            System.out.println("\n삭제를 취소합니다.");
            return;
        }
    }
 
    // Search - 검색
    public void search() {
        System.out.println(); // 개행
        System.out.print("검색하고 싶은 책의 쪽수를 입력하시오(1 ~ 20)\n>>>");
        pageNum = sc.nextInt();
        if (dtoArr[pageNum - 1] == null) {
            System.out.println("\n작성된 페이지가 없는 쪽수입니다\n");
            return;
        }
        System.out.println("\n검색하고 싶은 " + pageNum + "페이지의 내용입니다.");
        System.out.println(dtoArr[pageNum - 1].toString());
    }
 
    // Update - 수정
    public void update() {
        System.out.println(); // 개행
        System.out.print("수정하고 싶은 책의 쪽수를 입력하시오(1 ~ 20)\n>>>");
        pageNum = sc.nextInt();
        if (dtoArr[pageNum - 1] == null) {
            System.out.println("\n작성된 페이지가 없는 쪽수입니다");
            return;
        }
        System.out.println("\n수정하고 싶은 " + pageNum + "페이지의 내용입니다.");
        System.out.println(dtoArr[pageNum - 1].toString());
        System.out.print("페이지를 수정하고 싶으시면 'Y'아니면 'N'를 입력하시오\n>>>");
        check = sc.next();
        if (check.equals("y") || check.equals("Y")) {
            
            System.out.print("# 나이\n>>>");
            int age = sc.nextInt();
            System.out.print("# 이름\n>>>");
            String name = sc.next();
            System.out.print("# 생년월일\n>>>");
            String birth = sc.next();
            System.out.print("# 주소\n>>>");
            String address = sc.next();
            
            dtoArr[pageNum-1] = new DtoClass(pageNum, age, name, birth, address);
            
            System.out.println("\n페이지가 수정되었습니다.");
        }
    }
 
}
