package ioTask;

/**
 * @author Viktoriia Avramenko
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class InfoClass {
/*
Абсолютный путь файла +имя файла
Размер файла. (в килобайтах)
Атрибуты файла (Просмотр, Чтение, Скрытый и тд).
Количество предложений.
Количество слов.
Количество знаков препинания.
Количество пробелов.
Количество слов начинающихся с гласной буквы (латиница+кириллица).
Количество слов начинающихся с согласной буквы (латиница+кириллица).
Отношение слов на латинице к словам на кириллице.
Отношение латинских символов к кириллическим символам.
Отношение знаков препинания к символам (знаки + кол-во пробелов).
*/

    public static void getInfoMethod(File infoFile, File srcFile) {
        if (infoFile.exists()) {

            try {
                Path file = Paths.get("src/main/resources/SourceFolder/Shantaram.txt" );
                BasicFileAttributes attr = null;
                try {
                    attr = Files.readAttributes(file, BasicFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DosFileAttributes attr1 = null;
                try {
                    attr1 = Files.readAttributes(file, DosFileAttributes.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String absPathAndName = "1. Абсолютный путь файла: " + srcFile.getAbsolutePath() + "          Имя файла: " + srcFile.getName();
                String size = "2. Размер файла. (в килобайтах): " + (attr.size() /1024); //size() Returns the size of the file (in bytes).
                String state = "3. Атрибуты файла (Чтение): " + attr1.isReadOnly() + " (Скрытый): " + attr1.isReadOnly() + " isArchive is: " + attr1.isArchive() + " isSystem is: " + attr1.isSystem();
                String strQ = "4. Количество предложений: " + FilteringInfo.countSent;
                try(FileWriter writer = new FileWriter(infoFile, false)){
                    writer.write(absPathAndName);
                    writer.append('\n');

                    writer.write(size);
                    writer.append('\n');

                    writer.write(state);
                    writer.append('\n');

                    writer.write(strQ);
                    writer.append('\n');

                    writer.write("5. Количество слов: " + FilteringInfo.countWords);
                    writer.append('\n');

                    writer.write("6. Количество знаков препинания: " + FilteringInfo.countSymbol);
                    writer.append('\n');

                    writer.write("7. Количество пробелов: "+ FilteringInfo.countSpaces);
                    writer.append('\n');

                    writer.write("8. Количество слов начинающихся с гласной буквы (кириллица+латиница): " + FilteringInfo.countVowels);
                    writer.append('\n');

                    writer.write("9. Количество слов начинающихся с согласной буквы (кириллица+латиница): " + FilteringInfo.countConsonants);
                    writer.append('\n');

                    writer.write("10. Отношение слов на латинице к словам на кириллице: " + FilteringInfo.ratioWordsLaToCy);
                    writer.append('\n');

                    writer.write("11. Отношение латинских символов к кириллическим символам: " + FilteringInfo.ratioLatToCy);
                    writer.append('\n');

                    writer.write("12. Отношение знаков препинания к символам (знаки + кол-во пробелов): "+ FilteringInfo.ratioSymToSym);
                    writer.append('\n');
                }
                catch (FileNotFoundException fnf){
                    fnf.printStackTrace();
                }
                catch (IOException io){
                    io.printStackTrace();
                }


            } catch (UnsupportedOperationException x) {
                System.err.println("DOS file" +
                        " attributes not supported:" + x);
            }
        } else {
            System.out.println(srcFile + " file not found!");
        }
    }
}
/*try (FileWriter writer = new FileWriter(infoFile, false)) {
            writer.write("Количество слов: " + countWords);
            writer.append('\n');
            writer.write("Количество слов начинающихся с гласной буквы (кириллица+латиница): " + countVowels);
            writer.append('\n');
            writer.write("Количество слов начинающихся с согласной буквы (кириллица+латиница): " + countConsonants);
            writer.append('\n');
            writer.write("Отношение слов на латинице к словам на кириллице: " + ratio);
            writer.append('\n');
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }*/