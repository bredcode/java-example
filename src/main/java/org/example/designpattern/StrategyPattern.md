# 전략 패턴 (Strategy Pattern)과 응집력

## 전략 패턴 (Strategy Pattern) 개념

**전략 패턴**은 행위를 클래스 외부에서 정의하고, 이를 객체에 캡슐화하여 동적으로 행위를 변경할 수 있도록 하는 디자인 패턴입니다. 이 패턴은 특정 알고리즘을 여러 클래스로 분리하여, 런타임에 사용할 알고리즘을 선택할 수 있게 합니다.

### 개념 사이트
https://refactoring.guru/ko/design-patterns/strategy

### 구성 요소

1. **Context (문맥)**: 전략 객체를 참조하고 이를 통해 행위를 수행하는 클래스입니다.
2. **Strategy (전략 인터페이스)**: 다양한 알고리즘을 정의하는 공통 인터페이스입니다.
3. **ConcreteStrategy (구체적인 전략 클래스)**: `Strategy` 인터페이스를 구현하는 클래스들입니다. 각 클래스는 특정 알고리즘을 제공합니다.

---

## 전략 패턴 예제 코드 (Java)

```java
// 전략 인터페이스
public interface RouteStrategy {
    void buildRoute(String pointA, String pointB);
}

// ConcreteStrategy: 자동차 경로 전략
public class RoadStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String pointA, String pointB) {
        System.out.println("자동차 경로를 생성합니다: " + pointA + "에서 " + pointB + "까지");
    }
}

// ConcreteStrategy: 대중교통 경로 전략
public class PublicTransportStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String pointA, String pointB) {
        System.out.println("대중교통 경로를 생성합니다: " + pointA + "에서 " + pointB + "까지");
    }
}

// ConcreteStrategy: 도보 경로 전략
public class WalkingStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String pointA, String pointB) {
        System.out.println("도보 경로를 생성합니다: " + pointA + "에서 " + pointB + "까지");
    }
}

// Context 클래스
public class Navigator {
    private RouteStrategy routeStrategy;

    // 전략 설정 메서드
    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    // 경로 생성 메서드
    public void buildRoute(String pointA, String pointB) {
        routeStrategy.buildRoute(pointA, pointB);
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        // 자동차 경로 전략 설정
        navigator.setRouteStrategy(new RoadStrategy());
        navigator.buildRoute("서울", "부산");

        // 대중교통 경로 전략 설정
        navigator.setRouteStrategy(new PublicTransportStrategy());
        navigator.buildRoute("서울", "인천");

        // 도보 경로 전략 설정
        navigator.setRouteStrategy(new WalkingStrategy());
        navigator.buildRoute("광화문", "명동");
    }
}
```

### 설명

- `Navigator` 클래스는 `RouteStrategy` 인터페이스를 사용하여 다양한 경로 생성 전략을 동적으로 적용합니다.
- 이 코드 구조는 **높은 응집력**을 보여줍니다. `Navigator` 클래스는 경로 설정 및 생성에 대한 책임만 가지고 있으며, 각각의 `RouteStrategy` 구현 클래스는 특정 알고리즘만 다룹니다. 이로 인해 클래스들이 명확하게 정의된 책임을 가지고 있어, 유지보수와 확장이 쉽습니다.