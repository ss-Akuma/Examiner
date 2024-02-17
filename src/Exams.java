import java.util.*;

public class Exams {
    static ArrayList<Map> ExamsList = new ArrayList<>();
    public static void Add(){
        Scanner scanner = new Scanner(System.in);
        Map<String,ArrayList> examInfo = new HashMap<>();
        ArrayList<Map> examQuestions = new ArrayList<>();
        Map question = new HashMap<>();
        ArrayList<Map> questions = new ArrayList<>();

        //String course = null;
        String title;
        int question_choice;

        System.out.println("please enter exam title");
        title = scanner.nextLine().trim().toLowerCase();

        questions = Questions.questions;
        System.out.println(questions);
        while (true){
            System.out.println("choose the questions or type -1: ");
            question_choice = scanner.nextInt();
            if (question_choice == -1){
                break;
            } else {
                question = questions.get(question_choice - 1);
                examQuestions.add(question);
            }
        }
        /*boolean course_founding = true;
        while (course_founding){
            System.out.println("please enter course: ");
            course = scanner.nextLine().trim().toLowerCase();
            if(Questions.questions.containsKey(course)){
                questions = Questions.questions.get(course);
                System.out.println(questions);
                while (true){
                    System.out.println("choose the questions or type -1: ");
                    question_choice = scanner.nextInt();
                    if (question_choice == -1){
                        break;
                    }else {
                        question = questions.get(question_choice - 1);
                        examQuestions.add(question);
                    }
                }
                course_founding = false;
            }
            else {
                System.out.println("course not found!");

            }
        }*/

        examInfo.put(title,examQuestions);
        ExamsList.add(examInfo);
        System.out.println(ExamsList);
    }

    public static void Remove(){
        String choice;
        String examName;
        boolean found = true;
        //int i;
        Scanner scanner = new Scanner(System.in);

        while (found){
            Map<String,String> map = new HashMap<>();
            System.out.println("please enter Exam's title or type 'back': ");
            examName = scanner.nextLine().trim().toLowerCase();
            if (examName.equals("back")){
                found = false;
            }else {
                for (int i = 0;i< ExamsList.size();i++) {
                    map = ExamsList.get(i);
                    if (map.containsKey(examName)) {
                        System.out.println(map);
                        System.out.println("are you sure y/n: ");
                        choice = scanner.nextLine().trim().toLowerCase();
                        while (true) {
                            if (choice.equals("y")) {
                                ExamsList.remove(i);
                                break;
                            } else if (choice.equals("n")) {
                                break;
                            } else {
                                System.out.println("please enter y or n!");
                            }
                        }
                        found = false;
                        break;

                    }else {
                        System.out.println("exam not found!");
                    }
                }

            }
        }

    }

    public static void search(){
        String examName;
        boolean found = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Map> examList = new ArrayList<>();
        examList = ExamsList;
        while (found) {
            Map<String,ArrayList> map = new HashMap<>();
            System.out.println("please enter exam's title: ");
            examName = scanner.nextLine().trim().toLowerCase();
            if (examName.equals("back")) {
                found = false;
            } else {
                for (Map value : examList) {
                    map = value;
                    if (map.containsKey(examName)) {
                        System.out.println(map);
                        found = false;
                        break;
                    }
                    else {
                        System.out.println("exam not found!");
                    }
                }

            }
        }
    }

    public static Map<String, ArrayList> setExam (){
        String examName;
        boolean found = true;
        int i;
        Scanner scanner = new Scanner(System.in);

        Map<String,ArrayList> exam = new HashMap<>();

        while (found){
            System.out.println("please enter Exam's title: ");
            examName = scanner.nextLine().trim().toLowerCase();
            Map<String,ArrayList> map = new HashMap<>();
            for (i = 0;i< ExamsList.size();i++) {
                map = ExamsList.get(i);
                if (map.containsKey(examName)) {
                    exam = map;
                    found = false;
                    break;
                }else {
                    System.out.println("exam not found!");
                }
            }
        }
        return exam;

    }

    public static void getExam(Map<String,ArrayList> exam){
        ArrayList<Map> questions = new ArrayList<>();
        String answer;
        Scanner scanner = new Scanner(System.in);
        int Score = 0;

        for (Map.Entry<String, ArrayList> entry : exam.entrySet()) {
            String k = entry.getKey();
            questions = entry.getValue();
            System.out.println("### "+ k +" ###");

            for (Map question : questions) {
                System.out.println(question.get("question"));
                System.out.println(question.get("options"));
                answer = scanner.nextLine().trim().toLowerCase();

                while (true){
                    if (answer.equals("1")){
                        if (answer.equals(question.get("answer"))){
                            Score++;
                        }
                        break;
                    } else if (answer.equals("2")) {
                        if (answer.equals(question.get("answer"))){
                            Score++;
                        }
                        break;
                    } else if (answer.equals("3")) {
                        if (answer.equals(question.get("answer"))){
                            Score++;
                        }
                        break;
                    } else if (answer.equals("4")) {
                        if (answer.equals(question.get("answer"))){
                            Score++;
                        }
                        break;
                    }else {
                        System.out.println("please choose between 1-4");
                    }
                }
            }
        }
        System.out.println("your score : " + Score);
    }

}
