//配置助教课程优先级
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function SetPriority() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [courseID, setCourseID] = useState("");
    const [priority, setPriority] = useState(0);
    const [courseList, setCourseList] = useState([]);

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

    function submitPriority() {
        axios
            .get(serverURL + "/admin/editCourseList", {
                params: {
                    token: token,
                    courseID: courseID,
                    priority: priority,
                }
            })
            .then((res) => {
                console.log(res);
                if (res.status === 200 && res.data !== "") {
                    alert("修改成功！")
                }
                else {
                    alert("修改失败!");
                }
            });
        
    }
    function showPriority() {
        axios
            .get(serverURL + "/admin/getSystemCourseList", {
                params: {
                    token:token,
                }
            })
            .then((res) => {
                console.log(res);
                if(res.status === 200 && res.data!== "") {
                    setCourseList(res.data);
                }
                else {
                    alert("查询失败！");
                }
            });
    }

    return (
        <div className="App">
            <h1>配置助教课程优先级</h1>
            {isLogin ? (
                <div>
                    <label>请输入课程ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入课程ID"}
                        onChange={(e) => {
                            setCourseID(e.target.value);
                        }
                    }
                    />
                    <label>请输入课程优先级</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入课程优先级"}
                        onChange={(e) => {
                            setPriority(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitPriority}>保存</button>
                    <h2>课程信息显示</h2>
                    <button onClick={showPriority}>显示信息</button>
                    <p>{courseList}</p>

                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}