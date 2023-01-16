import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./Home";
import AddTeacherUser from "./admin/addTeacherUser";
import AddProject from "./admin/addProject";
import AddStudentUser from "./admin/addStudentUser";
import AddSubjectUser from "./admin/addSubjectUser";

import AddAttendance from "./student/addAttendance";
import ShowAttendance from "./student/showAttendance";
import AddExchange from "./student/addExchange";
// 新页面在这里导入
import CheckInfo from "./leader/checkInfo";

import AddMentorUser from './admin/addMentorUser';
import BindUser from './admin/bindUser';
import AddLeaderUser from './admin/addLeaderUser';


// 结束导入新页面

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        {/* 新页面在这里添加 */}
        
        <Route path="/addTeacherUser" element={<AddTeacherUser />} />
        <Route path="/addProject" element={<AddProject />} />
        <Route path="/addStudentUser" element={<AddStudentUser />} />
        <Route path="/addSubjectUser" element={<AddSubjectUser />} />
        <Route path="/addAttendance" element={<AddAttendance />} />
        <Route path="/showAttendance" element={<ShowAttendance />} />
        <Route path="/addExchange" element={<AddExchange />} />
        <Route path="/checkInfo" element={<CheckInfo />} />
        <Route path="/addMentorUser" element={<AddMentorUser />} />
        <Route path="/bindUser" element={<BindUser />} />
        <Route path="/addLeaderUser" element={<AddLeaderUser />} />

        {/* 结束添加新页面 */}
      </Routes>
    </Router>
  );
}

export default App;
