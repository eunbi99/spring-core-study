## 👩‍💻 <김영한 - 스프링 핵심 원리 기본편>을 보고 실습+정리한 내용입니다.

#### 📌의존관계 주입 DI(Dependency Injection)

애플리케이션 실행시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는것을 `"의존관계 주입"`이라 한다.

의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고 ,클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.
<hr>

#### 📌IoC컨테이너 , DI 컨테이너
- AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는것을 IoC 컨테이너 또는 DI 컨테이너라고한다.

### ✍스프링 컨테이너
 `ApplicationContext` 를 `스프링 컨테이너`라고 한다.
기존에는 `AppConfig`를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제는 스프링 컨테이너를 통해 사용한다.

스프링 컨테이너는 `@Configuration` 이 붙은 `AppConfig`를 설정(구성) 정보로 사용. 
여기서 `@Bean`이라 적힌 메소드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
이렇게 스프링 컨테이너에 등록된 객체를 `스프링 빈`이라고 한다.

스프링 빈은 `@Bean`이 붙은 메서드 명을 스프링 빈의 이름으로 사용
기존에는 개발자가 직접 자바코드로 모든 것을 했다면
이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경

#### 스프링 컨테이너 생성
```
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
```
- ApplicationContext를 스프링 컨테이너라고 한다.(인터페이스)
- XML기반, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.

##### 빈 이름
- 빈 이름은 메서드 이름을 사용해야한다.
- 빈 이름을 직접 부여할 수 있다 @Bean(name="memberService2")

> 🔔 주의! 빈 이름은 항상 다른 이름을 부여해야한다! 
##### 같은 이름을 부여하면 다른 빈이 무시되거나, 기존 빈을 덮어버리거나 설정에 따라 오류 발생
