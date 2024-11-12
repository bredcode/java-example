# 브릿지 패턴 (Bridge Pattern)

## 브릿지 패턴 (Bridge Pattern) 개념

**브릿지 패턴**은 추상화(Abstraction)와 구현(Implementation)을 분리하여 서로 독립적으로 확장할 수 있도록 설계하는 구조적 디자인 패턴입니다. 이 패턴은 클래스의 기능 계층과 구현 계층을 분리함으로써 서로 독립적으로 변경이 가능합니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/bridge

### 구성 요소

1. **Abstraction (추상화 클래스)**: 기능 계층의 기본 인터페이스 또는 추상 클래스를 정의하며, `Implementor` 객체에 대한 참조를 유지합니다.
2. **RefinedAbstraction (확장된 추상화 클래스)**: `Abstraction`을 확장하여 기능을 구체화합니다.
3. **Implementor (구현 인터페이스)**: 구현 계층의 인터페이스를 정의합니다.
4. **ConcreteImplementor (구체적인 구현 클래스)**: `Implementor` 인터페이스를 구현하여 실제 기능을 제공합니다.

---

## 브릿지 패턴 예제 코드 (Java)

```java
// Implementor 인터페이스 정의
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

// ConcreteImplementor 클래스: TV
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

// ConcreteImplementor 클래스: Radio
class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Radio volume set to " + volume);
    }
}

// Abstraction 클래스 정의
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);
}

// RefinedAbstraction 클래스: BasicRemote
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// RefinedAbstraction 클래스: AdvancedRemote
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }

    // 추가 기능: 음소거
    public void mute() {
        System.out.println("Device is muted.");
    }
}

// 메인 클래스
public class BridgePatternExample {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.turnOn();
        basicRemote.setVolume(10);
        basicRemote.turnOff();

        System.out.println();

        Device radio = new Radio();
        RemoteControl advancedRemote = new AdvancedRemote(radio);
        advancedRemote.turnOn();
        advancedRemote.setVolume(5);
        ((AdvancedRemote) advancedRemote).mute();
        advancedRemote.turnOff();
    }
}
```

### 설명

- **Device 인터페이스**: 구현 계층의 인터페이스로, `TV`와 `Radio`는 이를 구현하여 실제 기능을 제공합니다.
- **RemoteControl 클래스**: 추상화 계층의 기본 클래스로, `Device` 객체에 대한 참조를 유지하며, 기능 계층의 메서드를 정의합니다.
- **BasicRemote**와 **AdvancedRemote**: `RemoteControl`을 확장한 클래스들로, 각각 기본 및 추가 기능을 제공합니다.

---

## 요약

- **브릿지 패턴**은 추상화와 구현을 분리하여 독립적으로 확장할 수 있도록 합니다.
- 이 패턴을 사용하면 다양한 기능을 가진 클래스와 여러 구현을 조합하여 유연한 구조를 만들 수 있습니다.
- 코드의 변경에 유연성을 제공하며, 기능 확장과 구현 변경이 독립적으로 이루어질 수 있습니다.