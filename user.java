import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class User {
    private final String fullName;
    private final int age;
    private final String gender;

    public User(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        String initials = fullName.substring(0, 1).toUpperCase() + ".";
        return fullName + " " + initials + " " + age + " " + gender;
    }
}

class UserManagement {
    private final ArrayList<User> users;

    public UserManagement() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void sortByAge() {
        users.sort(Comparator.comparingInt(User::getAge));
    }

    public void sortByAgeAndGender() {
        users.sort(Comparator.comparingInt(User::getAge)
                .thenComparing(User::getGender));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Вывести список пользователей");
            System.out.println("3. Отсортировать по возрасту");
            System.out.println("4. Отсортировать по возрасту и полу");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> {
                    System.out.println("Введите ФИО:");
                    String fullName = scanner.nextLine();
                    System.out.println("Введите возраст:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.println("Введите пол:");
                    String gender = scanner.nextLine();
                    User user = new User(fullName, age, gender);
                    userManagement.addUser(user);
                }
                case 2 -> {
                    System.out.println("Список пользователей:");
                    userManagement.printUsers();
                }
                case 3 -> {
                    System.out.println("Сортировка по возрасту:");
                    userManagement.sortByAge();
                    userManagement.printUsers();
                }
                case 4 -> {
                    System.out.println("Сортировка по возрасту и полу:");
                    userManagement.sortByAgeAndGender();
                    userManagement.printUsers();
                }
                case 5 -> {
                    System.out.println("Программа завершена.");
                    System.exit(0);
                }
                default -> System.out.println("Неверный выбор. Попробуйте еще раз.");
            }

            System.out.println();
        }
    }
}
