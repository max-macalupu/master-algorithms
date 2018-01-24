package com.algorithms;

import java.util.*;
import java.util.stream.Collectors;

//Give array of string, find anagrams groups
public class Array_FindAnagrams {

    public static void main(String[] args) {
        String [] words = {"cat", "atc", "book", "oobk", "car", "rac", "pen", "nep", "cta", "npe"};
//        processFirstWay(words);
        processSecondWay(words);
    }

    private static void processSecondWay(String[] words) {
        Map<String, List<String>> anagrams = getAnagramsWords(words);
        anagrams.forEach((x, y) -> {
          System.out.println();
          y.forEach( t -> {
                  System.out.print(t + ",");
          });
        });
    }

    private static Map<String,List<String>> getAnagramsWords(String[] words) {
//        Map<String, List<String>> anagramsMap = new HashMap<>();
        return Arrays.stream(words).collect(Collectors.groupingBy(x -> sortedWord(x)));
//        for (String word: words) {
//            String sortedWord = sortedWord(word);
//            if (anagramsMap.get(sortedWord) == null) {
//                anagramsMap.put(sortedWord, new ArrayList<>());
//            }
//            anagramsMap.get(sortedWord).add(word);
//        }
//        return anagramsMap;
    }

    private static String sortedWord(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        return String.valueOf(characters);
    }

    private static void processFirstWay(String[] words) {
        String [] orderedWords = orderedWords(words);
        Map<String, List<Integer>> anagramAndIndexes = new HashMap<>();
        for(int i=0; i<orderedWords.length; i++) {
            if (anagramAndIndexes.get(orderedWords[i]) == null) {
                anagramAndIndexes.put(orderedWords[i], new ArrayList<>());
            }
            anagramAndIndexes.get(orderedWords[i]).add(i);
        }
        List<String[]> finalAnagram = new ArrayList<>();
        for(List<Integer> anagram: anagramAndIndexes.values()) {
            String [] arrayData = anagram.stream().map(x -> words[x]).toArray(String[]::new);
            finalAnagram.add(arrayData);
        }
        finalAnagram.forEach(x -> {
            System.out.println();
            Arrays.stream(x).peek(y -> System.out.print(y + ", ")).count();
        });
    }

    private static String[] orderedWords(String[] words) {
        List<String> orderedWords = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            char[] characterList = words[i].toCharArray();
            for(int j =0; j<characterList.length-1; j++) {
                for(int k=j; k<characterList.length; k++) {
                    if (characterList[j] > characterList[k]) {
                        char tmp = characterList[j];
                        characterList[j] = characterList[k];
                        characterList[k] = tmp;
                    }
                }
            }
            orderedWords.add(new String(characterList));
        }
        return orderedWords.stream().toArray(String[]::new);
    }


}