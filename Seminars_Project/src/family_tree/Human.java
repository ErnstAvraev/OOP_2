package family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDate;
    private LocalDate age;
    private Gender gender;
    private Human mother;
    private List<Human> children;
}
