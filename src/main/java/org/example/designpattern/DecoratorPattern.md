# 데코레이터 패턴 (Decorator Pattern)

## 데코레이터 패턴 (Decorator Pattern) 개념

**데코레이터 패턴**은 객체에 추가적인 기능을 동적으로 부여하는 패턴입니다. 이 패턴은 상속을 사용하지 않고도 객체의 기능을 확장할 수 있게 해줍니다. 객체의 구조를 수정하지 않고도 새로운 책임을 부여할 때 유용하게 사용됩니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/decorator

### 구성 요소

1. **Component (컴포넌트 인터페이스)**: 기본 객체에 추가될 기능을 정의하는 인터페이스입니다.
2. **ConcreteComponent (구체적인 컴포넌트)**: `Component` 인터페이스를 구현하며, 기본 기능을 제공하는 클래스입니다.
3. **Decorator (데코레이터 추상 클래스)**: `Component`를 구현하며, 추가 기능을 동적으로 부여할 수 있도록 설계된 클래스입니다.
4. **ConcreteDecorator (구체적인 데코레이터)**: `Decorator`를 확장하여 구체적인 기능을 추가하는 클래스입니다.

---

## 데코레이터 패턴 예제 코드 (Java)

```java
// Notifier 인터페이스 정의
interface Notifier {
    void send(String message);
}

// Concrete Notifier 클래스
class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}

// BaseDecorator 클래스 정의
abstract class BaseDecorator implements Notifier {
    protected Notifier wrappee;

    public BaseDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

// SMSDecorator 클래스 정의
class SMSDecorator extends BaseDecorator {
    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// FacebookDecorator 클래스 정의
class FacebookDecorator extends BaseDecorator {
    public FacebookDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendFacebookMessage(message);
    }

    private void sendFacebookMessage(String message) {
        System.out.println("Sending Facebook message: " + message);
    }
}

// SlackDecorator 클래스 정의
class SlackDecorator extends BaseDecorator {
    public SlackDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// 메인 클래스
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // 기본 알림 객체 생성
        Notifier notifier = new BasicNotifier();

        // SMS, Facebook, Slack 데코레이터 추가
        Notifier smsNotifier = new SMSDecorator(notifier);
        Notifier facebookNotifier = new FacebookDecorator(smsNotifier);
        Notifier slackNotifier = new SlackDecorator(facebookNotifier);

        // 알림 전송
        slackNotifier.send("This is a multi-channel notification!");
        // 출력:
        // Sending basic notification: This is a multi-channel notification!
        // Sending SMS notification: This is a multi-channel notification!
        // Sending Facebook message: This is a multi-channel notification!
        // Sending Slack message: This is a multi-channel notification!
    }
}

```

### 설명

- `BasicNotifier`: 기본 알림 기능을 제공합니다.
- `BaseDecorator`: `Notifier` 인터페이스를 구현하고, 기본 알림 객체를 감싸서 동적으로 기능을 추가할 수 있도록 합니다.
- `SMSDecorator`, `FacebookDecorator`, `SlackDecorator`: 각각 SMS, Facebook, Slack 알림 기능을 추가합니다. `super.send(message)`를 호출하여 기존 알림 기능을 수행한 후, 각각의 추가 기능을 실행합니다.

---

## 요약

- **데코레이터 패턴**은 객체에 기능을 동적으로 추가하는 데 유용하며, 상속 대신 구성(Composition)을 사용하여 기능 확장을 제공합니다.
- 객체의 기능을 다양한 방식으로 조합할 수 있으며, 코드의 유연성과 재사용성을 높여줍니다.
- 복잡한 객체 구조를 단순하게 유지하면서, 기능 확장을 쉽게 구현할 수 있습니다.