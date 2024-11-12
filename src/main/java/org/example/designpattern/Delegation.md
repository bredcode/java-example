## 위임 (Delegation)

**위임**은 객체가 작업을 스스로 처리하지 않고 다른 객체에 위임하여 처리하게 하는 설계 기법입니다. 이를 통해 코드의 책임을 분리하고 역할을 명확히 할 수 있습니다.

- **설명**: 객체는 특정 작업을 다른 객체에 위임하여 수행합니다. 이 방법은 동작을 쉽게 확장하거나 변경할 수 있을 때 유용합니다.
- **장점**:
    - **책임 분리**: 코드가 모듈화되고 역할이 명확하게 나뉩니다.
    - **유연성**: 작업을 위임하여 다양한 동작을 쉽게 변경할 수 있습니다.

### 예제

```java
// Printer 클래스
public class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}

// Manager 클래스 (위임 사용)
public class Manager {
    private Printer printer; // Printer 객체 포함

    public Manager(Printer printer) {
        this.printer = printer;
    }

    // Manager는 Printer에 메시지 출력을 위임
    public void delegatePrint(String message) {
        printer.print(message); // Printer에 작업을 위임
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Manager manager = new Manager(printer); // Manager는 Printer에 작업을 위임
        manager.delegatePrint("위임을 통한 출력입니다.");
    }
}
```
---
### 요약
**위임**: 작업을 다른 객체에 위임하여 책임을 분리하고 역할을 명확히 합니다.