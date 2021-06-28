package ioTask;

/**
 * @author Viktoriia Avramenko
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOTaskCyrilic {
    /*Дан файл Shantaram.txt
    Необходимо написать программу, которая выполнить чтение содержимого из файла и анализ текста, после которого программа генерирует файлы содержащие следующую информацию:
    1. Файл содержащий только кириллический текста
    2. Файл содержащий только текст на латинице.
    3. Файл содержащий информацию о тексте.*/

    /*
    реализация:
       1. Создадим 2 новых файла куда поместим только кирилические символы/только латиницу File
       2. Считаем и запишем с помощью InputStream/OutputStream
       3. В процессе записи отфильтруем на кирилицу и закинем в файл1 и латиницу в файл 2
       4. Создадим файл 3 куда будем писать информацию о тексте для первого и второго файлов
       5. Создадим интерфейсы/методы в классе которые будут иметь методы количество предложений, слов, знаков препинания, пробелов...
       6. Метоод/интерфейс который будет узнавать абс путь и имя файла, размер, атрибуты.
       7. Искл. ситуации обработать

       */
    public static void main(String[] args) {
            File myDir = new File("src/main/resources/ResultFolder");
            if(!myDir.exists()) {
                myDir.mkdir();

            System.out.println("Dir has been created");
            }
            else{
                System.out.println("Dir already exist!");
            }

        File cyrillic = new File(myDir + "/" + "cyrillic.txt");
        File latin = new File(myDir + "/" + "latin.txt");
        File infoFile = new File(myDir + "/" + "infoFile.txt");

        List<File> listFiles = new ArrayList<File>();
        listFiles.add(cyrillic);
        listFiles.add(latin);
        listFiles.add(infoFile);

        for (int i = 0; i < listFiles.size(); i++) {
            try {
                if (!listFiles.get(i).exists()) {
                    listFiles.get(i).createNewFile();
                    System.out.println("file created!!!");
                } else {
                    System.out.println(listFiles.get(i).getName() + "       file is already exist!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File srcFile = new File("src/main/resources/SourceFolder/Shantaram.txt");

        Filtering.writeTo(cyrillic, latin, srcFile);
        Filtering.getApropriateFile (cyrillic, latin, srcFile, infoFile);
        InfoClass.getInfoMethod(infoFile, srcFile);


    }
}
