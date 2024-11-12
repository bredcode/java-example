# 어댑터 패턴 - 콘센트 볼트 변환 예제

## 개념

이 예제에서는 **어댑터 패턴**을 사용하여 서로 다른 전압(Volt)을 사용하는 장치들이 동일한 전원 콘센트를 사용할 수 있도록 변환합니다. 예를 들어, 미국의 120V 전압을 사용하는 장치를 유럽의 240V 전압에 연결하거나 그 반대의 경우를 처리할 수 있습니다.

---

## 구성 요소 설명

1. **Target (타겟 인터페이스)**: `Volt` 객체를 반환하는 메서드를 정의합니다. 클라이언트가 기대하는 인터페이스입니다.
2. **Adaptee (적응 대상 클래스)**: 기존의 `Volt` 클래스로, 특정 전압을 반환합니다.
3. **Adapter (어댑터 클래스)**: `Target` 인터페이스를 구현하고, `Adaptee`의 전압을 변환하여 클라이언트가 기대하는 형식으로 제공합니다.

---

## 어댑터 패턴 예제 코드 (Java)

```java
// Volt 클래스 정의 (전압을 나타내는 간단한 클래스)
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }
}

// Target 인터페이스 정의
interface SocketAdapter {
    Volt get120Volt();
    Volt get240Volt();
    Volt get12Volt();
}

// Adaptee 클래스 정의 (기존 소켓 클래스)
class Socket {
    public Volt getVolt() {
        return new Volt(240); // 기본 전압은 240V
    }
}

// Adapter 클래스 정의 (어댑터 구현)
class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get120Volt() {
        Volt v = getVolt();
        return convertVolt(v, 2); // 240V를 120V로 변환
    }

    @Override
    public Volt get240Volt() {
        return getVolt(); // 240V 그대로 반환
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 20); // 240V를 12V로 변환
    }

    // 전압 변환 메서드
    private Volt convertVolt(Volt v, int divisor) {
        return new Volt(v.getVolts() / divisor);
    }
}

// 클라이언트 코드
public class AdapterPatternExample {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketAdapterImpl();

        Volt v120 = adapter.get120Volt();
        Volt v240 = adapter.get240Volt();
        Volt v12 = adapter.get12Volt();

        System.out.println("120V using Adapter: " + v120.getVolts() + "V");
        System.out.println("240V using Adapter: " + v240.getVolts() + "V");
        System.out.println("12V using Adapter: " + v12.getVolts() + "V");
    }
}
```

### 설명

- **Volt 클래스**: 전압을 나타내는 간단한 클래스입니다.
- **Socket 클래스**: 기본적으로 240V 전압을 반환하는 `Adaptee` 클래스입니다.
- **SocketAdapter 인터페이스**: 클라이언트가 기대하는 인터페이스로, 다양한 전압을 반환하는 메서드를 정의합니다.
- **SocketAdapterImpl 클래스**: `SocketAdapter`를 구현하며, `Socket` 클래스의 전압을 변환하여 제공하는 어댑터입니다.

---

## 요약

- **어댑터 패턴**을 사용하여 서로 다른 전압을 사용하는 장치들이 동일한 전원 소스를 사용할 수 있도록 변환합니다.
- 이 패턴은 기존 클래스의 인터페이스를 변환하여 클라이언트가 원하는 형식으로 제공함으로써 호환성을 제공합니다.
- 실제로 전압 변환 어댑터와 같이, 기존 클래스를 수정하지 않고도 유연하게 확장할 수 있습니다.