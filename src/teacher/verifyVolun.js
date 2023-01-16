//志愿审核
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function VerifyVolun() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [colunteerID, setColunteerID] = useState("");
    const [courseID, setCourseID] = useState("");
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

    function submitVolun() {
        axios
            .get(serverURL + "/teacher/selectAssistant", {
                params: {
                    token: token,
                    colunteerID: colunteerID,
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
    function showVolun() {
        axios
            .get(serverURL + "/teacher/getVolunteerList", {
                params: {
                    token:token,
                    courseID:courseID,
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
            <h1>志愿审核</h1>
            {isLogin ? (
                <div>
                    <label>助教ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入助教ID"}
                        onChange={(e) => {
                            setColunteerID(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitVolun}>通过</button>
                    
                    <h2>课程助教志愿显示</h2>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入课程ID"}
                        onChange={(e) => {
                            setCourseID(e.target.value);
                        }
                    }
                    />
                    <button onClick={showVolun}>显示</button>
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