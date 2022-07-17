# JVM (Java Virtual Machine)

생성일: 2022년 7월 15일 오후 3:23
태그: #java

## 1. 자바 가상 머신 (Java Virtual Machine)

자바 가상 머신은 자바 바이트코드를 실행할 수 있는 주체입니다. 자바 바이트코드는 플랫폼에 독립적이며 모든 자바 가상 머신은 자바 가상 머신 규격에 정의된 대로 자바 바이트코드 실행한다. 따라서 표준 자바 API까지 동일한 동작을 하도록 구현한 상태에서는 이론적으로 모든 자바 프로그램은 CPU나 운영 체제의 종류와 무관하게 동일하게 동작할 것을 보장한다.

![400px-JvmSpec7.png](../images/JVM%20(Java%20Virtual%20Machine)%202071bcd9b6cb427288226c6960fe094e/400px-JvmSpec7.png)

## 2. JVM의 특성

- 스택 기반의 가상 머신
    
    스몰토크 VM에 영향을 받아 스택 기반이어서 대다수의 명령어가 스택 선두에서 피연산자를 택하고 결과는 다시 스택에 넣는다.
    
- 가비지 컬렉션 사용
    
    가비지 컬렉션은 메모리 관리 기법 중의 하나로, 프로그램이 동적으로 할당했던 메모리 영역 중에서 필요 없게 된 영역을 해제하는 기능이다.
    
- 자바 바이트코드 검증기
    
    프로그램 실행 전에 스택 넘침, 명령어 규칙 위반 같은 오류들이 있는지 검증하여 실행 시 안정성을 보장하고 부담을 줄여준다.
    

## 3. JVM 메모리 구조

1. Class Loader
    
    JVM 내로 클래스 파일을 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈입니다. 런타임 시에 동적으로 클래스를 로드합니다.
    
2. Execution Engine
    
    클래스 로더를 통해 JVM 내의 Runtime Data Area에 배치된 바이트 코드들을 명령어 단위로 읽어서 실행합니다. 최초 JVM이 나왔을 당시에는 인터프리터 방식이었기 때문에 속도가 느리다는 단점이 있었지만 컴파일러 방식을 통해 이 점을 보완하였습니다. 모든 코드를 인터프리터 방식을 사용하다가 일정 기준이 넘어가면 컴파일러 방식으로 실행합니다.
    
3. Garbage Collector
    
    Garbage Collector는 힙 메모리 영역에 생성된 객체들 중에서 참조되지 않은 객체들을 탐색 후 제거하는 역할을 합니다.
    
4. Runtime Data Area
    
    JVM의 메모리 영역으로 자바 어플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역입니다. 이 영역은 크게 Method Area, Heap Area, Stack Area, PC Register, Native Method Stack로 나눌 수 있습니다.
    
    ![img1.daumcdn.png](../images/JVM%20(Java%20Virtual%20Machine)%202071bcd9b6cb427288226c6960fe094e/img1.daumcdn.png)
    
    - Metoed area
        
        모든 쓰레드가 공유하는 메모리 영역입니다. 메소드 영역은 클래스, 인터페이스, 메소드, 필드, Static 변수 등의 바이트 코드를 보관합니다.
        
    - Heap area
        
        모든 쓰레드가 공유하며, new 키워드로 생성된 객체와 배열이 생성되는 영역입니다. 또한, 메소드 영역에 로드된 클래스만 생성이 가능하고 Garbage Collector가 메모리를 해제하는 영역입니다.
        
    - Stack area
        
        메서드 호출 시마다 각각의 스택 프레임이 생성합니다. 메서드 안에서 사용되는 값들을 저장하고, 호출된 메서드의 매개변수, 지역변수, 리턴 값 및 연산 시 일어나는 값들을 임시로 저장합니다. 마지막으로, 메서드 수행이 끝나면 프레임별로 삭제합니다.
        
    - PC Register
        
        쓰레드가 시작될 때 생성되며, 생성될 때마다 생성되는 공간으로 쓰레드마다 하나씩 존재합니다. 쓰레드가 어던 부분을 무슨 명령으로 실해해야할 지에 대한 기록을 하는 부분으로 현재 수행중인 JVM 명령의 주소를 갖습니다.
        
    - Native method stack
        
        자바 외 언어로 작성된 네이티브 코드를 위한 메모리 영역입니다.
        
    
    ### 참고 사이트
    
    [https://jeong-pro.tistory.com/148](https://jeong-pro.tistory.com/148)
    
    [https://limkydev.tistory.com/51](https://limkydev.tistory.com/51)
    
    [https://asfirstalways.tistory.com/158](https://asfirstalways.tistory.com/158)