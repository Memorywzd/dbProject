import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
//const serverURL ="http://localhost:8080";
const serverURL = "http://az.pizzel.me";

export default function ApplyAchievement() {
    const location = useLocation();

    const [type, setType] = useState("award");

    const [achievementID, setAchievementID] = useState("");
    const [achievementStudentID, setAchievementStudentID] = useState("");

    const [awardName, setAwardName] = useState("");
    const [awardLevel, setAwardLevel] = useState("");
    const [awardRanking, setAwardRanking] = useState("");
    const [awardPublishTime, setAwardPublishTime] = useState("");
    const [awardAttachment, setAwardAttachment] = useState("");
    const [isMentorValid, setIsMentorValid] = useState(false);
    const [isAdminValid, setIsAdminValid] = useState(false);

    let isAward = (type === "award");
    let isPaper = (type === "paper");
    let isStandard = (type === "standard");
    let isReport = (type === "report");
    let isPatent = (type === "patent");
    let isPlatform = (type === "platform");
    let isTextbook = (type === "textbook");


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
    const formData = new FormData();
    formData.append("token", token);

    return (
        <div className="App">
            <h1>提交成果认定</h1>
            {isLogin ? (
                <div>
                    <label>成果类型:</label>
                    <select onChange={(e) => {
                        setType(e.target.value);
                    }}>
                        <option value="award">奖项</option>
                        <option value="paper">论文</option>
                        <option value="standard">标准</option>
                        <option value="report">报告</option>
                        <option value="patent">专利</option>
                        <option value="platform">软硬件平台</option>
                        <option value="textbook">教材</option>
                    </select>
                    {isAward ? (
                        <form className="form">
                            <label>成果ID:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="成果ID"
                                onChange={(e) => {
                                    setAchievementID(e.target.value);
                                }}
                            />

                            <label>成果学生ID:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="成果学生ID"
                                onChange={(e) => {
                                    setAchievementStudentID(e.target.value);
                                }}
                            />

                            <label>奖项名称:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="奖项名称"
                                onChange={(e) => {
                                    setAwardName(e.target.value);
                                }}
                            />

                            <label>奖项等级:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="奖项等级"
                                onChange={(e) => {
                                    setAwardLevel(e.target.value);
                                }}
                            />

                            <label>获奖等级:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="获奖等级"
                                onChange={(e) => {
                                    setAwardRanking(e.target.value);
                                }}
                            />

                            <label>获奖时间:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="获奖时间"
                                onChange={(e) => {
                                    setAwardPublishTime(e.target.value);
                                }}
                            />

                            <label>佐证材料:</label>
                            <input
                                className="input"
                                type="text"
                                placeholder="佐证材料"
                                onChange={(e) => {
                                    setAwardAttachment(e.target.value);
                                }}
                            />
                        </form>

                        ): null}

                    <button onClick={() => {
                        if(isAward) {
                            formData.append("type", "award");
                            formData.append("achievementID", achievementID);
                            formData.append("achievementStudentID", achievementStudentID);
                            formData.append("awardName", awardName);
                            formData.append("awardLevel", awardLevel);
                            formData.append("awardRanking", awardRanking);
                            formData.append("awardPublishTime", awardPublishTime);
                            formData.append("awardAttachment", awardAttachment);
                            formData.append("isMentorValid", isMentorValid);
                            formData.append("isAdminValid", isAdminValid);
                        }
                        axios
                            .post(serverURL + "/student/submitAchievement", formData)
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