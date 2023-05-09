# 6장. 돌아온 ‘모두를 위한 평등’

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
- **공용 equals**
- 공용 times

이제 중복을 제거할 차례다.

지난 5장에서 테스트를 통과하기 위해 많은 코드를 복사해서 붙이는 죄를 저질렀다.

청소하는 방법 중 한가지는 클래스 중 하나가 다른 클래스를 **상속받게 하는 것**이다.

**→ 해봤는데 어떤 코드도 구원하지 못했다.**

대신 **공통 상위 클래스**를 찾아낸다.

→ 시간이 조금 걸리긴 하지만 아주 잘 작동했다.

공통 상위 클래스인 Money 클래스가 공통의 `equals()` 코드를 갖게 하면 어떨까

간단한 것부터 시작해보자.

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
- **~~공용 equals~~**
- 공용 times
- Franc와 Dollar 비교하기

정리해보면,

- 공통된 코드를 첫 번째 클래스에서 상위 클래스(Money)로 단걔쩍으로 옮겼다
- 두 번째 클래스 Franc도 Money의 하위 클래스로 만들었다.
- 불필요한 구현을 제거하기 전에 두 equals() 구현을 일치시켰다.

이번 장에서는 공통 상위 클래스를 만들고 상속의 구조를 만듦으로서 중복된 코드를 제거하였다.