package de.qcentris.junit5Test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void setUpAll (){
        System.out.println("--Before all methode");
    }

    @BeforeEach
    void setUpEach (){
        System.out.println("--Before each methode");
    }


    @Test
    @DisplayName("this is a first test ")
    void testFirst(){
        System.out.println("    Hallo i'm the first test!");
    }

    @Test
    @DisplayName("I'm the second test!")
    void testSecond(){
        System.out.println("    Hey i'm the second one!");
    }

    @AfterEach
    void setDownEach(){
        System.out.println("--After each methode");
    }

    @AfterAll
    void setDownAll (){
        System.out.println("--After all methode");
    }
}
