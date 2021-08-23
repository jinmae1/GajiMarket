# GajiMarket

당근마켓과 중고나라에서 컨셉을 따와서 만든 가지마켓입니다.
최초 회원 생성 시와 게시글 작성 시에 오류가 날 수 있으니 참고해주세요
ANSI escape코드를 사용하기 때문에 이클립스에서 실행하기보다는
Windows Terminal과 같은 외부 터미널 환경에서 실행해주세요
프로젝트 최상위 경로에서

```$ javac -d bin src/com/games/*.java

$ javac -d bin -cp src src/com/gaji/mini/*/*.java
```
로 컴파일 하신 후
```
$ java -cp bin com.gaji.mini.run.GajiRun
```
로 실행 해주시면 됩니다. 아니면 그냥 이클립스에서 빌드하고 실행만
```
$ java -cp bin com.gaji.mini.run.GajiRun
```