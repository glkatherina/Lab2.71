import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class Main {

    /**
     Метод, считывающий данные о блюдах из файла и выводящий их в форматированном виде.
     @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Menu[] restaurantmenu = new Menu[50];

        try {
            FileReader fileReader = new FileReader("D:\\УНИВЕР\\II курс\\ASDC\\Lab2.71\\src\\menu.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            for (int i = 0; i < restaurantmenu.length; i++) {
                restaurantmenu[i] = new Menu();
                restaurantmenu[i].readingFile(bufferedReader);
            }

            Formatter form = new Formatter(System.out);
            for (int i = 0; i < restaurantmenu.length; i++) {
                restaurantmenu[i].writeTable(form);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}



