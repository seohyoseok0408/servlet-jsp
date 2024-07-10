~~# 서블릿
### : 자바 웹 프로그램



# WAS

(Web Application Server)

# Application/Session/Cookie

## application

사용범위 : 전역 범위에서 사용하는 저장 공간  
생명주기 : WAS가 시작해서 종료할 때 까지  
저장위치 : WAS 서버의 메모리

## session

사용범위 : 세션 범위에서 사용하는 저장 공간  
생명주기 : 세션이 시작해서 종료할 때 까지  
저장위치 : WAS 서버의 메모리

## cookie

사용범위 : Web Briwser별 지정한 path 범주 공간  
생명주기 : Browser에 전달한 시간부터 만료시간까지  
저장위치 : Web Browser의 메모리 또는 파일

생명 주기가 긴(1년) 데이터는 쿠키에 보관해야 한다.  
url로 전달되는 데이터는 쿠키에 보관해야 한다.

# 서버에서 페이지 전환해주기(redirection)

`resp.sendRedirect("calc2.html");`

# 동적인 페이지(서버 페이지)의 필요성

html은 정적인 페이지라 3 버튼을 눌러도 페이지에 동적으로 반영이 힘들기 때문에
요청이 들어오면 서버에서 동적인 문서를 만들어서 그것을 사용자에게 보내야 한다.

계산기 같은 격자형 프로그램을 만들 때에는 만들고자 하는 게 몇 행 몇 열인지 파악하고 table, tr, td로 구성

# JSP

add.jsp 파일을 Jasper가 서블릿 코드로 만든다.  
out.write .. 로 다 변환

서블릿 코드를 만듦에 있어서 jasper라는 도움자를 통해 서블릿을 만든다.  
jasper에게 일을 시키기 위해 만든 도구가 jsp.  
근데, jsp를 잘못하게 되면 코드 블럭이 복잡해진다.

코드 블록 : <% %>

- page 지시자 블럭

```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
```

- 선언부

```
<%!
    public int sum(int a, int b)
    {
        return a + b;
    }
%>
```

## JSP 내장 객체

<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/dd88146a-d051-4ece-a56d-cde0f26576c3">

- Jasper가 만든 서블릿에는 내장 객체들이 있다. (request, response...)

### 내장 객체 request : HttpServletRequest

<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/d05eb21c-855e-4d2e-95f3-66ae5b05fe21">

### 내장 객체 response : HttpServletResponse

<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/5cf16091-fbb2-4c3c-82f1-879ccb219a98">

### 내장 객체 session : javax.servlet.http.HttpSession

<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/4d6e570d-4af5-4daa-a4a3-3f5d9c879cd9">

### 내장 객체 application : javax.servlet.ServletContext

<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/ba0050cb-3b5f-418f-9336-e20c50373bbc">

## 장점

- 코드블럭만 책임지면 되고, 나머지 html은 jasper가 알아서 출력해준다.

## 단점

### 스파게티 코드를 만드는 JSP

순서만 맞다면, 코드블럭을 나눠서 만들 수도 있고 한곳에 합쳐서 만들 수도 있다.  
나눠서 만든다면, 어떤 블록이 어디서 오류가 났는지 등을 찾기가 어려워진다.  
스파게티 코드 : 내가 관심 있는 코드와 관심 없는 코드가 섞여있는 코드. (실타래 코드)  
-> 그래서 코드를 한 곳에 모아 놓는 게 더 바람직하다.

어떻게 효율적으로 만들 수 있을까? -> MVC Model1 방식

## MVC Model1

<p align="center"><img width="700" alt="효율적인 JSP" src="https://github.com/seohyoseok0408/study/assets/73714589/1c522ab8-222c-48d3-a294-ff98f8cd4e09">

- 오른쪽과 같이 한곳에만 코드블럭을 놓는다.
- 결과물, 산출물인 변수 model에다가 담아서 출력한다.
- <%=model%>도 코드 블럭이 들어가긴 하지만, 복잡한 로직이 없음. 단순히 출력
<br>
<br>
<p align="center"><img width="700" alt="MVC Model1" src="https://github.com/seohyoseok0408/study/assets/73714589/44f5abdb-2826-45f3-bfb6-bd1383c86fc3">

- Controller
  - 출력할 데이터를 만들어내는 과정을 갖고 있는 입력과 제어를 담당
- View
  - 출력 부분
- Model
  - 출력 데이터

장점

- 유지보수가 쉬워짐
- 출력을 관리하는 사람 또한 자바코드의 제어가 없어서 편하게 구성 가능

### Model1 방식을 만들 때 가장 중요한 것

- `자바 코드와 출력 코드를 최대한 분리`

## MVC Mopdel2

컨트롤로와 뷰가 `물리적으로 분리된` 방식

<p align="center"><img width="700" alt="MVC Model2" src="https://github.com/seohyoseok0408/study/assets/73714589/5bb71ba6-2873-445b-a56e-bbe6ff368d76">

- 장점
  - 실행속도 개선
    - Control은 자바코드밖에 없기 때문에 미리 컴파일 해놓을 수가 있기 때문이다.
  - 복잡도는 높아지지만, 개별적으로 유지관리 용이


View는 JSP. JSP라는 결과물은 서블릿이기 때문에 결국 서블릿이 두개가 되는 셈이다. 그래서 Model을 지역변수의 형태로서 사용할 수 없게 된다. 
서블릿과 서블릿을 이어줄 수 있는 방법이 필요.  
가장 적합한 것은 request. 원래는 입력도구이나 저장소로도 사용이 가능. 


