

import java.util.*;

/*
This method, MagicEightBall, outputs a randomized response when the 'ask()' method is invoked to console.
 */

//TODO Add GUI.



public class MagicEightBall {

    private String question;
    private String response;
    private boolean repeatquestion;
    public repeatQuestion repeatQuestion = new repeatQuestion();
    private final ArrayList<String> responses = new ArrayList<>(Arrays.asList(
            "Yes","No","Ask Another Time","Perhaps","I Plead the Fifth","You Don't Have The Rights To Ask This Question",
            "Definitely","Of Course","Of Course Not","Don't Get Your Hopes Up","I Wouldn't Be Surprised"
    ));

    public MagicEightBall() {
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {return response;}

    public void setRandomResponse() {
        this.response = getResponse();
    }

// Sets Question and Answer for the MagicEightBallObject
    public void setQuestion(String question) {
        this.question = question;
        setRandomResponse();
    }

    private String getResponse() {
        return responses.get(new Random().nextInt(responses.size()));
    }

    public String ask(String question) {
        if(repeatquestion) {
            if (!question.contains("?")) {
//                System.out.println(question + "?" + " \n" + getResponse());
                this.question = question + "?";
                return question + "?" + " \n" + getResponse();
            } else {
//                System.out.println(question + " \n" + getResponse());
                this.question = question;
                return question + " \n" + getResponse();
            }
        } else {
//            System.out.println(getResponse());
            return getResponse();
        }

    }

    public String ask(String question, boolean containsQuestion) {
        boolean temp = repeatquestion;
        if(containsQuestion) {
            repeatquestion = true;
            return ask(question);
        }
            return getResponse();

    }

    public ArrayList<MagicEightBall> ask(ArrayList<String> questions) {

        ArrayList<MagicEightBall> list = new ArrayList<>();

        questions.forEach(a -> {

                if (!a.contains("?")) {
                    list.add(new MagicEightBall(a + "?"));
//                    System.out.println(a + "?" + "\n" + getResponse());
                } else {
                    list.add(new MagicEightBall(a));
//                    System.out.println(a + "\n" + getResponse());
                }

        } );
        return list;
    }

    public MagicEightBall(String question) {
        this.question = question;
        setRandomResponse();
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


