//课程信息录入
import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddClass() {
    const location = useLocation();

    //定义变量
    const [courseID, setCourseID] = useState("");
    const [courseTeacherID, setCourseTeacherID] = useState("");
    const [courseName, setCourseName] = useState("");
    const [courseHour, setCourseHour] = useState(0);
    const [courseSelectedNum, setCourseSelectedNum] = useState(0);
    const [courseTarget, setCourseTarget] = useState(0);
    const [courseType, setCourseType] = useState(0);
    const [courseTime, setCourseTime] = useState("");
    const [coursePriority, setCoursePriority] = useState(0);

    //以上定义变量
    const [isLogin, setIsLogin] = useState(false);

    let token = cache.getItem("token");
    function setToken(temp) {
        token = temp;
        console.log("token: " + token);
    }

    useEffect(() => {
        if (location.state) {
            console.log("已经登录");
            console.log(location.state.token);
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, [location.state]);
    //以上照抄

    function  submitCourse() {
        //post请求，照着写
        const formData = new FormData();
        formData.append("courseID", courseID);
        formData.append("courseTeacherID", courseTeacherID);
        formData.append("courseName", courseName);
        formData.append("courseHour", courseHour);
        formData.append("courseSelectedNum", courseSelectedNum);
        formData.append("courseTarget", courseTarget);
        formData.append("courseType", courseType);
        formData.append("courseTime", courseTime);
        formData.append("coursePriority", coursePriority);
        //token参数必须照抄
        formData.append("token", token);
        
        axios
            .post(serverURL + "/teacher/submitCourse", formData)
            .then((res) => {
                    console.log(res);
                    if (res.status === 200 && res.data === true) {
                        alert("添加成功")
                    }
                    else {
                        alert("添加失败")
                    }
                }
            );
    }
    return (
        <div className="App">
            <h1>课程信息录入</h1>
            {isLogin ? (
                <div>
                    <form className="form">

                        <label>课程ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入课程ID"
                            onChange={(e) => {
                                setCourseID(e.target.value);
                            }}
                        />

                        <label>教师ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="教师ID"
                            onChange={(e) => {
                                setCourseTeacherID(e.target.value);
                            }}
                        />

                        <label>课程名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入课程名"
                            onChange={(e) => {
                                setCourseName(e.target.value);
                            }}
                        />

                        <label>课时:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入课时"
                            onChange={(e) => {
                                setCourseHour(e.target.value);
                            }}
                        />

                        <label>选课人数:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入选课人数"
                            onChange={(e) => {
                                setCourseSelectedNum(e.target.value);
                            }}
                        />

                        <label>授课对象:</label>
                        <select>
                            <option value="0" onClick={() => setCourseTarget(0)}>本科</option>
                            <option value="1" onClick={() => setCourseTarget(1)}>研究生</option>
                        </select>

                        <label>课程类型:</label>
                        <select>
                            <option value="0" onClick={() => setCourseType(0)}>必修课</option>
                            <option value="1" onClick={() => setCourseType(1)}>选修课</option>
                        </select>
                        
                        <label>授课时间:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入授课时间"
                            onChange={(e) => {
                                setCourseTime(e.target.value);
                            }}
                        />

                        <label>课程优先级:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入课程优先级"
                            onChange={(e) => {
                                setCoursePriority(e.target.value);
                            }}
                        />

                    </form>

                    <button onClick={submitCourse}>
                            创建课程
                    </button>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}