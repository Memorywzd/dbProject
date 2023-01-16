import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const serverURL = "http://localhost:3054";

export default function AddTeacherUser() {
    const location = useLocation();
    const [token, setToken] = useState("");
    const [teacherName, setteacherName] = useState("");
    const [password, setpassword] = useState("");
    const [teacherID, setteacherID] = useState("");
    const [teacherSubjectID, setteacherSubjectID] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function  submitTeacher() {
        const formData = new FormData();
        formData.append("teacherName", teacherName);
        formData.append("password", password);
        formData.append("teacherID", teacherID);
        formData.append("teacherSubjectID", teacherSubjectID);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addTecaherUser", formData)
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
            <h1>教师用户创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>教师用户账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师账号"
                            onChange={(e) => {
                                setteacherID(e.target.value);
                            }}
                        />

                        <label>教师密码:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师密码"
                            onChange={(e) => {
                                setpassword(e.target.value);
                            }}
                        />

                        <label>教师姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师姓名"
                            onChange={(e) => {
                                setteacherName(e.target.value);
                            }}
                        />

                        <label>教师所属学科ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师所属学科"
                            onChange={(e) => {
                                setteacherSubjectID(e.target.value);
                            }}
                        />
                     </form>

                        <button onClick={submitTeacher}>
                                创建教师用户
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