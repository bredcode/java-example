# 팩토리 메서드 패턴 (Factory Method Pattern)

## 팩토리 메서드 패턴 (Factory Method Pattern) 개념

**팩토리 메서드 패턴**은 객체의 생성 방식을 서브클래스에 위임하는 디자인 패턴입니다. 이 패턴을 사용하면 클라이언트 코드가 구체적인 클래스에 의존하지 않고, 객체 생성을 위한 인터페이스만 사용하여 객체를 생성할 수 있습니다. 이를 통해 코드의 유연성과 확장성을 높일 수 있습니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/factory-method

### 구성 요소

1. **Product (제품 인터페이스)**: 생성할 객체의 공통 인터페이스를 정의합니다.
2. **ConcreteProduct (구체적인 제품 클래스)**: `Product` 인터페이스를 구현하며, 팩토리 메서드를 통해 생성되는 실제 객체입니다.
3. **Creator (추상 클래스 또는 인터페이스)**: 팩토리 메서드를 선언하며, 객체 생성의 기본 인터페이스를 정의합니다.
4. **ConcreteCreator (구체적인 생성자 클래스)**: `Creator`를 구현하여, 객체 생성 메서드를 구체적으로 정의합니다.

---

## 팩토리 메서드 패턴 예제 코드 (Java)

```java
// Product 인터페이스 정의
interface Product {
    void use();
}

// ConcreteProductA 클래스 정의
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// ConcreteProductB 클래스 정의
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// Creator 추상 클래스 정의
abstract class Creator {
    // 팩토리 메서드 선언
    public abstract Product createProduct();

    // 작업을 수행하는 메서드
    public void doSomething() {
        Product product = createProduct();
        product.use();
    }
}

// ConcreteCreatorA 클래스 정의
class ConcreteCreatorA extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

// ConcreteCreatorB 클래스 정의
class ConcreteCreatorB extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// 메인 클래스
public class FactoryMethodExample {
    public static void main(String[] args) {
        // ConcreteCreatorA 사용
        Creator creatorA = new ConcreteCreatorA();
        creatorA.doSomething();  // 출력: Using Product A

        // ConcreteCreatorB 사용
        Creator creatorB = new ConcreteCreatorB();
        creatorB.doSomething();  // 출력: Using Product B
    }
}
```

### 설명

- `Creator` 클래스는 팩토리 메서드를 선언하여 객체 생성의 인터페이스를 정의합니다.
- `ConcreteCreatorA`와 `ConcreteCreatorB`는 `Creator`를 상속받아, 구체적인 `Product` 객체를 생성하는 팩토리 메서드를 구현합니다.
- 클라이언트는 `Creator` 클래스의 메서드를 통해 객체를 생성하며, 구체적인 클래스에 의존하지 않습니다.

---

## 응집력과의 관계

- **높은 응집력**: 팩토리 메서드 패턴은 객체 생성 로직을 각 구체적인 생성자 클래스에 캡슐화함으로써 응집력을 높입니다. `Creator` 클래스는 객체 생성 인터페이스만 제공하고, 구체적인 생성 로직은 서브클래스에 위임됩니다.
- **유지보수성 향상**: 새로운 제품을 추가할 때 기존 코드를 수정하지 않고, 새로운 `ConcreteCreator` 클래스를 추가하여 확장할 수 있습니다.
- **확장성**: 클라이언트는 `Creator` 인터페이스만 사용하기 때문에, 새로운 제품이 추가되더라도 클라이언트 코드를 수정할 필요가 없습니다.