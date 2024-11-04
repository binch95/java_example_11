package com.koreaIt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        byte system_status = 1;
        int id = 1;
        List<DayList> dayLists = new ArrayList<>();

        while (system_status == 1) {
            System.out.print("명령어) ");
            String app = new Scanner(System.in).nextLine().trim();
            if (app.equals("")) {
                System.out.println("명령어를 입력해");
            }
            if (app.equals("List") || app.equals("list")) {
                System.out.println("번호  /  내용");

//                for (int i = dayLists.size()-1; i >= 0; i--) {
//                    System.out.printf(" %d   /    %s\n", dayLists.get(i).getNum(), dayLists.get(i).getDay());
//                }
                dayLists.forEach(dayList -> System.out.printf(" %d   /    %s\n", dayList.getNum(), dayList.getDay()));

            } else if (app.equals("add")) {
                System.out.print("할일 : ");
                String body = new Scanner(System.in).nextLine();

                System.out.printf("%d번 할일이 생성되었습니다\n", id);

                DayList dayList = new DayList(id, body);
                dayLists.add(dayList);
                id++;

            } else if (app.equals("del")) {
                System.out.print("삭제할 할일의 번호 : ");
                int num = Integer.parseInt(new Scanner(System.in).nextLine());
//                for(DayList dayList :  dayLists) {
//                    if (dayList.getNum() == num) {
//                        dayLists.remove(dayList);
//                        System.out.printf("%d번 할일이 삭제되었습니다\n", num);
//                        break;
//                    }
//                }

                Boolean findlist = dayLists.removeIf(dayList -> dayList.getNum() == num);
                if (!findlist) {
                    System.out.printf("%d번 할일은 존재하지않습니다\n", num);
                }


            } else if (app.equals("modify")) {
                System.out.print("수정할 할일의 번호 : ");
                int num = Integer.parseInt(new Scanner(System.in).nextLine());
//                for(DayList dayList :  dayLists) {
//                    if (dayList.getNum() == num) {
//                        System.out.printf("기존 할일 : %s\n", dayList.getDay());
//                        System.out.printf("새 할일 : ");
//                        String body = new Scanner(System.in).nextLine();
//                        dayList.setDay(body);
//                        System.out.printf("%d번 할일이 수정되었습니다\n", num);
//                        break;
//                    }
//                }

                DayList dayList = dayLists.stream()
                        .filter(l -> l.getNum() == num)
                        .findFirst()
                        .orElse(null);

                if (dayList == null) {
                    System.out.printf("%d번 할일은 존재하지않습니다\n", num);
                } else {
                    System.out.printf("기존 할일 : %s\n", dayList.getDay());
                    System.out.printf("새 할일 : ");
                    String body = new Scanner(System.in).nextLine();
                    dayList.setDay(body);
                }


            } else if (app.equals("exit")) {
                System.out.println("앱 종료 명령이 입력되었습니다.");
                System.out.println("프로그램이 곧 종료합니다.");
                system_status = 0;
            }
        }

    }


    public static class DayList {
        int num;
        String day;

        public DayList(int num, String day) {
            this.num = num;
            this.day = day;
        }

        public int getNum() {
            return num;
        }

        public String getDay() {
            return day;
        }

        public int setNum(int num) {
            this.num = num;
            return num;
        }

        public String setDay(String day) {
            this.day = day;
            return day;
        }
    }

}