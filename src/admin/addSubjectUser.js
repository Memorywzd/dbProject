import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";


export default function AddSubjectUser() {
    const location = useLocation();
    
    const [token, setToken] = useState("");
    const [adminName, setadminName] = useState("");
    const [adminID, setadminID] = useState("");
    const [password, setpassword] = useState("");
    const [adminSubjectID, setadminSubjectID] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function  submitSubject() {
        const formData = new FormData();
        formData.append("adminName", adminName);
        formData.append("password", password);
        formData.append("adminID", adminID);
        formData.append("adminSubjectID", adminSubjectID);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/admin/addSubjectUser", formData)
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
                        <label>学科负责人姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学科负责人姓名"
                            onChange={(e) => {
                                setadminName(e.target.value);
                            }}
                        />

                        <label>学科负责人ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学科负责人ID"
                            onChange={(e) => {
                                setadminID(e.target.value);
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

                        <label>学科负责人所属学科ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入教师所属学科"
                            onChange={(e) => {
                                setadminSubjectID(e.target.value);
                            }}
                        />
                    </form>

                    <button onClick={submitSubject}>
                        创建学科负责人用户
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