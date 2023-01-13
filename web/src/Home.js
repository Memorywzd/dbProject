import "./App.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Home() {
    //定义页面跳转函数
    const Navigate = useNavigate();

    //定义状态
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [isAdminLogin, setIsAdminLogin] = useState(false);
    const [isLeaderLogin, setIsLeaderLogin] = useState(false);
    const [isTeacherLogin, setIsTeacherLogin] = useState(false);
    const [isMentorLogin, setIsMentorLogin] = useState(false);
    const [isStudentLogin, setIsStudentLogin] = useState(false);

    //登录函数
    function doLogin() {
        axios
            .get("http://localhost:3054/user", {
                params: {
                    username: username,
                    password: password,
                },
            })
            .then((res) => {
                console.log(res);
                if (res.data.code === 200) {
                    if (res.data.type === "admin" && res.data.role === "1") {
                        setIsAdminLogin(true);
                    }
                }
            });
    }

    function afterAdminLogin() {

        return (
            <h1>研究生培养管理员登录成功</h1>
        )
    }

    function afterLeaderLogin() {
        return (
            <h1>学科负责人登录成功</h1>
        )
    }

    function afterTeacherLogin() {
        return (
            <h1>授课教师登录成功</h1>
        )
    }

    function afterMentorLogin() {
        return (
            <h1>导师登录成功</h1>
        )
    }

    function afterStudentLogin() {
        return (
            <h1>学生登录成功</h1>
        )
    }

    return (
        <div className="App">
            <h1>研究生培养环节和成果认定综合管理系统</h1>
            <form className="form">
                <label>用户名：</label>
                <input
                    className="input"
                    type="text"
                    placeholder="请输入用户名"
                    onChange={(e) => {
                        setUsername(e.target.value);
                    }}
                />

                <label>密码：</label>
                <input
                    className="input"
                    type="password"
                    placeholder="请输入密码"
                    onChange={(e) => {
                        setPassword(e.target.value);
                    }}
                />

            </form>
            <button onClick={doLogin} className="input">
                登录
            </button>
            {isAdminLogin && afterAdminLogin()}
            {isLeaderLogin && afterLeaderLogin()}
            {isTeacherLogin && afterTeacherLogin()}
            {isMentorLogin && afterMentorLogin()}
            {isStudentLogin && afterStudentLogin()}
        </div>
    );
}

export default Home;
