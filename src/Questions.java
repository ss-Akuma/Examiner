import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Questions {
    static ArrayList<Map> questions = new ArrayList<>();
    public static void addQuestion(){

        //String courseName;
        String question;
        String option;
        int answer = 0;
        String answerChoice;
        ArrayList<String> options = new ArrayList<>();


        //boolean course_finding = true;
        Scanner scanner = new Scanner(System.in);
        boolean questionAdding = true;
        while (questionAdding){
            System.out.println("Question: ");
            question = scanner.nextLine().trim().toLowerCase();
            if (question.equals("done")){
                questionAdding = false;
            }
            else {
                System.out.println("options: ");
                for(int i = 0;i<4;i++){
                    System.out.printf("%s.",i+1);
                    option = scanner.nextLine().trim().toLowerCase();
                    System.out.println("is this the answer? y/n");
                    while (true){
                        answerChoice = scanner.nextLine().trim().toLowerCase();
                        if (answerChoice.equals("y")){
                            answer = i+1;
                            break;
                        } else if (answerChoice.equals("n")) {
                            break;
                        }else {
                            System.out.println("please choose between y/n: ");
                        }
                    }
                    options.add(option);
                }
                Map<String,String> questionInfo = new HashMap<>();
                questionInfo.put("question",question);
                questionInfo.put("options",options.toString());
                questionInfo.put("answer", String.valueOf(answer));
                questions.add(questionInfo);
                options.clear();

            }

        }
    }
}
