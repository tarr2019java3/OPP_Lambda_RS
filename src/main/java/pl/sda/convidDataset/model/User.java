package pl.sda.convidDataset.model;

import java.time.LocalDateTime;

// klasa modelu -> determinuje strukturę danych w projekcie
public class User {
// prywatne pola klasowe -> java bins
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDate=LocalDateTime.new();
    private boolean status=true;
    // przyisywanie uprawnień
    private Role role=Role.ROLE_USER;


}
