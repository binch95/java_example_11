package com.koreaIt;

import java.util.ArrayList;
import java.util.Scanner;

public class DayListController {

    private Scanner sc;
    private ArrayList<DayList> dayLists;
    private long todosLastId;

    public DayListController() {
        sc = new Scanner(System.in);
        dayLists = new ArrayList<>();
        todosLastId = 0;
    }

    public void add() {
        long id = todosLastId + 1;
        System.out.print("할 일 : ");
        String content = sc.nextLine().trim();

        DayList dayList = new DayList(id, content);
        dayLists.add(dayList);
        todosLastId++;

        System.out.printf("%d번 todo가 생성되었습니다\n", id);
    }

    public void list() {
        System.out.println("번호   /   내용  ");

        dayLists.forEach(dayList -> System.out.printf("%d  /  %s  \n", dayList.getId(), dayList.getContent()));
    }

    public void del() {
        System.out.printf("삭제할 할일의 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        boolean isRemoved = dayLists.removeIf(todo -> todo.getId() == id);

        if (!isRemoved) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번 할일이 삭제되었습니다.\n", id);
    }

    public void modify() {
        System.out.printf("수정할 할일의 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        DayList foundTodo = dayLists.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (foundTodo == null) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 할일 : %s\n", foundTodo.getContent());
        System.out.print("새 할일 : ");
        foundTodo.setContent(sc.nextLine().trim());

        System.out.printf("%d번 할일이 수정되었습니다.\n", id);
    }
}