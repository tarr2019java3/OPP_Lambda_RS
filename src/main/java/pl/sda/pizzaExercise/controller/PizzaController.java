package pl.sda.pizzaExercise.controller;

import pl.sda.pizzaExercise.model.Ingredients;
import pl.sda.pizzaExercise.model.Pizza;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    /**
     * Przekleić zawartość załączników do plików Ingredients.java i Pizza.java, uzupełnić brakujące importy.
     * Każda Pizza posiada nazwę (name) i listę składników (ingredients). Każdy składnik posiada nazwę (name), cenę (price),
     * informację czy jest to mięso (meat) (np pizza wegetariańska nie może posiadać żadnego składnika mięsnego),
     * informację czy jest pikantny (spicy). Cena pizzy to suma cen wszystkich jej składników.
     * • Zaimplementować klasę z następującymi metodami:
     * o Pizza findCheapestSpicy() - metoda zwracająca najtańszą ostrą pizzę.
     * o Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.
     * o List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
     * o Map groupByPrice() - metoda grupujące pizzę po cenie.
     * o String formatedMenu() - metoda zwracająca string w postaci nazwa_pizzy: składnik1, składnik2, składnik3
     * - cena, kolejne pizzę oddzielone znakiem nowej linii.
     * • Wszystkie metody zaimplementować z wykorzystaniem Stream API, najlepiej w postaci pojedynczego wyrażenia.
     * Wewnątrz metod nie mogą się zanajdować instrukcje sterujące (warunki, pętle).
     */


// Wyszukaj i zwróć najtańszą pizze
    public Pizza findCheapest() {
        return Arrays.stream(Pizza.values())
                .min(Comparator.comparing(this::getPizzaPrice)).get();

    }

    // Wyszukaj i zwróć najtańszą pizze ostra pizze
    public Pizza findCheapestSpicy() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredients -> ingredients.isSpicy()))
                .min(Comparator.comparing(this::getPizzaPrice)).get();

    }

    // Metoda zwracająca cenę pizzy podanej w argumencie metody
    public double getPizzaPrice(Pizza pizza) {
        return pizza.getIngredients()           // List<Ingerdeint>
                .stream()       // Stream<Ingredient>
                .mapToDouble(Ingredients::getPrice)   // Double
                .sum();         // Double
    }

    //Metoda zwraca najdroższą pizze wegetariańską
    public Pizza findMostExpensiveVegetarian() {
        return Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream()
                .noneMatch(ingredients -> ingredients.isMeat())).max(Comparator.comparing(this::getPizzaPrice)).get();
    }

    //  - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
    public List<Pizza> iLikeMeat() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream().anyMatch(Ingredients::isMeat))
                .sorted(Comparator.comparing(pizza -> pizza.getIngredients()
                        .stream()
                        .filter(ingredients -> ingredients.isMeat()).count(), Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    // metoda grupujące pizzę po cenie

    public Map groupByPrice() {
        return
                Arrays.stream(Pizza.values())
                        .collect(Collectors.groupingBy(pizza -> getPizzaPrice(pizza)));

    }

    public TreeMap<Long, List<Pizza>> groupByNumberOfSpiceIngredients() {

        return new TreeMap(Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza -> pizza.getIngredients().stream().filter(Ingredients::isSpicy).count())));
    }

    public TreeMap<Integer, List<Pizza>> groupByNumberOfIngredientsGreaterThan4() {
        return new TreeMap<Integer, List<Pizza>>(Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().size() > 4 && pizza.getIngredients().size() < 7)
                .collect(Collectors.groupingBy(pizza -> pizza.getIngredients().size()))
        );
    }

    //  - metoda zwracająca string w postaci

                //  nazwa_pizzy:
                //  cena
                // Vege
                // ostra
                //  składnik1, składnik2, składnik3
                //



    //kolejne pizzę oddzielone znakiem nowej linii.


    public  String formatedMenu(){
        Pizza pizzaOfDay = getRandomPizza();
        return Arrays.stream(Pizza.values())
        .map(pizza -> String.format
         //| nazwa |  ostrość |  wege   |  cena zł   | składniki |
                ("| %15s | %13s | %-13s | %5.2f zł | %-100s |"
                        , pizza.equals(pizzaOfDay)? pizza.getName()+" * ":pizza.getName()
                        ,pizza.getIngredients()
                                .stream().anyMatch(Ingredients::isSpicy)? "ostra":"łagodna"
                        ,pizza.getIngredients().stream().anyMatch(Ingredients::isMeat)? "mięsna":"wegetariańska"
                        , pizza.equals(pizzaOfDay)? getPizzaPrice(pizza)*0.8: getPizzaPrice(pizza)
                        ,pizza.getIngredients().stream().map(Ingredients::getName).collect(Collectors.joining(", "))
                )).collect(Collectors.joining("\n"));
    }

    public Pizza getRandomPizza() {

        return Pizza.values()[new Random().nextInt(Pizza.values().length)];

    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("najtańsza Pizza: " + pc.findCheapest() + " kosztuje");
        System.out.println("Najtańsza pizza ostra to: " + pc.findCheapestSpicy());
        System.out.println("Najdroższa wegetariańska pizza to : " + pc.findMostExpensiveVegetarian());
        System.out.println("Lista mięsnych pizz posortowancyh po ilości skłaników mięsnych: ");
        pc.iLikeMeat().forEach(pizza -> System.out.println(pizza
                + " " + pizza.getIngredients().size()
                + " " + pizza.getIngredients().stream().filter(Ingredients::isMeat).count()));
        System.out.println("grupy cennowe pizz");
        new TreeMap<>(pc.groupByPrice())
                .forEach((key, value) -> System.out.printf("%5.1f | %s\n", key, value));

        System.out.println("Pizze pogrupowanie po ilośći ostrych składników: ");
        pc.groupByNumberOfSpiceIngredients().forEach((key,value)-> System.out.printf("%5d |%s\n",key,value));

        System.out.println("Pizze pogrupowane po ilości składników, (wiecej niż 4 oraz mniej niż 7)");
        pc.groupByNumberOfIngredientsGreaterThan4()
                .forEach((key, value) -> System.out.printf("%5d | %s \n", key, value));
        System.out.println("Menu: ");
        System.out.println(pc.formatedMenu());
        System.out.println(pc.getRandomPizza());
    }
}
