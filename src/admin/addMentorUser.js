//新建导师用户(使用addTeacherUser的API)
import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddMentorUser() {
    const location = useLocation();

    //定义变量
    const [teacherID, setTeacherID] = useState("");
    const [teacherType, setTeacherType] = useState(1);
    const [teacherName, setTeacherName] = useState("");
    const [teacherSex, setTeacherSex] = useState(0);
    const [teacherSubjectID, setTeacherSubjectID] = useState("");
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

    function submitMentor() {
        //post请求，照着写
        const formData = new FormData();
        formData.append("teacherID", teacherID);
        formData.append("teacherType", "1");
        formData.append("teacherName", teacherName);
        formData.append("teacherSex", teacherSex);
        formData.append("teacherSubjectID", teacherSubjectID);
        formData.append("password", password);
        formData.append("token", token);
        //token参数必须照抄
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
            <h1>导师用户创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>导师姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入导师姓名"
                            onChange={(e) => {
                                setTeacherName(e.target.value);
                            }}
                        />

                        <label>导师性别:</label>
                        <select>
                            <option value="0" onClick={() => setTeacherSex(0)}>男</option>
                            <option value="1" onClick={() => setTeacherSex(1)}>女</option>
                        </select>

                        <label>导师所属学科ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入导师所属学科"
                            onChange={(e) => {
                                setTeacherSubjectID(e.target.value);
                            }}
                        />

                        <label>导师账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入导师账号"
                            onChange={(e) => {
                                setTeacherID(e.target.value);
                            }}
                        />

                        <label>导师密码:</label>
                        <input
                            className="input"
                            type="password"
                            placeholder="请输入导师密码"
                            onChange={(e) => {
                                setPassword(e.target.value);
                            }}
                        />
                     </form>

                        <button onClick={submitMentor}>
                                创建导师用户
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