import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function ShowAttendance() {
    const location = useLocation();

    const [token, setToken] = useState("");
    const [studentId, setstudentId] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);
    const [result, setResult] = useState(null);
     //获取项目认定表的信息


    return (
        <div className="App">
            <h1>项目认定情况</h1>
            {isLogin ? (
                <div>
                    <form className="form">

                        <label>学号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学号"
                            onChange={(e) => {
                                setstudentId(e.target.value);
                            }}
                        />
                    </form>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/getAttendProjectStatus", {
                                params: {
                                    studentID: studentId,
                                    token: token,
                                }
                            })
                            .then((res) => {
                                console.log(res);
                                if (res.status === 200 && res.data !== "") {
                                    setResult(res.data);
                                }
                                else {
                                    alert("获取失败")
                                }
                            });
                    }
                    }>获取项目认定表信息</button>
                    <p>{result}</p>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}