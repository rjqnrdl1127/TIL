# Java의 메모리 구조

생성일: 2022년 7월 16일 오전 6:10
태그: #java

## 자바의 메모리 구조

자바의 응용프로그램이 실행되면, JVM은 시스템으로부터 프로그램을 수행하는데 필요한 메모리를 할당받고 JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리합니다. 그 중 3가지 주요 영역에 대해 알아봅니다.

## 메서드 영역(method area)

> 프로그램 실행 중 어떤 클래스가 사용되면 , JVM은 해당 클래스의 클래스 파일(*.class)을 읽어서 분석하여 클래스에 대한 정보를 이곳에 저장한다. 이 때, 그 클래스의 클래스 변수도 이 영역에 함께 생성된다.
> 

## 힙(heap)

> 인스턴스가 생성되는 공간, 프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성된다. 즉, 인스턴스 변수들이 생성되는 공간이다.
> 

## 호출 스택(call stack 또는 execution stack)

> 호출스택은 메서드의 작업에 필요한 메모리 공간을 제공한다. 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되면, 이 메모리는 메서드가 작업을 수행하는 동안 지역변수와 매개변수들과 연산의 중간 결과 등을 저장하는데 사용된다. 그리고 메서드가 작업을 마치면 할당되었던 메모리 공간은 반환 되어 비어진다.
> 

## 예제

```java
class CallStackTest {
	public static void main(String[] args) {
		firstMethod();
	}
	
	static void firstMethod() {
		secondMethod();
	}
	
	static void secondMethod() {
		System.out.println("secondMethod()");
	}
}
```

- JVM에 의해서 main 메서드가 호출됨으로써 프로그램이 시작된다. 이 때, 호출스택에는 main메서드를 위한 메모리 공간이 할당되고 main메서드의 코드가 수행되기 시작한다.
- main 메서드에서 firstMethod()를 호출하여 main()스택 위에 firstMethod()스택이 쌓이고 firstMethod()의 코드가 실행된다.
- firstMethod()에서 secondMethod()를 호출하여 main()스택 위에 firstMethod()스택 위에 secondMethod()가 쌓이고 secondMethod()의 코드가 실행된다.
- secondMethod()의 println()이 실행되면서 ‘secondMethod()’가 출력되고 secondMethod()는 호출 스택에서 제거된다.
- firstMethod()가 호출 스택에서 제거된다.
- main()가 호출스택에서 제거되고 프로그램이 종료된다.

## 정리

- 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
- 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
- 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.
- 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.

## 참고 자료

- 도서 ‘자바의 정석’