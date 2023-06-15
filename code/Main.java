import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PeopleList peopleList = new PeopleList();

        Person person1 = new Person("Петров", "Петр", "Петрович");
        Person person2 = new Person("Сидоров", "сидор", "сидорович");
        Person person3 = new Person("Иванов", "иван", "Иванович");
        Person person4 = new Person("Дмитриев", "Дмитрий", "дмитриевич");
        Person person5 = new Person("Шалопаев", "шалопай", "Шалопаевич");
        Person person6 = new Person("Гренкин", "Гренка", "Гренкоевич");

        peopleList.addPerson(person1);
        peopleList.addPerson(person2);
        peopleList.addPerson(person3);
        peopleList.addPerson(person4);
        peopleList.addPerson(person5);
        peopleList.addPerson(person6);

        System.out.println("Исходный список:");
        printPeopleList(peopleList);
        
       boolean exitProgram = false;

        while (!exitProgram) {
            int choice = getMenuSelection();

            switch (choice) {
                case 1:
                    peopleList.sortPeopleByLastName();
                    System.out.println("\nСписок после сортировки по фамилии:");
                    printPeopleList(peopleList);
                    break;
                case 2:
                    peopleList.fixNames();
                    System.out.println("\nСписок после исправления имен:");
                    printPeopleList(peopleList);
                    break;
                case 3:
                    exitProgram = true;
                    System.out.println("\nПрограмма завершена.");
                    break;
                default:
                    System.out.println("\nНекорректный пункт меню.");
                    break;
            }
        }
    }

    private static void printPeopleList(PeopleList peopleList) {
        for (Person person : peopleList.getPeople()) {
            System.out.println(person.getLastName() + " " +
                    person.getFirstName() + " " +
                    person.getMiddleName());
        }
        System.out.println();
    }
    
    public static int getMenuSelection() {
        Scanner input = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("\nВыбор действия: ");
            System.out.println("1: Сортировка по фамилии: ");
            System.out.println("2: Исправление имен: ");
            System.out.println("3: Завершить программу");
            System.out.print("Введите номер пункта меню: ");

            choice = input.nextInt();

            if(choice < 1 || choice > 3) {
                System.out.println("\nНе корректный пункт меню: ");
            } else {
                break;
            }
        }

        return choice;
    }
}