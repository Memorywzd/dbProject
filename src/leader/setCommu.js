//配置学术交流次数
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function SetCommu() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [commuNum, setCommuNum] = useState(0);

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

    function submitCommu() {
        axios
            .get(serverURL + "/admin/editAcademicExchange", {
                params: {
                    token: token,
                    num: commuNum,
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
    function showCommu() {
        axios
            .get(serverURL + "/admin/getAcademicExchange", {
                params: {
                    token:token,
                }
            })
            .then((res) => {
                console.log(res);
                if(res.status === 200 && res.data!== "") {
                    setCommuNum(res.data);
                }
                else {
                    alert("查询失败！");
                }
            });
    }

    return (
        <div className="App">
            <h1>配置学术交流次数</h1>
            {isLogin ? (
                <div>
                    <label>请输入学术交流次数</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入学术交流次数"}
                        onChange={(e) => {
                            setCommuNum(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitCommu}>保存</button>

                    <h2>学术交流次数显示</h2>
                    <button onClick={showCommu}>显示信息</button>
                    <p>{commuNum + "次"}</p>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}