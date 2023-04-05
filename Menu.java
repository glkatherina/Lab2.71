import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

//класс Меню
/**

 Класс, описывающий блюдо в меню ресторана.
 */
public class Menu
{
    private String name; // Название блюда
    private int price; // Стоимость блюда
    private int weight; // Масса
    private String kind; // Вид (Постное/Кашерное/Диетическое)
    private String type; // Тип (Первое блюдо/Второе блюдо/Салат/Закуска/Напиток)

    /**

     Конструктор класса без параметров.
     Устанавливает значения полей объекта в значения по умолчанию.
     */
    public Menu()
    {
        name = "None";
        price = 0;
        weight = 0;
        kind = "None";
        type = "None";
    }
    /**

     Конструктор класса, создающий объект на основе другого объекта того же класса.
     @param other - другой объект класса Menu, на основе которого создается новый объект.
     */
    public Menu(Menu other)
    {
        name = other.name;
        price = other.price;
        weight = other.weight;
        kind = other.kind;
        type = other.type;
    }
    /**

     Метод создания копии текущего объекта.
     @return Возвращает новый объект класса Menu, являющийся копией текущего объекта.
     */
    public Menu clone()
    {
        return new Menu(this);
    }
    /**

     Метод сравнения текущего объекта с другим объектом того же класса.
     @param other - другой объект класса Menu, с которым нужно сравнить текущий объект.
     @return Возвращает true, если объекты равны (имеют одинаковые значения полей), и false в противном случае.
     */
    public boolean equal(Menu other)
    {
        return (name.equals(other.name) &&
                price == other.price &&
                weight == other.weight &&
                kind.equals(other.kind) &&
                type.equals(other.type));
    }
    /**

     Метод чтения данных из файла и инициализации полей объекта.

     @param reader - объект класса BufferedReader, используемый для чтения данных из файла.

     @throws IOException - исключение, которое может возникнуть при чтении данных из файла.
     */
    public void readingFile(BufferedReader reader) throws IOException
    {
        String line = reader.readLine(); // читаем первую строку файла
        String[] fields = line.split(", "); // разделяем её на поля

        name = fields[0]; // первое поле - название блюда
        price = Integer.parseInt(fields[1]); // второе поле - стоимость блюда
        weight = Integer.parseInt(fields[2]); // третье поле - масса блюда
        kind = fields[3]; // четвёртое поле - вид блюда
        type = fields[4]; // пятое поле - тип блюда
    }

/**

 Метод вывода данных о блюде в консоль в виде списка.
 Выводит название блюда, стоимость, массу, вид и тип блюда через запятую.
 */
            public void writeElement()
            {
                System.out.println( name + ", " +
                        price + ", " +
                        weight + ", " +
                        kind + ", " +
                        type);
            }
/**

 Метод вывода данных о блюде в консоль в виде таблицы.
 @param formatter объект класса Formatter, который используется для форматирования вывода
 Выводит название блюда, стоимость, массу, вид и тип блюда в виде таблицы с заданным форматированием.
 */
            public void writeTable(Formatter formatter)
            {
                formatter.format("%-50s Стоимость: %-10d гр:%-10d %-15s %s\n", name, price, weight, kind, type);
            }
        }