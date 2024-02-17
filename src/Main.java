import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> info = new HashMap<>();
        Map<String, ArrayList> currentExam = new HashMap<>();
        String userName;
        String Role;
        String action;
        System.out.println("#### WELCOME ####");

        while (true) {
            System.out.println("what can I do for you..1.register...2.login....or type Exit ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if(choice.equals("1")) {
                User.register();
            }
            else if (choice.equals("2")) {
                info = User.login();
                userName = info.get("username");
                Role = info.get("role");
                if (Objects.equals(Role, "Teacher")){
                    System.out.printf("welcome %s%n",userName);
                    System.out.printf("role %s%n",Role);

                    boolean flag = true;
                    while (flag) {
                        System.out.println("what can i do for you: " +
                                "\n1.Set an Exam" +
                                "\n2.Add an Exam" +
                                "\n3.Remove an Exam" +
                                "\n4.edit account" +
                                "\n5.Add question" +
                                "\n6.Search Exam" +
                                "\n7.Remove account" +
                                "\ntype 'out' for logout :");
                        action = scanner.nextLine().trim().toLowerCase();

                        if (action.equals("1")) {
                            currentExam = Exams.setExam();
                        } else if (action.equals("2")) {
                            Exams.Add();
                        } else if (action.equals("3")) {
                            Exams.Remove();
                        } else if (action.equals("4")) {
                            User.edit(userName);
                        } else if (action.equals("5")) {
                            Questions.addQuestion();
                        } else if (action.equals("6")) {
                            Exams.search();
                        } else if (action.equals("7")) {
                            User.remove();
                        } else if (action.equals("out")) {
                            flag = false;
                        } else {
                            System.out.println("please enter something!");
                        }
                    }

                } else if (Objects.equals(Role, "Student")) {
                    System.out.printf("welcome %s%n",userName);
                    System.out.printf("role %s%n",Role);
                    boolean flag = true;
                    while (flag) {
                        System.out.println("what can i do for you:" +
                                "\n1.Attend an Exam" +
                                "\n2.edit account" +
                                "\ntype 'out' for logout :");
                        action = scanner.nextLine().trim().toLowerCase();

                        if (action.equals("1")) {
                            Exams.getExam(currentExam);
                        } else if (action.equals("2")) {
                            User.edit(userName);
                        } else if (action.equals("out")) {
                            flag = false;
                        } else {
                            System.out.println("please enter something between 1-3 or out!");
                        }
                    }
                }

            }
            else if (choice.equals("exit")) {
                break;
            }
            else {
                System.out.println("please enter numbers 1 or 2 or exit");
            }

        }
    }
}
