# 비지터 패턴 (Visitor Pattern)

## 비지터 패턴 (Visitor Pattern) 개념

**비지터 패턴**은 객체 구조를 변경하지 않고도 새로운 기능을 추가할 수 있게 해주는 행동 디자인 패턴입니다. 이 패턴은 객체의 데이터 구조와 처리 로직을 분리하여 각 요소의 방문(Visit) 동작을 정의합니다. 객체의 구조가 변경되지 않으면서도 새로운 연산을 쉽게 추가할 수 있습니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/visitor

### 구성 요소

1. **Visitor (비지터 인터페이스)**: 각 요소에 방문할 수 있는 메서드를 정의합니다.
2. **ConcreteVisitor (구체적인 비지터 클래스)**: `Visitor` 인터페이스를 구현하며, 각 요소에 대한 연산을 정의합니다.
3. **Element (요소 인터페이스)**: `accept()` 메서드를 정의하여 `Visitor` 객체가 자신을 방문할 수 있도록 합니다.
4. **ConcreteElement (구체적인 요소 클래스)**: `Element` 인터페이스를 구현하며, `Visitor` 객체가 자신을 방문할 때 호출되는 메서드를 구현합니다.
5. **ObjectStructure (객체 구조)**: 요소 객체들을 저장하고 관리하며, 비지터를 사용하여 각 요소에 대한 연산을 수행합니다.

---

## 비지터 패턴 예제 코드 (Java)

```java
// Visitor 인터페이스 정의
interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}

// Element 인터페이스 정의
interface Item {
    void accept(Visitor visitor);
}

// ConcreteElement 클래스: Book
class Book implements Item {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteElement 클래스: Fruit
class Fruit implements Item {
    private String name;
    private double weight;
    private double pricePerKg;

    public Fruit(String name, double weight, double pricePerKg) {
        this.name = name;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteVisitor 클래스: PriceCalculator
class PriceCalculator implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle() + " costs $" + book.getPrice());
    }

    @Override
    public void visit(Fruit fruit) {
        double cost = fruit.getWeight() * fruit.getPricePerKg();
        System.out.println("Fruit: " + fruit.getName() + " costs $" + cost);
    }
}

// 메인 클래스
public class VisitorPatternExample {
    public static void main(String[] args) {
        Item book = new Book("Design Patterns", 30.0);
        Item apple = new Fruit("Apple", 2.5, 3.0);

        Visitor priceCalculator = new PriceCalculator();

        // 비지터 패턴을 사용하여 각 아이템의 가격 계산
        book.accept(priceCalculator);
        apple.accept(priceCalculator);
        // 출력:
        // Book: Design Patterns costs $30.0
        // Fruit: Apple costs $7.5
    }
}
```

### 설명

- **Visitor 인터페이스**: `visit()` 메서드를 정의하여 `Book`과 `Fruit` 객체를 방문할 수 있도록 합니다.
- **Book**과 **Fruit**: `Item` 인터페이스를 구현하며, `accept()` 메서드를 통해 `Visitor` 객체를 받아서 방문 작업을 수행합니다.
- **PriceCalculator**: `Visitor` 인터페이스를 구현한 클래스이며, 각 요소의 가격을 계산하는 연산을 수행합니다.

---

## 요약

- **비지터 패턴**은 객체 구조를 변경하지 않고 새로운 연산을 추가할 수 있게 합니다.
- 각 요소에 대한 처리 로직을 `Visitor` 클래스에 분리하여 구현하며, 객체 구조와 연산이 분리됩니다.
- 새로운 연산을 쉽게 추가할 수 있지만, 구조가 자주 변경될 경우에는 적합하지 않습니다.