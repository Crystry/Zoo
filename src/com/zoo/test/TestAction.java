package com.zoo.test;

import com.zoo.controller.AnimalAction;
import com.zoo.model.Animal;

import java.util.List;

public class TestAction {
    public static void main(String[] args) throws Exception {
        /*UserAction action;
        action = new UserAction();
        List<User> result=action.query();
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i).getId()+","+result.get(i).getName());
        }*/
        AnimalAction A=new AnimalAction();
        /*Animal animal=new Animal();
        animal.setAnimalName("Panda-lulu");
        animal.setAnimalType("panda");
        animal.setAnimalSex("male");
        animal.setAnimalAge("2");
        animal.setAnimalIntroduction("熊猫是中国的国宝");
        animal.setAnimalPresentSituation("fine");
        animal.setAnimalKeeper("Coco");
        A.addAnimal(animal);*/
       AnimalAction action=new AnimalAction();
        List<Animal> result=action.query();
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i).getAnimalName());
        }


    }

}
