# VYBZ Live Chat Service

VYBZ 플랫폼의 실시간 라이브 채팅을 담당하는 마이크로서비스입니다.

## 📋 목차

-   [개요](#개요)
-   [기술 스택](#기술-스택)
-   [주요 기능](#주요-기능)
-   [프로젝트 구조](#프로젝트-구조)
-   [API 문서](#api-문서)
-   [설치 및 실행](#설치-및-실행)
-   [환경 설정](#환경-설정)
-   [채팅 시스템](#채팅-시스템)
-   [이벤트 처리](#이벤트-처리)

## 🎯 개요

VYBZ Live Chat Service는 다음과 같은 기능을 제공합니다:

-   **실시간 채팅**: WebSocket을 통한 실시간 양방향 통신
-   **채팅방 관리**: 채팅방 생성, 참여, 퇴장 관리
-   **메시지 처리**: 채팅 메시지 송수신 및 저장
-   **사용자 관리**: 채팅방 내 사용자 상태 관리
-   **이벤트 처리**: Kafka를 통한 채팅 이벤트 발행
-   **데이터 저장**: MySQL과 MongoDB를 통한 메시지 및 사용자 데이터 저장

## 🛠 기술 스택

### Backend

![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-59666C?style=for-the-badge)
![Spring WebSocket](https://img.shields.io/badge/Spring_WebSocket-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

### Infra

![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Amazon EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### 협업

![Discord](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

### Database & Cache

-   **MySQL 8.0**: 채팅방 정보 및 사용자 데이터 저장
-   **MongoDB**: 실시간 채팅 메시지 저장
-   **Redis**: 실시간 세션 관리 및 캐싱

### Message Queue

-   **Apache Kafka**: 비동기 이벤트 처리

### Documentation

-   **Swagger/OpenAPI 3.0**: API 문서화

### Build & Deploy

-   **Gradle**: 빌드 도구
-   **Docker**: 컨테이너화

## 🚀 주요 기능

### 1. 실시간 채팅 (`/ws/chat`)

-   **WebSocket 연결**: 실시간 양방향 통신 지원
-   **채팅방 참여**: 사용자 채팅방 입장 및 퇴장
-   **메시지 송수신**: 실시간 메시지 전송 및 수신
-   **사용자 상태**: 온라인/오프라인 상태 관리
-   **메시지 저장**: MongoDB에 채팅 메시지 저장

### 2. 채팅방 관리

-   **채팅방 생성**: 새로운 채팅방 생성
-   **참여자 관리**: 채팅방 참여자 목록 관리
-   **권한 관리**: 채팅방 관리자 권한 설정
-   **방 설정**: 채팅방 제목, 설명 등 설정

### 3. 메시지 처리

-   **메시지 타입**: 텍스트, 이미지, 이모티콘 등 지원
-   **메시지 검증**: 부적절한 메시지 필터링
-   **메시지 히스토리**: 과거 메시지 조회
-   **메시지 삭제**: 메시지 삭제 기능

### 4. 실시간 알림

-   **새 메시지 알림**: 실시간 새 메시지 알림
-   **사용자 입장/퇴장**: 채팅방 참여자 변경 알림
-   **시스템 메시지**: 시스템 공지사항 전송

## 📁 프로젝트 구조

```
src/main/java/back/vybz/live_chat_service/
├── common/                    # 공통 모듈
│   ├── config/               # 설정 클래스들
│   │   ├── WebSocketConfig.java
│   │   ├── KafkaConfig.java
│   │   ├── RedisConfig.java
│   │   └── SwaggerConfig.java
│   ├── entity/               # 공통 엔티티
│   │   ├── BaseEntity.java
│   │   ├── BaseResponseEntity.java
│   │   └── BaseResponseStatus.java
│   ├── exception/            # 예외 처리
│   │   ├── BaseException.java
│   │   ├── BaseExceptionHandler.java
│   │   └── WebSocketExceptionHandler.java
│   └── util/                 # 유틸리티
│       └── RedisUtil.java
├── kafka/                    # Kafka 이벤트 처리
│   ├── config/               # Kafka 설정
│   │   └── LiveChatKafkaConfig.java
│   ├── event/                # 이벤트 모델
│   │   └── LiveChatEvent.java
│   ├── producer/             # 이벤트 프로듀서
│   │   └── LiveChatKafkaProducer.java
│   └── consumer/             # 이벤트 컨슈머
│       └── LiveChatKafkaConsumer.java
├── chat/                     # 채팅 도메인
│   ├── application/          # 채팅 서비스 로직
│   │   ├── ChatService.java
│   │   └── ChatServiceImpl.java
│   ├── domain/               # 채팅 도메인 모델
│   │   ├── ChatRoom.java
│   │   ├── ChatMessage.java
│   │   ├── ChatUser.java
│   │   └── MessageType.java
│   ├── dto/                  # 채팅 DTO
│   │   ├── request/
│   │   │   ├── CreateChatRoomDto.java
│   │   │   ├── JoinChatRoomDto.java
│   │   │   └── SendMessageDto.java
│   │   └── response/
│   │       ├── ChatRoomDto.java
│   │       ├── ChatMessageDto.java
│   │       └── ChatUserDto.java
│   ├── infrastructure/       # 채팅 리포지토리
│   │   ├── ChatRoomRepository.java
│   │   ├── ChatMessageRepository.java
│   │   └── ChatUserRepository.java
│   ├── presentation/         # 채팅 컨트롤러
│   │   ├── ChatController.java
│   │   └── ChatWebSocketHandler.java
│   └── vo/                   # 채팅 VO
│       ├── request/
│       │   ├── CreateChatRoomVo.java
│       │   ├── JoinChatRoomVo.java
│       │   └── SendMessageVo.java
│       └── response/
│           ├── ChatRoomVo.java
│           ├── ChatMessageVo.java
│           └── ChatUserVo.java
└── user/                     # 사용자 도메인
    ├── application/          # 사용자 서비스 로직
    │   └── UserService.java
    ├── domain/               # 사용자 도메인 모델
    │   └── ChatUser.java
    ├── dto/                  # 사용자 DTO
    │   └── response/
    │       └── ChatUserDto.java
    └── infrastructure/       # 사용자 리포지토리
        └── ChatUserRepository.java
```

## 📚 API 문서

Swagger UI를 통해 API 문서를 확인할 수 있습니다:

-   **URL**: `http://localhost:8888/live-chat-service/swagger-ui/index.html`
-   **API 그룹**: LIVE-CHAT-SERVICE

### 주요 API 엔드포인트

#### 채팅 API

-   `GET /api/v1/chat/rooms` - 채팅방 목록 조회
-   `POST /api/v1/chat/rooms` - 채팅방 생성
-   `GET /api/v1/chat/rooms/{roomId}` - 채팅방 상세 정보
-   `POST /api/v1/chat/rooms/{roomId}/join` - 채팅방 참여
-   `DELETE /api/v1/chat/rooms/{roomId}/leave` - 채팅방 퇴장
-   `GET /api/v1/chat/rooms/{roomId}/messages` - 채팅 메시지 조회

#### WebSocket 엔드포인트

-   `WS /ws/chat/{roomId}` - 채팅방 WebSocket 연결

### API 요청/응답 예시

#### 채팅방 생성 요청

```json
{
    "title": "라이브 채팅방",
    "description": "실시간 채팅을 위한 방입니다.",
    "maxParticipants": 100,
    "isPrivate": false
}
```

#### 채팅방 생성 응답

```json
{
    "status": "SUCCESS",
    "message": "채팅방이 성공적으로 생성되었습니다.",
    "data": {
        "roomId": "550e8400-e29b-41d4-a716-446655440000",
        "title": "라이브 채팅방",
        "description": "실시간 채팅을 위한 방입니다.",
        "maxParticipants": 100,
        "currentParticipants": 1,
        "isPrivate": false,
        "createdAt": "2024-01-01T12:00:00Z"
    }
}
```

#### WebSocket 메시지 형식

```json
{
    "type": "CHAT_MESSAGE",
    "roomId": "550e8400-e29b-41d4-a716-446655440000",
    "userId": "user123",
    "message": "안녕하세요!",
    "timestamp": "2024-01-01T12:00:00Z"
}
```

## 🚀 설치 및 실행

### 1. 사전 요구사항

-   Java 17
-   Gradle 8.4+
-   Docker (선택사항)
-   MySQL 8.0
-   MongoDB
-   Redis
-   Kafka

### 2. 로컬 실행

```bash
# 프로젝트 클론
git clone <repository-url>
cd live-chat-service

# Gradle 빌드
./gradlew clean build

# 애플리케이션 실행
./gradlew bootRun
```

### 3. Docker 실행

```bash
# Docker 이미지 빌드
docker build -t vybz-live-chat .

# Docker 컨테이너 실행
docker run -p 8888:8888 vybz-live-chat
```

## ⚙️ 환경 설정

### 주요 설정 파일

-   `application.yml`: 기본 설정
-   `application-dev.yml`: 개발 환경 설정
-   `application-prod.yml`: 운영 환경 설정

### 환경 변수

```yaml
# 데이터베이스 설정
spring:
  datasource:
    url: jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

# MongoDB 설정
spring:
  data:
    mongodb:
      uri: mongodb://${MONGO_USERNAME}:${MONGO_PASSWORD}@${MONGO_HOST}:${MONGO_PORT}/${MONGO_DATABASE}

# Redis 설정
spring:
  data:
    redis:
      host: ${REDIS_HOST}
      port: ${REDIS_PORT}
      password: ${REDIS_PASSWORD}

# Kafka 설정
spring:
  kafka:
    bootstrap-servers: ${KAFKA_SERVERS}
```

## 💬 채팅 시스템

### WebSocket 연결

#### 연결 설정

```javascript
const socket = new WebSocket("ws://localhost:8888/ws/chat/room-id");

socket.onopen = function (event) {
    console.log("WebSocket 연결됨");
};

socket.onmessage = function (event) {
    const message = JSON.parse(event.data);
    console.log("메시지 수신:", message);
};

socket.onclose = function (event) {
    console.log("WebSocket 연결 종료");
};
```

#### 메시지 타입

-   **CHAT_MESSAGE**: 일반 채팅 메시지
-   **JOIN_ROOM**: 채팅방 입장
-   **LEAVE_ROOM**: 채팅방 퇴장
-   **SYSTEM_MESSAGE**: 시스템 메시지
-   **USER_STATUS**: 사용자 상태 변경

### 채팅방 관리

#### 채팅방 상태

-   **ACTIVE**: 활성 상태
-   **INACTIVE**: 비활성 상태
-   **DELETED**: 삭제된 상태

#### 참여자 권한

-   **OWNER**: 방장 (채팅방 생성자)
-   **ADMIN**: 관리자
-   **MEMBER**: 일반 멤버
-   **GUEST**: 게스트

### 메시지 처리

#### 메시지 저장

-   **MySQL**: 채팅방 정보, 사용자 정보
-   **MongoDB**: 실시간 채팅 메시지
-   **Redis**: 실시간 세션 및 캐시

#### 메시지 검증

-   **길이 제한**: 메시지 길이 제한
-   **금지어 필터링**: 부적절한 단어 필터링
-   **스팸 방지**: 과도한 메시지 전송 방지

## 📡 이벤트 처리

### Kafka 이벤트

#### 발행 이벤트

-   **LiveChatEvent**: 라이브 채팅 이벤트
    -   `roomId`: 채팅방 ID
    -   `userId`: 사용자 ID
    -   `message`: 채팅 메시지
    -   `eventType`: 이벤트 타입

#### 구독 이벤트

-   **UserAuthEvent**: 사용자 인증 이벤트
-   **RoomCreateEvent**: 채팅방 생성 이벤트

### 이벤트 프로듀서

-   `LiveChatKafkaProducer`: 채팅 이벤트 발행

### 이벤트 컨슈머

-   `LiveChatKafkaConsumer`: 외부 서비스 이벤트 구독

### Kafka 토픽

-   `live-chat-events`: 라이브 채팅 이벤트 토픽
-   `user-auth-events`: 사용자 인증 이벤트 토픽
-   `room-events`: 채팅방 이벤트 토픽

### 이벤트 발행 시점

-   **메시지 전송**: 사용자가 메시지 전송 시
-   **방 입장/퇴장**: 사용자가 방에 입장하거나 퇴장 시
-   **방 생성/삭제**: 채팅방 생성 또는 삭제 시

## 🏗 아키텍처

### 도메인 주도 설계 (DDD)

-   **Domain Layer**: 채팅 도메인 모델과 비즈니스 로직
-   **Application Layer**: 채팅 서비스 로직과 유스케이스
-   **Infrastructure Layer**: 데이터베이스 접근과 외부 시스템 연동
-   **Presentation Layer**: REST API 및 WebSocket 엔드포인트

### 마이크로서비스 패턴

-   **Service Discovery**: Eureka Client를 통한 서비스 등록
-   **Event-Driven**: Kafka를 통한 비동기 이벤트 처리
-   **Stateless**: 상태 없는 서비스 설계

### 데이터베이스 설계

-   **MySQL**: 채팅방 정보, 사용자 정보, 시스템 데이터
-   **MongoDB**: 실시간 채팅 메시지 저장
-   **Redis**: 실시간 세션 관리 및 캐싱

### WebSocket 아키텍처

-   **STOMP**: WebSocket 메시징 프로토콜
-   **세션 관리**: Redis를 통한 세션 저장
-   **메시지 라우팅**: 채팅방별 메시지 라우팅
-   **연결 관리**: 연결 상태 모니터링

## 🔧 개발 가이드

### 코드 컨벤션

-   **패키지 구조**: 도메인별 계층 분리
-   **네이밍**: 명확하고 일관된 네이밍 규칙
-   **예외 처리**: BaseException을 통한 통일된 예외 처리
-   **로깅**: Slf4j를 통한 구조화된 로깅

### 테스트

```bash
# 단위 테스트 실행
./gradlew test

# 통합 테스트 실행
./gradlew integrationTest

# WebSocket 테스트
./gradlew test --tests "*WebSocketTest*"
```

### WebSocket 테스트

```javascript
// WebSocket 연결 테스트
const WebSocket = require("ws");
const ws = new WebSocket("ws://localhost:8888/ws/chat/test-room");

ws.on("open", function open() {
    console.log("연결됨");

    // 메시지 전송
    ws.send(
        JSON.stringify({
            type: "CHAT_MESSAGE",
            roomId: "test-room",
            userId: "test-user",
            message: "테스트 메시지",
        })
    );
});

ws.on("message", function message(data) {
    console.log("수신:", JSON.parse(data));
});
```

### 성능 최적화

#### 데이터베이스 최적화

-   **인덱싱**: 자주 조회되는 필드에 인덱스 설정
-   **배치 처리**: 대량 데이터 처리 시 배치 사용
-   **캐싱**: Redis를 통한 자주 조회되는 데이터 캐싱

#### WebSocket 최적화

-   **연결 풀링**: 연결 수 제한 및 관리
-   **메시지 압축**: 대용량 메시지 압축 전송
-   **하트비트**: 연결 상태 모니터링

#### Kafka 최적화

-   **배치 전송**: 메시지 배치 처리
-   **파티션 관리**: 토픽 파티션 최적화
-   **컨슈머 그룹**: 컨슈머 그룹 설정

## 📊 모니터링

### 로깅

-   **애플리케이션 로그**: Spring Boot 로깅
-   **WebSocket 로그**: 연결 및 메시지 로깅
-   **데이터베이스 로그**: 쿼리 성능 로깅

### 메트릭

-   **연결 수**: 활성 WebSocket 연결 수
-   **메시지 처리량**: 초당 처리 메시지 수
-   **응답 시간**: API 응답 시간
-   **에러율**: 에러 발생률

### 알림

-   **연결 실패**: WebSocket 연결 실패 알림
-   **데이터베이스 오류**: DB 연결 오류 알림
-   **Kafka 오류**: 메시지 전송 실패 알림

## 🚨 트러블슈팅

### 일반적인 문제

#### WebSocket 연결 실패

```bash
# 포트 확인
netstat -an | grep 8888

# 방화벽 설정 확인
sudo ufw status
```

#### 데이터베이스 연결 오류

```bash
# MySQL 연결 확인
mysql -h <탄력적 IP> -P 33306 -u vybz -p

# MongoDB 연결 확인
mongo mongodb://<탄력적 IP>:27020/vybz
```

#### Kafka 연결 오류

```bash
# Kafka 브로커 상태 확인
kafka-topics.sh --bootstrap-server <탄력적 IP>:10000 --list
```

### 로그 확인

```bash
# 애플리케이션 로그 확인
tail -f logs/application.log

# 에러 로그 확인
grep "ERROR" logs/application.log
```

## 📝 라이선스

이 프로젝트는 VYBZ 팀의 내부 프로젝트입니다.

## 👥 팀

-   **개발팀**: VYBZ Backend Team

---

**VYBZ Live Chat Service** - 실시간 라이브 채팅 서비스
