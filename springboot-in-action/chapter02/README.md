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