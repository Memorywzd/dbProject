import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function RateExchange() {
    const location = useLocation();

    const [exchangeList, setExchangeList] = useState([]);
    const [exchangeID, setExchangeID] = useState("");
    const [teacherRate, setTeacherRate] = useState("");



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

    function submitRate(){
        console.log("submitRate");
        console.log(teacherRate);
        axios
            .get(serverURL + "/teacher/rateAcademicExchange", {
                params: {
                    //token参数必须带上
                    token: token,
                    exchangeID: exchangeID,
                    teacherRate: teacherRate,
                }
            })
            .then((res) => {
                    console.log(res);
                    if (res.status === 200 && res.data !== "") {
                        alert("评价成功！");
                    }
                    else {
                        alert("评价失败！");
                    }
                }
            );
    }

    return (
        <div className="App">
            <h1>审核学术交流情况</h1>
            {isLogin ? (
                <div>
                    <h3>现有学术交流</h3>
                    <p><button onClick={
                        () => {
                            console.log("token: " + token);
                            axios
                                .get(serverURL + "/teacher/getAcademicExchangeList", {
                                    params: {
                                        //token参数必须带上
                                        token: token,
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
                    }>显示信息</button></p>
                    <p>{exchangeList}</p>
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
                    <label>评价结果:</label>
                    <select onChange = {(e) => {setTeacherRate(e.target.value)}}>
                        <option value = "false">不合格</option>
                        <option value ="true">合格</option>
                    </select>
                    <button onClick={submitRate}>提交审核</button>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    )
}