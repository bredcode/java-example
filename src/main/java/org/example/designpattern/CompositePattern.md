# 컴포지트 패턴 (Composite Pattern)

## 컴포지트 패턴 (Composite Pattern) 개념

**컴포지트 패턴**은 객체를 트리 구조로 구성하여 부분-전체 계층 구조를 표현하는 패턴입니다. 이 패턴을 사용하면 클라이언트가 개별 객체와 객체의 그룹을 동일하게 처리할 수 있습니다. 주로 복합 객체와 단일 객체를 일관성 있게 다루어야 할 때 유용합니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/composite

### 구성 요소

1. **Component (컴포넌트 인터페이스)**: 트리 구조의 노드들에 대한 공통 인터페이스를 정의합니다.
2. **Leaf (잎 노드 클래스)**: 트리 구조의 끝 노드를 나타내며, 실제 작업을 수행하는 클래스입니다.
3. **Composite (복합 노드 클래스)**: 자식을 가지는 노드로, 자식 노드들을 관리하고 작업을 위임합니다.

---

## 컴포지트 패턴 예제 코드 (Java)

```java
// Component 인터페이스 정의
interface Graphic {
    void draw();
}

// Leaf 클래스 정의: Circle
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Leaf 클래스 정의: Square
class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Composite 클래스 정의
class CompositeGraphic implements Graphic {
    private List<Graphic> childGraphics = new ArrayList<>();

    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : childGraphics) {
            graphic.draw();
        }
    }
}

// 메인 클래스
public class CompositePatternExample {
    public static void main(String[] args) {
        // Leaf 객체 생성
        Graphic circle1 = new Circle();
        Graphic circle2 = new Circle();
        Graphic square = new Square();

        // Composite 객체 생성
        CompositeGraphic composite = new CompositeGraphic();
        composite.add(circle1);
        composite.add(circle2);
        composite.add(square);

        // 전체 트리 구조의 draw 호출
        System.out.println("Drawing Composite Graphic:");
        composite.draw();
        // 출력:
        // Drawing a Circle
        // Drawing a Circle
        // Drawing a Square
    }
}
```

### 설명

- **Graphic 인터페이스**: `draw()` 메서드를 정의하여 모든 컴포넌트(잎과 복합 객체)가 이를 구현하도록 합니다.
- **Circle**과 **Square**: 잎 노드 클래스입니다. `Graphic` 인터페이스를 구현하며, `draw()` 메서드가 실제 작업을 수행합니다.
- **CompositeGraphic**: 복합 노드 클래스입니다. 자식 `Graphic` 객체들을 관리하며, `draw()` 메서드를 호출하여 자식 객체들의 `draw()` 메서드를 호출합니다.

---

## 요약

- **컴포지트 패턴**은 객체를 트리 구조로 구성하여 개별 객체와 복합 객체를 동일하게 다룰 수 있도록 합니다.
- 복잡한 객체 구조를 단순화하고, 클라이언트가 일관성 있게 객체들을 처리할 수 있습니다.
- 이 패턴은 UI 구성 요소나 파일 시스템과 같은 계층적 구조를 다룰 때 유용합니다.