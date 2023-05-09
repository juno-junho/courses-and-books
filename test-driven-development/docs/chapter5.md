# 5장. 솔직히 말하자면(Franc-ly speaking)

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
- **CHF * 2 = 10CHF**

이 목록에 있는 테스트 중에서 가장 흥미로워 보이는 첫 번째 테스트에 어떤 식으로 접근하는 것이 좋을까? → 우선 프랑(Franc)을 표현하는 객체가 필요할 것 같다.

→ Dollar 테스트를 복사한 후 수정해보자

```java
@Test
    void testMultiplication() {
        Franc five = new Franc(5);
        assertThat(five.times(2)).isEqualTo(new Franc(10));
        assertThat(five.times(3)).isEqualTo(new Franc(15));
    }
```

여기서 Dollar 클래스를 복붙해야 하는가?

주기에는 서로 다른 단계들이 있다.

1. 테스트 작성
2. 컴파일되게 하기
3. 실패하는지 확인하기 위해 실행
4. 실행하게 만듦
5. 중복 제거

각 단계에는 서로 다른 목적이 있다. 다른 스타일의 해법과 다른 미적 시각을 필요로 한다.

처음 네 단계는 빠르게 진행해야 새 기능이 포함되더라도 잘 알고 있는 상태에 이를 수 있다.

그 동안 만틈은 속도가 설계보다 더 높은 패이기 때문이다.

**주기의 다섯 번째 단계 없이는 앞의 네 단계도 제대로 되지 않는다.**

적절한 시기에 적절한 설계를. 돌아가게 만들고 올바르게 만들어라.

```java
public class Franc {
    private final int amount;
    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Franc franc = (Franc) obj;
        return amount == franc.amount;
    }
}
```

따라서 위 같이 만들고 중복을 해결할 방법을 목록에 추가 한다.

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
- 공용 equals
- 공용 times

코드를 실행하기까지의 단계가 짧았기에 ‘컴파일되게 하기’ 단계도 넘어갈 수 있었다.

**중복이 매우 많기에 다음 테스트를 작성하기 전에 이것들을 제거해야 한다.**

정리하자면,

- 우리는 큰 테스트를 공략할 수 없다. 따라서 진전을 나타낼 수 있는 자그마한 테스트를 만들었다.
- 뻔뻔스럽게 중복을 만들고 조금 고쳐 테스트를 작성했다.
- 모델 코드까지 복사하고 수정해 테스트를 통과했다.
- **중복이 사라지기 전에는 집에 가지 않겠다고 약속했다.**