package com.Todd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void playGame(){
        Scanner sc= new Scanner(System.in);
        ArrayList<TriviaQuestion> questionsForGame = importQuestions();
        Player player = new Player();

        int count = 0;
        while (count < 5){
            Random random = new Random();
            int randomInt = random.nextInt(questionsForGame.size()-1) + 1;
            TriviaQuestion question = questionsForGame.get(randomInt);
            if (question.isQuestionAsked()){
                continue;
            }
            count++;
            System.out.println(question.getQuestion());
            System.out.println("A) " + question.getFirstOption());
            System.out.println("B) " + question.getSecondOption());
            System.out.println("C) " + question.getThirdOption());
            System.out.println("Please note that any inputs other than A, B, or C will be marked as incorrect.");
            question.setQuestionAsked(true);

            String userAnswer = sc.nextLine();

            switch (userAnswer.toUpperCase()){
                case "A":
                    if (question.getFirstOption().equals(question.getCorrectAnswer())){
                        player.setScore(player.getScore() + 1);
                        break;
                    }
                    else{
                        break;
                    }
                case "B":
                    if (question.getSecondOption().equals(question.getCorrectAnswer())){
                        player.setScore(player.getScore() + 1);
                        break;
                    }
                    else{
                        break;
                    }
                case "C":
                    if (question.getThirdOption().equals(question.getCorrectAnswer())){
                        player.setScore(player.getScore() + 1);
                        break;
                    }
                    else{
                        break;
                    }
                default:
                    break;
            }
        }
        System.out.println("Your final score was " + player.getScore() + " out of " + count);
    }

    public ArrayList<TriviaQuestion> importQuestions(){
        //this holds the csv file location
        String fileName = "MovieTriviaQA.csv";
        String line;
        String splitBy = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
        int lineCount = 0;
        //Buffered reader class is a java.io class which reads
        //a character input file, it reads lines and arrays
        //File reader opens the given file in read mode
        ArrayList<TriviaQuestion> questionArrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            //readline function is used to read a line from the file
            while ((line = bufferedReader.readLine()) != null){
                lineCount++;
                if (lineCount == 1){
                    continue;
                }
                //loop will continue until the line ends
                String[] triviaData = line.split(splitBy);
                // split function use to split the words in the line by commas
                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(triviaData[0].replace("\"",""));
                question.setFirstOption(triviaData[1].replace("\"",""));
                question.setSecondOption(triviaData[2].replace("\"",""));
                question.setThirdOption(triviaData[3].replace("\"",""));
                question.setCorrectAnswer(triviaData[4].replace("\"",""));
                questionArrayList.add(question);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return questionArrayList;
    }
}
