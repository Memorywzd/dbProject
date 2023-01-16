//助教评定表审核
import React from "react";
import axios from "axios";
import {useState, useEffect} from "react";
import {Navigate, useLocation, NavLink} from "react-router-dom";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

export default function VerifyForm() {
    const location = useLocation();
    const [isLogin, setIsLogin] = useState(false);

    const [rateID, setRateID] = useState("");
    const [teacherRate, setTeacherRate] = useState("");
    const [rateList, setRateList] = useState([]);

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

    function submitRate() {
        axios
            .get(serverURL + "/teacher/rateAssistant", {
                params: {
                    token: token,
                    rateID: rateID,
                    teacherRate: teacherRate,
                }
            })
            .then((res) => {
                console.log(res);
                if (res.status === 200 && res.data !== "") {
                    alert("保存成功！")
                }
                else {
                    alert("保存失败!");
                }
            });
    }

    return (
        <div className="App">
            <h1>助教评定表审核</h1>
            {isLogin ? (
                <div>
                    <label>评定ID</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入评定ID"}
                        onChange={(e) => {
                            setRateID(e.target.value);
                        }
                    }
                    />
                    <label>教师评价</label>
                    <input
                        className={"input"}
                        type="text"
                        placeholder={"请输入教师评价"}
                        onChange={(e) => {
                            setTeacherRate(e.target.value);
                        }
                    }
                    />
                    <button onClick={submitRate}>保存</button>

                </div>
            ) : (
                <div>请登录</div>
            )}

            {/* <Navigate to="/">返回</Navigate> */}
            <NavLink to="../">返回</NavLink>
        </div>
    );
}