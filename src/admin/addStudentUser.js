import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const serverURL = "http://localhost:3054";

export default function AddStudentUser() {
    const location = useLocation();
    const [token, setToken] = useState("");
    const [studentName, setstudentName] = useState("");
    const [studentId, setstudentId] = useState("");
    const [password, setpassword] = useState("");
    const [studentType, setstudentType] = useState("");
    const [MentorId, setMentorId] = useState("");

    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function  submitStudent() {
        const formData = new FormData();
        formData.append("studentName", studentName);
        formData.append("studentId", studentId);
        formData.append("password", password);
        formData.append("studentType", studentType);
        formData.append("mentorId", MentorId);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addStudentUser", formData)
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
            <h1>研究生用户创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">

                        <label>研究生姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入姓名"
                            onChange={(e) => {
                                setstudentName(e.target.value);
                            }}
                        />

                        <label>研究生账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入研究生账号"
                            onChange={(e) => {
                                setstudentId(e.target.value);
                            }}
                        />

                        <label>密码:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入密码"
                            onChange={(e) => {
                                setpassword(e.target.value);
                            }}
                        />

                        <label>项目类型:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目类型"
                            onChange={(e) => {
                                setstudentType(e.target.value);
                            }}
                        />

                        <label>导师ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入导师ID"
                            onChange={(e) => {
                                setMentorId(e.target.value);
                            }}
                        />
                    </form>

                    <button onClick={submitStudent}>
                            创建研究生用户
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