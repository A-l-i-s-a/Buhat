package com.example.buhat.chat;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Generator {

    public static ArrayList<Chat> generatorProduct(int count) {
        ArrayList<Chat> chats = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            String[] msg = generateRandomWords((int) (1 + (Math.random() * 10)));
            ArrayList<Msg> msgs = new ArrayList<>();

            for (int j = 0; j < msg.length; j++) {
                String name = "";
                if (j % 2 == 0) {
                    name = "User 1";
                } else {
                    name = "User 2";
                }

                msgs.add(new Msg(name, msg[j], Calendar.getInstance()));
            }
            chats.add(new Chat(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)), generateRandomWords(1)[0], msgs));
        }


        return chats;
    }

    private static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                if (j == 0) {
                    word[j] = (char) ('A' + random.nextInt(26));
                } else {
                    word[j] = (char) ('a' + random.nextInt(26));
                }
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
}
