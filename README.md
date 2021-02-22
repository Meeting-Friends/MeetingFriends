

# Welcome to Meeting Friends!:smiley:

> 안녕하세요:kissing_smiling_eyes: 저희는 **Meeting Friends** 를 만든 팀입니다. :raised_hands:

## :speech_balloon: Introduction

- 웹 기반 온라인 다자간 화상 회의 서비스 구현
- 언택트 시대에 맞는 선진적인 웹 서비스 구현
- 테마별로 섹션을 나눠 사람들을 랜덤 매칭하는 서비스 구현

## :eyes: 추진 배경 및 필요성


 코로나로 인해 우리 모두의 삶에 활력이 사라진 현 시점, 저희 팀은 비대면으로 다양한 사람들을 만날 수 있는 서비스가 나왔으면 좋겠다는 생각을 했습니다.

> ***before***:point_left:
>  - 프로젝트 첫 주제 선정은 비대면 술친구 시스템이었습니다.
>   - 혼술족을 위한, 비슷한 주류를 선호하는 사람들끼리 비대면 영상을 통한 술자리를 마련할 예정이었습니다. 
>   - 기존 화상회의와 차별성을 두기 위해 기본적인 화상회의 구현 이외의 기능 필요성을 검토하였습니다.



> ***after***:point_right:
>  - 각계각층 고객들의 니즈를 맞추기 위해 저희는 한정적으로 서비스를 제공할 수 밖에 없는 '술' 이라는 주제에서 벗어나 테마별로 방의 용도를 구별해 서비스를 구현하게 되었습니다.

## :thought_balloon:서비스 내용

## 프로그램 구조[PROGAMMING STRUCTURE]
### 전체 구조
![Web Programming Structure](https://user-images.githubusercontent.com/74332188/108668646-db153180-751e-11eb-94cf-85ecfcc92dd2.png)
### VUE 구조
![VUE STRUCTURE](https://user-images.githubusercontent.com/74332188/108669011-8cb46280-751f-11eb-82f0-4c14581494cf.png)
### 메인 페이지[MAIN PAGE]
```
- SIGN IN 기능
- SIGN UP 기능
```

### 대기실 페이지[WAITINGROOM PAGE]
```
- 내 정보 보기 기능
- 채팅룸 만들기 기능
- 채팅룸 입장 기능
```

### 화상 미팅 페이지[VIDEO MEET PAGE]
```
- 방 수정 기능(ONLY 방장)
- 비디오 ON/OFF 기능
- 오디오 ON/OFF 기능
- 타이머 기능
- 채팅 기능
- 화면공유 기능
- 방 나가기 기능
- 강제퇴장 기능
- 테마별[수다방, 먹방, 운동방, 게임방, 클럽하우스방, 기타]
```

### 관리자 페이지[ADMIN PAGE]
```
- 방 정보 보기 기능
- 회원 정보 보기 기능
- 필터 기능
```

### 관리자 페이지에 관리자만 접근 허용
```
랜더링되기 전 시점에 로그인 된 쿠키 기록을 통해 관리자일 때만 
관리자 페이지에 입장가능,
관리자 아닐 시, 로그인 화면으로 이동
```
```java script
beforeCreate() {
	if (getUserFromCookie() !== 'admin@naver.com') {
		alert('관리자만 접근가능합니다.');
		this.$router.push('/signin');
	}
}
```


### CORS 
```
tomcat server와 node js server 간의 소통시 CORS필요
```
```java
spring boot controller의 메소드 상단에 어노테이션 처리 

@CrossOrigin(origins = "*", allowedHeaders = "*")
```
```java script
node js의 express에 CORS 미들웨어 적용

const  app = express();
const  cors = require('cors');
app.use(cors());
```


## :wrench:개발 도구

- frontend : html, css, vue.js, eslint-pretier
- backend : spring boot, node js
- database : oracle
- server : tomcat, express, socket io

## :hourglass_flowing_sand:기대 효과

- 온라인에서 다양한 사람들을 만날 수 있는 환경제공
- 언택트 시대에 맞는 테마별 방을 나눠 고객의 니즈 충족

##  :rainbow:향후 계획

- AWS(Amazon Web Service) EC2 / S3 / RGB 기능 추가
- 모바일 어플리케이션 확장

##  :pencil2:AUTHOR
- :man:김준형[(CUBEGRAY)](https://github.com/CubeGray)
- :girl:최지수 [(JISOO CHOI)](https://github.com/choijisoo-94)
- :boy:양호준[(hoyang21)](https://github.com/hoyang21)
- :man_with_gua_pi_mao:차왕현[(chawanghyeon)](https://github.com/chawanghyeon)
- :girl:최지원[(jiwonnn11)](https://github.com/jiwonnn11)
- :man:김혜성[(baptize33)](https://github.com/baptize33)


## :file_folder:참고
- [(GOOGLE DRIVE)](https://drive.google.com/drive/folders/1c_-EskHJlcoH3ueRKNMtfeVfFhK0FC7k
)
- [(OVEN APP)](https://ovenapp.io/view/lMqTcTCLn0at8gHMKhSCuvzel5oeaAYG
)
