import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AddExchange() {
    const location = useLocation();

    const [exchangeStudentID, setExchangeStudentID] = useState("");
    const [exchangeSubjectID, setExchangeSubjectID] = useState("");
    const [exchangeName, setExchangeName] = useState("");
    const [exchangeLocation, setExchangeLocation] = useState("");
    const [exchangeTime, setExchangeTime] = useState("");
    const [exchangeReportName, setExchangeReportName] = useState("");
    const [exchangeImagePath, setExchangeImagePath] = useState("");
    const [exchangeNote, setExchangeNote] = useState("");

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


    function submitExchange() {
        const formData = new FormData();
        formData.append("exchangeName", exchangeName);
        formData.append("exchangeStudentID", exchangeStudentID);
        formData.append("exchangeSubjectID", exchangeSubjectID);
        formData.append("exchangeLocation", exchangeLocation);
        formData.append("exchangeTime", exchangeTime);
        formData.append("exchangeReportName", exchangeReportName);
        formData.append("exchangeImagePath", exchangeImagePath);
        formData.append("exchangeNote", exchangeNote);
        formData.append("isMentorValid", false);
        formData.append("isLeaderValid", false);

        formData.append("token", token);
        
        axios
            .post(serverURL + "/student/submitAcademicExchange", formData)
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
            <h1>学术交流情况提交</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>学号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学号"
                            onChange={(e) => {
                                setExchangeStudentID(e.target.value);
                            }}
                        />

                        <label>学科号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学科号"
                            onChange={(e) => {
                                setExchangeSubjectID(e.target.value);
                            }}
                        />

                        <label>活动名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入活动名称"
                            onChange={(e) => {
                                setExchangeName(e.target.value);
                            }}
                        />
                        <label>活动地点:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入活动地点"
                            onChange={(e) => {
                                setExchangeLocation(e.target.value);
                            }}
                        />
                        <label>参与活动时间:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入参与活动时间"
                            onChange={(e) => {
                                setExchangeTime(e.target.value);
                            }}
                        />

                        <label>报告名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入报告名称"
                            onChange={(e) => {
                                setExchangeReportName(e.target.value);
                            }}
                        />
                        <label>参会证明图片路径:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入图片路径"
                            onChange={(e) => {
                                setExchangeImagePath(e.target.value);
                            }}
                        />
                        <label>备注:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入备注"
                            onChange={(e) => {
                                setExchangeNote(e.target.value);
                            }}
                        />
                    </form>
                    <button onClick={submitExchange}>
                        提交学术交流认定表
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