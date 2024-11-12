# 추상 팩토리 패턴 (Abstract Factory Pattern)과 응집력

## 추상 팩토리 패턴 (Abstract Factory Pattern) 개념

**추상 팩토리 패턴**은 관련된 객체들의 가족(군)을 생성하기 위한 인터페이스를 제공하는 디자인 패턴입니다. 이 패턴을 통해 객체 생성에 필요한 구체적인 클래스를 지정하지 않고도, 여러 객체 계열을 일관되게 생성할 수 있습니다. 추상 팩토리 패턴은 **팩토리 메서드 패턴**의 확장형으로 볼 수 있습니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/abstract-factory

### 구성 요소

1. **AbstractFactory (추상 팩토리 인터페이스)**: 객체 생성 메서드들의 집합을 정의합니다. 관련된 제품 객체를 생성하는 메서드를 선언합니다.
2. **ConcreteFactory (구체적인 팩토리 클래스)**: `AbstractFactory`를 구현하여 각 제품 계열에 대한 객체를 생성하는 역할을 합니다.
3. **AbstractProduct (추상 제품 인터페이스)**: 각 제품 계열이 구현해야 할 인터페이스입니다.
4. **ConcreteProduct (구체적인 제품 클래스)**: `AbstractProduct`를 구현하는 클래스들로, 특정 제품의 구체적인 구현체입니다.
5. **Client (클라이언트)**: 추상 팩토리와 제품 인터페이스를 사용하여 객체를 생성하고 사용합니다. 구체적인 클래스에 의존하지 않으므로, 클라이언트 코드의 결합도가 낮아집니다.

---

## 추상 팩토리 패턴 예제 코드 (Java)

```java
// 추상 팩토리 인터페이스
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// AbstractProductA 인터페이스 정의
interface ProductA {
    void use();
}

// AbstractProductB 인터페이스 정의
interface ProductB {
    void operate();
}

// ConcreteProductA1 클래스 정의
class ConcreteProductA1 implements ProductA {
    @Override
    public void use() {
        System.out.println("Using Product A1");
    }
}

// ConcreteProductA2 클래스 정의
class ConcreteProductA2 implements ProductA {
    @Override
    public void use() {
        System.out.println("Using Product A2");
    }
}

// ConcreteProductB1 클래스 정의
class ConcreteProductB1 implements ProductB {
    @Override
    public void operate() {
        System.out.println("Operating Product B1");
    }
}

// ConcreteProductB2 클래스 정의
class ConcreteProductB2 implements ProductB {
    @Override
    public void operate() {
        System.out.println("Operating Product B2");
    }
}

// ConcreteFactory1 클래스 정의
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// ConcreteFactory2 클래스 정의
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}

// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        // ConcreteFactory1 사용
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.use();           // 출력: Using Product A1
        productB1.operate();       // 출력: Operating Product B1

        // ConcreteFactory2 사용
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.use();           // 출력: Using Product A2
        productB2.operate();       // 출력: Operating Product B2
    }
}
```

### 설명

- `AbstractFactory`는 제품 객체를 생성하는 메서드를 정의합니다.
- `ConcreteFactory1`과 `ConcreteFactory2`는 `AbstractFactory`를 구현하며, 각기 다른 제품 계열을 생성합니다.
- `ProductA`와 `ProductB`는 제품 계열을 대표하는 추상 인터페이스이며, `ConcreteProductA1`, `ConcreteProductA2`, `ConcreteProductB1`, `ConcreteProductB2`는 각 인터페이스의 구체적인 구현체입니다.
- 클라이언트는 `AbstractFactory` 인터페이스만 참조하므로, 구체적인 클래스에 의존하지 않고 객체를 생성할 수 있습니다.

---

## 응집력과의 관계

- **높은 응집력**: 추상 팩토리 패턴은 객체 생성 로직을 한 곳에 집중시킴으로써 응집력이 높아집니다. 각 팩토리 클래스는 특정 제품 계열을 생성하는 책임만 가지며, 제품 객체 생성과 관련된 코드가 명확하게 분리되어 있습니다.
- **유지보수성 향상**: 객체 생성 로직이 응집되어 있으므로, 새로운 제품 계열을 추가하거나 기존 제품을 수정할 때 코드 수정이 용이합니다.
- **확장성**: 새로운 팩토리 클래스나 제품 계열을 추가할 때 클라이언트 코드에 영향을 주지 않고 확장할 수 있습니다.