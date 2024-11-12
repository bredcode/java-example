# 파사드 패턴 (Facade Pattern)

## 파사드 패턴 (Facade Pattern) 개념

**파사드 패턴**은 복잡한 서브시스템에 대한 간단한 인터페이스를 제공하는 구조적 디자인 패턴입니다. 이 패턴은 서브시스템의 내부 복잡성을 숨기고, 클라이언트가 서브시스템을 쉽게 사용할 수 있도록 단순화된 인터페이스를 제공합니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/facade

### 구성 요소

1. **Facade (파사드 클래스)**: 클라이언트가 사용하기 쉬운 간단한 인터페이스를 제공합니다.
2. **Subsystem (서브시스템 클래스)**: 복잡한 로직을 포함하는 여러 클래스들로 구성됩니다. 파사드 클래스는 이 서브시스템의 기능을 단순화하여 제공합니다.

---

## 파사드 패턴 예제 코드 (Java)

```java
// 서브시스템 클래스 1
class CPU {
    public void start() {
        System.out.println("CPU starting...");
    }
    public void stop() {
        System.out.println("CPU stopping...");
    }
}

// 서브시스템 클래스 2
class Memory {
    public void load() {
        System.out.println("Memory loading...");
    }
    public void clear() {
        System.out.println("Memory clearing...");
    }
}

// 서브시스템 클래스 3
class HardDrive {
    public void readData() {
        System.out.println("HardDrive reading data...");
    }
    public void writeData() {
        System.out.println("HardDrive writing data...");
    }
}

// Facade 클래스
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // 간단한 인터페이스 제공: 컴퓨터 시작
    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.readData();
        System.out.println("Computer started successfully!");
    }

    // 간단한 인터페이스 제공: 컴퓨터 종료
    public void shutdownComputer() {
        hardDrive.writeData();
        memory.clear();
        cpu.stop();
        System.out.println("Computer shut down successfully!");
    }
}

// 메인 클래스
public class FacadePatternExample {
    public static void main(String[] args) {
        // Facade 클래스 사용
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();  // 컴퓨터 시작
        System.out.println();
        computer.shutdownComputer();  // 컴퓨터 종료
    }
}
```

### 설명

- **CPU**, **Memory**, **HardDrive**: 서브시스템 클래스들로, 각각의 복잡한 동작을 수행합니다.
- **ComputerFacade**: 클라이언트가 서브시스템의 복잡성을 알 필요 없이, 컴퓨터를 시작하거나 종료하는 간단한 메서드를 제공합니다.
- **클라이언트**: `ComputerFacade` 클래스만 사용하여 서브시스템을 쉽게 제어할 수 있습니다.

---

## 요약

- **파사드 패턴**은 복잡한 서브시스템에 대한 단순화된 인터페이스를 제공합니다.
- 서브시스템의 내부 복잡성을 감추고, 클라이언트가 더 쉽게 사용할 수 있도록 도와줍니다.
- 코드의 이해와 유지보수를 쉽게 하고, 서브시스템과 클라이언트 간의 결합도를 줄이는 데 유용합니다.