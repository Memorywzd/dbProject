//配置助教可选志愿数量
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function SetVolunteer() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [volunteerNum, setvolunteerNum] = useState(0);

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

    function submitVolunteer() {
        axios
            .get(serverURL + "/admin/editVolunteerNumber", {
                params: {
                    token: token,
                    num: volunteerNum,
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
    function showVolunteer() {
        axios
            .get(serverURL + "/admin/getVolunteerNumber", {
                params: {
                    token:token,
                }
            })
            .then((res) => {
                console.log(res);
                if(res.status === 200 && res.data!== "") {
                    setvolunteerNum(res.data);
                }
                else {
                    alert("查询失败！");
                }
            });
    }

    return (
        <div className="App">
            <h1>配置助教可选志愿数量</h1>
            {isLogin ? (
                <div>
                    <label>请输入志愿数量</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入志愿数量"}
                        onChange={(e) => {
                            setvolunteerNum(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitVolunteer}>保存</button>
                    <h2>志愿数量显示</h2>
                    <button onClick={showVolunteer}>显示信息</button>
                    <p>{volunteerNum + "个"}</p>

                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}