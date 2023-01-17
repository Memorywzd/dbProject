import "./App.css";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const cache = localStorage;
const serverURL = "http://az.pizzel.me";

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
    const [userRole, setUserRole] = useState(0);
    let token = cache.getItem("token");

    function  setLoginState(role) {
        console.log("role: " + role);
        switch (role) {
            case 0:
            case '0':
                console.log("研究生登录！");
                setIsStudentLogin(true);
                break;
            case 1:
            case '1':
                console.log("教师登录！");
                setIsTeacherLogin(true);
                break;
            case 2:
            case '2':
                console.log("导师登录！");
                setIsMentorLogin(true);
                break;
            case 3:
            case '3':
                console.log("管理员登录！");
                setIsAdminLogin(true);
                break;
            case 4:
            case '4':
                console.log("学科负责人登录！");
                setIsLeaderLogin(true);
                break;
            default:
                break;
        }
    }

    useEffect(() => {
        //判断是否登录
        if (cache.getItem("token") !== "" && cache.getItem("role")) {
            console.log("已经登录,token:" + cache.getItem("token") +
                ",role:" + cache.getItem("role"));
            setLoginState(cache.getItem("role"));
        }
    }, []);

    //登录函数
    function doLogin() {
        const formData = new FormData();
        formData.append("userID", username);
        formData.append("password", password);
        formData.append("role", userRole);

        axios
            .post(serverURL + "/app/login", formData)
            .then((res) => {
                console.log(res);
                if (res.status === 200 && res.data) {
                    setIsLeaderLogin(false);
                    setIsAdminLogin(false);
                    setIsTeacherLogin(false);
                    setIsMentorLogin(false);
                    setIsStudentLogin(false);
                    cache.clear();
                    token = res.data;
                    setLoginState(userRole);
                    cache.setItem("token", res.data);
                    cache.setItem("role", userRole);
                    console.log("登录成功, token:" + cache.getItem("token"));
                    console.log("role为" + cache.getItem("role"));
                }
                else {
                    alert("用户名或者密码错误！");
                }
            })

    }
    //清空缓存
    function clearCache() {
        setIsLeaderLogin(false);
        setIsAdminLogin(false);
        setIsTeacherLogin(false);
        setIsMentorLogin(false);
        setIsStudentLogin(false);
        cache.clear();
        window.location.reload();
    }

    function afterAdminLogin() {

        function addTeacherUser() {
            Navigate("/addTeacherUser", {
                state: { token: token }
            });
        }
        function addProject() {
            Navigate("/addProject", {
                state: { token: token }
            });
        }
        function addStudentUser() {
            console.log("token:" + token);
            Navigate("/addStudentUser", {
                state: { token: token }
            });
        }
        //新加addLeaderUser
        function addLeaderUser() {
            Navigate("/addLeaderUser", {
                state: { token: token }
            });
        }
        function addMentorUser() {
            Navigate("/addMentorUser", {
                state: {token: token}
            });
        }
        function bindUser() {
            Navigate("/bindUser", {
                state: {token: token}
            });
        }
        function checkResult() {
            Navigate("/checkResult", {
                state: {token: token}
            });
        }
        return (
            <div>
                <h1>研究生培养管理员登录成功</h1>
                <p><button onClick={checkResult}>审核成果情况</button></p>
                <p><button onClick={addLeaderUser}>新建学科负责人用户</button></p>
                <p><button onClick={addTeacherUser}>新建授课教师用户</button></p>
                <p><button onClick={addMentorUser}>新建导师用户</button></p>
                <p><button onClick={addStudentUser}>新建研究生用户</button></p>
                <p><button onClick={bindUser}>建立学生与导师联系</button></p>
                <p><button onClick={addProject}>新建项目</button></p>
            </div>
        )
    }

    function afterLeaderLogin() {
        function setPriority() {
            Navigate("/setPriority", {
                state: {token: token}
            });
        }
        function setVolunteer() {
            Navigate("/setVolunteer", {
                state: {token: token}
            });
        }
        function setFund() {
            Navigate("/setFund", {
                state: {token: token}
            });
        }
        function setCommu() {
            Navigate("/setCommu", {
                state: {token: token}
            });
        }
        function checkInfo() {
            Navigate("/checkInfo", {
                state: {token: token}
            });
        }
        return (
            <div>
                <h1>学科负责人登录成功</h1>
                <p><button onClick={setPriority}>配置助教课程优先级</button></p>
                <p><button onClick={setVolunteer}>配置助教可选志愿数量</button></p>
                <p><button onClick={setFund}>配置参与项目经费</button></p>
                <p><button onClick={setCommu}>配置学术交流次数</button></p>
                <p><button onClick={checkInfo}>查看导师和研究生情况</button></p>
            </div>
        )
    }

    function afterTeacherLogin() {
        function addClass() {
            Navigate("/addClass", {
                state: {token: token}
            });
        }
        function verifyVolun() {
            Navigate("/verifyVolun", {
                state: {token: token}
            });
        }
        function verifyForm() {
            Navigate("/verifyForm", {
                state: {token: token}
            });
        }
        return (
            <div>
                <h1>授课教师登录成功</h1>
                <p><button onClick={addClass}>课程信息录入</button></p>
                <p><button onClick={verifyVolun}>志愿审核</button></p>
                <p><button onClick={verifyForm}>助教评定表审核</button></p>
            </div>
        )
    }

    function afterMentorLogin() {
        function assignProject() {
            Navigate("/assignProject", {
                state: {token: token}
            });
        }
        function verifyCommuInfo() {
            Navigate("/verifyCommuInfo", {
                state: {token: token}
            });
        }
        function checkStuCer() {
            Navigate("/checkStuCer", {
                state: {token: token}
            });
        }
        return (
            <div>
                <h1>导师登录成功</h1>
                <p><button onClick={verifyCommuInfo}>审核学术交流情况</button></p>
                <p><button onClick={assignProject}>研究生项目管理</button></p>
                <p><button onClick={checkStuCer}>研究生成果认证</button></p>
            </div>
        )
    }

    function afterStudentLogin() {

        function addAttendance() {
            Navigate("/addAttendance", {
                state: { token: token }
            });
        }
        function showAttendance() {
            Navigate("/showAttendance", {
                state: { token: token }
            });
        }
        function addExchange() {
            Navigate("/addExchange", {
                state: { token: token }
            });
        }
        function submitExchangeStatistics() {
            Navigate("/countCommuInfo", {
                state: {token: token}
            });
        }
        function setStuCer() {
            Navigate("/setStuCer", {
                state: {token: token}
            });
        }
        function chooseVolun() {
            Navigate("/chooseVolun", {
                state: {token: token}
            });
        }
        function setTAForm() {
            Navigate("/setTAForm", {
                state: {token: token}
            });
        }
        function showTAVolun() {
            Navigate("/showTAVolun", {
                state: {token: token}
            });
        }
        function showTAEvaInfo() {
            Navigate("/showTAEvaInfo", {
                state: {token: token}
            });
        }
        return (
            <div >
                <h1>研究生登录成功</h1>
                <p><button onClick={addExchange}>学术交流情况提交</button></p>
                <p><button onClick={submitExchangeStatistics}>提交学术交流统计</button></p>
                <p><button onClick={chooseVolun}>助教志愿选择</button></p>
                <p><button onClick={setTAForm}>助教评定表填写</button></p>
                <p><button onClick={showAttendance}>查看项目认定情况</button></p>
                <p><button onClick={addAttendance}>项目认定表填写</button></p>
                <p><button onClick={setStuCer}>填写成果认定</button></p>

            </div>
        )
    }

    return (
        <div className="App">
            <h1>研究生培养环节和成果认定综合管理系统</h1>
            <p><button onClick={clearCache}>清除系统缓存</button></p>
            <label>用户角色：
                <select onChange={(e) => {
                    setUserRole(e.target.selectedIndex);
                }}>
                    <option>研究生</option>
                    <option>授课教师</option>
                    <option>导师</option>
                    <option>管理员</option>
                    <option>学科负责人</option>
                </select></label>
            <form className="form">
                <label>用户名：
                    <input
                        className="input"
                        type="text"
                        placeholder="请输入用户名"
                        onChange={(e) => {
                            setUsername(e.target.value);
                        }}
                    /></label>
                <label>密&emsp;码：
                    <input
                        className="input"
                        type="password"
                        placeholder="请输入密码"
                        onChange={(e) => {
                            setPassword(e.target.value);
                        }}
                    /></label>
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
