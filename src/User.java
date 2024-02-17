import java.io.*;
import java.util.*;

public class User {
    String userName;
    String passWord;
    String firstName;
    String gmail;
    UserRoles role;
    static ArrayList<Map> allUsers = new ArrayList<>();

    public static void edit(String userName){
        String action;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.change password" +
                    "%n2.delete account"+
                    "%n or type back");
            action = scanner.nextLine().trim().toLowerCase();
            if (action.equals("1")) {
                String password;
                int found = 0;
                int i;
                Map<String, String> map = new HashMap<>();
                for (i = 0; i < allUsers.size(); i++) {
                    map = allUsers.get(i);
                    if (userName.equals(map.get("username"))) {
                        while (true) {
                            System.out.println("pls enter your password : ");
                            password = scanner.nextLine().trim();
                            if (password.equals(map.get("password"))) {
                                System.out.println("new password: ");
                                String newPassword;
                                newPassword = scanner.nextLine().trim().toLowerCase();
                                map.replace("password", newPassword);
                                allUsers.set(i, map);
                                break;
                            } else if (password.equals("back")) {
                                break;
                            } else {
                                System.out.println("password incorrect !");
                            }
                        }
                    }
                }
            } else if (action.equals("2")) {
                int i;
                String choice;
                Map<String, String> map = new HashMap<>();
                for (i = 0; i < allUsers.size(); i++) {
                    map = allUsers.get(i);
                    if (userName.equals(map.get("username"))) {
                        while (true) {
                            System.out.println("are you sure? y/n :");
                            choice = scanner.nextLine().trim().toLowerCase();
                            if (choice.equals("y")) {
                                allUsers.remove(i);
                                break;
                            } else if (choice.equals("n")) {
                                break;
                            } else {
                                System.out.println("pls enter y/n");
                            }
                        }
                    }
                }
            }else if (action.equals("back")) {
                break;
            } else {
                System.out.println("please enter 1-2 or back");
            }
        }

    }

    public static void remove(){
        int i;
        String choice;
        String userName;
        Map<String, String> map = new HashMap<>();
        int found = 0;
        Scanner scanner = new Scanner(System.in);

        while (found == 0) {
            System.out.println("please enter the username: ");
            userName = scanner.nextLine().trim().toLowerCase();
            for (i = 0; i < allUsers.size(); i++) {
                map = allUsers.get(i);
                if (userName.equals(map.get("username"))) {
                    found++;
                    while (true) {
                        System.out.println("are you sure? y/n :");
                        choice = scanner.nextLine().trim().toLowerCase();
                        if (choice.equals("y")) {
                            allUsers.remove(i);
                            break;
                        } else if (choice.equals("n")) {
                            break;
                        } else {
                            System.out.println("pls enter y/n");
                        }
                    }
                }
            }
            if (found == 0){
                System.out.println("user not found");
            }
        }
    }

    public static void register () throws IOException {
        String userName;
        String passWord;
        String firstName;
        String gmail;
        UserRoles role = UserRoles.Student;
        Scanner scanner = new Scanner(System.in);
        System.out.println("######## Registration ########");
        System.out.println("pls enter your username : ");
        userName = scanner.nextLine();

        System.out.println("pls enter your password : ");
        passWord = scanner.nextLine();

        System.out.println("pls enter your gmail : ");
        gmail = scanner.nextLine();

        System.out.println("pls enter your firstname : ");
        firstName = scanner.nextLine();

        System.out.println("pls choose your role :\n 1.Teacher\n 2.Student ");

        boolean flag = true;
        while (flag) {
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                role = UserRoles.Teacher;
                flag = false;
            } else if (choice.equals("2")) {
                role = UserRoles.Student;
                flag = false;
            } else {
                System.out.println("please choose between these two choices!");
            }

        }
        HashMap<String,String> infos = new HashMap<>();
        infos.put("username",userName.trim().toLowerCase());
        infos.put("password",passWord.trim());
        infos.put("gmail",gmail.trim());
        infos.put("firstname",firstName.trim());
        infos.put("role",role.toString().trim());

        allUsers.add(infos);

        System.out.println("you've been registered successfully!");
    }

    public static Map<String, String> login() throws IOException {
        String userName;
        String passWord;
        int userTrue = 0;
        Map<String, String> map = new HashMap<>();
        Map<String,String> info = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        System.out.println("######## Login ########");

        while (userTrue == 0) {
            System.out.println("pls enter your username/doesnt have a account? type reg to register : ");
            userName = scanner.nextLine().trim().toLowerCase();
            if (Objects.equals(userName, "back")) {
                break;
            } else if (Objects.equals(userName, "")) {
                System.out.println("pls enter something!");
            } else if (userName.equals("reg")) {
                register();
                break;
            } else {
                for (Map value : allUsers) {
                    map = value;
                    if (userName.equals(map.get("username"))) {
                        userTrue++;
                        while (true) {
                            System.out.println("pls enter your password : ");
                            passWord = scanner.nextLine().trim();
                            if (passWord.equals(map.get("password"))) {
                                info.put("username", map.get("username"));
                                info.put("role", map.get("role"));
                                break;
                            } else if (passWord.equals("back")) {
                                break;
                            } else {
                                System.out.println("password incorrect !");
                            }
                        }
                    }
                }
            }
            if (userTrue == 0) {
                System.out.println("user not found!");
            }
        }

        return info;
    }

}





