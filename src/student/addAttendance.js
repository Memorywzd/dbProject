import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const serverURL = "http://localhost:3054";

export default function AddAttendance() {
    const location = useLocation();
    const [token, setToken] = useState("");
    const [attendanceName, setattendanceName] = useState("");
    const [attendanceID, setattendanceID] = useState("");
    const [attendanceStudentID, setattendanceStudentID] = useState("");
    const [studentName, setstudentName] = useState("");
    const[attendanceProjectID, setattendanceProjectID] = useState("");
    const [attendanceTime, setattendanceTime] = useState("");
    const[attendanceTask, setattendanceTask] = useState("");
    const [attendanceBudget, setattendanceBudget] = useState("");
    const [attendanceType, setattendanceType] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        //判断是否登录
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function  submitAttendance() {
        const formData = new FormData();
        formData.append("attendanceName", attendanceName);
        formData.append("attendanceID", attendanceID);
        formData.append("attendanceStudentID", attendanceStudentID);
        formData.append("studentName", studentName);
        formData.append("attendanceProjectID", attendanceProjectID);
        formData.append("attendanceTime", attendanceTime);
        formData.append("attendanceTask", attendanceTask);
        formData.append("attendanceBudget", attendanceBudget);
        formData.append("attendanceType", attendanceType);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/student/addAttendance", formData)
            .then((res) => {
                    console.log(res);
                    if (res.data.code === 200 && res.data === "true") {
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
            <h1>项目认定表填写</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>学号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学号"
                            onChange={(e) => {
                                setattendanceStudentID(e.target.value);
                            }}
                        />

                        <label>姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入姓名"
                            onChange={(e) => {
                                setstudentName(e.target.value);
                            }}
                        />

                        <label>学科id:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学科id"
                            onChange={(e) => {
                                setattendanceProjectID(e.target.value);
                            }}
                        />

                        <label>项目ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目ID"
                            onChange={(e) => {
                                setattendanceID(e.target.value);
                            }}
                        />

                        <label>项目名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目名称"
                            onChange={(e) => {
                                setattendanceName(e.target.value);
                            }}
                        />
                        <label>项目类型:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目类型"
                            onChange={(e) => {
                                setattendanceType(e.target.value);
                            }}
                        />
                        <label>参与项目时间:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入参与项目时间"
                            onChange={(e) => {
                                setattendanceTime(e.target.value);
                            }}
                        />
                        <label>承担工作:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入承担工作"
                            onChange={(e) => {
                                setattendanceTask(e.target.value);
                            }}
                        />
                        <label>项目经费:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目经费"
                            onChange={(e) => {
                                setattendanceBudget(e.target.value);
                            }}
                        />
                    </form>

                    <button onClick={submitAttendance}>
                           提交项目认定表
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