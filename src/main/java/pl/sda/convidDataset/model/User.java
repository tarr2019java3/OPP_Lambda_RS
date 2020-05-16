package pl.sda.convidDataset.model;

import java.time.LocalDateTime;

// klasa modelu -> determinuje strukturę danych w projekcie
public class User {
    private int userId;
    static int idCounter;
// prywatne pola klasowe -> java bins
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private boolean status=true;
    // przyisywanie uprawnień
    private Role role=Role.ROLE_USER;

    public User() {
        this.userId = idCounter;
        idCounter++;
    }

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userId = idCounter;
        idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + //registrationDate +
                ", status=" + status +
                ", role=" + role +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
