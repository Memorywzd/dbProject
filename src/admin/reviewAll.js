import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function ReviewAll() {
    const location = useLocation();

    const [userList, setUserList] = useState([]);
    const [courseList, setCourseList] = useState([]);
    const [projectList, setProjectList] = useState([]);
    const [exchangeList, setExchangeList] = useState([]);
    const [subjectList, setSubjectList] = useState([]);
    const [rateList, setRateList] = useState([]);
    const [achievementList, setAchievementList] = useState([]);

    const [validID, setValidID] = useState("");
    const [valid, setValid] = useState(0);
    const [type, setType] = useState("attendance");


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
                    <h3>查看系统用户列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getSystemUserList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setUserList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {userList.map((item) => (<p>{item}</p>))}
                    <h3>查看系统课程列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getSystemCourseList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setCourseList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {courseList.map((item) => (<p>{item}</p>))}
                    <h3>查看系统项目参与列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getSystemProjectList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setProjectList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {projectList.map((item) => (<p>{item}</p>))}
                    <h3>查看学术交流列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getSystemAcademicExchangeList", {
                                params: {
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
                    }>查询</button>
                    {exchangeList.map((item) => (<p>{item}</p>))}
                    <h3>查看系统学科列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getSystemUserList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setSubjectList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {subjectList.map((item) => (<p>{item}</p>))}
                    <h3>查看助教评定列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getRateList", {
                                params: {
                                    token: token,
                                }
                            })
                            .then((res) => {
                                    console.log(res);
                                    if (res.status === 200 && res.data !== "") {
                                        setRateList(res.data);
                                    }
                                    else {
                                        alert("查询失败！");
                                    }
                                }
                            );
                    }
                    }>查询</button>
                    {rateList.map((item) => (<p>{item}</p>))}
                    <h3>查看学生成果列表</h3>
                    <button onClick={() => {
                        axios
                            .get(serverURL + "/admin/getAchievementList", {
                                params: {
                                    token: token,
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
                    }>查询</button>
                    {achievementList.map((item) => (<p>{item}</p>))}
                    <form className="form">
                        <label>选择审核的类别
                        <select onChange={(e) => {
                            setType(e.target.value);
                        }}>
                            <option value="attendance">项目参与</option>
                            <option value="exchange">学术交流</option>
                            <option value="rate">助教评定</option>
                            <option value="achievement">学生成果</option>
                        </select></label>

                        <label>请输入对象ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入对象ID"}
                            onChange={(e) => {
                                setValidID(e.target.value);
                            }
                            }
                        />

                        <label>审核是否有效:</label>
                        <select onChange = {(e) => {setValid(e.target.value)}}>
                            <option value="1" onClick={() => setValid(1)}>有效</option>
                            <option value="0" onClick={() => setValid(0)}>无效</option>
                        </select>
                    </form>

                    <button onClick={() => {
                        console.log("valid: " + valid);
                        console.log(type);
                        axios
                            .get(serverURL + "/admin/reviewInfo", {
                                params: {
                                    token: token,
                                    id: validID,
                                    valid: valid,
                                    type: type,
                                }
                            })
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