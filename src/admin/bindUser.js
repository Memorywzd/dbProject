import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";
//const serverURL = "http://localhost:8080";

export default function BindUser() {
    const location = useLocation();

    const [isLogin, setIsLogin] = useState(false);

    const [studentID, setstudentID] = useState("");
    const [mentorID, setmentorID] = useState("");
    const [ifBinded, setifBinded] = useState([]);


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
            .get(serverURL + "/admin/bindMentorWithStudent", {
                params: {
                    //token参数必须带上
                    token: token,
                    studentID: studentID,
                    mentorID: mentorID,
                }
            })
            .then((res) => {
                    console.log(res);
                    if (res.status === 200 && res.data !== "") {
                        setifBinded(res.data);
                        alert("建立成功！");
                    }
                    else {
                        alert("建立失败！");
                    }
                }
            );

    }

    return (
        <div className="App">
            <h1>建立导师和学生联系</h1>
            {isLogin ? (
                <div>
                    <label>请输入学生ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学科ID"}
                        onChange={(e) => {
                            setstudentID(e.target.value);
                        }
                    }
                    />

                    <label>请输入导师ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学科ID"}
                        onChange={(e) => {
                            setmentorID(e.target.value);
                        }
                    }
                    />
                    <button onClick={show}>显示信息</button>
                    
                    
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );

}