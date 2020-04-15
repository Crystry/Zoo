package com.zoo.model;

import javafx.beans.property.SimpleStringProperty;

public class Animal {
   /* private String AnimalName;
    private String AnimalType;
    private String AnimalSex;
    private String AnimalAge;
    private String AnimalIntroduction;
    private String AnimalPresentSituation;
    private String AnimalKeeper;
    private String Animal_Name;*/

   private final SimpleStringProperty AnimalName=new SimpleStringProperty(this,"AnimalName");
    private  final SimpleStringProperty AnimalType=new SimpleStringProperty(this,"AnimalType");
    private final SimpleStringProperty AnimalSex=new SimpleStringProperty(this,"AnimalSex");
    private final SimpleStringProperty AnimalAge=new SimpleStringProperty(this,"AnimalAge");
    private final SimpleStringProperty AnimalIntroduction=new SimpleStringProperty(this,"AnimalIntroduction");
    private final SimpleStringProperty AnimalPresentSituation=new SimpleStringProperty(this,"AnimalPresentSituation");
    private final SimpleStringProperty AnimalKeeper=new SimpleStringProperty(this,"AnimalKeeper");

    public SimpleStringProperty animalNameProperty() {
        return AnimalName;
    }

    public final String getAnimalName() {
        return animalNameProperty().get();
    }

    public final void setAnimalName(String animalName) {
        animalNameProperty().set(animalName);
    }

    public SimpleStringProperty animalTypeProperty() {
        return AnimalType;
    }

    public final String getAnimalType() {
        return animalTypeProperty().get();
    }

    public final void setAnimalType(String animalType) {
        animalTypeProperty().set(animalType);
    }

    public SimpleStringProperty animalSexProperty() {
        return AnimalSex;
    }

    public final String getAnimalSex() {
        return animalSexProperty().get();
    }

    public final void setAnimalSex(String animalSex) {
        animalSexProperty().set(animalSex);
    }

    public SimpleStringProperty animalAgeProperty() {
        return AnimalAge;
    }

    public final String getAnimalAge() {
        return animalAgeProperty().get();
    }

    public final void setAnimalAge(String animalAge) {
        animalAgeProperty().set(animalAge);
    }

    public SimpleStringProperty animalIntroductionProperty() {
        return AnimalIntroduction;
    }

    public final String getAnimalIntroduction() {
        return animalIntroductionProperty().get();
    }

    public final void setAnimalIntroduction(String animalIntroduction) {
        animalIntroductionProperty().set(animalIntroduction);
    }

    public SimpleStringProperty animalPresentSituationProperty() {
        return AnimalPresentSituation;
    }

    public final String getAnimalPresentSituation() {
        return animalPresentSituationProperty().get();
    }

    public final void setAnimalPresentSituation(String animalPresentSituation) {
        animalIntroductionProperty().set(animalPresentSituation);
    }

    public SimpleStringProperty animalKeeperProperty() {
        return AnimalKeeper;
    }

    public final String getAnimalKeeper() {
        return animalKeeperProperty().get();
    }

    public final void setAnimalKeeper(String animalKeeper) {
        animalIntroductionProperty().set(animalKeeper);
    }
    public Animal(){

    }
    public Animal(String aAnimalName,String aAnimalType ,String aAnimalSex,String aAnimalAge,
                  String aAnimalIntroduction, String aPresentSituation,String aAnimalKeeper){
        setAnimalName(aAnimalName);
        setAnimalType(aAnimalType);
        setAnimalSex(aAnimalSex);
        setAnimalAge(aAnimalAge);
        setAnimalIntroduction(aAnimalIntroduction);
        setAnimalPresentSituation(aPresentSituation);
        setAnimalKeeper(aAnimalKeeper);
    }

   /* public String getAnimal_Name() {
        return Animal_Name;
    }

    public void setAnimal_Name(String animal_Name) {
        Animal_Name = animal_Name;
    }*/

}
