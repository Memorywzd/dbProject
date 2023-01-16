
# New Collection



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [app](#app)
    1. [login](#1-login)
        * [succeed](#i-example-request-succeed)
* [admin](#admin)
    1. [addStudentUser](#1-addstudentuser)
    1. [addTeacherUser](#2-addteacheruser)
        * [addTeacherUser](#i-example-request-addteacheruser)
    1. [assignProject](#3-assignproject)
    1. [bindMentorWithStudent](#4-bindmentorwithstudent)
    1. [editAcademicExchange](#5-editacademicexchange)
    1. [editCourseList](#6-editcourselist)
    1. [editProjectFounding](#7-editprojectfounding)
    1. [editVolunteerNumber](#8-editvolunteernumber)
    1. [getAcademicExchange](#9-getacademicexchange)
    1. [getMentorList](#10-getmentorlist)
    1. [getProjectFounding](#11-getprojectfounding)
    1. [getStudentList](#12-getstudentlist)
    1. [getSystemAcademicExchangeList](#13-getsystemacademicexchangelist)
    1. [getSystemCourseList](#14-getsystemcourselist)
    1. [getSystemProjectList](#15-getsystemprojectlist)
    1. [getSystemSubjectList](#16-getsystemsubjectlist)
    1. [getSystemUserList](#17-getsystemuserlist)
    1. [getVolunteerNumber](#18-getvolunteernumber)
    1. [reviewInfo](#19-reviewinfo)
* [teacher](#teacher)
    1. [assignProject](#1-assignproject)
    1. [getAcademicExchangeList](#2-getacademicexchangelist)
    1. [getAchievementList](#3-getachievementlist)
    1. [getCourseList](#4-getcourselist)
    1. [getProjectList](#5-getprojectlist)
    1. [getRateList](#6-getratelist)
    1. [getStudentListByMentorID](#7-getstudentlistbymentorid)
    1. [getVolunteerList](#8-getvolunteerlist)
    1. [rateAcademicExchange](#9-rateacademicexchange)
    1. [rateAssistant](#10-rateassistant)
    1. [reviewAchievement](#11-reviewachievement)
    1. [selectAssistant](#12-selectassistant)
    1. [submitCourse](#13-submitcourse)
* [student](#student)
    1. [applyAcademicExchangeStatistics](#1-applyacademicexchangestatistics)
    1. [applyAssistantRate](#2-applyassistantrate)
    1. [applyVolunteer](#3-applyvolunteer)
    1. [getAcademicExchangeStatus](#4-getacademicexchangestatus)
    1. [getAssistantCourseList](#5-getassistantcourselist)
    1. [getAssistantRateStatus](#6-getassistantratestatus)
    1. [getAssistantStatus](#7-getassistantstatus)
    1. [getAttendProjectStatus](#8-getattendprojectstatus)
    1. [getPsubmitAttendProjectrojectList](#9-getpsubmitattendprojectrojectlist)
    1. [submitAcademicExchange](#10-submitacademicexchange)
    1. [submitAchievement](#11-submitachievement)

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
| userID |  | str，userID,请注意不是username |
| password |  | str，密码 |
| role |  | int，身份 0-学生 1-教师 2-管理员 |



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
admin-token //登录成功返回token，前端应当保存这个token，在后续流程中进行验证，请注意，后续流程中，token不需要载入请求头，只需作为请求参数传递即可
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
| studentID |  | str,学号，uid |
| studentType |  | int,学生类型，0-专硕，1-学硕，2-博士 |
| studentName |  | str,学生姓名 |
| studentSex |  | int,性别，0-男，1-女 |
| studentMentorId |  | str,导师工号 |
| studentAssistantStatus |  | int,是否做过助教，0-否，1-是 |
| studentAssistantRateStatus |  | int,助教评价，0-未评价，1-已评价 |
| studentExchangeNum |  | int,交换次数 |
| password |  | str,密码 |



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
| teacherID |  | str,教师id |
| teacherType |  | int,教师类型，0-授课教师，1-导师 |
| teacherName |  | str,教师姓名 |
| teacherSex |  | int,教师性别，0-男，1-女 |
| teacherSubjectID |  | str,教师所教授科目id |
| password |  | str,密码 |



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
true //成功
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
| token |  | str,token |
| projectID |  | str,评定id |
| projectSubjectID |  | str,项目学科id |
| projectMentorID |  | str,项目导师id |
| projectType |  | str,项目类型 |
| projectName |  | str,项目名称 |
| projectFund |  | double,项目资金 |



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
| token |  | str,token |
| studentID |  | str,学生id |
| mentorID |  | str,导师id |



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
| token |  | str,token |
| num |  | int,更新后的次数 |



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
| token |  | str,token |
| courseID |  | str,课程id |
| priority |  | int,新的优先级 |



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
| token |  | str,token |
| num |  | double,新的项目资金 |



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
| token	 |  | str,token |
| num |  | int,新的助教数量 |



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
| token |  | str,token |



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
| token |  | str,token |
| subjectID |  | str,科目id |



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
| token |  | str,token |



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
| token |  | str,token |
| subjectID |  | str,科目id |



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
| token |  | str,token |



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
| token |  | str,token |



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
| token |  | str,token |



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



### 19. reviewInfo



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{url}}/admin/reviewInfo
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |



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
| projectID |  | str,项目id |
| studentID |  | str,学生id |



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
| studentID |  | str,学生id |



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
| courseID |  | str,课程id |



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
| mentorID |  | str,导师id |



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
| courseID |  | str,课程id |



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
| exchangeID |  | str,学术交流id |
| teacherRate |  | boolean,是否评定 |



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
| rateID |  | str,评定id |
| teacherRate |  | str,教师评价 |



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
| token |  | str,token |
| type |  | str:成果类型 |
| achievementID |  | str,成果id |
| isValid |  | boolean,是否有效 |



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
| colunteerID |  | str,助教id |



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
| CourseID |  | str,课程id |
| courseName |  | str,课程名 |
| courseHour |  | int,课时 |
| courseSelectedNum |  | int,选课人数 |
| courseTarget |  | int,授课对象，0-本科，1-研究生 |
| courseType |  | int,课程类型，0-必修课，1-选修课 |
| courseTime |  | str,授课时间 |
| coursePriority |  | int,课程优先级 |



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
| exchangeID |  | str,交流项目id |
| studentID |  | str,交流项目学生id |



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
| rateAssistantID |  | str,助教评价id |
| rateSelf |  | str,助教工作自述 |
| isTeacherRated |  | bool,教师是否评价 |



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
| assistantStudentID |  | str,助教学号 |
| assistantTeacherID |  | str,助教所属教师工号 |
| assistantCourseID |  | str,助教所属课程ID |



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
| studentID |  | str,学生id |



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
| studentID |  | str,学生id |



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
| studentID |  | str,学生id |



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
| studentID |  | str,学生id |



### 9. getPsubmitAttendProjectrojectList



***Endpoint:***

```bash
Method: POST
Type: 
URL: {{host}}/student/getPsubmitAttendProjectrojectList
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| token |  | str,token |
| AttendanceTime |  | str,参与时间 |
| AttendanceTask |  | str,参与项目 |
| AttendanceFund |  | double,参与资金 |
| AttendanceID |  | int,参与id |



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
| ExchangeID |  | str,交流项目ID |
| ExchangeStudentID |  | str,交流项目学生ID |
| ExchangeSubjectID |  | str,交流项目学科ID |
| ExchangeName |  | str,交流项目名称 |
| ExchangeLocation |  | str,交流项目地点 |
| ExchangeTime |  | str,交流项目时间 |
| ExchangeReportName |  | str,交流项目报告名称 |
| ExchangeImagePath |  | str,交流项目图片路径 |
| ExchangeNote |  | str,交流项目备注 |



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
| type |  | str,成果类型,须为 award,paper,patent,platform,report,standard,textbook之一，不同成果对应参数见附表 |



---
[Back to top](#new-collection)

>Generated at 2023-01-16 17:04:36 by [docgen](https://github.com/thedevsaddam/docgen)
