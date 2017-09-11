package ru.stga.pdt.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args){
     //String[] langs = {"Java", "C++", "Python"};
     //List<String> languages = new ArrayList<String>();
    List<String> languages = Arrays.asList("Java", "C++", "Python");
     languages.add("C#");
     for (String l: languages){
       System.out.println("I want to learn" + " " + l);
     }







      // for (int i = 0; i < langs.length; i++){
     //  System.out.println("I want to learn" + " " + langs[i]);
    // }
  }
}
