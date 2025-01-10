# calculator_project
calculator project 


### intro:  계산기 과제

<hr/>

### Level 1: 클래스 없이 기본 연산 수행
파일: calculator/Calculator.java
클래스를 사용하지 않고, 기본적인 사칙연산(+, -, *, /)을 수행할 수 있는 간단한 계산기를 구현

<hr/>

### Level2: 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
calculator2/<br/>
  |- Main.java<br/>
  |- Calculator.java<br/>

- 클래스 구조를 도입:
  - Main.java: 사용자와 상호작용하며, Calculator를 호출
  - Calculator.java: 연산 로직을 처리하고 계산 결과를 반환

<hr/>

### Level3: (도전기능)Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
calculator3/<br/>
  |- Operator.enum<br/>
  |- Main.java<br/>
  |- Calculator.java<br/>
  |- ArithmeticCalculator.java<br/>

- 사칙 연산자를 Enum으로 정의.
- Main을 프로그램의 진입점으로 하여, 사용자 입력을 처리하고 Calculator를 호출하도록 함
- Calculator는 입력된 수식을 파싱하여 ArithmeticCalculator를 호출, 계산 기록을 저장 및 관리함
- ArithmeticCalculator는 실제 계산을 수행하고, 결과를 반환함

#### 추가 구현  정수 연산 결과 출력

핸드폰 계산기처럼, 정수끼리의 연산 결과가 정수일 경우 이를 정수로 출력하도록 구현했습니다.
내부적으로는 모든 연산을 double로 처리한 후, 결과를 isInteger() 메서드를 통해 정수 여부를 확인하고 정수로 변환하여 출력합니다.


![image](https://github.com/user-attachments/assets/cee39702-8288-4cb1-a495-2feffb3ebdf8)

결과이미지

![image](https://github.com/user-attachments/assets/cbf99fda-ffea-43fd-bf43-39b0eddf66ea)
