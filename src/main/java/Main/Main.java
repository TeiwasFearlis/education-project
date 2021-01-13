package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы находитесь  в библиотеке");
        System.out.println("Введите ее название в родительном падеже или просто нажмите Enter:");
        String nameLibrary = scanner.nextLine();
        Library library;
        if (nameLibrary == null || nameLibrary.isEmpty()) {
            library = new Library();
        } else {
            library = new Library(nameLibrary);
        }
        int menu;
        do {
            library.printLibraryMenu();
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            library.doMenuFunction(menu);
        } while (menu != 7);

    }

}
