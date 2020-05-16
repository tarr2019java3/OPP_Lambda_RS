package pl.sda.convidDataset.data;

import pl.sda.convidDataset.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserData {
    //
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("Rafał", "Stasiorowski", "rs@rs.p;", "rs"),
            new User("Adam", "Pierwszy", "rs@rs.p;", "rs"),
            new User("Tomek", "Sitko", "rs@rs.p;", "rs"),
            new User("Agata", "Mimi", "rs@rs.p;", "rs"),
            new User("Justynka", "Walczewska", "jw@rs.p;", "rs")
    )
    );
}
