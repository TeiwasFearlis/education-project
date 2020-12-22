import java.util.Scanner;

public class Book {
    String book1 = "Некрономикон";
    String book2 = "Дневники Ктулху";
    String book3 = "Чья эта Чёрная Коза?";
    final Scanner scanner = new Scanner(System.in);

   // public String getNameBook() {
   //     return nameBook;
   // }

   //public void setNameBook(String nameBook) {
    //   this.nameBook = nameBook;
   // }
  //private String nameBook;
   public String nameBook;
    public void book() {
        while (true) {
            nameBook = scanner.nextLine();
            if (nameBook.equals(book1)) {
                System.out.println("Книга " + nameBook + " взята...и вы начинаете испытывать неописуемый УЖАС!");
                break;
            } else if (nameBook.equals(book2)) {
                System.out.println("Книга " + nameBook + " взята...и Пх'нглуи мглв'нафх" +
                        " Ктулху Р'льех вгах'нагл фхтагн!");
                break;
            } else if (nameBook.equals(book3)) {
                System.out.println("Книга " + nameBook + " взята...и Вы слышите шёпот, говорящий 'Ничья'");
                break;
            } else {
                System.out.println("Такой книги у нас нет, или Вы неправильно вводите название!" + "\n" +
                        "В любом случае мы не виноваты =) Выберите еще раз из списка, пожалуйста");
                System.out.println("Доступны следующие книги: 'Некрономикон', " + " \n" +
                        "'Дневники Ктулху' и 'Чья эта Чёрная Коза?' ");
            }
        }
    }

    public String returnBook;

    public void returnBook() {
        while (true) {
           //this.nameBook=returnBook;
            returnBook = scanner.nextLine();
           // nameBook = scanner.nextLine();
            if (returnBook.equals(book1)||returnBook.equals(book2)||returnBook.equals(book3)) {
                System.out.println("Книга " + returnBook + " благополучно возвращена");
                break;
            } else {
                System.out.println("ГДЕЕЕ МОЯ Книгаааа?!!!");
            }
        }

    }
}