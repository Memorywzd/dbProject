import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const serverURL = "http://localhost:3054";

export default function ShowAttendance() {
    const location = useLocation();
    const [token, setToken] = useState("");
    const [attendanceName, setattendanceName] = useState("");
    const [attendanceID, setattendanceID] = useState("");
    const [studentId, setstudentId] = useState("");
    const [studentName, setstudentName] = useState("");
    const[subjectID, setsubjectID] = useState("");
    const [attendanceTime, setattendanceTime] = useState("");
    const[attendanceTask, setattendanceTask] = useState("");
    const [attendanceBudget, setattendanceBudget] = useState("");
    const [attendanceType, setattendanceType] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);
    const [result, setResult] = useState(null);
     //获取项目认定表的信息


    return (
        <div className="App">
            <h1>项目认定情况</h1>
            {isLogin ? (
                <div>
                    <button onClick={() => {
                        axios
                            .post(serverURL + "/student/showAttendance", {
                                token: token,
                            })
                            .then((res) => {
                                if (res.data.code === 200) {
                                    setResult(res.data.result);
                                }
                                else {
                                    alert("获取失败")
                                }
                            });
                    }
                    }>获取项目认定表信息</button>
                    {result &&
                    result.map((item, showAttendance) => {
                        return (
                            <div key={showAttendance}>
                                <p>学号：{item.studentId}</p>
                                <p>姓名：{item.studentName}</p>
                                <p>学科号：{item.subjectID}</p>
                                <p>项目编号：{item.attendanceID}</p>
                                <p>项目名称：{item.attendanceName}</p>
                                <p>项目类型：{item.attendanceType}</p>
                                <p>参与项目时间：{item.attendanceTime}</p>
                                <p>承担工作：{item.attendanceTask}</p>
                                <p>项目经费：{item.attendanceBudget}</p>
                            </div>
                        );
                    }
                    )}


                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}