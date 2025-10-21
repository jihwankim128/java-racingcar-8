# 요구사항 정리

* 자동차
  * 이름 부여 가능
    * 쉼표를 기준으로 구분
    * 5자 이하
  * 전진 및 정지 기능
    * 무작위 값이 4 이상 일 경우 전진
    * 그 외 정지
* 사용자
  * 입력
    * 총 이동 횟수
  * 출력
    * 자동차 : 이동횟수
* 경주 게임
  * 우승자 발표
    * 한명 이상일 수 있다.
    * 여러명이라면 쉼표를 이용해 구분
* 사용자가 잘못된 값을 입력할 경우
  * IllegalArgumentException을 발생 후 종료
* 도구
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  * 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.