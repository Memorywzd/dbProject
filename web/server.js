const Express = require("express");

const app = Express();

//设置允许跨域访问该服务.
app.all("*", function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Content-Type");
    res.header("Access-Control-Allow-Methods", "*");
    res.header("Content-Type", "application/json;charset=utf-8");
    next();
});

app.get("/user", (req, res) => {
    const username = req.query.username;
    const password = req.query.password;
    console.log(username + " " + password);
    // 返回验证通过
    res.send({
        code: 200,
        token: "admin-token",
        type: "admin",
        role: "1",
    });
});

const users = [
    {
        username: "admin",
        age: 11,
    },
    {
        username: "xcxx",
        age: 11,
    },
    {
        username: "张三",
        age: 12,
    },
];

app.get("/users", (req, res) => {
    res.send(users);
});

app.listen(3001, () => {
    console.log("server is running at 3001");
});