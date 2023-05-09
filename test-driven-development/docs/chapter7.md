# 7장. 사과와 오렌지

제목 : “You can’t compare apples and oranges”: 서로 다른 것을 비교할 수 없다.

**[목록]**

- $5 + 10CHF = $10 (환율이 2:1인 경우)
- ~~$5 X 2 = $10~~
- ~~amount를 private으로 만들기~~
- ~~Dollar side effect~~
- Money 반올림
- ~~equals()~~
- hashCode()
- Equal null
- Equal object
- ~~CHF * 2 = 10CHF~~
- Dollar / Franc 중복
- ~~공용 equals~~
- 공용 times
- **Franc와 Dollar 비교하기**

6장이 끝날 무렵 떠오른 생각에 대해 이야기 해보자.

Franc와 Dollar를 비교하면 어떻게 될까?

```java
@Test
    void testEquality() {
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
        assertThat(new Franc(5)).isEqualTo(new Franc(5));
        assertThat(new Franc(5)).isNotEqualTo(new Franc(6));
        assertThat(new Franc(5)).isNotEqualTo(new Dollar(5));
    } 
```

위와 같이 Dollar와 Franc을 비교하는 테스트를 작성하면 실패한다.

동치성 코드에서는 Dollar가 Franc과 비교되지 않는지 검사해야 한다.

두 객체의 클래스를 비교함으로써 이러한 검사를 쉽게 수행할 수 있다.

오직 금액과 클래스가 서로 동일할 때만 두 Money가 서로 같은 것이다.

따라서 Money 클래스의 `equals()` 메서드 또한 다음과 같이 변경한다.

```java
@Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount && this.getClass().equals(money.getClass());
    }
```

오직 금액과 클래스가 서로 동일할 때만 두 Money가 서로 같은 것이다.

모델 코드에서 클래스를 이런 식으로 사용하는 것은 좀 지저분해 보인다.

자바 객체의 용어를 사용하는 것보다 재정 분야에 맞는 용어를 사용하고 싶지만 현재는 통화 개념 같은것이 없고 통화 개념을 도입할 충분한 이유도 없어 보이므로 잠시 동안은 이대로 두자.

**[목록]**

- $5 + 10CHF = $10 (환율이 2:1인 경우)
- ~~$5 X 2 = $10~~
- ~~amount를 private으로 만들기~~
- ~~Dollar side effect~~
- Money 반올림
- ~~equals()~~
- hashCode()
- Equal null
- Equal object
- ~~CHF * 2 = 10CHF~~
- Dollar / Franc 중복
- ~~공용 equals~~
- 공용 times
- Franc와 Dollar 비교하기
- 통화?

이제 공통 `times()` 코드를 처리해야 할 때이다.

따라서 혼합된 통화 간의 연산에 대해 다루어야 한다.

정리하자면, 이번장에서는

- 괴롭히던 결함을 끄집어 내 테스트에 담아냈다.
- 완벽하지는 않지만 `getClass()` 로 테스트를 통과하게 만들었다.
- 더 많은 동기가 있기 전에는 더 많은 설계를 도입하지 않기로 했다.