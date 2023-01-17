import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./Home";

// 新页面在这里导入
import CheckInfo from "./leader/checkInfo";
import SetVolunteer from './leader/setVolunteer';
import SetFund from './leader/setFund';
import SetCommu from './leader/setCommu';
import SetPriority from './leader/setPriority';

import AddClass from './teacher/addClass';
import VerifyVolun from './teacher/verifyVolun';
import VerifyForm from './teacher/verifyForm';

import AddTeacherUser from "./admin/addTeacherUser";
import AddProject from "./admin/addProject";
import AddStudentUser from "./admin/addStudentUser";
import AddMentorUser from './admin/addMentorUser';
import BindUser from './admin/bindUser';
import AddLeaderUser from './admin/addLeaderUser';

import AssignProject from "./mentor/assignProject";
import RateExchange from "./mentor/rateExchange";
import ReviewAchievement from "./mentor/reviewAchievement";

import AddAttendance from "./student/addAttendance";
import ShowAttendance from "./student/showAttendance";
import AddExchange from "./student/addExchange";
import AddExchangeStatistics from "./student/addExchangeStatistics";
import ApplyVolunteer from "./student/applyVolunteer";
import ApplyVolunteerRate from "./student/applyVolunteerRate";
import ApplyAchievement from "./student/applyAchievement";
import ReviewAll from "./admin/reviewAll";
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
        <Route path="/addAttendance" element={<AddAttendance />} />
        <Route path="/showAttendance" element={<ShowAttendance />} />
        <Route path="/addExchange" element={<AddExchange />} />
        <Route path="/checkInfo" element={<CheckInfo />} />
        <Route path="/setVolunteer" element={<SetVolunteer />} />
        <Route path="/setFund" element={<SetFund />} />
        <Route path="/setCommu" element={<SetCommu />} />
        <Route path="/setPriority" element={<SetPriority />} />
        <Route path="/addClass" element={<AddClass />} />
        <Route path="/VerifyVolun" element={<VerifyVolun />} />
        <Route path="/VerifyForm" element={<VerifyForm />} />
        <Route path="/addMentorUser" element={<AddMentorUser />} />
        <Route path="/bindUser" element={<BindUser />} />
        <Route path="/addLeaderUser" element={<AddLeaderUser />} />

        <Route path="/assignProject" element={<AssignProject />} />
        <Route path="/verifyCommuInfo" element={<RateExchange />} />
        <Route path="/checkStuCer" element={<ReviewAchievement />} />
        <Route path="/countCommuInfo" element={<AddExchangeStatistics />} />
        <Route path="/chooseVolun" element={<ApplyVolunteer />} />
        <Route path="/setTAForm" element={<ApplyVolunteerRate />} />
        <Route path="/showAttendance" element={<ShowAttendance />} />
        <Route path="/addAttendance" element={<AddAttendance />} />
        <Route path="/setStuCer" element={<ApplyAchievement />} />
        <Route path="/checkResult" element={<ReviewAll />} />
        {/* 结束添加新页面 */}
      </Routes>
    </Router>
  );
}

export default App;
