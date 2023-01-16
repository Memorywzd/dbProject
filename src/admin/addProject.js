import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";


export default function AddProject() {
    const location = useLocation();

    const [projectName, setprojectName] = useState("");
    const [MentorIdID, setMentorId] = useState("");
    const [projectID, setprojectID] = useState("");
    const [projectFund, setprojectFund] = useState("");
    const [projectType, setprojectType] = useState("");

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


    function  submitProject() {
        const formData = new FormData();
        formData.append("projectName", projectName);
        formData.append("mentorId", MentorIdID);
        formData.append("projectID", projectID);
        formData.append("projectFund", projectFund);
        formData.append("projectType", projectType);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addProject", formData)
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
            <h1>项目创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>项目账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目账号"
                            onChange={(e) => {
                                setprojectID(e.target.value);
                            }}
                        />

                        <label>项目名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目名称"
                            onChange={(e) => {
                                setprojectName(e.target.value);
                            }}
                        />

                        <label>项目类型:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目类型"
                            onChange={(e) => {
                                setprojectType(e.target.value);
                            }}
                        />

                        <label>项目负责人（导师）ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入导师ID"
                            onChange={(e) => {
                                setMentorId(e.target.value);
                            }}
                        />

                        <label>项目经费:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入项目经费"
                            onChange={(e) => {
                                setprojectFund(e.target.value);
                            }}
                        />
                    </form>

                    <button onClick={submitProject}>
                         创建项目
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