package pl.sda.oop;

import java.time.LocalDate;

public class Main {
    public static void main(String[]args){
        Task task = new Task("Nauka programowania",
                LocalDate.now(),
                LocalDate.of(2020,9,30));
        System.out.println(task.toString());

        Task emptyTask = new Task();
        emptyTask.setTaskName("empty task");
        System.out.println(emptyTask.getTaskName());


    }
}
