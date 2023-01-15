# 2022数据库课程设计

------

## 系统设计

- [ ] 助教子系统
- [ ] 学术交流子系统
- [ ] 项目参与子系统
- [ ] 成果认定子系统
- [ ] 管理子系统

------

### 系统ER图设计

见子文件夹图片和txt数据

使用工具辅助设计ER图，地址 [数据库 - Creately](https://app.creately.com/d/FUkOA74e2n8/edit) 账户名sakana07@proton.me 密码Chisato0923

或者自行注册账号，复制txt数据粘贴至绘制ER图的界面即可。同理，导出ER图时全选图形，粘贴至txt文件种即可。

------

### 数据库设计

格式：关系表文字说明，关系表，DDL语句

命名全部使用英文全称，遵循驼峰命名法，如需翻译请使用 [DeepL翻译](https://www.deepl.com)。例studentName。命名时考虑可识别性，难以设计时对命名添加备注说明。库的名字为dbProject。

##### 视图

1. 成果视图 achievements，包含各类成果
2. 用户视图 users，包含各类用户账号密码
3. 

##### 全局表格

0. 系统用户情况

    | 属性名       | 数据类型      | 键型 | 非空 | 备注 |
    | ------------ | :------------ | :--- | :--- | :--- |
    | userID       | varchar(50)   | 主键 | 是   |      |
    | password     | nvarchar(200) |      | 是   |      |
    | userRole     | int           |      | 是   |      |
    | userType     | varchar(50)   | 外键 | 是   |      |
    | token        | int           |      | 是   |      |
    | isTokenValid | nvarchar(MAX) |      |      |      |

    ```sql
    CREATE TABLE students (
        
    );
    ```

1. 研究生表 students(studentID, studentName, studentSex, studentSubjectID, studentType, studentContact)

   | 属性名                     | 数据类型      | 键型 | 非空 | 备注                      |
   | -------------------------- | :------------ | :--- | :--- | :------------------------ |
   | studentID                  | varchar(50)   | 主键 | 是   | 学生id                    |
   | studentType                | int           |      | 是   | 学生类型，0专硕1学硕2博士 |
   | studentName                | nvarchar(200) |      | 是   | 学生姓名                  |
   | studentSex                 | int           |      | 是   | 学生性别，0男1女          |
   | studentMentorId            |               |      |      |                           |
   | studentAssistantStatus     |               |      |      |                           |
   | studentAssistantRateStatus |               |      |      |                           |
   | studentExchangeNum         |               |      |      |                           |
   | password                   |               |      |      |                           |

   ```sql
   CREATE TABLE students (
       studentID varchar(50) NOT NULL,
       studentName nvarchar(200) NOT NULL,
       studentSex int NOT NULL,
       studentSubjectID varchar(50) NOT NULL,
       studentType int NOT NULL,
       studentContact nvarchar(MAX),
       PRIMARY KEY (studentID),
       FOREIGN KEY (studentSubjectID) REFERENCES subjects(subjectID)
   );
   ```

2. 老师表 teachers(teacherID, teacherName, teacherSex, teacherSubjectID, teacherType, teacherContact)

   | 属性名           | 数据类型      | 键型 | 非空 | 备注                     |
   | ---------------- | :------------ | :--- | :--- | :----------------------- |
   | teacherID        | varchar(50)   | 主键 | 是   | 老师id                   |
   | teacherType      | int           |      | 是   | 老师类型，0授课教师1导师 |
   | teacherName      | nvarchar(200) |      | 是   | 老师姓名                 |
   | teacherSex       | int           |      | 是   | 老师性别，0男1女         |
   | teacherSubjectID | varchar(50)   | 外键 | 是   | 老师学科id               |
   | teacherContact   | longtext      |      |      | 老师联系方式             |
   | password         |               |      |      |                          |

   ```sql
   CREATE TABLE teachers (
    teacherID varchar(50) NOT NULL,
    teacherName nvarchar(200) NOT NULL,
    teacherSex int NOT NULL,
    teacherSubjectID varchar(50) NOT NULL,
    teacherType int NOT NULL,
    teacherContact longtext,
    PRIMARY KEY (teacherID),
    FOREIGN KEY (teacherSubjectID) REFERENCES subjects(subjectID)
   );
   ```

3. 管理员表 admins

   | 属性名           | 数据类型      | 键型 | 非空 | 备注                     |
   | ---------------- | :------------ | :--- | :--- | :----------------------- |
   | teacherID        | varchar(50)   | 主键 | 是   | 老师id                   |
   | teacherType      | int           |      | 是   | 老师类型，0授课教师1导师 |
   | teacherName      | nvarchar(200) |      | 是   | 老师姓名                 |
   | teacherSex       | int           |      | 是   | 老师性别，0男1女         |
   | teacherSubjectID | varchar(50)   | 外键 | 是   | 老师学科id               |
   | teacherContact   | longtext      |      |      | 老师联系方式             |
   | password         |               |      |      |                          |

      ```sql
      CREATE TABLE teachers (
       teacherID varchar(50) NOT NULL,
       teacherName nvarchar(200) NOT NULL,
       teacherSex int NOT NULL,
       teacherSubjectID varchar(50) NOT NULL,
       teacherType int NOT NULL,
       teacherContact longtext,
       PRIMARY KEY (teacherID),
       FOREIGN KEY (teacherSubjectID) REFERENCES subjects(subjectID)
      );
      ```

4. 学科表 subjects(subjectID, subjectName)

   | 属性名      | 数据类型      | 键型 | 非空 | 备注   |
   | ----------- | :------------ | :--- | :--- | :----- |
   | subjectID   | varchar(50)   | 主键 | 是   | 学科id |
   | subjectName | nvarchar(200) |      | 是   | 学科名 |

      ```sql
      CREATE TABLE subjects (
          subjectID varchar(50) NOT NULL,
          subjectName nvarchar(200) NOT NULL,
          PRIMARY KEY (subjectID)
      );
      ```

##### 助教子系统表格
0. 课程表 courses(courseID, courseName, courseHour, courseSelectedNum, courseTarget, courseType, courseTime)

    | 属性名            | 数据类型      | 键型 | 非空 | 备注                     |
    | ----------------- | :------------ | :--- | :--- | :----------------------- |
    | courseID          | varchar(50)   | 主键 | 是   | 课程id                   |
    | courseName        | nvarchar(200) |      | 是   | 课程名                   |
    | courseHour        | int           |      | 是   | 课时                     |
    | courseSelectedNum | int           |      | 是   | 选课人数                 |
    | courseTarget      | int           |      | 是   | 授课对象，0本科1研究生   |
    | courseType        | int           |      | 是   | 课程类型，0必修课1选修课 |
    | courseTime        | nvarchar(MAX) |      | 是   | 授课时间                 |
    | coursePriority    |               |      |      |                          |

    ```sql
    CREATE TABLE courses (
        courseID varchar(50) NOT NULL,
        courseName nvarchar(200) NOT NULL,
        courseHour int default 32  NOT NULL,
        courseSelectedNum int default 0 NOT NULL,
        courseTarget int NOT NULL,
        courseType int NOT NULL,
        courseTime nvarchar(MAX) NOT NULL,
        PRIMARY KEY (`courseID`)
    );
    ```

1. 助教志愿表 assistantVolunteers(volunteerID, volunteerTeacherID, volunteerStudentID, volunteerCourseID)

   | 属性名             | 数据类型    | 键型 | 非空 | 备注          |
   | ------------------ | :---------- | :--- | :--- | :------------ |
   | volunteerID        | int         | 主键 | 是   | 志愿id， 自增 |
   | volunteerTeacherID | varchar(50) | 外键 | 是   | 志愿教师id    |
   | volunteerStudentID | varchar(50) | 外键 | 是   | 志愿学生id    |
   | volunteerCourseID  | varchar(50) | 外键 | 是   | 志愿课程id    |

      ```sql
      CREATE TABLE assistantVolunteers (
          
      );
      ```

2. 助教选定表 assistants(assistantID, assistantTeacherID, assistantStudentID, assistantCourseID, assistantRateID)

   | 属性名             | 数据类型    | 键型 | 非空 | 默认值 | 备注          |
   | ------------------ | :---------- | :--- | :--- | ------ | :------------ |
   | assistantID        | int         | 主键 | 是   |        | 助教id， 自增 |
   | assistantTeacherID | varchar(50) | 外键 | 是   |        | 助教教师id    |
   | assistantStudentID | varchar(50) | 外键 | 是   |        | 助教学生id    |
   | assistantCourseID  | varchar(50) | 外键 | 是   |        | 助教课程id    |
   | assistantRateID    | int         |      |      |        |               |
   
      ```sql
      CREATE TABLE assistants (
          
      );
      ```
   
3. 助教情况表 rates(rateID, rateAssistantID, rateSelf, rateTeacher)

   | 属性名          | 数据类型    | 键型 | 非空 | 备注                   |
   | --------------- | :---------- | :--- | :--- | :--------------------- |
   | rateID          | int         | 主键 | 是   | 评定id， 自增          |
   | rateAssistantID | int         | 外键 | 是   | 助教id                 |
   | rateSelf        | varchar(50) |      | 是   | 助教工作自述           |
   | rateTeacher     | varchar(50) |      | 是   | 授课教师评价           |
   | isTeacherRated  |             |      |      |                        |
   | rateResult      | int         |      | 是   | 评价结果，0合格1不合格 |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```
   
   

##### 成果认定子系统

1. 奖励表 awards

   | 属性名               | 数据类型      | 键型 | 非空 | 备注          |
   | -------------------- | :------------ | :--- | :--- | :------------ |
   | achievementID        | varchar(50)   | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID | varchar(50)   |      |      |               |
   | awardName            | nvarchar(200) |      |      |               |
   | awardLevel           | nvarchar(200) |      |      |               |
   | awardRanking         | nvarchar(200) |      |      |               |
   | awardPublishTime     | nvarchar(200) |      |      |               |
   | awardAttachment      | nvarchar(200) |      |      |               |
   | isMentorValid        |               |      |      |               |
   | isAdminValid         |               |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

2. 论文表 papers

   | 属性名               | 数据类型 | 键型 | 非空 | 备注          |
   | -------------------- | :------- | :--- | :--- | :------------ |
   | achievementID        | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID |          |      |      |               |
   | paperName            |          |      |      |               |
   | paperPublication     |          |      |      |               |
   | paperStatus          |          |      |      |               |
   | paperPublishTime     |          |      |      |               |
   | paperIndex           |          |      |      |               |
   | paperBelong          |          |      |      |               |
   | paperAttachment      |          |      |      |               |
   | isMentorValid        |          |      |      |               |
   | isAdminValid         |          |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

3. 专利 patents

   | 属性名               | 数据类型 | 键型 | 非空 | 备注          |
   | -------------------- | :------- | :--- | :--- | :------------ |
   | achievementID        | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID |          |      |      |               |
   | patentName           |          |      |      |               |
   | patentType           |          |      |      |               |
   | patentID             |          |      |      |               |
   | patentPublishTime    |          |      |      |               |
   | patentState          |          |      |      |               |
   | patentContribution   |          |      |      |               |
   | patentAttachment     |          |      |      |               |
   | isMentorValid        |          |      |      |               |
   | isAdminValid         |          |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

4. 软硬件平台表 platforms

   | 属性名                | 数据类型 | 键型 | 非空 | 备注          |
   | --------------------- | :------- | :--- | :--- | :------------ |
   | achievementID         | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID  |          |      |      |               |
   | platformName          |          |      |      |               |
   | platformServiceOffice |          |      |      |               |
   | platformPublishTime   |          |      |      |               |
   | platformContribution  |          |      |      |               |
   | platformAttachment    |          |      |      |               |
   | isMentorValid         |          |      |      |               |
   | isAdminValid          |          |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

5. 报告表 reports

   | 属性名               | 数据类型 | 键型 | 非空 | 备注          |
   | -------------------- | :------- | :--- | :--- | :------------ |
   | achievementID        | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID |          |      |      |               |
   | reportName           |          |      |      |               |
   | reportType           |          |      |      |               |
   | reportServiceOffice  |          |      |      |               |
   | reportPublishTime    |          |      |      |               |
   | reportContribution   |          |      |      |               |
   | reportAttachment     |          |      |      |               |
   | isMentorValid        |          |      |      |               |
   | isAdminValid         |          |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

6. 标准表 standards

   | 属性名               | 数据类型 | 键型 | 非空 | 备注          |
   | -------------------- | :------- | :--- | :--- | :------------ |
   | achievementID        | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID |          |      |      |               |
   | standardName         |          |      |      |               |
   | standardLevel        |          |      |      |               |
   | standardPublishTime  |          |      |      |               |
   | standardAttachment   |          |      |      |               |
   | isMentorValid        |          |      |      |               |
   | isAdminValid         |          |      |      |               |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

7. 教材表 textbooks

   | 属性名               | 数据类型 | 键型 | 非空 | 备注          |
   | -------------------- | :------- | :--- | :--- | :------------ |
   | achievementID        | int      | 主键 | 是   | 评定id， 自增 |
   | achievementStudentID |          |      |      |               |
   | textbookName         |          |      |      |               |
   | textbookPublishHouse |          |      |      |               |
   | textbookPublishTime  |          |      |      |               |
   | textbookContribution |          |      |      |               |
   | textbookAttachment   |          |      |      |               |
   | isMentorValid        |          |      |      |               |
   | isAdminValid         |          |      |      |               |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```

##### 参与项目情况子系统

1. 项目表 projects

   | 属性名           | 数据类型 | 键型 | 非空 | 备注          |
   | ---------------- | :------- | :--- | :--- | :------------ |
   | projectID        | int      | 主键 | 是   | 评定id， 自增 |
   | projectSubjectID |          |      |      |               |
   | projectMentorID  |          |      |      |               |
   | projectType      |          |      |      |               |
   | projectName      |          |      |      |               |
   | projectFund      |          |      |      |               |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```

2. 参与情况表 attendances

   | 属性名              | 数据类型 | 键型 | 非空 | 备注          |
   | ------------------- | :------- | :--- | :--- | :------------ |
   | attendanceID        | int      | 主键 | 是   | 评定id， 自增 |
   | attendanceProjectID |          |      |      |               |
   | attendanceStudentID |          |      |      |               |
   | attendanceTime      |          |      |      |               |
   | attendanceTask      |          |      |      |               |
   | attendanceFund      |          |      |      |               |
   | isMentorValid       |          |      |      |               |
   | isLeaderValid       |          |      |      |               |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```


##### 学术交流子系统

1. 交流表 exchanges

   | 属性名             | 数据类型 | 键型 | 非空 | 备注          |
   | ------------------ | :------- | :--- | :--- | :------------ |
   | exchangeID         | int      | 主键 | 是   | 评定id， 自增 |
   | exchangeStudentID  |          |      |      |               |
   | exchangeSubjectID  |          |      |      |               |
   | exchangeName       |          |      |      |               |
   | exchangeLocation   |          |      |      |               |
   | exchangeTime       |          |      |      |               |
   | exchangeReportName |          |      |      |               |
   | exchangeImagePath  |          |      |      |               |
   | exchangeNote       |          |      |      |               |
   | isMentorValid      |          |      |      |               |
   | isLeaderValid      |          |      |      |               |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```


2. 交流统计表 exchangeStatistics

   | 属性名            | 数据类型 | 键型 | 非空 | 备注          |
   | ----------------- | :------- | :--- | :--- | :------------ |
   | exchangeID        | int      | 主键 | 是   | 评定id， 自增 |
   | exchangeStudentID |          |      |      |               |
   
      ```sql
      CREATE TABLE rates (
          
      );
      ```
