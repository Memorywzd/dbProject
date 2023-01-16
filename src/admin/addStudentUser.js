import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddStudentUser() {
    const location = useLocation();

    //定义变量
    const [studentId, setStudentId] = useState("");
    const [studentType, setStudentType] = useState(0);
    const [studentName, setStudentName] = useState("");
    const [studentSex, setStudentSex] = useState(0);
    const [studentSubjectID, setStudentSubjectID] = useState("");
    const [password, setPassword] = useState("");
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

    function  submitStudent() {
        //post请求，照着写
        const formData = new FormData();
        formData.append("studentID", studentId);
        formData.append("studentType", studentType);
        formData.append("studentName", studentName);
        formData.append("studentSex", studentSex);
        formData.append("studentSubjectID", studentSubjectID);
        formData.append("password", password);
        //token参数必须照抄
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addStudentUser", formData)
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
                                setStudentName(e.target.value);
                            }}
                        />
                        <label>研究生性别:</label>
                        <select>
                            <option value="0" onClick={() => setStudentSex(0)}>男</option>
                            <option value="1" onClick={() => setStudentSex(1)}>女</option>
                        </select>

                        <label>学生类型:</label>
                        <select onChange={(e) => {
                            setStudentType(e.target.selectedIndex);
                        }}>
                            <option>专硕</option>
                            <option>学硕</option>
                            <option>博士</option>
                        </select>

                        <label>学生学科ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学生学科ID"
                            onChange={(e) => {
                                setStudentSubjectID(e.target.value);
                            }}
                        />

                        <label>研究生账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入研究生账号"
                            onChange={(e) => {
                                setStudentId(e.target.value);
                            }}
                        />

                        <label>密码:</label>
                        <input
                            className="input"
                            type="password"
                            placeholder="请输入密码"
                            onChange={(e) => {
                                setPassword(e.target.value);
                            }}
                        />
                    </form>

                    <button className="input" onClick={submitStudent}>
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