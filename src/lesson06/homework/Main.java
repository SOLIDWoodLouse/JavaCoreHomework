package lesson06.homework;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String textFileOne = "/Users/romanbocharov/IdeaProjects/JavaCoreHomework/src/lesson06/homework/files/text_one.txt";
    private static final String textFileTwo = "/Users/romanbocharov/IdeaProjects/JavaCoreHomework/src/lesson06/homework/files/text_two.txt";
    private static final String textFileThree = "/Users/romanbocharov/IdeaProjects/JavaCoreHomework/src/lesson06/homework/files/text_three.txt";
    private static final File fileFolder = new File("/Users/romanbocharov/IdeaProjects/JavaCoreHomework/src/lesson06/homework/files");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите текст который нужно записать в первый файл:");
        String textOne = scanner.nextLine();
        createFile(textOne, textFileOne, false);

        System.out.println("Введите текст который нужно записать во второй файл:");
        String textTwo = scanner.nextLine();
        createFile(textTwo, textFileTwo, false);

        //2.2 Склеиваем в отдельном файле текст из первых созданных файлов
        createFile(createText(textFileOne), textFileThree, false);
        createFile(createText(textFileTwo), textFileThree, true);

//        createFile(createText(textFileOne, textFileTwo), textFileThree, true);

        System.out.println("Введите желаемое слово которое нужно найти в тексте");
        String word = scanner.nextLine();

        System.out.println(findText(textFileThree, word));
        System.out.println(findTextInFolder(fileFolder, word));

    }

    //1. Создаем файлы, нужно было просто созать файлы, я решил попрактиковаться с информацией с урока и создать
    //файлы программно
    private static void createFile(String text, String textFile, Boolean bl) {

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(textFile, bl);
            byte[] textBuffer = text.getBytes();
            fos.write(textBuffer, 0, textBuffer.length);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //2.1. тут мы берем текст из файла и возвращаем его в String. В задании говориться, что нужно сделать метод, а не методы,
    //по этому процесс создания третьего файла из двух я привел ниже и закомментировал
    private static String createText(String textFile) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fisOne = new FileInputStream(textFile);
            int outbox;
            while ((outbox = fisOne.read()) != -1) {
                stringBuilder.append((char) outbox);
            }
            fisOne.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();

    }

//    private static String createText(String textFileOne, String textFileTwo) {
//
//        String[] texts = {textFileOne, textFileTwo};
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < texts.length; i++) {
//            try {
//                FileInputStream fisOne = new FileInputStream(texts[i]);
//                int outbox;
//                while ((outbox = fisOne.read()) != -1) {
//                    stringBuilder.append((char) outbox);
//                }
//                fisOne.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return stringBuilder.toString();
//
//    }

    //3.ищем слово в файле
    private static String findText(String textFile, String word) {

        String text = createText(textFile);

        String[] textElements = text.split(" ");

        for (String textElement : textElements) {
            if (textElement.equals(word)) {
                return "Ваше слова есть в тексте";
            }
        }
        return "Такого слова в тексте нет";
    }

    //4. ищем слово в папке
    private static String findTextInFolder(File folder, String word) {

        File[] files = folder.listFiles();

        for (File file : files) {

            String text = createText(file.toString());

            String[] textElements = text.split(" ");

            for (String textElement : textElements) {
                if (textElement.equals(word)) {
                    return "Ваше слово есть в папке.";
                }
            }

        }
        return "Вашего слова в папке нет";
    }

}
