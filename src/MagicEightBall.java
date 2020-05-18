
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
This method, MagicEightBall, outputs a randomized response when the 'ask()' method is invoked to console.
 */

//TODO Add GUI.



public class MagicEightBall {

    private String question;
    private boolean repeatquestion;
    public repeatQuestion repeatQuestion = new repeatQuestion();
    private ArrayList<String> questions = new ArrayList<>();
    private final ArrayList<String> responses = new ArrayList<>(Arrays.asList(
            "Yes","No","Ask Another Time","Perhaps","I Plead the Fifth","You Don't Have The Rights To Ask This Question",
            "Definitely","Of Course","Of Course Not","Don't Get Your Hopes Up","I Wouldn't Be Surprised"
    ));

    public MagicEightBall() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    private String getResponse() {
        return responses.get(new Random().nextInt(responses.size()));
    }

    public void ask(String question) {
        if(repeatquestion) {
            if (!question.contains("?")) {
                System.out.println(question + "?" + " \n" + getResponse());
            } else {
                System.out.println(question + " \n" + getResponse());
            }
        } else {
            System.out.println(getResponse());
        }

    }
    public void ask(ArrayList<String> questions) {
        questions.forEach(a -> {
            if(repeatquestion) {
                if (!a.contains("?")) {
                    System.out.println(a + "?" + "\n" + getResponse());
                } else {
                    System.out.println(a + "\n" + getResponse());
                }
            } else {
                System.out.println(getResponse());
            }
        } );
    }

    public MagicEightBall(String question) {
        this.question = question;
        ask(question);
    }

    public MagicEightBall(ArrayList<String> questions) {
        this.questions = questions;
        ask(questions);
    }

    class repeatQuestion{

        public void setFalse(){
            repeatquestion = false;
        }

        public void setTrue() {
            repeatquestion = true;
        }

    }


}


class test {

    public static void main(String[] args) {
        MagicEightBall magic8ball = new MagicEightBall();
        magic8ball.repeatQuestion.setFalse();
        while(true) {
            Scanner in = new Scanner(System.in);
            String Question = in.nextLine();
            if(Question.toLowerCase().equals("exit")) break;
            magic8ball.ask(Question);

        }
    }



}
