package com.lab2.immutableclass1;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public  class ImmutableStudent {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student("Andrew", 19, new Date());
        System.out.println( student1.clone());
        Student student2 = new Student("Alina", 18, new Date());
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Yurii",17,new Date()));
        set.add(new Student("Yeuhen",20,new Date()));
        set.add(new Student("Natalia",19,new Date()));
        set.add(new Student("Dmitro",21,new Date()));
        set.add(new Student("Rostislav",16,new Date()));
        for (Object obj : set){
            System.out.println(obj);
        }
        System.out.println(student1.equals(student2));
        System.out.println(student2.hashCode());
    }
}
final class Student implements Cloneable,Comparable<Student>{
    final String name;
    final int age;
    final Date birthDate;

    public Student(String name, int age,Date date)
    {
        this.name = name;
        this.age = age;
        this.birthDate = date;
    }
    public String getName()
    {
        return name;
    }
    public int getRegNo()
    {
        return age;
    }

    public Date getBirthDate (){
        return (Date) birthDate.clone();
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthDate.clone(),student.birthDate.clone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthDate.clone());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Student stud) {
       return this.age - stud.age;
    }
}
