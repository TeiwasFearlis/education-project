package Main;

public class ArrayCalculate {
    int index;
    int[] numbers = new int[index];

    public void massiv() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }


    int sum = 0;

    public void summa(int index) {
        for (int x : numbers) {
            sum += x;
        }

        System.out.println("Сумма массива=" + sum);
    }


    int maxNumber = 0;

    public void max(int index) {
        for (int x : numbers) {
            if (maxNumber < x) {
                maxNumber = x;
            }
        }
        System.out.println("Максимальное значение=" + maxNumber);
    }


    int aSum = 0;

    public void middle(int index) {
        int middleNumber = 0;
        for (int x : numbers) {
            aSum += x;
        }
        middleNumber += aSum / numbers.length;
        System.out.println("Средний элемент=" + middleNumber);
    }

    public void revers(int index) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println("Массив наоборот=" + numbers[i]);
        }
    }
}
