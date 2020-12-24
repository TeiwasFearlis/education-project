import java.util.Scanner;

public class Book {
    String book1 = "Некрономикон";
    String book2 = "Дневники Ктулху";
    String book3 = "Чья эта Чёрная Коза?";
    final Scanner scanner = new Scanner(System.in);

   public String nameBook;
    String exit = "назад";
    public void book() {
        System.out.println("Какую книгу будете брать?:");
        System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
        System.out.println("(Для выхода в меню наберите слово 'назад')");
        while (true) {
            nameBook = scanner.nextLine();
            if (nameBook.equals(book1)) {
                System.out.println("Книга " + nameBook + " взята...и вы начинаете испытывать неописуемый УЖАС!");
                break;
            } else if (nameBook.equals(book2)) {
                System.out.println("Книга " + nameBook + " взята...и Пх'нглуи мглв'нафх" +
                        " Ктулху Р'льех вгах'нагл фхтагн!");
                break;
            } else if(nameBook==null|| nameBook.isEmpty()){
                System.out.println("Вы ничего не выбрали");
                System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                        "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            } else if (nameBook.equals(book3)) {
                System.out.println("Книга " + nameBook + " взята...и Вы слышите шёпот, говорящий 'Ничья'");
                break;
            } else if(nameBook.equals(exit)){
                break;
            } else {
                System.out.println("Такой книги у нас нет, или Вы неправильно вводите название!" + "\n" +
                        "В любом случае мы не виноваты =) Выберите еще раз из списка, пожалуйста");
                System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                        "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            }
        }
    }

    public String returnBook;

    public void returnBook() {
        System.out.println("(Для выхода в меню наберите слово 'назад')");
        while (true) {
            returnBook = scanner.nextLine();
            if (returnBook.equals(book1)||returnBook.equals(book2)||returnBook.equals(book3)) {
                System.out.println("Книга " + returnBook + " благополучно возвращена");
                break;
            } else if(returnBook.equals(exit)){
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
            if (ourBook.equals(book1)||ourBook.equals(book2)||ourBook.equals(book3)) {
                System.out.println("Книга " + ourBook + " имеется");
                break;
            } else if(ourBook==null|| ourBook.isEmpty()){
                System.out.println("Вы ничего не выбрали");
                System.out.println("(Для выхода в меню наберите слово 'назад')");
            } else if(ourBook.equals(exit)){
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