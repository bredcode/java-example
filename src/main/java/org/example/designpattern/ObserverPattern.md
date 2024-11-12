# 옵저버 패턴 (Observer Pattern)

## 옵저버 패턴 (Observer Pattern) 개념

**옵저버 패턴**은 객체의 상태 변화에 따라 의존 관계에 있는 다른 객체들이 자동으로 알림을 받고 갱신될 수 있도록 하는 디자인 패턴입니다. 주로 이벤트 기반 시스템에서 사용되며, 발행-구독(publish-subscribe) 모델로도 알려져 있습니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/observer

### 구성 요소

1. **Subject (주제)**: 상태를 관리하며 옵저버를 등록, 제거, 알림을 제공하는 인터페이스입니다.
2. **Observer (옵저버 인터페이스)**: 주제의 상태 변화에 따라 알림을 받는 인터페이스입니다.
3. **ConcreteSubject (구체적인 주제)**: `Subject`를 구현하며, 상태가 변경되면 옵저버들에게 알림을 보냅니다.
4. **ConcreteObserver (구체적인 옵저버)**: `Observer`를 구현하며, 상태 변화에 따라 행동을 정의합니다.

---

## 옵저버 패턴 예제 코드 (Java)

```java
// Observer 인터페이스 정의
interface Observer {
    void update(String message);
}

// Subject 인터페이스 정의
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// ConcreteSubject 클래스 정의
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    // 뉴스 업데이트 메서드
    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

// ConcreteObserver 클래스 정의
class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

// 메인 클래스
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Observer subscriber1 = new NewsSubscriber("Subscriber 1");
        Observer subscriber2 = new NewsSubscriber("Subscriber 2");

        newsAgency.registerObserver(subscriber1);
        newsAgency.registerObserver(subscriber2);

        // 뉴스 업데이트
        newsAgency.setNews("Breaking News: Observer Pattern Example!");
        // 출력:
        // Subscriber 1 received news: Breaking News: Observer Pattern Example!
        // Subscriber 2 received news: Breaking News: Observer Pattern Example!

        newsAgency.removeObserver(subscriber1);
        newsAgency.setNews("Update: Observer Pattern Modified!");
        // 출력:
        // Subscriber 2 received news: Update: Observer Pattern Modified!
    }
}
```

### 설명

- `NewsAgency`는 `Subject` 인터페이스를 구현한 클래스이며, 옵저버들을 관리하고 상태 변화가 발생할 때 알림을 보냅니다.
- `NewsSubscriber`는 `Observer` 인터페이스를 구현한 클래스이며, 상태 변화에 따른 행동을 정의합니다.
- `setNews()` 메서드를 통해 뉴스가 업데이트되면 등록된 옵저버들에게 알림이 전송됩니다.

---

## 요약

- **옵저버 패턴**은 객체 간의 일대다 의존성을 정의하여, 하나의 객체 상태가 변화할 때 여러 객체가 자동으로 알림을 받는 구조입니다.
- 상태 변화를 주제 객체가 관리하고, 옵저버들은 이 변화에 따라 행동합니다.
- 이벤트 기반 시스템, GUI 응용 프로그램, 데이터 바인딩 등에 유용하게 사용됩니다.