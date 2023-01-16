import "./App.css";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
const cache = window.localStorage;
const serverURL = "http://az.pizzel.me";
//const serverURL = "http://localhost:8080";

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
    const [token, setToken] = useState("");

    function  setLoginState(role) {
        console.log("role: " + role);
        switch (role) {
            case 1:
            case '1':
                console.log("研究生登录！");
                setIsStudentLogin(true);
                break;
            case 2:
            case '2':
                console.log("教师登录！");
                setIsTeacherLogin(true);
                break;
            case 3:
            case '3':
                console.log("导师登录！");
                setIsMentorLogin(true);
                break;
            case 4:
            case '4':
                console.log("管理员登录！");
                setIsAdminLogin(true);
                break;
            case 5:
            case '5':
                console.log("学科负责人登录！");
                setIsLeaderLogin(true);
                break;
            default:
                break;
        }
    }

    useEffect(() => {
        //判断是否登录
        if (cache.getItem("token") && cache.getItem("role")) {
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
                if (res.status === 200) {
                    setToken(res.data);
                    setLoginState(userRole);
                    cache.setItem("token", res.data);
                    cache.setItem("role", userRole);
                    console.log("登录成功, token:" + cache.getItem("token"));
                    console.log("role为" + cache.getItem("role"));
                }
            })

    }
    //清空缓存
    function clearCache() {
        cache.clear();
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
            Navigate("/addStudentUser", {
                state: { token: token }
            });
        }
        function addSubjectUser() {
            Navigate("/addSubjectUser", {
                state: { token: token }
            });
        }
        return (
            <div>
                <h1>研究生培养管理员登录成功</h1>
                <p><button onClick={addProject}>新建项目</button></p>
                <p><button onClick={addTeacherUser}>新建教师用户</button></p>
                <p><button onClick={addStudentUser}>新建研究生用户</button></p>
                <p><button onClick={addSubjectUser}>新建学科负责人用户</button></p>
            </div>
        )
    }

    function afterLeaderLogin() {
        return (
            <div>
                <h1>学科负责人登录成功</h1>
                <p><button>配置助教课程优先级</button></p>
                <p><button>配置助教可选志愿数量</button></p>
                <p><button>配置参与项目经费</button></p>
                <p><button>配置学术交流次数</button></p>
                <p><button>查看学科下的导师和研究生情况</button></p>
            </div>
        )
    }

    function afterTeacherLogin() {
        return (
            <div>
                <h1>授课教师登录成功</h1>
                <p><button>课程信息录入</button></p>
                <p><button>志愿审核</button></p>
                <p><button>助教评定表审核</button></p>
            </div>
        )
    }

    function afterMentorLogin() {
        return (
            <div>
                <h1>导师登录成功</h1>
                <p><button>查看导师个人项目</button></p>
                <p><button>为未完成项目认定的研究生分配项目</button></p>
                <p><button>查看项目认定表，确认金额</button></p>
                <p><button>学术交流情况审核</button></p>
                <p><button>查看/修改学生成果认证</button></p>
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
        return (
            <div >
                <h1>研究生登录成功</h1>
                <p><button onClick={showAttendance}>查看项目认定情况</button></p>
                <p><button onClick={addAttendance}>项目认定表填写</button></p>
                <p><button onClick={addExchange}>学术交流认定资料提交</button></p>
                <p><button>学术交流情况统计</button></p>
                <p><button>成果认定情况</button></p>
                <p><button>填写成果认定</button></p>
                <p><button>助教志愿选择</button></p>
                <p><button>助教评定表填写</button></p>
                <p><button>查看助教志愿选择结果</button></p>
                <p><button>查看助教评定结果</button></p>

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
