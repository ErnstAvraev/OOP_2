package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human partner;

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.birthDay = birthDay;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDay) {
        this(name, gender, birthDay, null, null,null);
    }

    public Human(String name, Gender gender, LocalDate birthDay, Human mother, Human father) {
        this(name, gender, birthDay, null, father, mother);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public void setMother(Human mother) {this.mother = mother;}

    public void setFather(Human father) {this.father = father;}

    public Human getMother() {return mother;}

    public Human getFather() {return father;}

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDay, LocalDate.now());
        } else {
            return getPeriod(birthDay, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDay, LocalDate deathDate){
        Period diff = Period.between(birthDay, deathDate);
        return diff.getYears();
    }

    public void setPartner(Human partner){this.partner = partner;}

    public String getName() {return name;}

    public Human getPartner() {return partner;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public LocalDate getBirthDay() {return birthDay;}

    public LocalDate getDeathDate() {return deathDate;}

    public List<Human> getChildren() {return children;}

    public void setBirthDay(LocalDate birthDay) {this.birthDay = birthDay;}

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public Gender getGender() {return gender;}

    @Override
    public String toString() { return getInfo(); }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getPartnerInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getPartnerInfo(){
        String res = "супруг(а): ";
        if (partner == null){
            res += "нет";
        } else {
            res += partner.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        if(mother != null){
            res += mother.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if(father != null){
            res += father.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
