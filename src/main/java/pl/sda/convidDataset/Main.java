package pl.sda.convidDataset;

import pl.sda.convidDataset.controller.UserController;
import pl.sda.convidDataset.model.Role;
import pl.sda.convidDataset.model.User;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
      //  User u1 = new User();
        //User u2 = new User("Rafał","Stasiorowski","rs@rs.pl","rs");

        //System.out.println(u1.toString());
      //  System.out.println(u2);
        //u2.setRole(Role.ROLE_ADMIN);
       // System.out.println("Nowa Rola: "+ u2.getRole());
        //System.out.println(u2);
       // System.out.println(" USER CONTROLER");
        UserController uc = new UserController();
        uc.getAllUsers();

        System.out.println("Aktywni użytkownicy: ");
        uc.getAllUsersWithStatus(true).forEach(System.out::println);
        System.out.println("Zmiana Satusu ");
        uc.updateUserStatusById(1, false);
        uc.updateUserStatusById(1, false);
        uc. getAllUsersWithStatus(true).forEach(System.out::println);
        System.out.println("\"");
        uc.updateUserRoleById(0, Role.ROLE_ADMIN);
        System.out.println("Liczba Atywnych: "+ uc.countActiveUsers());
        System.out.println("Liczba Administratorów: "+ uc.countAdmins());
        System.out.println("Admini posertowani");
        uc.getAllAminsOrderByEmailAsc().forEach(System.out::println);
        uc.printAdmins();

    }

}
