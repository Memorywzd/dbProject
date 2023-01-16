import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddAttendance() {
    const location = useLocation();

    const [attendanceID, setattendanceID] = useState("");
    const [attendanceTime, setattendanceTime] = useState("");
    const [attendanceTask, setattendanceTask] = useState("");
    const [attendanceFund, setattendanceFund] = useState(0);

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


    function  submitAttendance() {
        const formData = new FormData();
        formData.append("attendanceID", attendanceID);
        formData.append("attendanceTime", attendanceTime);
        formData.append("attendanceTask", attendanceTask);

        formData.append("token", token);
        
        axios
            .post(serverURL + "/student/submitAttendProject", formData)
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
            <h1>项目认定表填写</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>参与项目ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目ID"
                            onChange={(e) => {
                                setattendanceID(e.target.value);
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
                                setattendanceFund(e.target.value);
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