import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function ApplyVolunteerRate() {
    const location = useLocation();

    const [studentID , setStudentID] = useState("");
    const [rateAssistantID, setRateAssistantID] = useState("");
    const [rateSelf, setRateSelf] = useState("");


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
            <h1>提交助教评定表</h1>
            {isLogin ? (
                <div>
                    <h3>查看助教评定情况</h3>
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
                            .get(serverURL + "/student/getAssistantRateStatus", {
                                params: {
                                    token: token,
                                    studentID: studentID,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200) {
                                        if(res.data === true){
                                            alert("已完成助教评定");
                                        }
                                        else {
                                            alert("未完成助教评定");
                                        }
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    <form className="form">
                        <label>请输入助教ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入助教ID"}
                            onChange={(e) => {
                                setRateAssistantID(e.target.value);
                            }
                            }
                        />

                        <label>请输入工作自述：</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入工作自述"}
                            onChange={(e) => {
                                setRateSelf(e.target.value);
                            }
                            }
                        />
                    </form>

                    <button onClick={() => {
                        const formData = new FormData();
                        formData.append("token", token);
                        formData.append("rateAssistantID", rateAssistantID);
                        formData.append("rateSelf", rateSelf);
                        console.log(formData.get("rateAssistantID"));

                        axios
                            .post(serverURL + "/student/applyAssistantRate", formData)
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data === true) {
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