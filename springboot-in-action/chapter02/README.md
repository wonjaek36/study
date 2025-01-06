# Chapter 02

---

## 2. 1. 정보 보여주기

간단한 MVC 패턴을 통해 원하는 타코를 제조하는 페이지를 만듭니다.   

타코와 그 재료를 나타내는 도메인(Model) 클래스를 만듭니다. Lombok을 사용하면 getter, setter, constructor 등을 자동으로 생성할 수 있습니다.
어노테이션 `@Data`를 사용하면 getter, setter 등을 자동으로 생성할 수 있고, `@NoArgsConstructor`를 사용하면 Arguments가 없는 기본 생성자를 생성할 수 있습니다.

- Ingredient(tacos.Ingredient.java)
- Taco(tacos.Taco.java)

그리고 DesignTacoController 클래스를 만들어 http 요청을 처리하고, HTML을 반환합니다.  
RequestMapping을 이용하여 여러 Method의 요청을 처리할 수 있고,
GetMapping, PostMapping 등을 통해 각각의 HTTP Method 를 처리할 수 있습니다.

어노테이션 @Slf4j를 사용하면 자동으로 SLF4J Logger를 생성할 수 있습니다.

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DesignTacoController {
    // 어노테이션은 아래 코드와 같습니다.
    // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
}
```

마지막으로 Thymeleaf를 이용하여 뷰(HTML)을 만들어 보여줍니다.
여기서는 주로 사용하는 템플릿만 간단하게 소개하면,
```html
<p th:text="${message}">placeholder message</p>
<!-- placeholder message 대신 message를 출력합니다. -->

<div th:each="ingredient : ${wrap}">
    <input name="ingredients" type="checkbox" th:value="${ingredient.id}" />
    <span th:text="${ingredient.name}">placeholder name</span>
</div>
<!-- wrap에 있는 ingredient들을 하나씩 출력합니다. -->
<!-- wrap은 Model에 담겨있는 객체입니다. -->

```

## 2. 2. 폼 제출 처리하기

design.html에서 제출한 폼을 processDesign 메소드로 받아서 처리합니다.
그리고, 리다이렉트를 통해 orderForm을 호출하여 orderForm.html로 이동합니다.
```java
@PostMapping
public String processDesign(Taco design) {
    log.info("Processing design: " + design);
    // redirect 사용 방법
    return "redirect:/orders/current";
}
```

마찬가지로 orderForm.html 에서 /orders에 POST 요청을 보내면 processOrder 메소드로 받아서 "/"로 리다이렉트 합니다.
```java
@PostMapping
public String processOrder(Order order) {
    log.info("Order submitted: " + order);
    return "redirect:/";
}
```

## 2. 3. 폼 입력 유효성 검사하기
Model 클래스에 적절한 어노테이션을 사용하여 필드별 유효성 검사를 할 수 있습니다.
- @NotNull: 필드가 Null이 아닌지 확인합니다.
- @Size: 문자열 또는 리스트의 길이를 확인합니다.
- @NotBlank: 문자열이 Null이 아거나 공백이 아닌지 확인합니다.
- @CreditCardNumber: 신용카드 번호 형식을 확인합니다.
- @Pattern: 정규식을 사용하여 문자열이 매칭되는지 확인합니다.
- @Digits: 숫자의 정수와 소수의 자릿수를 확인합니다.

```java
// Taco.java
@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;
}

// Order.java
@Data
public class Order {

    @NotBlank(message="Name is required")
    private String deliveryName;

    // 일부 필드 생략
    
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp= "^(0[1-9]|1[0-2])(/)([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
}
```

cf) Spring 3 부터는 Validation을 하기 위해 jakarta.validation 을 import 합니다.
그리고, validation starter 의존성 추가합니다.
```xml
<!-- pom.xml //-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

thymeleaf에서 필드별 에러 메시지를 출력하기 위해서는 아래와 같이 사용합니다.
```html
<label for="ccCVV">CVV: </label>
<input type="text" th:field="*{ccCVV}" />
<!-- fields.hasErrors('ccCVV')는 ccCVV 필드에 에러가 있는지 확인하고, 에러가 있다면 CVV Error를 출력합니다. -->
<span class="validationError"
      th:if="${#fields.hasErrors('ccCVV')}"
      th:errors="*{ccCVV}">CVV Error</span>
<br />
```

## 2. 4. 뷰 컨트롤러로 작업하기
현재까지 @Controller 어노테이션을 이용해 컨트롤러를 만들고 http 요청을 처리하고, 뷰를 반환하였습니다.
하지만, HomeController는 단순히 뷰를 반환하는 역할만 하기 때문에 Controller 대신 View Controller를 이용할 수 있습니다.

WebMvcConfigurer 인터페이스를 구현해서 addViewControllers 메소드를 오버라이드하여 View Controller를 추가할 수 있습니다.
아래 코드는 "/" 요청을 home.html로 리다이렉트 합니다. 
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
```

## 2. 5. 뷰 템플릿 라이브러리 선택하기
스프링은 Thymeleaf 외에도 다양한 뷰 템플릿 라이브러리를 지원합니다.
- FreeMarker
- Groovy Template
- javaServer Pages (JSP)
- Mustache
- Thymeleaf

템플릿 캐싱을 사용하지 않으려면 application.properties에 아래와 같이 설정합니다.
```properties
spring.thymeleaf.cache=false
```