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

命名全部使用英文全称，遵循驼峰命名法，如需翻译请使用 [DeepL翻译](https://www.deepl.com)。例studentName。命名时考虑可识别性，难以设计时对命名添加备注说明。

##### 全局表格

1. 研究生表 students(studentID, studentName, studentSex, studentSubjectID, studentType, studentContact)

   | 属性名           | 数据类型     | 键型 | 非空 | 默认值 | 备注                      |
   | ---------------- | :----------- | :--- | :--- | ------ | :------------------------ |
   | studentID        | char(50)     | 主键 | 是   |        | 学生id                    |
   | studentName      | varchar(200) |      | 是   |        | 学生姓名                  |
   | studentSex       | int          |      | 是   |        | 学生性别，0男1女          |
   | studentSubjectID | char(50)     | 外键 | 是   |        | 学生学科id                |
   | studentType      | int          |      | 是   |        | 学生类型，0专硕1学硕2博士 |
   | studentContact   | longtext     |      |      |        | 学生联系方式              |
   
   ```sql
   CREATE TABLE students (
       studentID char(50) NOT NULL,
       studentName varchar(200) NOT NULL,
       studentSex int NOT NULL,
       studentSubjectID char(50) NOT NULL,
       studentType int NOT NULL,
       studentContact longtext,
       PRIMARY KEY (`studentID`)
   );
   ```

2. 老师表 teachers(teacherID, teacherName, teacherSex, teacherSubjectID, teacherType, teacherContact)

   | 属性名           | 数据类型     | 键型 | 非空 | 默认值 | 备注                     |
   | ---------------- | :----------- | :--- | :--- | ------ | :----------------------- |
   | teacherID        | char(50)     | 主键 | 是   |        | 老师id                   |
   | teacherName      | varchar(200) |      | 是   |        | 老师姓名                 |
   | teacherSex       | int          |      | 是   |        | 老师性别，0男1女         |
   | teacherSubjectID | char(50)     | 外键 | 是   |        | 老师学科id               |
   | teacherType      | int          |      | 是   |        | 老师类型，0授课教师1导师 |
   | teacherContact   | longtext     |      |      |        | 老师联系方式             |

   ```sql
   CREATE TABLE teachers (
       
   );
   ```

3. 课程表 courses(courseID, courseName, courseHour, courseSelectedNum, courseTarget, courseType, courseTime)

   | 属性名            | 数据类型     | 键型 | 非空 | 默认值 | 备注                     |
   | ----------------- | :----------- | :--- | :--- | ------ | :----------------------- |
   | courseID          | char(50)     | 主键 | 是   |        | 课程id                   |
   | courseName        | varchar(200) |      | 是   |        | 课程名                   |
   | courseHour        | int          |      | 是   | 32     | 课时                     |
   | courseSelectedNum | int          |      | 是   | 0      | 选课人数                 |
   | courseTarget      | int          |      | 是   |        | 授课对象，0本科1研究生   |
   | courseType        | int          |      | 是   |        | 课程类型，0必修课1选修课 |
   | courseTime        | longtext     |      | 是   |        | 授课时间                 |

   ```sql
   CREATE TABLE courses (
       
   );
   ```

4. 学科表 subjects(subjectID, subjectName)

   | 属性名      | 数据类型     | 键型 | 非空 | 默认值 | 备注   |
   | ----------- | :----------- | :--- | :--- | ------ | :----- |
   | subjectID   | char(50)     | 主键 | 是   |        | 学科id |
   | subjectName | varchar(200) | 外键 | 是   |        | 学科名 |

      ```sql
      CREATE TABLE subjects (
          
      );
      ```

##### 助教子系统表格

1. 助教志愿表 assistantVolunteers(volunteerID, volunteerTeacherID, volunteerStudentID, volunteerCourseID)

   | 属性名             | 数据类型 | 键型 | 非空 | 默认值 | 备注          |
   | ------------------ | :------- | :--- | :--- | ------ | :------------ |
   | volunteerID        | int      | 主键 | 是   |        | 志愿id， 自增 |
   | volunteerTeacherID | char(50) | 外键 | 是   |        | 志愿教师id    |
   | volunteerStudentID | char(50) | 外键 | 是   |        | 志愿学生id    |
   | volunteerCourseID  | char(50) | 外键 | 是   |        | 志愿课程id    |

      ```sql
      CREATE TABLE assistantVolunteers (
          
      );
      ```

2. 助教选定表 assistants(assistantID, assistantTeacherID, assistantStudentID, assistantCourseID, assistantRateID)

   | 属性名             | 数据类型 | 键型 | 非空 | 默认值 | 备注          |
   | ------------------ | :------- | :--- | :--- | ------ | :------------ |
   | assistantID        | int      | 主键 | 是   |        | 助教id， 自增 |
   | assistantTeacherID | char(50) | 外键 | 是   |        | 助教教师id    |
   | assistantStudentID | char(50) | 外键 | 是   |        | 助教学生id    |
   | assistantCourseID  | char(50) | 外键 | 是   |        | 助教课程id    |
   | assistantRateID    | int      | 外键 | 是   |        | 助教评价id    |

      ```sql
      CREATE TABLE assistants (
          
      );
      ```

3. 助教情况表 rates(rateID, rateAssistantID, rateSelf, rateTeacher)

   | 属性名          | 数据类型 | 键型 | 非空 | 默认值 | 备注                   |
   | --------------- | :------- | :--- | :--- | ------ | :--------------------- |
   | rateID          | int      | 主键 | 是   |        | 评定id， 自增          |
   | rateAssistantID | char(50) | 外键 | 是   |        | 评定助教选定id         |
   | rateSelf        | char(50) |      | 是   |        | 助教工作自述           |
   | rateTeacher     | char(50) |      | 是   |        | 授课教师评价           |
   | rateResult      | int      |      | 是   |        | 评价结果，0合格1不合格 |

      ```sql
      CREATE TABLE rates (
          
      );
      ```

   
