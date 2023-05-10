# 8장. 객체 만들기

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
- **Dollar / Franc 중복**
- ~~공용 equals~~
- 공용 times
- Franc와 Dollar 비교하기
- 통화?

Dollar와 Franc에서 `times()` 메서드가 중복된다.

→ Money를 메서드 반환 타입으로 설정한다.

그 다음 무엇을 해야 할까

Money의 두 하위 클래스는 그다지 많은 일을 하는 것 같지 않기에 그냥 아예 제거해버리고 싶다.

그런데 한번에 큰 단계를 밟은 것은 TDD를 효과적으로 보여주기에 적절하지 않을것 같다.

→ 하위 클래스에 대한 직접적인 참조가 적어지면 하위 클래스를 제거하기 위해 한 발짝 더 다가갔다고 할 수 있다.

→ Money에 Dollar를 반환하는 `Factory Method`를 도입한다.

```java
public static Money dollar(int amount) {
        return new Dollar(amount);
    }
```

글고 Money를 추상 클래스로 변경하며, `times()` 메서드를 추상 메서드로 변경한다.

**이렇게 변경하면 어떤 클라이언트 코드도 Dollar 하위 클래스가 있따는 사실을 알지 못한다.**

**하위 클래스의 존재를 테스트에서 분리함으로써 어떤 무델 코드에도 영향을 주지 않고 상속구조를 마음대로 변경할 수 있게 되었다.**

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
- **Dollar / Franc 중복**
- ~~공용 equals~~
- 공용 times
- ~~Franc와 Dollar 비교하기~~
- 통화?
- `testFrancMultiplication()` 을 지워야 할까?

다음 장에서는 `times()` 의 중복을 거둬낼 것이다.

우리는

- 동일한 `times()` 메서드의 두 변이형 메서드 서명부를 통일시킴으로써 중복 제거를 향해 한 단계 더 전진했다.
- 최소한 메서드 선언부만이라도 고통 상위 클래스로 옮겼다.
- 팩토리 메서드를 도입해 테스트 코드에서 콘크리트 하위 클래스의 존재 사실을 분리해냈다.
- 하위클래스가 사라지면 몇몇 테스트는 불필요한 여분의 것이 된다는 것을 인식했다. 하지만 일단 그냥 뒀다.