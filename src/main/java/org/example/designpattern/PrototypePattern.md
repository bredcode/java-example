# 프로토타입 패턴 (Prototype Pattern)

## 프로토타입 패턴 (Prototype Pattern) 개념

**프로토타입 패턴**은 객체를 생성하는 비용이 클 때, 기존 객체를 복제하여 새로운 객체를 생성하는 디자인 패턴입니다. 이 패턴을 사용하면 객체를 복제(clone)하여 생성할 수 있으며, 객체의 복제 과정을 제어할 수 있습니다. 프로토타입 패턴은 복잡한 객체를 효율적으로 생성할 때 유용합니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/prototype

### 구성 요소

1. **Prototype (프로토타입 인터페이스)**: 복제 메서드를 정의합니다.
2. **ConcretePrototype (구체적인 프로토타입 클래스)**: `Prototype` 인터페이스를 구현하며, 자신을 복제하는 메서드를 제공합니다.
3. **Client (클라이언트)**: `Prototype` 인터페이스를 사용하여 객체를 복제합니다.

---

## 프로토타입 패턴 예제 코드 (Java)

```java
// Prototype 인터페이스 정의
interface Prototype {
    Prototype clone();
}

// ConcretePrototype1 클래스 정의
class ConcretePrototype1 implements Prototype {
    private String field;

    public ConcretePrototype1(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this.field);
    }

    public void show() {
        System.out.println("ConcretePrototype1: " + field);
    }
}

// ConcretePrototype2 클래스 정의
class ConcretePrototype2 implements Prototype {
    private int number;

    public ConcretePrototype2(int number) {
        this.number = number;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this.number);
    }

    public void show() {
        System.out.println("ConcretePrototype2: " + number);
    }
}

// 메인 클래스
public class PrototypePatternExample {
    public static void main(String[] args) {
        // 원본 객체 생성
        ConcretePrototype1 prototype1 = new ConcretePrototype1("Original 1");
        ConcretePrototype2 prototype2 = new ConcretePrototype2(42);

        // 객체 복제
        ConcretePrototype1 clonedPrototype1 = (ConcretePrototype1) prototype1.clone();
        ConcretePrototype2 clonedPrototype2 = (ConcretePrototype2) prototype2.clone();

        // 복제된 객체 출력
        clonedPrototype1.show();  // 출력: ConcretePrototype1: Original 1
        clonedPrototype2.show();  // 출력: ConcretePrototype2: 42
    }
}
```

### 설명

- `Prototype` 인터페이스는 객체 복제를 위한 `clone()` 메서드를 정의합니다.
- `ConcretePrototype1`과 `ConcretePrototype2`는 `Prototype` 인터페이스를 구현하며, 자신을 복제하는 구체적인 로직을 제공합니다.
- 클라이언트는 `clone()` 메서드를 사용하여 객체를 복제하며, 복제된 객체는 원본과 동일한 상태를 가집니다.

---

## 요약

- **프로토타입 패턴**은 객체 생성 비용이 클 때 유용하며, 객체를 복제하여 효율적으로 생성할 수 있습니다.
- 객체를 복제함으로써 복잡한 초기화 과정을 피하고, 다양한 객체를 빠르게 생성할 수 있습니다.
- 이 패턴은 특히 객체의 상태를 유지하면서 동일한 구조의 객체를 여러 개 생성할 때 적합합니다.