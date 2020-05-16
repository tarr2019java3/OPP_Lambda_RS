package pl.sda.convidDataset.controller;

import pl.sda.convidDataset.data.UserData;
import pl.sda.convidDataset.model.Role;
import pl.sda.convidDataset.model.User;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserController {
    //klasa kontrolera implementuje metody obslugujące żądania
    public static void getAllUsers(){
       // for (User user: UserData.users){
         //   System.out.println(user);
        //}

        // tworzenie predykatu CTRL+ spacja
       // UserData.users.stream().forEach(user -> System.out.println(user) );
        // wersja uproszczona
        UserData.users.forEach(System.out::println);
    }

    public Optional<User> getUserByEmail(String searchEmail){
        return UserData.users                                       // List<User>
                .stream()                                           // Stream<User>
                .filter(user -> user.getEmail().equals(searchEmail))// Stream<User>
                .findFirst();                                       // Optional<User>
    }
    public String getUserByEmailWithValidation(String searchEmail){
        Optional<User> userOpt = getUserByEmail(searchEmail);
        return userOpt.map(user -> "Znalezieono użytkownika: " + user.toString())
                .orElseGet(() -> "Nie znaleziono użytkownika o adresie: " + searchEmail);
    }

    public List<User> getAllUsersWithStatus(boolean status){
        return UserData.users.stream(). filter(user -> user.isStatus()== status).collect(Collectors.toList());

    }

    public void updateUserStatusById(int userId, boolean status) {
        UserData.users.stream().filter(user -> user.getUserId()== userId).forEach(user -> user.setStatus(status));
    }

    public boolean updateUserRoleById(int userId, Role role){
        // sprawdzamy czy jest użytkownik o podany id
        Optional<User> userOpt = UserData.users.stream().filter(user -> user.getUserId() == userId).findFirst();
        if(userOpt.isPresent()){
            // userOpt          -> Optional<User>
            // userOpt.get()    -> User
            User user = userOpt.get();
            user.setRole(role);
            return true;
        }
        System.out.println("Nie ma takiego użytkownika!! ");
        return false;
    }

    public int countActiveUsers(){
        return (int) UserData.users.stream().filter(User::isStatus).count();
    }
    public int countAdmins(){
        return (int) UserData.users.stream().filter(user -> user.getRole() == Role.ROLE_ADMIN).count();
    }

    //public List<User> getAllUsersOrderByRegistrationDateDesc(){
      //  return UserData.users.stream().sorted(Comparator.comparing(User:getReistrationDate))
    //}
    public List<User> getAllAminsOrderByEmailAsc(){

        return UserData.users.stream().filter(user -> user.getRole()==Role.ROLE_ADMIN)
                .sorted(Comparator.comparing(User::getEmail)).collect(Collectors.toList());
    }
    public List<User> getFirstThreeUsersOrderByRegistrationDateAsc(){
        return UserData.users.stream()
                .sorted(Comparator.comparing(User::getRegistrationDate)).limit(3)
                .collect(Collectors.toList());
    }
    public void printAdmins() throws NoSuchAlgorithmException   {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        System.out.println(UserData.users
                .stream()
                .filter(user -> user.getRole() == Role.ROLE_ADMIN)
                .map(user -> String.format("|%2d |%20s |%20s |%20s |%20s |%20s |",
                        user.getUserId(),
                        user.getName(),
                        user.getLastName(),
                        user.getEmail(),
                        md.digest(user.getPassword().getBytes(StandardCharsets.UTF_8)).toString().replace("[B@",""),
                        "ADMINISTRATOR"))
                .collect(Collectors.joining("\n")));}


}