
# api


<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [app](#app)
    1. [login](#1-login)
        * [succeed](#i-example-request-succeed)
* [admin](#admin)
    1. [addStudentUser](#1-addstudentuser)
        * [addStudentUser](#i-example-request-addstudentuser)
    1. [addTeacherUser](#2-addteacheruser)
        * [addTeacherUser](#i-example-request-addteacheruser)
    1. [assignProject](#3-assignproject)
        * [assignProject](#i-example-request-assignproject)
    1. [bindMentorWithStudent](#4-bindmentorwithstudent)
        * [bindMentorWithStudent](#i-example-request-bindmentorwithstudent)
    1. [editAcademicExchange](#5-editacademicexchange)
        * [editAcademicExchange](#i-example-request-editacademicexchange)
    1. [editCourseList](#6-editcourselist)
        * [editCourseList](#i-example-request-editcourselist)
    1. [editProjectFounding](#7-editprojectfounding)
        * [editProjectFounding](#i-example-request-editprojectfounding)
    1. [editVolunteerNumber](#8-editvolunteernumber)
        * [editVolunteerNumber](#i-example-request-editvolunteernumber)
    1. [getAcademicExchange](#9-getacademicexchange)
        * [getAcademicExchange](#i-example-request-getacademicexchange)
    1. [getMentorList](#10-getmentorlist)
        * [getMentorList](#i-example-request-getmentorlist)
    1. [getProjectFounding](#11-getprojectfounding)
        * [getProjectFounding](#i-example-request-getprojectfounding)
    1. [getStudentList](#12-getstudentlist)
        * [getStudentList](#i-example-request-getstudentlist)
    1. [getSystemAcademicExchangeList](#13-getsystemacademicexchangelist)
        * [getSystemAcademicExchangeList](#i-example-request-getsystemacademicexchangelist)
    1. [getSystemCourseList](#14-getsystemcourselist)
        * [getSystemCourseList](#i-example-request-getsystemcourselist)
    1. [getSystemProjectList](#15-getsystemprojectlist)
        * [getSystemProjectList](#i-example-request-getsystemprojectlist)
    1. [getSystemSubjectList](#16-getsystemsubjectlist)
        * [getSystemSubjectList](#i-example-request-getsystemsubjectlist)
    1. [getSystemUserList](#17-getsystemuserlist)
        * [getSystemUserList](#i-example-request-getsystemuserlist)
    1. [getVolunteerNumber](#18-getvolunteernumber)
        * [getVolunteerNumber](#i-example-request-getvolunteernumber)
    1. [reviewInfo(Not implemented)](#19-reviewinfonot-implemented)
        * [reviewInfo](#i-example-request-reviewinfo)
* [teacher](#teacher)
    1. [assignProject](#1-assignproject)
        * [assignProject](#i-example-request-assignproject-1)
    1. [getAcademicExchangeList](#2-getacademicexchangelist)
        * [getAcademicExchangeList](#i-example-request-getacademicexchangelist)
    1. [getAchievementList](#3-getachievementlist)
        * [getAchievementList](#i-example-request-getachievementlist)
    1. [getCourseList](#4-getcourselist)
        * [getCourseList](#i-example-request-getcourselist)
    1. [getProjectList](#5-getprojectlist)
        * [getProjectList](#i-example-request-getprojectlist)
    1. [getRateList](#6-getratelist)
        * [getRateList](#i-example-request-getratelist)
    1. [getStudentListByMentorID](#7-getstudentlistbymentorid)
        * [getStudentListByMentorID](#i-example-request-getstudentlistbymentorid)
    1. [getVolunteerList](#8-getvolunteerlist)
        * [getVolunteerList](#i-example-request-getvolunteerlist)
    1. [rateAcademicExchange](#9-rateacademicexchange)
        * [rateAcademicExchange](#i-example-request-rateacademicexchange)
    1. [rateAssistant](#10-rateassistant)
        * [rateAssistant](#i-example-request-rateassistant)
    1. [reviewAchievement](#11-reviewachievement)
        * [reviewAchievement](#i-example-request-reviewachievement)
    1. [selectAssistant](#12-selectassistant)
        * [selectAssistant](#i-example-request-selectassistant)
    1. [submitCourse](#13-submitcourse)
        * [submitCourse](#i-example-request-submitcourse)
* [student](#student)
    1. [applyAcademicExchangeStatistics](#1-applyacademicexchangestatistics)
        * [applyAcademicExchangeStatistics](#i-example-request-applyacademicexchangestatistics)
    1. [applyAssistantRate](#2-applyassistantrate)
        * [applyAssistantRate](#i-example-request-applyassistantrate)
    1. [applyVolunteer](#3-applyvolunteer)
        * [applyVolunteer](#i-example-request-applyvolunteer)
    1. [getAcademicExchangeStatus](#4-getacademicexchangestatus)
        * [getAcademicExchangeStatus](#i-example-request-getacademicexchangestatus)
    1. [getAssistantCourseList](#5-getassistantcourselist)
        * [getAssistantCourseList](#i-example-request-getassistantcourselist)
    1. [getAssistantRateStatus](#6-getassistantratestatus)
        * [getAssistantRateStatus](#i-example-request-getassistantratestatus)
    1. [getAssistantStatus](#7-getassistantstatus)
        * [getAssistantStatus](#i-example-request-getassistantstatus)
    1. [getAttendProjectStatus](#8-getattendprojectstatus)
    1. [submitAttendProject](#9-submitattendproject)
        * [submitAttendProject](#i-example-request-submitattendproject)
    1. [submitAcademicExchange](#10-submitacademicexchange)
        * [submitAcademicExchange](#i-example-request-submitacademicexchange)
    1. [submitAchievement](#11-submitachievement)
        * [award](#i-example-request-award)
        * [paper](#ii-example-request-paper)
        * [patent](#iii-example-request-patent)
        * [platform](#iv-example-request-platform)
        * [report](#v-example-request-report)
        * [standard](#vi-example-request-standard)
        * [textbook](#vii-example-request-textbook)

--------



## app



### 1. login



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/app/login
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| userID |  | str???userID,???????????????username |
| password |  | str????????? |
| role |  | int????????? 0-?????? 1-?????? 2-?????? 3-????????? 4-??????????????? |



***More example Requests/Responses:***


#### I. Example Request: succeed



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| userID | 2001 |  |
| password | admin |  |
| role | 2 |  |



***Body: None***



#### I. Example Response: succeed
```js
admin-token //??????????????????token???????????????????????????token??????????????????????????????????????????????????????????????????token???????????????????????????????????????????????????????????????
```


***Status Code:*** 200

<br>



## admin



### 1. addStudentUser



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/admin/addStudentUser
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,?????????uid |
| studentType |  | int,???????????????0-?????????1-?????????2-?????? |
| studentName |  | str,???????????? |
| studentSex |  | int,?????????0-??????1-??? |
| studentMentorId |  | str,???????????? |
| studentAssistantStatus |  | int,?????????????????????0-??????1-??? |
| studentAssistantRateStatus |  | int,???????????????0-????????????1-????????? |
| studentExchangeNum |  | int,???????????? |
| password |  | str,?????? |



***More example Requests/Responses:***


#### I. Example Request: addStudentUser



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| studentID | 0002 | str,?????????uid |
| studentType | 0 | int,???????????????0-?????????1-?????????2-?????? |
| studentName | test | str,???????????? |
| studentSex | 0 | int,?????????0-??????1-??? |
| studentMentorId | 1001 | str,???????????? |
| studentAssistantStatus | 0 | int,?????????????????????0-??????1-??? |
| studentAssistantRateStatus | 1 | int,???????????????0-????????????1-????????? |
| studentExchangeNum | 0 | int,???????????? |
| password | passwd | str,?????? |



***Body: None***



#### I. Example Response: addStudentUser
```js
true // ????????????
```


***Status Code:*** 200

<br>



### 2. addTeacherUser



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/admin/addTeacherUser
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| teacherID |  | str,??????id |
| teacherType |  | int,???????????????0-???????????????1-?????? |
| teacherName |  | str,???????????? |
| teacherSex |  | int,???????????????0-??????1-??? |
| teacherSubjectID |  | str,?????????????????????id |
| password |  | str,?????? |



***More example Requests/Responses:***


#### I. Example Request: addTeacherUser



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token |  |
| teacherID | 1001 |  |
| teacherType | 0 |  |
| teacherName | test |  |
| teacherSex | 0 |  |
| teacherSubjectID | 1001 |  |
| password | passwd |  |



***Body: None***



#### I. Example Response: addTeacherUser
```js
true //??????
```


***Status Code:*** 0

<br>



### 3. assignProject



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/admin/assignProject
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| projectID | 1001 | str,??????id |
| projectSubjectID | 1001 | str,????????????id |
| projectMentorID | 1001 | str,????????????id |
| projectType | test | str,???????????? |
| projectName | test | str,???????????? |
| projectFund | 10.1 | double,???????????? |



***More example Requests/Responses:***


#### I. Example Request: assignProject



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| projectID | 1001 | str,??????id |
| projectSubjectID | 1001 | str,????????????id |
| projectMentorID | 1001 | str,????????????id |
| projectType | test | str,???????????? |
| projectName | test | str,???????????? |
| projectFund | 10.1 | double,???????????? |



***Body: None***



#### I. Example Response: assignProject
```js
true //??????
```


***Status Code:*** 200

<br>



### 4. bindMentorWithStudent



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/bindMentorWithStudent
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| studentID | 0002 | str,??????id |
| mentorID | 1001 | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: bindMentorWithStudent



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| studentID | 0002 | str,??????id |
| mentorID | 1001 | str,??????id |



***Body: None***



#### I. Example Response: bindMentorWithStudent
```js
true
```


***Status Code:*** 200

<br>



### 5. editAcademicExchange



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/editAcademicExchange
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 9 | int,?????????????????? |



***More example Requests/Responses:***


#### I. Example Request: editAcademicExchange



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 9 | int,?????????????????? |



***Body: None***



#### I. Example Response: editAcademicExchange
```js
true
```


***Status Code:*** 200

<br>



### 6. editCourseList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/editCourseList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| courseID | 1001 | str,??????id |
| priority | 2 | int,??????????????? |



***More example Requests/Responses:***


#### I. Example Request: editCourseList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| courseID | 1001 | str,??????id |
| priority | 2 | int,??????????????? |



***Body: None***



#### I. Example Response: editCourseList
```js
true
```


***Status Code:*** 200

<br>



### 7. editProjectFounding



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/editProjectFounding
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 20.0 | double,?????????????????? |



***More example Requests/Responses:***


#### I. Example Request: editProjectFounding



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 20.0 | double,?????????????????? |



***Body: None***



#### I. Example Response: editProjectFounding
```js
true
```


***Status Code:*** 200

<br>



### 8. editVolunteerNumber



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/editVolunteerNumber
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 100 | int,?????????????????? |



***More example Requests/Responses:***


#### I. Example Request: editVolunteerNumber



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| num | 100 | int,?????????????????? |



***Body: None***



#### I. Example Response: editVolunteerNumber
```js
true
```


***Status Code:*** 200

<br>



### 9. getAcademicExchange



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getAcademicExchange
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getAcademicExchange



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getAcademicExchange
```js
9
```


***Status Code:*** 200

<br>



### 10. getMentorList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getMentorList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| subjectID | 1001 | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getMentorList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| subjectID | 1001 | str,??????id |



***Body: None***



#### I. Example Response: getMentorList
```js
[
    "??????ID???1002 ???????????????test"
]
```


***Status Code:*** 200

<br>



### 11. getProjectFounding



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getProjectFounding
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getProjectFounding



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getProjectFounding
```js
20
```


***Status Code:*** 200

<br>



### 12. getStudentList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getStudentList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| subjectID | 1001 | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getStudentList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |
| subjectID | 1001 | str,??????id |



***Body: None***



#### I. Example Response: getStudentList
```js
[
    "??????ID???0002 ???????????????test"
]
```


***Status Code:*** 200

<br>



### 13. getSystemAcademicExchangeList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getSystemAcademicExchangeList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getSystemAcademicExchangeList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getSystemAcademicExchangeList
```js
[
    "Exchange{exchangeName='test', exchangeLocation='test', exchangeTime='test', exchangeReportName='test', exchangeImagePath='test', exchangeNote='test', isMentorValid=false, isLeaderValid=false}"
]
```


***Status Code:*** 200

<br>



### 14. getSystemCourseList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getSystemCourseList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getSystemCourseList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getSystemCourseList
```js
[
    "Course{courseName='test', courseHour=48, courseSelectedNum=100, courseTarget=0, courseType=0, courseTime='test', coursePriority=2}"
]
```


***Status Code:*** 200

<br>



### 15. getSystemProjectList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getSystemProjectList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getSystemProjectList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getSystemProjectList
```js
[
    "Project{projectID='1001', projectSubjectID='1001', projectMentorID='1001', projectType='test', projectName='test', projectFund=10.1}"
]
```


***Status Code:*** 200

<br>



### 16. getSystemSubjectList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getSystemSubjectList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getSystemSubjectList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getSystemSubjectList
```js
[
    "Subject{subjectID='1001', subjectName='test'}"
]
```


***Status Code:*** 200

<br>



### 17. getSystemUserList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getSystemUserList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: getSystemUserList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getSystemUserList
```js
[
    "????????????2001 ???????????????admin ?????????admin",
    "????????????0002 ???????????????test ?????????student",
    "????????????1001 ???????????????test ?????????teacher",
    "????????????1002 ???????????????test ?????????mentor"
]
```


***Status Code:*** 200

<br>



### 18. getVolunteerNumber



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/getVolunteerNumber
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getVolunteerNumber



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: getVolunteerNumber
```js
100
```


***Status Code:*** 200

<br>



### 19. reviewInfo(Not implemented)



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/admin/reviewInfo
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***More example Requests/Responses:***


#### I. Example Request: reviewInfo



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | admin-token | str,token |



***Body: None***



#### I. Example Response: reviewInfo
```js
false
```


***Status Code:*** 200

<br>



## teacher



### 1. assignProject



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/assignProject
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| projectID |  | str,??????id |
| studentID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: assignProject



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| projectID | 1001 | str,??????id |
| studentID | 0001 | str,??????id |



***Body: None***



#### I. Example Response: assignProject
```js
true
```


***Status Code:*** 200

<br>



### 2. getAcademicExchangeList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getAcademicExchangeList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getAcademicExchangeList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |



***Body: None***



#### I. Example Response: getAcademicExchangeList
```js
[
    "Exchange{exchangeName='test', exchangeLocation='test', exchangeTime='test', exchangeReportName='test', exchangeImagePath='test', exchangeNote='test', isMentorValid=false, isLeaderValid=false}",
    "Exchange{exchangeName='test', exchangeLocation='test', exchangeTime='test', exchangeReportName='test', exchangeImagePath='test', exchangeNote='test', isMentorValid=true, isLeaderValid=true}"
]
```


***Status Code:*** 200

<br>



### 3. getAchievementList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getAchievementList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getAchievementList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| studentID | 0001 | str,??????id |



***Body: None***



#### I. Example Response: getAchievementList
```js
[
    "test"
]
```


***Status Code:*** 200

<br>



### 4. getCourseList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getCourseList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getCourseList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |



***Body: None***



#### I. Example Response: getCourseList
```js
[
    "Course{courseName='test', courseHour=48, courseSelectedNum=100, courseTarget=0, courseType=0, courseTime='test', coursePriority=2}"
]
```


***Status Code:*** 200

<br>



### 5. getProjectList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getProjectList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getProjectList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |



***Body: None***



#### I. Example Response: getProjectList
```js
[
    "Project{projectID='1001', projectSubjectID='1001', projectMentorID='1001', projectType='test', projectName='test', projectFund=10.1}"
]
```


***Status Code:*** 200

<br>



### 6. getRateList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getRateList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| courseID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getRateList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| teacherID | 1002 | str,??????id |



***Body: None***



#### I. Example Response: getRateList
```js
[
    "??????????????????test????????????????????? test????????????????????? test????????????????????? test",
    "??????????????????test????????????????????? test????????????????????? test1????????????????????? test"
]
```


***Status Code:*** 200

<br>



### 7. getStudentListByMentorID



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getStudentListByMentorID
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| mentorID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getStudentListByMentorID



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| mentorID | 1001 | str,??????id |



***Body: None***



#### I. Example Response: getStudentListByMentorID
```js
[
    "??????ID???0002 ???????????????test"
]
```


***Status Code:*** 200

<br>



### 8. getVolunteerList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/getVolunteerList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| courseID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getVolunteerList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| courseID | 1001 | str,??????id |



***Body: None***



#### I. Example Response: getVolunteerList
```js
[
    "Student{studentId='0001', studentName='??????', sex=0, MentorId='null', assistantStatus=false, assistantRateStatus=false, exchangeNum=0}"
]
```


***Status Code:*** 200

<br>



### 9. rateAcademicExchange



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/rateAcademicExchange
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| exchangeID |  | str,????????????id |
| teacherRate |  | boolean,???????????? |



***More example Requests/Responses:***


#### I. Example Request: rateAcademicExchange



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| exchangeID | 2 | str,????????????id |
| teacherRate | true | boolean,???????????? |



***Body: None***



#### I. Example Response: rateAcademicExchange
```js
true
```


***Status Code:*** 200

<br>



### 10. rateAssistant



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/rateAssistant
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| rateID |  | str,??????id |
| teacherRate |  | str,???????????? |



***More example Requests/Responses:***


#### I. Example Request: rateAssistant



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| rateID | 4 | str,??????id |
| teacherRate | test | str,???????????? |



***Body: None***



#### I. Example Response: rateAssistant
```js
true
```


***Status Code:*** 200

<br>



### 11. reviewAchievement



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/reviewAchievement
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| type | award | str:????????????,??????award,paper,patent,platform,report,standard,textbook |
| achievementID | test | str,??????id |
| isValid | 1 | boolean,???????????? |



***More example Requests/Responses:***


#### I. Example Request: reviewAchievement



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| type | award | str:???????????? |
| achievementID | test | str,??????id |
| isValid | 1 | boolean,???????????? |



***Body: None***



#### I. Example Response: reviewAchievement
```js
true
```


***Status Code:*** 200

<br>



### 12. selectAssistant



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/teacher/selectAssistant
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| colunteerID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: selectAssistant



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| volunteerID | 1 | str,??????id |



***Body: None***



#### I. Example Response: selectAssistant
```js
true
```


***Status Code:*** 200

<br>



### 13. submitCourse



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/teacher/submitCourse
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| CourseID |  | str,??????id |
| courseName |  | str,????????? |
| courseHour |  | int,?????? |
| courseSelectedNum |  | int,???????????? |
| courseTarget |  | int,???????????????0-?????????1-????????? |
| courseType |  | int,???????????????0-????????????1-????????? |
| courseTime |  | str,???????????? |
| coursePriority |  | int,??????????????? |



***More example Requests/Responses:***


#### I. Example Request: submitCourse



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | teacher-token | str,token |
| CourseID | 1002 | str,??????id |
| courseName | test1 | str,????????? |
| courseHour | 64 | int,?????? |
| courseSelectedNum | 200 | int,???????????? |
| courseTarget | 1 | int,???????????????0-?????????1-????????? |
| courseType | 1 | int,???????????????0-????????????1-????????? |
| courseTime | test | str,???????????? |
| coursePriority | 5 | int,??????????????? |



***Body: None***



#### I. Example Response: submitCourse
```js
true
```


***Status Code:*** 200

<br>



## student



### 1. applyAcademicExchangeStatistics



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/applyAcademicExchangeStatistics
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| exchangeID |  | str,????????????id |
| studentID |  | str,??????????????????id |



***More example Requests/Responses:***


#### I. Example Request: applyAcademicExchangeStatistics



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| exchangeID | 2 | str,????????????id |
| studentID | 0002 | str,??????????????????id |



***Body: None***



#### I. Example Response: applyAcademicExchangeStatistics
```js
true
```


***Status Code:*** 200

<br>



### 2. applyAssistantRate



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/applyAssistantRate
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| rateAssistantID |  | str,????????????id |
| rateSelf |  | str,?????????????????? |



***More example Requests/Responses:***


#### I. Example Request: applyAssistantRate



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| rateAssistantID | 1 | str,????????????id |
| rateSelf | test1 | str,?????????????????? |



***Body: None***



#### I. Example Response: applyAssistantRate
```js
true
```


***Status Code:*** 200

<br>



### 3. applyVolunteer



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/applyVolunteer
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| assistantStudentID |  | str,???????????? |
| assistantTeacherID |  | str,???????????????????????? |
| assistantCourseID |  | str,??????????????????ID |



***More example Requests/Responses:***


#### I. Example Request: applyVolunteer



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| assistantStudentID | 0001 | str,???????????? |
| assistantTeacherID | 1001 | str,???????????????????????? |
| assistantCourseID | 1001 | str,??????????????????ID |



***Body: None***



#### I. Example Response: applyVolunteer
```js
true
```


***Status Code:*** 200

<br>



### 4. getAcademicExchangeStatus



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/getAcademicExchangeStatus
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getAcademicExchangeStatus



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| studentID | 0002 | str,??????id |



***Body: None***



#### I. Example Response: getAcademicExchangeStatus
```js
[
    "Exchange{exchangeName='test', exchangeLocation='test', exchangeTime='test', exchangeReportName='test', exchangeImagePath='test', exchangeNote='test', isMentorValid=false, isLeaderValid=false}"
]
```


***Status Code:*** 200

<br>



### 5. getAssistantCourseList



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/getAssistantCourseList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



***More example Requests/Responses:***


#### I. Example Request: getAssistantCourseList



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |



***Body: None***



#### I. Example Response: getAssistantCourseList
```js
[
    "Course{courseName='test', courseHour=48, courseSelectedNum=100, courseTarget=0, courseType=0, courseTime='test', coursePriority=2}"
]
```


***Status Code:*** 200

<br>



### 6. getAssistantRateStatus



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/getAssistantRateStatus
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getAssistantRateStatus



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| studentID | 0002 | str,??????id |



***Body: None***



#### I. Example Response: getAssistantRateStatus
```js
true //??????????????????false
```


***Status Code:*** 200

<br>



### 7. getAssistantStatus



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/getAssistantStatus
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,??????id |



***More example Requests/Responses:***


#### I. Example Request: getAssistantStatus



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| studentID | 0002 | str,??????id |



***Body: None***



#### I. Example Response: getAssistantStatus
```js
false
```


***Status Code:*** 200

<br>



### 8. getAttendProjectStatus



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{host}}/student/getAttendProjectStatus
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| studentID |  | str,??????id |



### 9. submitAttendProject



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/submitAttendProject
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| AttendanceTime |  | str,???????????? |
| AttendanceTask |  | str,???????????? |
| AttendanceFund |  | double,???????????? |
| AttendanceID |  | int,??????id |



***More example Requests/Responses:***


#### I. Example Request: submitAttendProject



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| AttendanceTime | test | str,???????????? |
| AttendanceTask | test | str,???????????? |
| AttendanceFund | 20.0 | double,???????????? |
| AttendanceID | 2 | int,??????id |



***Body: None***



#### I. Example Response: submitAttendProject
```js
true
```


***Status Code:*** 200

<br>



### 10. submitAcademicExchange



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/submitAcademicExchange
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| ExchangeID |  | str,????????????ID |
| ExchangeStudentID |  | str,??????????????????ID |
| ExchangeSubjectID |  | str,??????????????????ID |
| ExchangeName |  | str,?????????????????? |
| ExchangeLocation |  | str,?????????????????? |
| ExchangeTime |  | str,?????????????????? |
| ExchangeReportName |  | str,???????????????????????? |
| ExchangeImagePath |  | str,???????????????????????? |
| ExchangeNote |  | str,?????????????????? |



***More example Requests/Responses:***


#### I. Example Request: submitAcademicExchange



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| ExchangeStudentID | 0001 | str,??????????????????ID |
| ExchangeSubjectID | 1001 | str,??????????????????ID |
| ExchangeName | test | str,?????????????????? |
| ExchangeLocation | test | str,?????????????????? |
| ExchangeTime | test | str,?????????????????? |
| ExchangeReportName | test | str,???????????????????????? |
| ExchangeImagePath | test | str,???????????????????????? |
| ExchangeNote | test | str,?????????????????? |
| isMentorValid | true | boolean,?????????????????? |
| isLeaderValid | true | boolean,?????????????????? |



***Body: None***



#### I. Example Response: submitAcademicExchange
```js
true
```


***Status Code:*** 200

<br>



### 11. submitAchievement



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/submitAchievement
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| type |  | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |



***More example Requests/Responses:***


#### I. Example Request: award



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | award | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| awardName | test | str |
| awardLevel | test | str |
| awardRanking | test | str |
| awardPublishTime | test | str |
| awardAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### I. Example Response: award
```js
true
```


***Status Code:*** 200

<br>



#### II. Example Request: paper



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | paper | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| paperName | test | str |
| paperPublication | test | str |
| paperStatus | test | str |
| paperPublishTime | test | str |
| paperIndex | test | str |
| paperBelong | test | str |
| paperAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### II. Example Response: paper
```js
true
```


***Status Code:*** 200

<br>



#### III. Example Request: patent



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | patent | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| patentName | test | str |
| patentType | test | str |
| patentID | test | str |
| patentPublishTime | test | str |
| patentState | test | str |
| patentContribution | test | str |
| patentAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### III. Example Response: patent
```js
true
```


***Status Code:*** 200

<br>



#### IV. Example Request: platform



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | platform | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| platformName | test | str |
| platformServiceOffice | test | str |
| platformPublishTime | test | str |
| platformContribution | test | str |
| platformAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### IV. Example Response: platform
```js
true
```


***Status Code:*** 200

<br>



#### V. Example Request: report



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | report | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| reportName | test | str |
| reportServiceOffice | test | str |
| reportPublishTime | test | str |
| reportContribution | test | str |
| reportAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### V. Example Response: report
```js
true
```


***Status Code:*** 200

<br>



#### VI. Example Request: standard



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | standard | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| standardName | test | str |
| standardLevel | test | str |
| standardPublishTime | test | str |
| standardAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### VI. Example Response: standard
```js
true
```


***Status Code:*** 200

<br>



#### VII. Example Request: textbook



***Query:***

| Key | Value | Description |
| --- | ------|-------------|
| token | student-token | str,token |
| type | textbook | str,????????????,?????? award,paper,patent,platform,report,standard,textbook?????????????????????????????????????????? |
| achievementID | test | str |
| textbookName | test | str |
| textbookPublishHouse | test | str |
| textbookPublishTime | test | str |
| textbookContribution | test | str |
| textbookAttachment | test | str |
| achievementStudentID | 0001 | str |



***Body: None***



#### VII. Example Response: textbook
```js
true
```


***Status Code:*** 200

<br>



---
[Back to top](#new-collection)

>Generated at 2023-01-16 21:18:24 by [docgen](https://github.com/thedevsaddam/docgen)
