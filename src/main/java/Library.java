import java.util.Scanner;

public class Library {
    String name = "Аркхема";

    public Library() {
    }

    Book[] books = new Book[]{
            new Book("Дневники Ктулху"),
            new Book("Некрономикон"),
            new Book("Чья эта Чёрная Коза?"),
            new Book("Бибилия")
    };

    public Library(String name) {
        this.name = name;
    }

    private void greeting() {
        System.out.println("Вас приветствует библиотека " + name);
    }

    public void printLibraryMenu() {
        System.out.println(
                "(чтобы выбрать один из пунктов меню,введите соответствующую цифру)\n" +
                        "1. Приветствие\n" +
                        "2. Список книг\n" +
                        "3. Наличие книги\n" +
                        "4. Взять книгу\n" +
                        "5. Вернуть книгу\n" +
                        "6. Тишина должна быть в библиотеке \n" +
                        "7. Выход.\n"
        );
    }

    public void doMenuFunction(int menu) {
        switch (menu) {
            case 1:
                greeting();
                break;
            case 2:
                System.out.println(getAvailableBooks());
                break;
            case 3:
                libraryBook();
                break;
            case 4:
                takeBook();
                break;
            case 5:
                returnBook();
                break;
            case 6:
                System.out.println("Тишина должна быть в библиотеке!");
                break;
            case 7:
                System.out.println("Конец!");
                break;
            default:
                throw new IllegalStateException("Wrong menu");
        }
    }

    private void libraryBook() {
        System.out.println("Введите название книги:\n");
        final Scanner scanner = new Scanner(System.in);
        String userBook = scanner.nextLine();
        if (isExistBook(userBook)) {
            System.out.println("Книга " + userBook + " имеется\n");
        } else if (userBook == null || userBook.isEmpty()) {
            System.out.println("Вы ничего не выбрали\n");
        } else {
            System.out.println("Здесь, вообще то, приличная библиотека! \n");
        }
    }

    private boolean isExistBook(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName) && book.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    private String getTookMessage(String bookName) {
        switch (bookName) {
            case "некрономикон":
                return "Книга 'Некрономикон' взята...и вы начинаете испытывать неописуемый УЖАС!";
            case "дневники ктулху":
                return "взята...и Пх'нглуи мглв'нафх Ктулху Р'льех вгах'нагл фхтагн!";
            case "чья эта чёрная коза?":
                return "взята...и Вы слышите шёпот, говорящий 'Ничья'";
            default:
                return "взята...и ничего не случилось";
        }
    }

    private String getAvailableBooks() {
        String message = "Доступны следующие книги:";
        for (Book book : books) {
            if (book.isAvailable()) {
                message = message + "'" + book.getBookName() + "', ";
            }
        }
        return message;
    }

    private Book getBookByName(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    private void takeBook() {
        System.out.println("Какую книгу будете брать?:");
        System.out.println(getAvailableBooks());
        final Scanner scanner = new Scanner(System.in);
        String nameBook = scanner.nextLine();
        if (isExistBook(nameBook)) {
            Book book = getBookByName(nameBook);
            if (book != null) {
                System.out.println(getTookMessage(nameBook.toLowerCase()));
                book.setAvailable(false);
            } else {
                throw new IllegalStateException("Book not found");
            }
        } else {
            System.out.println("Такой книги у нас нет, или Вы неправильно вводите название!" + "\n" +
                    "В любом случае мы не виноваты =) Выберите еще раз из списка, пожалуйста");
        }
    }


    public void returnBook() {
        System.out.println("Подержали? А теперь верните книгу,введя ее точное название:");
        final Scanner scanner = new Scanner(System.in);
        String nameBook = scanner.nextLine();
        Book resultBook = null;
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(nameBook) && !book.isAvailable()) {
                resultBook = book;
            }
        }
        if (resultBook == null) {
            System.out.println("Вы ошиблись библиотекой");
        } else {
            System.out.println("Книга " + nameBook + " благополучно возвращена");
            resultBook.setAvailable(true);
        }
    }
}

