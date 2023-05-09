# 4장. 프라이버시

**[목록]**

- $5 + 10CHF = $10 (환율이 2:1인 경우)
- ~~$5 X 2 = $10~~
- **amount를 private으로 만들기**
- ~~Dollar side effect~~
- Money 반올림
- ~~equals()~~
- hashCode()
- Equal null
- Equal object

3장에서 `equals()` 를 재정의 함으로서 객체의 값에 인자로 받은 곱수만큼 곱한 값을 같는 Dollar를 반환해야 하지만 테스트가 정확히 그것을 말하지 않으므로 테스트를  리펙토링한다.

```java
@Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }
```

위 테스트는 참인 명제에 대한 단언들이므로 의도를 더 명확하게 이야기해준다.

테스트를 고치고 나니 Dollar의 amount 인스턴스 변수를 사용하는 코드는 Dollar 자신 밖에 없으므로 변수를 private으로 변경할 수 있다.

하지만 위 코드에서 동치성 테스트가 동치성에 대한 코드가 정확히 작동한다는 것을 검증하는데 실패한다면, 곱하기 테스트 역시 정확히 작동한다는 것을 검증하는 데 실패하게 된다.

이것이 TDD를 하면서 적극적으로 관리해야 할 위험 요소다.

완벽함을 위해 노력하는 것이 아니라 모든 것을 두 번 말함으로써 자신감을 가지고 전진할 수 있을 만큼만 결함의 정도를 낮추기를 희망할 뿐이다.

정리해보면

- 오직 테스트를 향상시키기 위해서만 개발된 기능을 사용했다.
- 두 테스트가 동시에 실패하면 망한다는 점을 인식했다.
- 위험 요소가 있음에도 계쏙 진행했다.
- 테스트와 코드 사이의 결합도를 낮추기 위해서 테스트하는 객체의 새 기능을 사용했다.