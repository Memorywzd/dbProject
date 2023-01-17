import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navigate, useLocation, NavLink } from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function AssignProject() {
    const location = useLocation();

    const [projectList, setProjectList] = useState([]);
    const [studentList, setStudentList] = useState([]);
    const [projectID, setProjectID] = useState("");
    const [studentID, setStudentID] = useState("");
    const [mentorID, setMentorID] = useState("");
    const [fund, setFund] = useState(0.0);

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

    function submitAssign(){

    }

    return (
        <div className="App">
            <h1>填报学生参与项目</h1>
            {isLogin ? (
                <div>
                    <h3>项目列表</h3>
                    <div>
                        <button onClick={
                            () => {
                                axios
                                    .get(serverURL + "/teacher/getProjectList", {
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
                        }>显示信息</button>
                        <p>{projectList}</p>
                    </div>
                    <h3>学生列表</h3>
                    <div>
                        <label>请输入导师ID</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入导师ID"}
                            onChange={(e) => {
                                setMentorID(e.target.value);
                            }
                            }
                        />

                        <button onClick={
                            () => {
                                axios
                                    .get(serverURL + "/teacher/getStudentListByMentorID", {
                                        params: {
                                            token: token,
                                            mentorID: mentorID,
                                        }
                                    })
                                    .then((res) => {
                                            console.log(res);
                                            if (res.status === 200 && res.data !== "") {
                                                setStudentList(res.data);
                                            }
                                            else {
                                                alert("查询失败！");
                                            }
                                        }
                                    );
                            }}>显示信息</button>
                        <p>{studentList}</p>
                    </div>

                    <form className="form">
                    <label>请输入项目ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入项目ID"}
                        onChange={(e) => {
                            setProjectID(e.target.value);
                        }
                        }
                    />

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

                        <label>请输入经费</label>
                        <input
                            className={"input"}
                            type="text"
                            placeholder={"请输入经费"}
                            onChange={(e) => {
                                setFund(e.target.value);
                            }
                            }
                        />
                    </form>
                    <button onClick={
                        () => {
                            axios
                                .get(serverURL + "/teacher/assignProject", {
                                    params: {
                                        token: token,
                                        projectID: projectID,
                                        studentID: studentID,
                                        fund: fund,
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
    )
}