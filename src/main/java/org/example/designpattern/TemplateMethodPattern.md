# 템플릿 메서드 패턴 (Template Method Pattern)

## 템플릿 메서드 패턴 (Template Method Pattern) 개념

**템플릿 메서드 패턴**은 상위 클래스에서 알고리즘의 골격(템플릿)을 정의하고, 하위 클래스에서 일부 단계를 구체적으로 구현하는 디자인 패턴입니다. 이를 통해 알고리즘의 구조는 유지하면서, 세부적인 구현은 하위 클래스에서 다르게 제공할 수 있습니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/template-method

### 구성 요소

1. **AbstractClass (추상 클래스)**: 알고리즘의 템플릿을 정의하며, 템플릿 메서드가 포함됩니다. 일부 메서드는 구현되어 있고, 일부 메서드는 추상 메서드로 하위 클래스에서 구현됩니다.
2. **ConcreteClass (구체적인 클래스)**: `AbstractClass`를 상속받아, 추상 메서드를 구현하고 알고리즘의 특정 단계를 제공합니다.

---

## 템플릿 메서드 패턴 예제 코드 (Java)

```java
// AbstractClass 정의
abstract class DataProcessor {
    // 템플릿 메서드 - 알고리즘의 골격을 정의
    public final void process() {
        loadData();
        processData();
        saveData();
    }

    // 데이터 로드 메서드 (구현된 메서드)
    protected void loadData() {
        System.out.println("데이터를 로드합니다.");
    }

    // 데이터 처리 메서드 (추상 메서드)
    protected abstract void processData();

    // 데이터 저장 메서드 (구현된 메서드)
    protected void saveData() {
        System.out.println("데이터를 저장합니다.");
    }
}

// ConcreteClass1 정의
class TextDataProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("텍스트 데이터를 처리합니다.");
    }
}

// ConcreteClass2 정의
class ImageDataProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("이미지 데이터를 처리합니다.");
    }
}

// 메인 클래스
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        // TextDataProcessor 사용
        DataProcessor textProcessor = new TextDataProcessor();
        textProcessor.process();
        // 출력:
        // 데이터를 로드합니다.
        // 텍스트 데이터를 처리합니다.
        // 데이터를 저장합니다.

        // ImageDataProcessor 사용
        DataProcessor imageProcessor = new ImageDataProcessor();
        imageProcessor.process();
        // 출력:
        // 데이터를 로드합니다.
        // 이미지 데이터를 처리합니다.
        // 데이터를 저장합니다.
    }
}
```

### 설명

- `DataProcessor`는 알고리즘의 구조를 정의하는 추상 클래스입니다. `process()` 메서드는 데이터 처리의 일반적인 흐름을 정의하며, 일부 단계는 하위 클래스에서 구현됩니다.
- `TextDataProcessor`와 `ImageDataProcessor`는 `DataProcessor`를 상속받아, `processData()` 메서드를 각각 다르게 구현합니다.
- `process()` 메서드는 `final`로 선언되어 있어, 하위 클래스에서 알고리즘의 전체 구조를 변경할 수 없습니다.

---

## 요약

- **템플릿 메서드 패턴**은 알고리즘의 기본 구조를 정의하면서, 세부 구현은 하위 클래스에 위임합니다.
- 알고리즘의 공통 부분은 상위 클래스에서 구현되고, 변해야 하는 부분만 하위 클래스에서 오버라이딩하여 확장할 수 있습니다.
- 코드의 재사용성을 높이고, 알고리즘의 변화를 최소화할 수 있습니다.