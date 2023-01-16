//配置参与项目经费
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function SetFund() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [fundNum, setfundNum] = useState(0);

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

    function submitFund() {
        axios
            .get(serverURL + "/admin/editProjectFounding", {
                params: {
                    token: token,
                    num: fundNum,
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
    function showFund() {
        axios
            .get(serverURL + "/admin/getProjectFounding", {
                params: {
                    token:token,
                }
            })
            .then((res) => {
                console.log(res);
                if(res.status === 200 && res.data!== "") {
                    setfundNum(res.data);
                }
                else {
                    alert("查询失败！");
                }
            });
    }

    return (
        <div className="App">
            <h1>配置参与项目经费</h1>
            {isLogin ? (
                <div>
                    <label>请输入项目经费</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入项目经费"}
                        onChange={(e) => {
                            setfundNum(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitFund}>保存</button>

                    <h2>项目经费显示</h2>
                    <button onClick={showFund}>显示信息</button>
                    <p>{fundNum + "元"}</p>
                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}