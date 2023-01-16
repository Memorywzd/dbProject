import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";
//const serverURL = "http://localhost:8080";

export default function CheckInfo() {
    const location = useLocation();

    const [isLogin, setIsLogin] = useState(false);
    const [subjectID, setSubjectID] = useState("");
    const [mentorList, setMentorList] = useState([]);
    const [studentList, setStudentList] = useState([]);

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

    function show() {
        axios
            .get(serverURL + "/admin/getMentorList", {
                params: {
                    //token参数必须带上
                    token: token,
                    subjectID: subjectID,
                }
            })
            .then((res) => {
                    console.log(res);
                    if (res.status === 200 && res.data !== "") {
                        setMentorList(res.data);
                    }
                    else {
                        alert("查询失败！");
                    }
                }
            );
        axios
            .get(serverURL + "/admin/getStudentList", {
                params: {
                    token: token,
                    subjectID: subjectID,
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

    }

    return (
        <div className="App">
            <h1>查看导师和研究生情况</h1>
            {isLogin ? (
                <div>
                    <label>请输入学科ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学科ID"}
                        onChange={(e) => {
                            setSubjectID(e.target.value);
                        }
                    }
                    />
                    <button onClick={show}>显示信息</button>
                    <h2>导师列表</h2>
                    <p>{mentorList}</p>
                    <h2>研究生列表</h2>
                    <p>{studentList}</p>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );

}