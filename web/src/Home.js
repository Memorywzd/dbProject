import "./App.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
const serverURL = "http://localhost:3054";
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
    const [token, setToken] = useState("");
    //登录函数
    function doLogin() {
        axios
            .get(serverURL + "/user", {
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
                        setToken(res.data.token);
                    }
                }
            });
    }

    function afterAdminLogin() {
        function addTeacherUser() {
            Navigate("/addTeacherUser",{
                state: {token: token}
            });
        }
        return (
            <div>
                <h1>研究生培养管理员登录成功</h1>
                <p><button>新建项目</button></p>
                <p><button>新建研究生</button></p>
                <p><button onClick={addTeacherUser}>新建导师</button></p>
                <p><button>新建学科负责人</button></p>
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
        return (
            <div >
                 <h1>学生登录成功</h1>
                 <p><button>项目认定情况</button></p>
                 <p><button>项目认定表填写</button></p>
                 <p><button>项目进度填写</button></p>
                 <p><button>学术交流认定资料提交</button></p>
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
