import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";
//const serverURL = "http://localhost:8080";

export default function AddTeacherUser() {
    const location = useLocation();

    const [teacherID, setTeacherID] = useState("");
    const [teacherType, setTeacherType] = useState(0);
    const [teacherName, setTeacherName] = useState("");
    const [teacherSex, setTeacherSex] = useState(0);
    const [teacherSubjectID, setTeacherSubjectID] = useState("");
    const [password, setPassword] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    let token = cache.getItem("token");

    function setToken(temp) {
        token = temp;
        console.log("token: " + token);
    }

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function  submitTeacher() {
        const formData = new FormData();
        formData.append("teacherID", teacherID);
        formData.append("teacherType", "0");
        formData.append("teacherName", teacherName);
        formData.append("teacherSex", teacherSex);
        formData.append("teacherSubjectID", teacherSubjectID);
        formData.append("password", password);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addTeacherUser", formData)
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
            <h1>授课教师用户创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>授课教师姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师姓名"
                            onChange={(e) => {
                                setTeacherName(e.target.value);
                            }}
                        />

                        <label>授课教师性别:</label>
                        <select>
                            <option value="0" onClick={() => setTeacherSex(0)}>男</option>
                            <option value="1" onClick={() => setTeacherSex(1)}>女</option>
                        </select>

                        <label>授课教师所属学科ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师所属学科"
                            onChange={(e) => {
                                setTeacherSubjectID(e.target.value);
                            }}
                        />

                        <label>授课教师账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师账号"
                            onChange={(e) => {
                                setTeacherID(e.target.value);
                            }}
                        />

                        <label>授课教师密码:</label>
                        <input
                            className="input"
                            type="password"
                            placeholder="请输入教师密码"
                            onChange={(e) => {
                                setPassword(e.target.value);
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