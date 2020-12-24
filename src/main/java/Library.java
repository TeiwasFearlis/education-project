import java.util.Scanner;

public class Library {
    String name = "Аркхема";
    Library() {

    }

    Book[] books = new Book[]{new Book("Дневники Ктулху"),new Book("Некрономикон"),new Book("Чья эта Чёрная Коза?")};

    Library(String name) {
        this.name = name;
    }

    private void greeting(){
        System.out.println("Вас приветствует библиотека "+name);
    }

    public void printLibraryMenu(){
        System.out.println(
                "(чтобы выбрать один из пунктов меню,введите соответствующую цифру)\n"+
                "1. Приветствие\n" +
                        "2. Наличие книги\n" +
                        "3. Взять книгу\n" +
                        "4. Вернуть книгу\n" +
                        "5. Тишина должна быть в библиотеке \n" +
                        "6. Выход.\n"
        );
    }
    Book aBook=  new Book();

    public void doMenuFunction(int menu){
        switch (menu) {
            case 1:
                greeting();
                break;
            case 2:
                aBook.libraryBook();
                break;
            case 3:
                aBook.book();
                break;
            case 4:
                System.out.println("Подержали? А теперь верните книгу,введя ее точное название:");
                aBook.returnBook();
                break;
            case 5: System.out.println("Тишина должна быть в библиотеке!");
                break;
            case 6: System.out.println("Конец!");
                break;
            default:
                throw new IllegalStateException("Wrong menu");
        }
    }

    private boolean isExistBook(String bookName){

    }

    private void takeBook() {
        System.out.println("Какую книгу будете брать?:");
        System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
        final Scanner scanner = new Scanner(System.in);
        String nameBook = scanner.nextLine();
            if (nameBook.equalsIgnoreCase(book1)) {
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
            } else {
                System.out.println("Такой книги у нас нет, или Вы неправильно вводите название!" + "\n" +
                        "В любом случае мы не виноваты =) Выберите еще раз из списка, пожалуйста");
                System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                        "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
                System.out.println("(Для выхода в меню наберите слово 'назад')");

        }
    }
}

