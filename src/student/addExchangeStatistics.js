import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddExchangeStatistics() {
    const location = useLocation();

    const [studentID , setStudentID] = useState("");
    const [exchangeID , setExchangeID] = useState("");
    const [exchangeList , setExchangeList] = useState([]);


    let token = cache.getItem("token");
    const [isLogin, setIsLogin] = useState(false);

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

    return (
        <div className="App">
            <h1>提交学术交流统计</h1>
            {isLogin ? (
                <div>
                    <h3>查看学术交流列表</h3>
                    <label>请输入学生ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学生ID"}
                        onChange={(e) => {
                            setStudentID(e.target.value);
                        }
                        }
                    />
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/getAcademicExchangeStatus", {
                                params: {
                                    token: token,
                                    studentID: studentID,
                                }
                            })
                            .then((res) => {
                                console.log(res);
                                if (res.status === 200 && res.data !== "") {
                                    setExchangeList(res.data);
                                }
                                else {
                                    alert("查询失败！");
                                }
                            }
                            );
                    }
                    }>查询</button>
                    <p>{exchangeList}</p>
                    <form className="form">
                        <label>请输入学生ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入学生ID"}
                            onChange={(e) => {
                                setStudentID(e.target.value);
                            }
                            }
                        />

                        <label>请输入交流ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入交流ID"}
                            onChange={(e) => {
                                setExchangeID(e.target.value);
                            }
                            }
                        />
                    </form>

                    <button onClick={() => {
                        axios
                            .get(serverURL + "/student/applyAcademicExchangeStatistics", {
                                params: {
                                    token: token,
                                    studentID: studentID,
                                    exchangeID: exchangeID,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        alert("提交成功！");
                                    }
                                    else {
                                        alert("提交失败！");
                                    }
                                }
                            );
                    }
                    }>提交</button>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}