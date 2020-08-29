package lesson;

import java.util.*;

public class EmployeeMapDemo {
    public static void main(String[] args) {
        List<Employee> employeesArray = Arrays.asList(
                new Employee("Владимир", 0, 20),
                new Employee("Василий", 1, 22),
                new Employee("Вадим", 2, 20),
                new Employee("Роза", 3, 70),
                new Employee("Римма", 4, 20),
                new Employee("Эдуард", 5, 22),
                new Employee("Агата", 6, 22),
                new Employee("Вадим", 7, 22),
                new Employee("Владимир", 8, 22)
        );
        System.out.println(findById(employeesArray, 6)); //линейное время поиска

        //создаем мапу сотрудников
        Map<Integer, Employee> employeeByIdMap = new HashMap<>();
        employeesArray.forEach(employee -> employeeByIdMap.put(employee.getId(), employee));
        System.out.println(employeeByIdMap.get(6)); //за константное время

        Map<String, Employee> employeeNameAgeMap = new TreeMap<String, Employee>();
        //формуруем по-другому ключ
        employeesArray.forEach(employee ->
                employeeNameAgeMap.put(employee.getName() + " " + employee.getAge() + " " + employee.getId(), employee));
        System.out.println(employeeNameAgeMap.entrySet().toString());

        //упорядоченный список
        SortedSet<Employee> employees = new TreeSet<>(Comparator
                .comparing(Employee::getName)
                .thenComparing(Employee::getAge));
        employees.addAll(employeesArray);
        System.out.println(employees);
    }

    /*public static Optional<Employee> findById(List<Employee> employeeArray, int id) {
        //пробегается по списку - линейное время (можно сделать конст. с использованием мапы)
        return employeeArray.stream().filter(employee -> employee.getId() == id).findFirst();
    }*/

    //метод без стримов
    public static Employee findById(List<Employee> employeeArray, int id) {
        for (Employee employee : employeeArray) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; //если не нашли сотрудника
    }
}
