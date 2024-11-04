package com.koreaIt;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private DayListController todoController;
    private SystemController systemController;

    public App() {
        sc = new Scanner(System.in);
        todoController = new DayListController();
        systemController = new SystemController();
    }

    public void run() {
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.equals("add")) {
                todoController.add();
            } else if (cmd.equals("list")) {
                todoController.list();
            } else if (cmd.equals("del")) {
                todoController.del();
            } else if (cmd.equals("modify")) {
                todoController.modify();
            }
        }
        sc.close();
    }
}