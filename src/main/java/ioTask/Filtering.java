package ioTask;

/**
 * @author Viktoriia Avramenko
 */
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filtering {
   public static void writeTo(File cyrillic, File latin, File srcFile) {

       try (FileInputStream fis = new FileInputStream(srcFile);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader buffReader = new BufferedReader(isr);
            FileOutputStream fos1 = new FileOutputStream(cyrillic);
            FileOutputStream fos2 = new FileOutputStream(latin)) {
           //byte[] buffer = new byte[fin.available()];

           //fos1.write(buffer, 0, buffer.length);
           StringBuilder sb = new StringBuilder();
           StringBuilder sb1 = new StringBuilder();
           StringBuilder sb2 = new StringBuilder();
           int buff;
           while ((buff = buffReader.read()) > -1) {
               sb.append((char) buff);
           }
           String text1 = sb1.toString();
           String text2 = sb2.toString();
//Матчер для кирилицы
           Pattern pattern1 = Pattern.compile("[a-zA-Z]");
           Matcher matcherCy = pattern1.matcher(sb.toString());

           text1 = matcherCy.replaceAll("");


//Матчер для латиницы
           Pattern pattern2 = Pattern.compile("[^a-zA-Z\\s]");
           Matcher matcherLa = pattern2.matcher(sb.toString());

           text2 = matcherLa.replaceAll("");
                                                                            //дописать матчер чтоб убирал лишние пробелы, пробелы вне текста текста
           fos1.write(text1.getBytes());
           fos2.write(text2.getBytes());

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

        public static void getApropriateFile(File cyrillic, File latin, File srcFile, File infoFile) {

           StringBuilder sb = new StringBuilder();

           try (FileInputStream fis = new FileInputStream(srcFile);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader buffReader = new BufferedReader(isr);){
                int buff;
                while ((buff = buffReader.read()) > -1) {
                   sb.append((char) buff);
                }
                String text = sb.toString();

               int countSent = FilteringInfo.filterBySentence(text, infoFile);
               FilteringInfo.filterByWord(text, infoFile);
               FilteringInfo.filterByCyLaSymbols(text, infoFile);
               FilteringInfo.filterBySymbolAndSpaces(text, infoFile);


           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
}
