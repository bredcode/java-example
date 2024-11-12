# 높은 응집력과 낮은 응집력

## 응집력 (Cohesion) 개념

- **응집력**은 객체 지향 설계에서 클래스나 모듈의 **책임이 얼마나 관련성이 높은지**를 나타냅니다.
- 높은 응집력은 클래스의 메서드와 필드가 하나의 목적을 공유하며 강하게 결합되어 있음을 의미합니다.
- 낮은 응집력은 클래스의 책임이 서로 관련이 적거나 여러 다른 작업을 처리할 때 발생합니다.
- **높은 응집력**은 코드의 **유지보수성**과 **가독성**을 높이고, **낮은 응집력**은 코드를 이해하고 수정하기 어렵게 만듭니다.

---

## 1. 높은 응집력 (High Cohesion) 코드 예시

```java
// 높은 응집력을 가진 User 클래스
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // User 클래스는 사용자의 정보에 대한 책임만 가짐
    public void displayUserInfo() {
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
    }

    public boolean isValidEmail() {
        return email.contains("@");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        User user = new User("홍길동", "hong@example.com");
        user.displayUserInfo();
        System.out.println("이메일 유효성: " + user.isValidEmail());
    }
}
```

**설명**: `User` 클래스는 사용자의 정보에 대한 책임만 가지고 있습니다. 모든 메서드는 `User` 클래스의 목적과 관련이 있으며, 클래스의 책임이 명확합니다. 이를 **높은 응집력**이라고 합니다.

---

## 2. 낮은 응집력 (Low Cohesion) 코드 예시

```java
// 낮은 응집력을 가진 User 클래스
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // 사용자 정보와 관련된 메서드
    public void displayUserInfo() {
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
    }

    // 유효성 검사 메서드 (관련 있음)
    public boolean isValidEmail() {
        return email.contains("@");
    }

    // 낮은 응집력: 파일 저장과 관련 없는 책임을 가짐
    public void saveToFile(String filename) {
        // 파일 저장 로직
        System.out.println("파일 " + filename + "에 사용자 정보를 저장했습니다.");
    }

    // 낮은 응집력: 데이터베이스 연결과 관련 없는 책임을 가짐
    public void connectToDatabase() {
        // 데이터베이스 연결 로직
        System.out.println("데이터베이스에 연결했습니다.");
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        User user = new User("홍길동", "hong@example.com");
        user.displayUserInfo();
        user.saveToFile("user_info.txt");
        user.connectToDatabase();
    }
}
```

**설명**: `User` 클래스는 사용자 정보뿐만 아니라 **파일 저장**과 **데이터베이스 연결**과 같은 서로 관련이 없는 책임을 가지고 있습니다. 이로 인해 클래스의 목적이 명확하지 않고 응집력이 낮아집니다. **낮은 응집력**은 클래스가 여러 다른 작업을 처리하기 때문에 **유지보수성**이 떨어집니다.

---

## 높은 응집력의 장점

- 클래스의 **책임이 명확**하여 코드를 쉽게 이해하고 유지보수할 수 있습니다.
- 변경이 필요할 때 코드의 다른 부분에 영향을 덜 미칩니다.

## 낮은 응집력의 단점

- 클래스의 책임이 **명확하지 않으며** 서로 관련 없는 작업을 포함합니다.
- 코드의 **재사용성**과 **유지보수성**이 낮아지고, 수정할 때 의도치 않은 부작용이 발생할 수 있습니다.

---

**요약**: 높은 응집력은 클래스의 역할을 명확하게 하여 좋은 객체 지향 설계를 가능하게 합니다. 낮은 응집력은 코드의 복잡성을 증가시키고, 이해 및 수정하기 어렵게 만듭니다.