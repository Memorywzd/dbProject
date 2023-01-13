package design.console;

import java.io.Console;
import java.io.IOException;

public class Main {
    private static String userID;
    private static int userRole;
    public static void login() {
        System.out.println("欢迎使用研究生培养环节和成果认定综合管理系统");
        Console console = System.console();
        System.out.println("研究生培养环节和成果认定综合管理系统 console version 0.1");
        System.out.println("输入身份：1.学生 2.教师 3.管理员");
        int role = Integer.parseInt(console.readLine());
        System.out.println("登录\n输入账号 密码：");
        String[] input = console.readLine().split(" ");
        String account = input[0];
        String password = input[1];


    }

    public static void main(String[] args) {
        login();
    }
}
