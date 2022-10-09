package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void checkGetFelineFamily(){
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void checkEatMeatForPredatorAnimalKind() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(food,feline.getFood("Хищник"));
    }

    @Test
    public void checkEatMeatForHerbivorousAnimalKind() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of("Трава", "Различные растения");
        Assert.assertEquals(food,feline.getFood("Травоядное"));
    }

    @Test
    public void checkEatMeatExceptionForUnknownAnimalKind() throws Exception {
        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            feline.getFood("Грибы");
        });
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void verifyKittensCount(){
        Feline feline = new Feline();
        Assert.assertEquals(1,feline.getKittens());
    }
}