# 빌더 패턴 (Builder Pattern)

## 빌더 패턴 (Builder Pattern) 개념

**빌더 패턴**은 복잡한 객체의 생성 과정을 단계별로 나눌 수 있도록 해주는 디자인 패턴입니다. 이 패턴을 사용하면 객체 생성에 필요한 다양한 속성을 명확하게 설정할 수 있으며, 생성자에 많은 매개변수를 사용하는 경우보다 더 읽기 쉽고 유지보수하기 편리한 코드 작성을 가능하게 합니다.

### 개념 사이트

https://refactoring.guru/ko/design-patterns/builder

### 구성 요소

1. **Builder (빌더 인터페이스)**: 객체를 구성하는 메서드들을 정의합니다.
2. **ConcreteBuilder (구체적인 빌더 클래스)**: `Builder` 인터페이스를 구현하여 객체 생성에 필요한 구체적인 메서드를 정의합니다.
3. **Product (제품 클래스)**: 빌더가 생성하는 복잡한 객체입니다.
4. **Director (디렉터 클래스)**: 빌더 객체를 사용하여 제품을 생성하는 클래스입니다.

---

## 빌더 패턴 예제 코드 (Java)

```java
// Product 클래스 정의
class Product {
    // 필수 속성
    private final String name;
    private final double price;

    // 선택 속성
    private final String description;
    private final String manufacturer;
    private final int warranty;

    // 생성자 - 빌더를 통해서만 접근 가능
    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
        this.manufacturer = builder.manufacturer;
        this.warranty = builder.warranty;
    }

    // Product 클래스의 정보 출력 메서드
    public void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + (description != null ? description : "N/A"));
        System.out.println("Manufacturer: " + (manufacturer != null ? manufacturer : "N/A"));
        System.out.println("Warranty: " + (warranty > 0 ? warranty + " year(s)" : "N/A"));
    }

    // Builder 클래스 정의
    public static class Builder {
        // 필수 속성
        private final String name;
        private final double price;

        // 선택 속성
        private String description;
        private String manufacturer;
        private int warranty;

        // Builder 생성자 - 필수 속성만 초기화
        public Builder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // 선택 속성을 설정하는 메서드들
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder warranty(int warranty) {
            this.warranty = warranty;
            return this;
        }

        // 최종 Product 객체 생성
        public Product build() {
            return new Product(this);
        }
    }
}

// 메인 클래스
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Product 객체를 빌더를 통해 생성
        Product product = new Product.Builder("Laptop", 1500.00)
                .description("High-performance laptop")
                .manufacturer("TechBrand Inc.")
                .warranty(2)
                .build();

        // Product 객체의 정보 출력
        product.display();
    }
}
```

### 설명

- `Product` 클래스는 `Builder` 클래스를 통해서만 생성됩니다. 이로써 객체의 생성 과정을 단계별로 제어할 수 있습니다.
- `Builder` 클래스는 필수 속성만 설정한 후, 선택 속성을 설정할 수 있도록 메서드 체인을 제공합니다.
- `build()` 메서드를 호출하면 `Product` 객체가 생성됩니다.

---

## 요약

- **빌더 패턴**은 복잡한 객체를 유연하게 생성할 수 있도록 합니다.
- 생성자에 많은 매개변수를 사용하지 않고도, 객체의 속성을 명확하게 설정할 수 있습니다.
- 특히 객체가 불변이거나 다양한 속성 조합이 필요한 경우에 유용합니다.