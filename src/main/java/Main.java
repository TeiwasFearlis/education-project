import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Name name = new Name();
        System.out.println("Для конспирации вы можете сменить название библиотеки");
        System.out.println("Введите новое название:");
        String nameLibrary = scanner.nextLine();
        Name rename = new Name(nameLibrary);
        System.out.println("В нашей библиотеке " + nameLibrary+ " доступны следующие книги: 'Некрономикон', " +" \n" +
                "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
        System.out.println("Какую книгу будете брать?:");
        Book aBook = new Book();
        aBook.book();
        System.out.println("Подержали? А теперь верните книгу,введя ее точное название:");
        Book a2Book = new Book();
        a2Book.returnBook();
        System.out.println("Тишина должна быть в библиотеке, а теперь всего хорошего!");
        System.out.println("Конец!");
    }

}
