# Work App

## Team Apis
### 1. Team 등록
- Method : Post
- Path  : /api/v1/team
- Request
  ```
  {
    "teamName" : "{String}"
  }
  ```


### 2. Team 조회
- Method : Get
- Path : /api/v1/team
- Response
  ```
    [
      {
        "name": "{String}",
        "manager": "{String}",
        "memberCount": {long}
      },
      {
        "name": "{String}",
        "manager": "{String}",
        "memberCount": {long}
      }
    ]
  ```

--------
## Member Apis
### 1. Member 등록
- Method : Post
- Path  : /api/v1/team
- Request
  ```
  {
    "name" : "{String}",
    "teamId" : {long},
    "isManager" : {boolean},
    "workStartAt" : "{localDate}",
    "birthday" : "{localDate}"
  }
  ```


### 2. Member 조회
- Method : Get
- Path : /api/v1/team
- Response
  ```
  [
    {
        "memberId": {lomg},
        "name": "{String}",
        "teamName": "{String}",
        "role": "{String}",
        "birthday": "{localDate}",
        "workStartDate": "{localDate}"
    }
  ]
  ```

--------
## Work Apis
### 1. 출근
- Method : Post
- Path  : /api/v1/work
- Request
  ```
  {
    "memberId" : {long}, 
    "workDate" : "{localDate}",
    "startAt" : "{localTime}"
  }
  ```


### 2. 퇴근
- Method : Put
- Path : /api/v1/work
- Request
  ```
  {
    "memberId" : {long}, 
    "workDate" : "{localDate}",
    "endAt" : "{localTime}"
  }
  ```