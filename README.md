### Uniwersalna Notatka i Szablon Testów Jednostkowych w Javie (JUnit 5)
Podstawowe zasady pisania testów jednostkowych:
Testujemy pojedynczą funkcjonalność/metodę.

Testy powinny być niezależne i łatwe do zrozumienia.

Stosujemy assertacje do porównywania wyników z oczekiwaniami.

Testujemy także scenariusze brzegowe i błędne (np. wyjątki).

Wykorzystujemy adnotacje JUnit do organizacji testów.

## Przykładowy szablon testu w JUnit 5
```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class YourClassTest {

    @BeforeAll
    static void setupAll() {
        // Kod wykonywany raz przed wszystkimi testami (np. otwarcie połączenia)
    }

    @AfterAll
    static void tearDownAll() {
        // Kod wykonywany raz po wszystkich testach (np. zamknięcie połączenia)
    }

    @BeforeEach
    void setup() {
        // Kod wykonywany przed każdym testem (np. inicjalizacja obiektów)
    }

    @AfterEach
    void tearDown() {
        // Kod wykonywany po każdym teście (np. czyszczenie danych)
    }

    @Test
    void shouldReturnExpectedValue() {
        // Arrange - przygotowanie danych
        YourClass instance = new YourClass();

        // Act - wywołanie metody
        var result = instance.methodUnderTest();

        // Assert - sprawdzenie wyniku
        assertEquals("expected", result);
    }

    @Test
    void shouldThrowExceptionWhenCondition() {
        YourClass instance = new YourClass();

        Exception exception = assertThrows(ExpectedException.class, () -> {
            instance.methodThatShouldThrow();
        });

        assertTrue(exception.getMessage().contains("expected message fragment"));
    }

    @Test
    void shouldAddElementToCollection() {
        YourClass instance = new YourClass();
        instance.addElement("item");

        assertFalse(instance.isEmpty());
        assertEquals(1, instance.size());
        assertTrue(instance.contains("item"));
    }
}
```
### Uniwersalny Szablon Testów z Przykładami Kodów
## 1. Podstawowy test sprawdzający wartość zwracaną
```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }
}
```
## 2. Test sprawdzający rzutowanie wyjątku
```java
class Divider {
    int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divider cannot be zero");
        return a / b;
    }
}

public class DividerTest {

    @Test
    void shouldThrowWhenDivideByZero() {
        Divider div = new Divider();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            div.divide(10, 0);
        });

        assertTrue(thrown.getMessage().contains("zero"));
    }
}
```
## 3. Test zmiany stanu kolekcji (dodawanie elementu)
```java
import java.util.ArrayList;
import java.util.List;

public class ListManager {
    private List<String> list = new ArrayList<>();

    void addItem(String item) {
        list.add(item);
    }

    boolean contains(String item) {
        return list.contains(item);
    }

    int size() {
        return list.size();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}

public class ListManagerTest {

    @Test
    void addItemIncreasesSizeAndContainsElement() {
        ListManager manager = new ListManager();

        assertTrue(manager.isEmpty());

        manager.addItem("apple");

        assertEquals(1, manager.size());
        assertTrue(manager.contains("apple"));
    }
}
```
## 4. Test z wykorzystaniem @BeforeEach i @AfterEach
```java
public class Resource {
    boolean open = false;

    void open() { open = true; }
    void close() { open = false; }
    boolean isOpen() { return open; }
}

public class ResourceTest {

    Resource resource;

    @BeforeEach
    void setUp() {
        resource = new Resource();
        resource.open();
    }

    @AfterEach
    void tearDown() {
        resource.close();
    }

    @Test
    void resourceShouldBeOpenInTest() {
        assertTrue(resource.isOpen());
    }

    @Test
    void resourceClosesAfterTest() {
        // test body can be empty
        // AfterEach will close resource automatically
    }
}
```
## 5. Parametryzowany test (wiele wartości wejściowych)
```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberTest {

    boolean isEven(int n) {
        return n % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {
        assertTrue(isEven(number));
    }
}
```

## Dodawanie depedencji JUnit w pom.xml

```java
<dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version> <!-- lub najnowsza wersja -->
        <scope>test</scope>
    </dependency>
```
