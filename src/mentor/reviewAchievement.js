import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function ReviewAchievement() {
    const location = useLocation();

    const [studentID, setStudentID] = useState("");
    const [type, setType] = useState("");
    const [achievementID, setAchievementID] = useState("");
    const [isValid, setIsValid] = useState(false);
    const [achievementList, setAchievementList] = useState([]);

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

    function submitReview(){

    }

    return (
        <div className="App">
            <h1>研究生成果认证</h1>
            {isLogin ? (
                <div>
                    <h3>学生成果列表</h3>
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
                    <p><button onClick={
                        () => {
                            console.log("token: " + token);
                            axios
                                .get(serverURL + "/teacher/getAchievementList", {
                                    params: {
                                        //token参数必须带上
                                        token: token,
                                        studentID: studentID,
                                    }
                                })
                                .then((res) => {
                                        console.log(res);
                                        if (res.status === 200 && res.data !== "") {
                                            setAchievementList(res.data);
                                        }
                                        else {
                                            alert("查询失败！");
                                        }
                                    }
                                );
                        }
                    }>显示信息</button></p>
                    <p>{achievementList}</p>
                    <form className="form">
                        <label>请输入成果类型：</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入交流ID"}
                            onChange={(e) => {
                                setType(e.target.value);
                            }
                            }
                        />
                        <label>请输入成果ID：</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入成果ID"}
                            onChange={(e) => {
                                setAchievementID(e.target.value);
                            }
                            }
                        />
                        <label>评价结果:</label>
                        <select>
                            <option value="0" onClick={() => setIsValid(0)}>不合格</option>
                            <option value="1" onClick={() => setIsValid(1)}>合格</option>
                        </select>
                    </form>

                    <button onClick={
                        () => {
                            axios
                                .get(serverURL + "/teacher/reviewAchievement", {
                                    params: {
                                        token: token,
                                        type: type,
                                        achievementID: achievementID,
                                        isValid: isValid,
                                    }
                                })
                                .then((res) => {
                                        console.log(res);
                                        if (res.status === 200 && res.data !== "") {
                                            alert("认证成功！");
                                        }
                                        else {
                                            alert("认证失败！");
                                        }
                                    }
                                );
                        }
                    }>提交审核</button>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    )
}