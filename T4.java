import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

class Quiz_App {
    static String[] question =

            {
                    " What are the features of Software Code ?", " Who proposed Function Points ?",
                    " What is system software ? "
            };

    static String[][] choice = {
            { "A.Simplicity", "B.Accessibility", "C.Modularity", "D.All of the Above" },
            { "A.Albrecht", "B.Jacobson", "C.Boehm", "D.Booch" },
            { "A.Computer program", "B.Testing", "C.Ai", "D.IOT" }
    };

    static String[] answ = { "C", "A", "A" };
    static int score = 0;
    static Timer ti;

    Quiz_App() {
        System.out.println("Welcome To Quiz !");
        System.out.println("You Will Get 10 seconds For Each Question");
        tim_fun();
        ques_fun();
        ti.cancel();
        System.out.println("Congrats!,You Have successfully Completed the Quiz");
        System.out.println("Your Final Score is " + score);
    }

    void tim_fun() {
        ti = new Timer();
        ti.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Time up!");
                        System.out.println("Your Final Score is " + score);
                        ti.cancel();
                        System.exit(0);
                    }
                },
                10000);
    }

    void ques_fun() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < question.length; i++) {
            System.out.println((i + 1) + "" + question[i]);
            for (String choic : choice[i]) {
                System.out.println(choic);
            } // for loop end
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();
            if (userAnswer.equals(answ[i])) {// if else
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        } // for loop end
    }

    public static void main(String args[])///// main ()
    {
        Quiz_App qp = new Quiz_App();
    }
}