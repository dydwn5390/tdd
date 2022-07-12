# Junit 5 기초

## @Test annotation

- 테스트로 사용할 클래스를 만들고 @Test annotation 을 메서드에 붙여 사용한다.
- @Test annotation 을 붙인 메서드는 private이면 안된다.

## 주요 메서드

| 메서드                                             | 설명                                        |
|-------------------------------------------------|-------------------------------------------|
| assertEquals(expected,actual)                   | 실제 값(actual)이 기대하는 값(expected)과 같은지 검사한다. |
| assertNotEquals(unexpected, actual)             | 실제 값(actual)이 특정 값(unexpected)과 같은지 검사한다. |
| assertSame(Object expected, Object actual)      | 두 객체가 동일한 객체인지 검사한다.                      |
| assertNotSame(Object unexpected, Object actual) | 두 객체가 동일하지 않은 객체인지 검사한다.                  |
| assertTrue(boolean condition)                   | 값이 true 인지 검사한다.                          |
| assertFalse(boolean condition)                  | 값이 false 인지 검사한다.                         |
| assertNull(Object actual)                       | 값이 null 인지 검사한다.                          |
| assertNotNull(Object actual)                    | 값이 null이 아닌지 검사한다.                        |
| fail()                                          | 테스트를 실패 처리한다.                             |


<br>

## 익셉션 발생 유무 검사 메서드
| 메서드                                                        | 설명                                          |
|------------------------------------------------------------|---------------------------------------------|
| assertThrows(Class<T> expectedType, Executable executable) | executable 실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사한다. |
| assertDoesNotThrows(Executable executable)                 | executable을 실행한 결과로 익셉션이 발생하지 않는지 검사한다.     |

<br>

assert 메서드는 실패하면 다음 코드를 실행하지 않고 바로 익셉션을 발생한다.
예를 들어, 다음 코드는 첫 번째 assertEquals() 메서드에서 검증에 실패하기 떄문에, 그 시점에 AssertionFailedError가 발생한다.
따라서 두번쨰 assertEquals() 메서드는 실행되지 않는다.

<br>

```
assertEquals(3, 5/2); // 검증 에러로 실패 발생
assertEquals(4, 2*2);
```

<br>

그런데 경우에 따라 일단 모든 검증을 실행하고 그중에 실패한 것이 있는지 확인하고 싶을 때가 있다.
이럴 때 사용할 수 있는 것이 **assertAll()** 메서드이다.

```
        assertAll(
                () -> assertEquals(3, 5/2),
                () -> assertEquals(4, 2*2)
        );
```

<br>

assertAll() 메서드는 Executable 목록을 가변 인자로 전달받아 각 Executable을 실행한다.
실행 결과로 검증에 실패한 코드가 있으면 그 목록을 모아서 에러 메세지로 보여준다.

<br>
<br>
<br>

## 테스트 라이프 사이클

### @BeforeEach, @AfterEach

Junit은 각 테스트 메서드마다 다음 순서대로 코드를 실행핟나.

1. 테스트 메서드를 포함한 객체 생성 
2. (존재하면) @BeforeEach annotation이 붙은 메서드 실행
3. @Test annotation이 붙은 메서드 실행
4. (존재하면) @AfterEach annotation이 붙은 메서드 실행

<br>

@BeforeEach 어노테이션은 테스트를 실행하는데 필요한 준비 작업을 할 때 사용한다.
테스트에서 사용할 임시 파일을 생성한다거나, 테스트 메서드에서 사용할 객체를 생성한다.

반대로, @AfterEach 어노테이션은 테스트를 실행한 후에 정리할 것이 있을때 사용한다. 
테스트에서 사용한 임시파일을 삭제해야될 때 AfterEach 어노테이션을 사용하면 된다.


<br>
<br>

### @BeforeAll, @AfterAll

한 클래스의 모든 테스트 메서드가 실행되기 전에 특정 작업을 수행해야 한다면, @BeforeAll annotation을 사용한다.
@BeforeAll annotation은 정적 메서드에 붙이는데, 이 메서드는 클래스의 모든 테스트 메서드를 실행하기 전에 한 번 실행된다.

@AfterAll은 반대로 클래스의 모든 테스트 메서드를 실행한 뒤에 실행된다. 이 메서드 역시 정적 메서드에 적용한다.


<br>
<br>

### @BeforeAll vs @BeforeEach

**@BeforeAll**

- 리턴 타입 : void  
- private 사용 금지  
- static (정적) 메서드만 테스트  

**@BeforeEach**  
- 리턴 타입 : void  
- private 사용 금지  
- 일반 메서드만 테스트 

<br>
<br>
<br>

## 테스트 메서드 간 실행 순서 의존과 필드 공유하지 않기 

 테스트 메서드가 특정 순서대로 실행된다는 가정 하에 테스트 메서드를 작성하면 안 된다.

JUnit이 테스트 순서를 결정하긴 하지만 그 순서는 버전에 따라 달라질 수 있다.

각 테스트 메서드는 서로 독립적으로 동작해야 한다. 한 테스트 메서드의 결과에 따라 다른 테스트 메서드의 실행 결과가 달라지면 안 된다.

<br>
<br>
<br>

## @DisplayName, @Disabled 

- @DisplayName : 테스트에 표시 이름을 붙일 수 있음.
- @Disabled : 테스트 실행 대상에서 제외할 수 있음.
- 
