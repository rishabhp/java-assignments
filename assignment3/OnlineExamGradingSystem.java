
import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private char correctLabel;

    public Question(String questionText, ArrayList<String> options, char correctLabel) {
        this.questionText = questionText;
        this.options = options;
        this.correctLabel = correctLabel;
    }

    public boolean checkAnswer(char userAnswer) {
        return this.correctLabel == userAnswer;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Q. ").append(this.questionText);
        for (int i = 0; i < options.size(); i++) {
            sb.append("\n").append((char) (i+65)).append(". ").append(options.get(i));
        }
        return sb.toString();
    }

    public char getCorrectLabel() {
        return correctLabel;
    }
}

class Exam {
    private ArrayList<Question> questionSet;
    private double score;
    private boolean hasTakenTest;

    public Exam(ArrayList<Question> questionSet) {
        this.questionSet = questionSet;
        this.score = 0;
        this.hasTakenTest = false;
    }

    public void takeTest(Scanner scanner) {
        if (this.hasTakenTest) {
            System.out.println("Cannot attempt an already taken test.");
            return;
        }

        double correctAnswerWeightage = 100.0 / questionSet.size();
        for (Question question : questionSet) {
            System.out.println(question);
            System.out.print("Choose your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);
            
            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct Answer");
                this.score += correctAnswerWeightage;
            } else {
                System.out.println("Incorrect Choice! Correct Answer: " + question.getCorrectLabel());
            }
            System.out.println();
        }
        this.hasTakenTest = true;
    }

    public double getScore() {
        return this.score;
    }
}

public class OnlineExamGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Delhi");
        options1.add("Mumbai");
        options1.add("Hyderabad");
        options1.add("Pune");
        questions.add(new Question("What is the capital of India?", options1, 'A'));

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Earth");
        options2.add("Venus");
        options2.add("Mars");
        options2.add("Jupiter");
        questions.add(new Question("Which planet is known as the Red Planet?", options2, 'C'));

        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Isaac Newton");
        options3.add("Albert Einstein");
        options3.add("Galileo Galilei");
        options3.add("Nikola Tesla");
        questions.add(new Question("Who developed the theory of relativity?", options3, 'B'));


        Exam exam = new Exam(questions);
        exam.takeTest(scanner);

        System.out.println("Your final score: " + exam.getScore());
        scanner.close();
    }
}
