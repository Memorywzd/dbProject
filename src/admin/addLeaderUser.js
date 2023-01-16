import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";


export default function AddLeaderUser() {
    const location = useLocation();

    const [adminID, setAdminID] = useState("");
    const [adminType, setAdminType] = useState(1);
    const [adminName, setAdminName] = useState("");
    const [password, setPassword] = useState("");

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


    function  submitLeader() {
        const formData = new FormData();
        formData.append("adminID", adminID);
        formData.append("adminType", adminType);
        formData.append("adminName", adminName);
        formData.append("password", password);

        formData.append("token", token);

        axios
            .post(serverURL + "/admin/addLeaderUser", formData)
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
            <h1>学科负责人用户创建</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>学科负责人姓名:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入负责人姓名"
                            onChange={(e) => {
                                setAdminName(e.target.value);
                            }}
                        />

                        <label>负责人账号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入负责人账号"
                            onChange={(e) => {
                                setAdminID(e.target.value);
                            }}
                        />

                        <label>负责人密码:</label>
                        <input
                            className="input"
                            type="password"
                            placeholder="请输入负责人密码"
                            onChange={(e) => {
                                setPassword(e.target.value);
                            }}
                        />
                    </form>

                    <button onClick={submitLeader}>
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