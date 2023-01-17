import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function ApplyVolunteer() {
    const location = useLocation();

    const [studentID , setStudentID] = useState("");
    const [num , setNum] = useState(0);
    const [assistantStatus, setAssistantStatus] = useState(false);
    const [courseList, setCourseList] = useState([]);
    const [volunteerStudentID, setVolunteerStudentID] = useState("");
    const [volunteerCourseID, setVolunteerCourseID] = useState("");
    const [volunteerTeacherID, setVolunteerTeacherID] = useState("");

    let token = cache.getItem("token");
    const [isLogin, setIsLogin] = useState(false);

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

    return (
        <div className="App">
            <h1>选择助教志愿</h1>
            {isLogin ? (
                <div>
                    <h3>查询当前系统允许志愿数量</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/getVolunteerNumber", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                console.log(res);
                                if (res.status === 200 && res.data !== "") {
                                    setNum(res.data);
                                }
                            })
                            .catch((err) => {
                                console.log(err);
                            });
                    }
                    }>查询</button>
                    <p>数量为{num}个</p>
                    <h3>查看助教状态</h3>
                    <label>请输入学生ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学生ID"}
                        onChange={(e) => {
                            setStudentID(e.target.value);
                        }
                        }
                    />
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/getAssistantStatus", {
                                params: {
                                    token: token,
                                    studentID: studentID,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200) {
                                        setAssistantStatus(res.data);
                                        if(res.data) {
                                            alert("您已经做过助教了");
                                        }
                                        else {
                                            alert("您没有做过助教！");
                                        }
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    <h3>查询可选课程</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/getAssistantCourseList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setCourseList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {courseList.map((item) => {
                        return (
                            <div>
                                <p>{item}</p>
                            </div>
                        );
                    })}
                    <form className="form">
                        <label>请输入学生ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入学生ID"}
                            onChange={(e) => {
                                setVolunteerStudentID(e.target.value);
                            }
                            }
                        />

                        <label>请输入教师ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入学生ID"}
                            onChange={(e) => {
                                setVolunteerTeacherID(e.target.value);
                            }
                            }
                        />

                        <label>请输入课程ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入交流ID"}
                            onChange={(e) => {
                                setVolunteerCourseID(e.target.value);
                            }
                            }
                        />
                    </form>

                    <button onClick={() => {
                        const formData = new FormData();
                        formData.append("token", token);
                        formData.append("assistantStudentID", volunteerStudentID);
                        formData.append("assistantTeacherID", volunteerTeacherID);
                        formData.append("assistantCourseID", volunteerCourseID);
                        axios
                            .post(serverURL + "/student/applyVolunteer", formData)
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data === true) {
                                        alert("提交成功！");
                                    }
                                    else {
                                        alert("提交失败！");
                                    }
                                }
                            );
                    }
                    }>提交</button>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}