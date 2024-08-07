package Java_Concept;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams_Practice {

    static class Employee {
        private Integer id;
        private String name;
        private Double salary;

        public Employee(Integer id, String name, Double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return this.name;
        }

        public Double getSalary() {
            return this.salary;
        }

        public Integer getId() {
            return this.id;
        }


        public void setSalary(Double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);


        // 1.) get map of Character as key and it's occurrences of each character in string

        String s = "asdfaghjklkjhgfdsa";

        String[] inputArray = s.split("");

        Map<String, List<String>> map = Arrays.stream(inputArray)
                .filter(singleChar -> !singleChar.equals(" "))
                .collect(
                        Collectors.groupingBy(
                                singleChar -> singleChar)
                );

        System.out.println("With occurrences : " + map);

        // 2.) Count occurrences of each character in string


        Map<String, Long> counts = Arrays.stream(inputArray)
                .filter(singleChar -> !singleChar.equals(" "))
                .collect(
                        Collectors.groupingBy(
                                singleChar -> singleChar, Collectors.counting()
                        )
                );

        System.out.println("Count occurrences : " + counts);

        // alternatively

        Map<String, Long> counts2 = Arrays.stream(inputArray)
                .filter(singleChar -> !singleChar.equals(" "))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );


        System.out.println("Count occurrences : " + counts2);


        // 3.) Get occurrences of each word in string

        String input = "hello world, hello java, hello world";
        String[] split = input.split(" ");
        Map<String, Long> wordToCount = Arrays.stream(split)
                .collect(
                        Collectors.groupingBy(
                                word -> word, Collectors.counting()
                        )
                );

        System.out.println("Get occurrences of each word in string : " + wordToCount);

        // 4.) get in sorted order of occurrences of each word based on above frequency
        // Note for reversing  we can use  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))

        List<Map.Entry<String, Long>> listToMap = wordToCount.entrySet().stream().sorted((m1, m2) -> {

            if (m1.getValue() > m2.getValue()) {
                return -1;
            } else if (m1.getValue() < m2.getValue()) {
                return 1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());

        System.out.println(listToMap.get(0));

        // or

        List<Map.Entry<String, Long>> listToMap2 = wordToCount.entrySet().stream()
                .sorted(
                        Collections.reverseOrder(Map.Entry.comparingByKey())
                )
                .collect(Collectors.toList());

        System.out.println(listToMap2.get(0));

        //  5.) Get a first character which repeats more than 1 times in string
        Stream<Character> charStream = s.chars().mapToObj(c -> (char) c);
        Map<Character, Long> charCountMap = charStream.collect(
                Collectors.groupingBy(
                        character -> character,
                        () -> {
                            return new LinkedHashMap<Character, Long>();
                        },
                        Collectors.counting()
                ));

        Optional<Character> firstRepeatedChar = charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1L) // Filter entries where count is greater than 1
                .findFirst() // Get the first entry (maintains order)
                .map(entry -> entry.getKey());      // Extract the character (key) from the entry

        System.out.println(firstRepeatedChar.orElse(null));

        moreExample();
    }

    private static void moreExample() {

        // 1.) Create list of Employee

        List<Employee> listOfEmployee = new ArrayList<>();

        Employee john = new Employee(1, "john", 1000.0);
        Employee ram = new Employee(2, "ram", 2000.0);
        Employee karan = new Employee(3, "karan", 7000.0);

        listOfEmployee.add(john);
        listOfEmployee.add(ram);
        listOfEmployee.add(karan);
        // can also use Arrays.asList


        System.out.println("Created emp list is " + listOfEmployee);


        // 2.) Salary above 5000.0

        List<Employee> listGreaterThen5000 = listOfEmployee.stream().filter(employee ->
                employee.getSalary() > 5000.0).collect(Collectors.toList());

        System.out.println("Salary greater then 5000.0 is " + listGreaterThen5000);


        // 3.) New list containing employees with a salary increase of 10%.

        List<Employee> employeeWithIncreaseSalary = listOfEmployee.stream().map(employee -> {
            employee.setSalary(employee.getSalary() * 1.1);
            return employee;
        }).collect(Collectors.toList());

        System.out.println("New Employee list after increase so far is " + employeeWithIncreaseSalary);


        // 4.) Average salary

        double averageSalary = listOfEmployee.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);


        // 5.) Highest salary
        List<Employee> sortedBySalary = listOfEmployee.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("Highest salary emp is + " + sortedBySalary.get(0));

        // 6.) Mode of salary
        double modeSalary = listOfEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0.0);

        // 7.) Calculate median salary
        List<Double> sortedSalaries = listOfEmployee.stream()
                .map(Employee::getSalary)
                .sorted()
                .collect(Collectors.toList());

        double medianSalary;
        int size = sortedSalaries.size();
        if (size % 2 == 0) {
            medianSalary = (sortedSalaries.get(size / 2 - 1) + sortedSalaries.get(size / 2)) / 2.0;
        } else {
            medianSalary = sortedSalaries.get(size / 2);
        }


    }

    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }

    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
        Map<Integer, List<String>> valueToKeyListMap = map.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getValue,
                                Collectors.mapping(Map.Entry::getKey, Collectors.toList())   // getting only key to list
                        ));

        return valueToKeyListMap
                .entrySet()                                // till here 1200 --> same, alice , 1300 -> ram , 800 -> sham
                .stream()
                .sorted(
                        Collections.reverseOrder(Map.Entry.comparingByKey())                         // reversing by key
                )
                .collect(Collectors.toList())
                .get(num - 1);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], heights[i]);
        }

        List<String> sortedKeys = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return sortedKeys.toArray(new String[0]);
    }

}
