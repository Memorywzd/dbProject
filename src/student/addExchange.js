import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const serverURL = "http://localhost:3054";

export default function AddExchange() {
    const location = useLocation();
    const [token, setToken] = useState("");
    const [exchangeName, setexchangeName] = useState("");
    const [exchangeID, setexchangeID] = useState("");
    const [exchangeStudentID, setexchangeStudentID] = useState("");
    const[exchangeSubjectID, setexchangeSubjectID] = useState("");
    const [exchangeLocation, setexchangeLocation] = useState("");
    const[exchangeTime, setexchangeTime] = useState("");
    const [exchangeReportName, setexchangeReportName] = useState("");
    const [exchangeImagePath, setexchangeImagePath] = useState("");
    const [exchangeNote, setexchangeNote] = useState("");
    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        if (location.state) {
            console.log("登录成功");
            setToken(location.state.token);
            setIsLogin(true);
        }
    }, []);


    function submitExchange() {
        const formData = new FormData();
        formData.append("exchangeName", exchangeName);
        formData.append("exchangeID", exchangeID);
        formData.append("exchangeStudentID", exchangeStudentID);
        formData.append("exchangeSubjectID", exchangeSubjectID);
        formData.append("exchangeLocation", exchangeLocation);
        formData.append("exchangeTime", exchangeTime);
        formData.append("exchangeReportName", exchangeReportName);
        formData.append("exchangeImagePath", exchangeImagePath);
        formData.append("exchangeNote", exchangeNote);
        formData.append("token", token);
        
        axios
            .post(serverURL + "/student/addExchange", formData)
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
            <h1>学术交流认定表填写</h1>
            {isLogin ? (
                <div>
                    <form className="form">
                        <label>学号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学号"
                            onChange={(e) => {
                                setexchangeStudentID(e.target.value);
                            }}
                        />

                        <label>学科号:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入学科号"
                            onChange={(e) => {
                                setexchangeSubjectID(e.target.value);
                            }}
                        />

                        <label>交流活动ID:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入交流项目id"
                            onChange={(e) => {
                                setexchangeID(e.target.value);
                            }}
                        />

                        <label>活动名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入活动名称"
                            onChange={(e) => {
                                setexchangeName(e.target.value);
                            }}
                        />
                        <label>活动地点:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入活动地点"
                            onChange={(e) => {
                                setexchangeLocation(e.target.value);
                            }}
                        />
                        <label>参与活动时间:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入参与活动时间"
                            onChange={(e) => {
                                setexchangeTime(e.target.value);
                            }}
                        />

                        <label>报告名称:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入报告名称"
                            onChange={(e) => {
                                setexchangeReportName(e.target.value);
                            }}
                        />
                        <label>参会证明图片路径:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入图片路径"
                            onChange={(e) => {
                                setexchangeImagePath(e.target.value);
                            }}
                        />
                        <label>备注:</label>
                        <input
                            className="input"
                            type="text"
                            placeholder="请输入备注"
                            onChange={(e) => {
                                setexchangeNote(e.target.value);
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