import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Main {

    static JFrame Frame = new JFrame();
    static int length = 0, overallLength = 0, wordCounter = 0, random;
    static Random rand = new Random();

    static ArrayList<String> wordList = new ArrayList<>();
    static String word1, word2, word3;

    static JLabel Word1 = new JLabel(), Word2 = new JLabel(), Word3 = new JLabel(), ScorePoints = new JLabel(), CurrentWord = new JLabel(" ");

    static Timer Stopwatch = new Timer();
    static long Start, End;

    public Main() {

        JPanel Panel = new JPanel();
        JPanel Score = new JPanel();
        JPanel Correct = new JPanel();

        Frame.setFocusable(true);
        Frame.setLocation(0, 0);
        Frame.setVisible(true);
        Container C = Frame.getContentPane();
        C.setBackground(Color.ORANGE);
        Frame.setTitle("Words Per Minute");
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.setSize(500, 250);
        word1 = wordList.get(rand.nextInt(wordList.size()));

        Frame.setLayout(new BorderLayout());

        Panel.add(Word1);
        Panel.add(Word2);
        Panel.add(Word3);

        Word1.setFont(new Font("Verdana", Font.BOLD, 25));
        Word2.setFont(new Font("Verdana", Font.PLAIN, 25));
        Word3.setFont(new Font("Verdana", Font.PLAIN, 25));

        Word1.setVerticalAlignment(JLabel.BOTTOM);

        ScorePoints.setText("0");
        Score.add(ScorePoints);

        ScorePoints.setFont(new Font("Verdana", Font.BOLD, 35));

        CurrentWord.setFont(new Font("Verdana", Font.BOLD, 25));
        Correct.add(CurrentWord);

        //Score.setLocation(0, 50);
        //Score.setSize(500, 200);
        Score.setBackground(Color.WHITE);

        //Panel.setLocation(0, 200);
        //Panel.setSize(500, 300);
        Panel.setBackground(Color.WHITE);

        //Correct.setLocation(0, 0);
        //Correct.setSize(500, 50);
        Correct.setBackground(Color.GREEN);

        Frame.add(Score, BorderLayout.SOUTH);
        Frame.add(Panel, BorderLayout.CENTER);
        Frame.add(Correct, BorderLayout.NORTH);

        Correct.revalidate();
        Panel.revalidate();
        Score.revalidate();
        Frame.revalidate();


        Frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == word1.charAt(length)) {
                    Correct.setBackground(Color.GREEN);
                    length++;
                    overallLength++;
                    CurrentWord.setText(word1.substring(0, length));
                    if (length == word1.length()) {
                        random = rand.nextInt(wordList.size());
                        word1 = word2;
                        word2 = word3;
                        word3 = wordList.get(rand.nextInt(wordList.size()));
                        Word1.setText(word1);
                        Word2.setText(word2);
                        Word3.setText(word3);
                        wordCounter++;
                        End = System.currentTimeMillis();

                        double WPM = (double) wordCounter / ((End - Start) * 0.00001666666667);
                        WPM = Math.round(WPM);

                        ScorePoints.setText("WPM: " + WPM);
                        length = 0;
                    }
                } else {
                    length = 0;
                    Correct.setBackground(Color.RED);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {

        wordList.add("marta");
        wordList.add("jest");
        wordList.add("super");
        wordList.add("kocham");
        wordList.add("marte");
        wordList.add("piekna");
        wordList.add("cudowna");
        wordList.add("aaa");
        wordList.add("wspaniala");
        wordList.add("kaczki");

        word1 = wordList.get(rand.nextInt(wordList.size()));
        word2 = wordList.get(rand.nextInt(wordList.size()));
        word3 = wordList.get(rand.nextInt(wordList.size()));

        Main App = new Main();

        Word1.setText(word1);
        Word2.setText(word2);
        Word3.setText(word3);

        Start = System.currentTimeMillis();

        while (true) {

        }
    }
}