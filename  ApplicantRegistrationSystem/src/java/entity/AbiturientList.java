package entity;

public class AbiturientList {

    private static Abiturient[] abiturients = new Abiturient[5];

    static {
        abiturients[0] = new Abiturient("111111", "Петя", "Петрович", "Петров", "+375333175235", "Людникова 17 кв. 249", 5, 10, 7);
        abiturients[1] = new Abiturient("222222", "Сидор", "Сидорович", "Сидоров", "+375333175235", "Людникова 17 кв. 249", 6, 8, 8);
        abiturients[2] = new Abiturient("333333", "Вася", "Васильевич", "Васечкин", "+375333175235", "Людникова 17 кв. 249", 9, 9, 9);
        abiturients[3] = new Abiturient("444444", "Света", "Световна", "Светова", "+375333175235", "Людникова 17 кв. 249", 7, 7, 7);
        abiturients[4] = new Abiturient("555555", "Петя", "Петрович", "Иванов", "+375333175235", "Людникова 17 кв. 249", 5, 4, 3);
    }

    public static Abiturient[] getAbiturients() {
        return abiturients;
    }
}
