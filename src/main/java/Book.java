import java.util.Scanner;

public class Book {
    final private String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public void returnBook() {
        System.out.println("(Для выхода в меню наберите слово 'назад')");
        while (true) {
            returnBook = scanner.nextLine();
            if (returnBook.equals(book1) || returnBook.equals(book2) || returnBook.equals(book3)) {
                System.out.println("Книга " + returnBook + " благополучно возвращена");
                break;
            } else if (returnBook.equals(exit)) {
                break;
            } else {
                System.out.println("ГДЕЕЕ МОЯ Книгаааа?!!!");
                System.out.println("(верните книгу,введя ее точное название:)");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            }
        }
    }

    public void libraryBook() {
        System.out.println("Какие книги вас интересуют?");
        System.out.println("(Для выхода в меню наберите слово 'назад')");
        while (true) {
            String ourBook = scanner.nextLine();
            if (ourBook.equals(book1) || ourBook.equals(book2) || ourBook.equals(book3)) {
                System.out.println("Книга " + ourBook + " имеется");
                break;
            } else if (ourBook == null || ourBook.isEmpty()) {
                System.out.println("Вы ничего не выбрали");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            } else if (ourBook.equals(exit)) {
                break;
            } else {
                System.out.println("Здесь, вообще то, приличная библиотека! ");
                System.out.println("У нас доступны следующие книги: 'Некрономикон', " + " \n" +
                        "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
                System.out.println("Введите любую из этих книг ");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            }
        }
    }
}