서블릿에서 서블릿으로 흐름을 이어받아서 코드를 진행할 때 사용되는게 포워딩이다. 컨트롤러는 Dispatch를 통해서 포워딩을 하게 된다.  

서블릿에서 서블릿으로 전이하는 방법은 2가지
- redirect
  - 서블릿 호출 시 아예 다른 페이지로 가버리는 방법
  - ex) 로그인 페이지로 보내기, 목록 페이지로 보내기
- forward
  - request.getRequestDispatcher("/경로.jsp").forward(request, response);
    - 현재 사용하고 있는 저장소 객체와, 출력 객체를 공유

<p align="center"><img width="700" alt="MVC Model2" src="https://github.com/seohyoseok0408/study/assets/73714589/e675977a-7434-4e59-8f8d-10c35e83d85b">

원래는 Controller가 많아져서 서블릿이 많아지지만,  
Dispatcher를 하나만 둬서, 실질적으로 서블릿을 하나만 만든다. 일반적인 업무 로직 같은 경우는 별도의 POJO 클래스로, 서블릿 클래스가 아닌, 일반 클래스 형태이다.  
사용자의 요청이 들어오면 Dispatcher가 사용자의 요청을 수반해서 적절한 컨트롤러를 찾아서 수행하게 하는 방식으로 진행된다.

## EL(Expression Language)

- 저장 객체에서 값을 추출해서 출력하는 표현식
<p align="center"><img width="700" alt="EL" src="https://github.com/seohyoseok0408/study/assets/73714589/2f71ed7e-6f58-4e33-810a-b00e43847a7c"> 
<p align="center"><img width="700" alt="EL" src="https://github.com/seohyoseok0408/study/assets/73714589/ee64d90c-0308-4b17-a9d8-9faccf5fb89c">

## EL의 데이터 저장소

- 서버 상에 존재하는 저장소 4가지
  - page, request, session, application

### 저장 객체에서 값을 추출하는 순서

4개 저장소에 같은 키워드를 갖고 있는 값을 심었을 경우에 ${cnt} 는 4개 저장소에 있는 것을 다 뒤져서 꺼냄.  
충돌이 안난다. -> 우선순위가 있다는 뜻.  
순서는 page -> request -> session -> application

<p align="center"><img width="700" alt="EL" src="https://github.com/seohyoseok0408/study/assets/73714589/8644b680-ac05-4547-80d2-2d4274c78f39">

만약, 특정지어서 한곳의 저장소에서 값을 꺼내고자 한다면 Scope를 쓰면 된다. `${sessionScope.cnt}`

## EL 연산자

- `[] .`
- `()`
- `not ! empty  `
- `* / div % mod `
- `+ -`
- `< > <= >=  lt gt le ge`
- `&& and`
- `|| or`
- `? :`  
  empty는 null이거나 빈문자열일 경우 true. 반대로 not empty 가능. 삼항연산자랑 엮으면 좋다.


## View 페이지 은닉하기  
원래 Contoller 실행 후 Model을 만든 뒤에 View 가 실행되야 하지만,  
list.jsp인 View를 사용자가 직접 요청해서 볼 수 있기 때문에 막아야 한다.  

WEB-INF : 사용자가 직접 요청할 수 없는 곳  
WEB-INF 폴더 안에 View 페이지에 대한 내용들을 옮겨 넣는다.  
물론, Controller의 disparcher경로도 수정해줘야 한다.  
`request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);`

## JSTL (JSP Standard Tag Library)
- JSTP은 5개의 범주의 태그 라이브러리 제공
- `Core, Formating, Functions, SQL, XML`
- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p align="center"><img width="700" alt="JSTL Core" src="https://github.com/seohyoseok0408/study/assets/73714589/e8a92dd0-110e-4a02-b005-6b5ef6d54458">

# 중간정리
<p align="center"><img width="700" alt="summary" src="https://github.com/seohyoseok0408/study/assets/73714589/46cb4120-cb33-4139-9b8b-cb8e5e72b239">

# 기업형으로 레이어를 나누는 이유와 설명  
<p align="center"><img width="700" alt="JSTL Core" src="https://github.com/seohyoseok0408/study/assets/73714589/a9e2ef98-43d7-46a8-bb0e-92c9d17ec67c">


서블릿가지고도 충분히 만들 수 있지만, 
jsp로 분리해서 Controller가 Model을 만들고 Model을 View에 소개하는 방식을 사용했다.
위 방식은 문서를 출력하는 것에 대한 부담이 페이지 기반으로 만듦으로써 적다. 
Servlet이 하는 일은 사용자의 응답을 처리하고 출력에 대한 내용을 jsp에게 위임하는 Contoller.   
중간에 업무를 처리하는 부분도 지금까지 Servlet이 담당했지만, 이제 경험이 많은 사람이 업무 서비스를 맡고 
사용자의 입출력 담당을 하는 사람이 Servlet을 맡는 방식. (분업이 잘됨)  
Servlet : 입출력 담당 부분  
업무 서비스 : 사용자가 요청하는 단위.(Ex.계좌이체)  
데이터 서비스 : 실제로 데이터를 조작해주는 부분  
필요에 따라 분리를 안해도 된다. 





