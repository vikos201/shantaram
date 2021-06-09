package ioTask;

/**
 * @author Viktoriia Avramenko
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilteringInfo {
    public  static int countSent;
    public  static int countWords;
    public  static int countVowelsCy;
    public  static int countVowelsLa;
    public  static int countVowels;
    public  static int countConsonantsCy;
    public  static int countConsonantsLa;
    public  static int countConsonants;
    public  static double ratioWordsLaToCy;
    public  static int countLaSym;
    public  static int countCySym;
    public  static int allLitCharacters;
    public  static double ratioLatToCy;
    public  static int countSymbol;
    public  static int countSpaces;
    public  static int countSymAndSpa;
    public  static double ratioSymToSym;


    public static int filterBySentence(String text, File infoFile) {
//Количество предложений:
        for (String st : text.split("[.?!]")) {
            //System.out.println(st);
            countSent++;
        }
        System.out.println("Количество предложений: " + countSent);
        String str = "Количество предложений:" + countSent;
        return countSent;
    }

    public static void filterByWord(String text, File infoFile) {
//Количество слов
        String newText = text.replaceAll("[0-9]", "");
        List<String> list = new ArrayList<>();

        for (String s : newText.split(" ")) {

            if (s.equals("–")){
                //s.replaceAll("–", "");
            } else {
                list.add(s);
                //System.out.println(s);
                countWords++;
            }
        }
        System.out.println("Количество слов: " + countWords);

        //Количество слов начинающихся с гласной буквы (латиница+кириллица). //("[ауоыиэяюёеАУОЫИЭЯЮЁЕ]")

        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if (temp.startsWith("а") || temp.startsWith("А") || temp.startsWith("у") || temp.startsWith("У") || temp.startsWith("о") || temp.startsWith("О")
                    || temp.startsWith("ы") || temp.startsWith("Ы") || temp.startsWith("и") || temp.startsWith("И") || temp.startsWith("э") || temp.startsWith("Э")
                    || temp.startsWith("я") || temp.startsWith("Я") || temp.startsWith("ю") || temp.startsWith("Ю") || temp.startsWith("е") || temp.startsWith("Е")) {
                countVowelsCy++;
                //System.out.println(temp);
            }
        }

        for (int j = 0; j < list.size(); j++) {

            String temp = list.get(j);
            if (temp.startsWith("i") || temp.startsWith("I") || temp.startsWith("u") || temp.startsWith("U") || temp.startsWith("a")
                    || temp.startsWith("A") || temp.startsWith("e") || temp.startsWith("E") || temp.startsWith("y") || temp.startsWith("Y")) {
                countVowelsLa++;
                //System.out.println(temp);
            }
        }
        countVowels = countVowelsCy + countVowelsLa;

        System.out.println("Количество слов начинающихся с гласной буквы (кириллица): " + countVowelsCy);
        System.out.println("Количество слов начинающихся с гласной буквы (латиница): " + countVowelsLa);
        System.out.println("Количество слов начинающихся с гласной буквы (кириллица+латиница): " + countVowels);
        //Количество слов начинающихся с согласной буквы (латиница+кириллица).
        for (int k = 0; k < list.size(); k++) {

            String temp = list.get(k);
            if (temp.startsWith("б") || temp.startsWith("Б") || temp.startsWith("в") || temp.startsWith("В") || temp.startsWith("г") || temp.startsWith("Г")
                    || temp.startsWith("д") || temp.startsWith("Д") || temp.startsWith("ж") || temp.startsWith("Ж") || temp.startsWith("з") || temp.startsWith("З")
                    || temp.startsWith("й") || temp.startsWith("Й") || temp.startsWith("к") || temp.startsWith("К") || temp.startsWith("л") || temp.startsWith("Л")
                    || temp.startsWith("м") || temp.startsWith("М") || temp.startsWith("н") || temp.startsWith("Н") || temp.startsWith("о") || temp.startsWith("О")
                    || temp.startsWith("п") || temp.startsWith("П") || temp.startsWith("р") || temp.startsWith("Р") || temp.startsWith("с") || temp.startsWith("С")
                    || temp.startsWith("т") || temp.startsWith("Т") || temp.startsWith("ф") || temp.startsWith("Ф") || temp.startsWith("х") || temp.startsWith("Х")
                    || temp.startsWith("ц") || temp.startsWith("Ц") || temp.startsWith("ч") || temp.startsWith("Ч") || temp.startsWith("ш") || temp.startsWith("Ш")
                    || temp.startsWith("щ") || temp.startsWith("Щ")) {
                countConsonantsCy++;
                //System.out.println(temp);
            }
        }
        for (int m = 0; m < list.size(); m++) {

            String temp = list.get(m);
            if (temp.startsWith("b") || temp.startsWith("B") || temp.startsWith("c") || temp.startsWith("C") || temp.startsWith("d") || temp.startsWith("D")
                    || temp.startsWith("f") || temp.startsWith("F") || temp.startsWith("g") || temp.startsWith("G") || temp.startsWith("h") || temp.startsWith("H")
                    || temp.startsWith("j") || temp.startsWith("J") || temp.startsWith("k") || temp.startsWith("K") || temp.startsWith("l") || temp.startsWith("L")
                    || temp.startsWith("m") || temp.startsWith("M") || temp.startsWith("n") || temp.startsWith("N") || temp.startsWith("p") || temp.startsWith("P")
                    || temp.startsWith("q") || temp.startsWith("Q") || temp.startsWith("r") || temp.startsWith("R") || temp.startsWith("s") || temp.startsWith("S")
                    || temp.startsWith("t") || temp.startsWith("T") || temp.startsWith("v") || temp.startsWith("V") || temp.startsWith("w") || temp.startsWith("W")
                    || temp.startsWith("x") || temp.startsWith("X") || temp.startsWith("z") || temp.startsWith("Z")) {
                countConsonantsLa++;
                //System.out.println(temp);
            }
        }

        countConsonants = countConsonantsCy + countConsonantsLa;
        System.out.println("Количество слов начинающихся с согласной буквы (кириллица): " + countConsonantsCy);
        System.out.println("Количество слов начинающихся с согласной буквы (латиница): " + countConsonantsLa);
        System.out.println("Количество слов начинающихся с согласной буквы (латиница+кириллица): " + countConsonants);

        //Отношение слов на латинице к словам на кириллице.

        ratioWordsLaToCy = (double) (countVowelsLa + countConsonantsLa) / (countVowelsCy + countConsonantsCy);

        System.out.println("Отношение слов на латинице к словам на кириллице (коефициент): " + ratioWordsLaToCy);
    }
//Отношение латинских символов к кириллическим символам.

    public static void filterByCyLaSymbols(String text, File infoFile) {

//Матчер для латиницы
        Pattern pattern2 = Pattern.compile("[a-zA-Z]");
        Matcher matcherLa = pattern2.matcher(text);
        while (matcherLa.find()) {
            countLaSym++;
        }
//Матчер для кирилицы
        Pattern pattern1 = Pattern.compile("[а-яА-Я]");
        Matcher matcherCy = pattern1.matcher(text);
        while (matcherCy.find()) {
            countCySym++;
        }
        //System.out.println("Количество латинских символов: " + countLaSym);
        //System.out.println("Количество кирилических символов: " + countCySym);
        allLitCharacters = countLaSym + countCySym;
        ratioLatToCy = (double) countLaSym/countCySym;

        System.out.println("Все буквенные символы: " + allLitCharacters);
        System.out.println("Отношение латинских символов к кириллическим символам: " + ratioLatToCy);
    }

    //Количество знаков препинания

    public static void filterBySymbolAndSpaces(String text, File infoFile) {

        Pattern p = Pattern.compile("[^a-zA-Zа-яА-Я0-9\\s]");
        Matcher m = p.matcher(text);
        while (m.find()) {
            countSymbol++;
        }
        System.out.println("Количество знаков препинания: " + countSymbol);

        //Количество пробелов.

        Pattern pS = Pattern.compile("[\\s]");
        Matcher mS = pS.matcher(text);
            while(mS.find())
        {
            countSpaces++;
        }
            System.out.println("Количество пробелов: "+ countSpaces);
        //Отношение знаков препинания к символам (знаки + кол-во пробелов).
        countSymAndSpa = countSpaces + countSymbol;
        System.out.println("Все знаки + кол-во пробелов: " + countSymAndSpa);
        ratioSymToSym = (double) countSymAndSpa / allLitCharacters;

        System.out.println("Отношение знаков препинания к символам (знаки + кол-во пробелов): " + ratioSymToSym);
    }
}
