## 객체 합성 (Object Composition)

**객체 합성**은 객체가 다른 객체를 구성 요소로 포함하여 기능을 확장하거나 코드를 재사용하는 설계 기법입니다. 클래스 간의 결합도를 낮추고 유연성을 높일 수 있습니다.

- **설명**: 클래스는 다른 클래스의 인스턴스를 필드로 포함하고 그 기능을 사용합니다. 이를 통해 객체는 다양한 구성 요소를 결합하여 복잡한 작업을 수행할 수 있습니다.
- **장점**:
    - **유연성**: 런타임에 포함된 객체를 동적으로 변경할 수 있습니다.
    - **낮은 결합도**: 상속보다 객체 간 결합도가 낮아 유지보수가 용이합니다.

### 예제

```java
// Engine 클래스
public class Engine {
    public void start() {
        System.out.println("엔진이 시작되었습니다.");
    }
}

// Car 클래스 (객체 합성 사용)
public class Car {
    private Engine engine; // Engine 객체를 포함

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start(); // Engine 객체의 기능 사용
        System.out.println("자동차가 출발합니다.");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine); // Car는 Engine 객체를 포함
        car.startCar();
    }
}
```

---

### 요약

- **객체 합성**: 객체가 다른 객체를 포함하여 그 기능을 사용하며, 독립적으로 존재하지만 함께 작업합니다.