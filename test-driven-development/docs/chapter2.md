TDD 주기는 다음과 같다.

1. **테스트를 작성한다.** 마음속에 있는 오퍼레이션이 코드에 어떤 식으로 나타나길 원하는지 생각해봐라. 원하는 인터페이스를 개발해라. 올바른 답을 얻기 위해 필요한 이야기의 모든 요소를 포함 시켜라.
2. **실행 가능하게 만든다.** 일단 테스트 통과시키는 것이 중요하다. 깔끔하고 단순한 해법이 명백히 보이면 그것을 입력해라.
   만약 깔끔하고 단순한 해법이 있지만 구현하는 데 몇 분 정도 걸릴 것 같다면 일단 적어 놓은 뒤에 원래 문제로 돌아오자.
3. **올바르게 만든다.** 시스템이 이제 작동하므로 직전에 저질렀던 죄악을 수습하자.
   중복을 제거하고 테스트가 통과되게 만들자.

**목적은 작동하는 깔끔한 코드를 얻는 것이다.**

********************************************************하지만 그것은 도달하기 힘들기 때문에 나누어서 정복하자 (divide and conquer)********************************************************

************************일단 ‘작동’ 하게 만들고 → ‘깔끔한 코드’ 부분을 해결해라.************************

‘깔끔한 코드’ 부분을 해결한 후에 ‘작동하는’ 부분을 해결해 나가면서 배운 것들을 설계에 반영하느라 허둥거리는 아키텍처 주도 개발 (architecture-driven development)과는 정 반대다.

**[목록]**

- $5 + 10CHF = $10 (환율이 2:1인 경우)
- ~~$5 X 2 = $10~~
- amount를 private으로 만들기
- **Dollar side effect**
- Money 반올림

**Dollar side effect:**

```java
@Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
        five.times(3);
        assertThat(five.amount).isEqualTo(15);
    }
```

위 방법에서 `test()` 에서 새로운 객체를 반환하게 하면 어떨까?

이렇게 하려면 Dollar 인터페이스를 수정해야 하고 테스트도 수정해야 한다.

하지만 괜찮다.

어떤 구현이 올바른가에 대한 우리 추측이 완벽하지 못한 것과 마찬가지로 **올바른 인터페이스에 대한 추측 역시 절대 완벽하지 못하다.**

테스트를 아래와 같이 변경한다.

```java
@Test
    void testMultiplication2() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
```

그리고 Dollar 클래스를 아래와 같이 수정한다.

```java
public Dollar times(int multiplier) {
        return new Dollar(amount *= multiplier);
    }
```

최대한 빨리 테스트를 통과하기 위해서 취할 수 있는 세 가지 전략 중 두가지

1. 가짜로 구현하기:
   상수를 반환하게 만들고 진짜 코드를 얻을 때까지 단계적으로 상수를 변수로 바꾸어 간다.
2. 명백한 구현 사용하기: 실제 구현을 입력한다.
3. ~~삼각측량(triangulation)~~ → 3장에서 다룸

작가는 보통 실무에서 TDD 사용시 위 두 방법 번갈아가며 사용한다.

이 장에서

- 설계상의 결함 (Dollar 부작용)을 결함으로 인해 실패하는 테스트로 변환했다.
- 스텁 구현으로 빠르게 컴파일을 통과하도록 만들었다.
- 올바르다고 생각하는 코드를 입력해 테스트를 통과했다.

느낌(부작용에 대한 혐오감)을 테스트로 변환하는 것은 tdd의 일반적인 주제다.

이런 작업을 오래 할수록 미적 판단을 테스트로 담아내는 것에 점점 익숙해지게 된다.

이걸 할 수 있어야 설계 논의는 훨씬 더 흥미로워진다.

우선 시스템이 이런 식으로 동작해야 하는지 저런 식으로 동작해야 하는지 논의 할 수 있다.