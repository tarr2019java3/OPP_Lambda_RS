package pl.sda.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

//Adnotacje lombok'a
@AllArgsConstructor //implementuje konstruktor z wszystkimi argumentami
@NoArgsConstructor  //implementuje pusty konstruktor
@Data               //implementuje gettery, settery i toString()

public class Task extends Object {
    private String taskName;
    private LocalDate startDate;
    private LocalDate stopDate;

}
