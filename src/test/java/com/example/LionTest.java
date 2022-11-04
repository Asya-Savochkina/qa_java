package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void verifyKittensCount() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodForAnimalKindPredator() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void getFoodUnknownAnimalReturnException() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Нечто", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
    }
