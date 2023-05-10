# 9장. 우리가 사는 시간

** 제목은 시간과 곱하기 time 동의어를 사용한 말장난이다

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
- ~~Franc와 Dollar 비교하기~~
- **통화?**
- `testFrancMultiplication()` 을 지워야 할까?

목록에서 어떤 것을 하면 귀찮고 불필요한 하위 클래스를 제거하는데 도움이 될까?

통화 개념을 도입해보면 어떨까

통화를 표현하기 위한 복잡한 객체를 원할 수도 있다.

그리고 객체들이 필요한 만큼만 만들어지도록 하기 위해 경량 팩토리(flyweight factories)를 사용할 수 있을 것이다. 하지만 당분간은 그런 것들 대신 문자열을 쓰자.

우선 테스트를 아래와 같이 작성하고,

```java
@Test
    void testCurrency() {
        assertThat(Money.dollar(1).currency()).isEqualTo("USD");
        assertThat(Money.franc(1).currency()).isEqualTo("CHF");
    }
```

Money 클래스에 `currency()` 를 추상 메서드로 선언한다.

그리고 각각 Dollar와 Franc 클래스에서 구현한다.

우린 두 클래스가 모두 포함할 수 있는 동일한 구현을 원한다.

통화를 인스턴스 변수에 저장하고 메서드에서는 그냥 그것을 반환하게 만들 수 있을 것 같다.

```java
    private final String currency;

    public Franc(int amount) {
        this.amount = amount;
        this.currency = "CHF";
    }
		@Override
    String currency() {
        return this.currency;
    }
```

위 같이 변경한다.

이제 `currency()` 가 Dollary와 Franc에서 동일하므로 변수 선언과 `currency()` 구현을 둘 다 위로 올릴 수 있게 되었다.

```java
	protected String currency;
	String currency(){
        return this.currency;
   }
```

위와 같이 Money 클래스를 변경했다.

문자열 “USD”와 “CHF”를 정적 팩토리 메서드로 옮기면 두 생성자가 동일해 질것이고, 이는 공통 구현을 만들 수 있다.

우선 생성자에 인자 currency를 추가하자 (Dollar, Franc)

→ 진행하기 전에 `times()` 를 정리하자. (정적 팩토리 메서드)

Money 클래스에서 생성자로 currency를 주입하게 변경한다.

```java
    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }
```

이렇게 하면 두 생성자가 동일해 졌다 → 상위 클래스로 옮기자.

Money로 생성자를 다음과 같이 옮기고,

```java
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
```

Franc와 Dollar 생성자는 아래와 같이 처리해준다.

```java
	 public Franc(int amount, String currency) {
        super(amount, currency);
    }
```

이러면 `times()` 를 상위 클래스로 올리고 하위 클래스들을 제거할 준비가 거의 다 되었다.

지금까지 한 것을 검토해 본다면,

- 큰 설계 아이디어를 다루다 곤경에 빠져 더 작은 작업을 수행했다.
- 다른 부분들을 호출자(팩토리 메서드)로 옮김으로써 두 생성자를 일치시켰다.
- `times()` 가 팩토리 메서드를 사용하도록 만들기 위해서 리팩토링을 잠시 중단했다.
- 비슷한 리팩토링을 한번의 큰 단계로 처리했다.
- 동일한 생성자들을 상위 클래스로 올렸다.