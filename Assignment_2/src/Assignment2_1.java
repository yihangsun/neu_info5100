/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        return name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        this.name = name;
    }
    
    public void raiseSalary(double byPercent) {
    	salary = salary * byPercent / 100.00;
    }
}

enum Gender {
    MALE,
    FEMALE;
}

public class Assignment2_1 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        double salary = employee.salary;
        if (salary <= 8900) return 0.062 * salary;
        else return 0.062 * 106800;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        int age = employee.age;
        double salary = employee.salary;
        if (age < 35) return salary * 0.03;
        else if (age >= 35 && age <= 50) return salary * 0.04;
        else if (age > 50 && age <= 60) return salary * 0.05;
        else return salary * 0.06;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
       Employee temp;
       if (e1.salary > e2.salary) {
    	   temp = e1;
    	   e1 = e2;
    	   e2 = temp;
       }
       if (e2.salary > e3.salary) {
    	   temp = e2; 
    	   e2 = e3; 
    	   e3 = temp;
       }
       if (e1.salary > e2.salary) {
    	   temp = e1; 
    	   e1 = e2;
    	   e2 = temp;
       }
       System.out.print(e1.getName() + ' ' + e2.getName() + ' ' + e3.getName());
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(300.00);
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     Because in Java, the objects of any class passed in into a method are not the objects themselves, but the pointers or copies. These pointers are 
     pointing to the specific location of those data. For example, Employee("Jenny", 20, Gender.FEMALE, 2500) is a house, and a is an address card.
     When we pass the address card into a method, it copied the card and pass in with a new but same card. This card still points to the house. However,
     if we modify the address card, we are not changing the actual thing in the house, because you are not letting houseowner (the original address card) know.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2500);
        Employee b = new Employee("John", 30, Gender.MALE, 2000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
