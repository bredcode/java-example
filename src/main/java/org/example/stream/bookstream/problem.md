### 문제

민수는 다양한 책 정보를 포함하는 Book 객체의 리스트를 가지고 있습니다. 

각 Book 객체는 title(제목), author(저자), 그리고 price(가격)를 속성으로 가지고 있습니다. 

민수의 목표는 
- 가격이 20달러 이상인 책들 중, 
- 저자 이름이 "Smith"로 끝나는 책들의 제목을 모두 소문자로 변환한 뒤, 
- 알파벳 순서로 정렬하여 리스트로 반환하는 것입니다.

민수가 원하는 목표대로 동작할 수 있는 프로그램을 만들어주세요.


### 입력

```json
[
  { "title": "Java Programming", "author": "John Smith", "price": 25.50 },
  { "title": "Advanced Algorithms", "author": "Jane Doe", "price": 30.00 },
  { "title": "Data Structures", "author": "Alice Smith", "price": 19.99 },
  { "title": "Web Development", "author": "Robert Smith", "price": 22.75 },
  { "title": "Database Systems", "author": "Chris Johnson", "price": 18.00 },
  { "title": "Design Patterns", "author": "Emily Smith", "price": 21.99 }
]
```

### 출력

```json
[design patterns, java programming, web development]
```