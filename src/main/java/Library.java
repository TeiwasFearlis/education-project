
public class Library {
    String name = "Аркхема";
    Library() {

    }

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
    Book a2Book = new Book();
    Book a3Book= new Book();


    public void doMenuFunction(int menu){
        switch (menu) {
            case 1:
                greeting();
                break;
            case 2:
           a3Book.libraryBook();
                break;
            case 3:
                aBook.book();
                break;
            case 4:
                System.out.println("Подержали? А теперь верните книгу,введя ее точное название:");
                a2Book.returnBook();
                break;
            case 5: System.out.println("Тишина должна быть в библиотеке!");
                break;
            case 6: System.out.println("Конец!");
                break;
            default:
                throw new IllegalStateException("Wrong menu");
        }
    }
}

