package com.ivosv.pangramexercise;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Character> alphabet = new ArrayList<>();
    static ArrayList<Character> letters = new ArrayList<>();
    static ArrayList<String> days= new ArrayList<>();




    static String testSentence = "Pack my box with five dozen liquor jugs";
    static String words = "";

    public static void testAlpha() {

        for (int i = 0; i <= alphabet.size() - 1; i++) {

            /* Alternate conditional


            if (testSentence(alphabet.get(i))) {
                Log.d("Slovo: ", "OK");
            } else {

                words+=alphabet.get(i);
            }*/

            words += testSentence(alphabet.get(i)) ? "" : alphabet.get(i);

        }

    }

    //97 - 122

    public static boolean testSentence(char c) {

        for (int i = 0; i <= testSentence.length() - 1; i++) {

            if (c == testSentence.toLowerCase().charAt(i)) {

                return true;
            }


        }
        return false;

    }

    private static char[] fillArray() {
      //  for (int i = 97; i <= 122; i++) {
        int br=0;
        for (int i = 122; i <= 97; i--) {

            alphabet.add((char) i);
        }
        char[] al=new char[alphabet.size()];
        for(char a:alphabet){


            al[br]=a;
            br++;
        }
        return al;
    }

    public void start() {


        char[] al=fillArray();
        testAlpha();

        Log.d("Slova iz stringa: ", words);

        Log.d("Sort: ", alphabet.toString());


        days.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.indexOf(0)<o2.indexOf(0)){

                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(String da:days){

            Log.d("Dani: ", da);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        days.add("Ponediljak");
        days.add("Utorak");
        days.add("Srida");
        days.add("Cetvrtak");
        days.add("Petak");
        days.add("Subota");
        days.add("Nedilja");



        start();

    }
}




