package frame.com.wode.api.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    private String teacherNumber;
    private String studentNumber;
    private String userId;
    private String account;
    private String userName;
    private String userGenderValue;
    private String userEmail;
    private String userMobile;
    private String roleNameCode;   // 用户角色码值
    private String schoolName;
    private String deviceId;

    private StudentOfClazz studentOfClazz;
    private List<TeachClazz> teachClazz;
    private List<MainTeacherClazz> mainTeacherClazz;
    private int schoolPkg;

    public List<UserInfo.sectionInfos> getSectionInfos() {
        return sectionInfos;
    }

    public void setSectionInfos(List<UserInfo.sectionInfos> sectionInfos) {
        this.sectionInfos = sectionInfos;
    }

    private List<sectionInfos> sectionInfos;


    public void setSchoolPkg(int schoolPkg) {
        this.schoolPkg = schoolPkg;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGenderValue() {
        return userGenderValue;
    }

    public void setUserGenderValue(String userGenderValue) {
        this.userGenderValue = userGenderValue;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getRoleNameCode() {
        return roleNameCode;
    }

    public void setRoleNameCode(String roleNameCode) {
        this.roleNameCode = roleNameCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public StudentOfClazz getStudentOfClazz() {
        return studentOfClazz;
    }

    public void setStudentOfClazz(StudentOfClazz studentOfClazz) {
        this.studentOfClazz = studentOfClazz;
    }

    public List<TeachClazz> getTeachClazz() {
        return teachClazz;
    }

    public void setTeachClazz(List<TeachClazz> teachClazz) {
        this.teachClazz = teachClazz;
    }

    public List<MainTeacherClazz> getMainTeacherClazz() {
        return mainTeacherClazz;
    }

    public void setMainTeacherClazz(List<MainTeacherClazz> mainTeacherClazz) {
        this.mainTeacherClazz = mainTeacherClazz;
    }


    /**
     * 学生所在班级
     */
    public class StudentOfClazz {
        @SerializedName("classNameValue")
        private String sectionNameValue;
        @SerializedName("classId")
        private String classId;
        private String sectionNameCode;
        @SerializedName("gradeNameCode")
        private String gradeNameCode;

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getGradeNameValue() {
            return gradeNameValue;
        }

        public void setGradeNameValue(String gradeNameValue) {
            this.gradeNameValue = gradeNameValue;
        }

        private String gradeNameValue;


        public String getGradeNameCode() {
            return gradeNameCode;
        }

        public void setGradeNameCode(String gradeNameCode) {
            this.gradeNameCode = gradeNameCode;
        }


        public String getSectionNameValue() {
            return sectionNameValue;
        }

        public void setSectionNameValue(String sectionNameValue) {
            this.sectionNameValue = sectionNameValue;
        }

        public String getSectionNameCode() {
            return sectionNameCode;
        }

        public void setSectionNameCode(String sectionNameCode) {
            this.sectionNameCode = sectionNameCode;
        }


    }

    /**
     * 教师教授班级
     */
    public class TeachClazz {

        private String classNameValue;
        private String classId;
        private String gradeNameCode;
        private String gradeNameValue;

        public String getGradeNameValue() {
            return gradeNameValue;
        }

        public void setGradeNameValue(String gradeNameValue) {
            this.gradeNameValue = gradeNameValue;
        }

        public String getGradeNameCode() {
            return gradeNameCode;
        }

        public void setGradeNameCode(String gradeNameCode) {
            this.gradeNameCode = gradeNameCode;
        }


        public String getClassNameValue() {
            return classNameValue;
        }

        public void setClassNameValue(String classNameValue) {
            this.classNameValue = classNameValue;
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }
    }

    /**
     * 备注：只有班主任有信息，管理员为空，若为管理员，返回空数组
     */
    public class MainTeacherClazz {
        /**
         * classId : 381050001
         * classNameValue : 初一1班
         */

        private String classId;
        private String classNameValue;
        private String gradeNameValue;

        public String getGradeNameValue() {
            return gradeNameValue;
        }

        public void setGradeNameValue(String gradeNameValue) {
            this.gradeNameValue = gradeNameValue;
        }

        public String getGradeNameCode() {
            return gradeNameCode;
        }

        public void setGradeNameCode(String gradeNameCode) {
            this.gradeNameCode = gradeNameCode;
        }

        private String gradeNameCode;


        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getClassNameValue() {
            return classNameValue;
        }

        public void setClassNameValue(String classNameValue) {
            this.classNameValue = classNameValue;
        }
    }

    public class sectionInfos {
        private int sectionId;
        private String sectionNameCode;
        private String sectionNameValue;

        public int getSectionId() {
            return sectionId;
        }

        public void setSectionId(int sectionId) {
            this.sectionId = sectionId;
        }

        public String getSectionNameCode() {
            return sectionNameCode;
        }

        public void setSectionNameCode(String sectionNameCode) {
            this.sectionNameCode = sectionNameCode;
        }

        public String getSectionNameValue() {
            return sectionNameValue;
        }

        public void setSectionNameValue(String sectionNameValue) {
            this.sectionNameValue = sectionNameValue;
        }
    }

    public class ClassInfos {
        private String classNameValue;
        private String classId;

        public String getClassNameValue() {
            return classNameValue;
        }

        public void setClassNameValue(String classNameValue) {
            this.classNameValue = classNameValue;
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }
    }

    @Override
    public String toString() {
        return "UserInfo Bean 信息{" +
                "teacherNumber='" + teacherNumber + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                ", userName='" + userName + '\'' +
                ", userGenderValue='" + userGenderValue + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", roleNameCode='" + roleNameCode + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", studentOfClazz=" + studentOfClazz +
                ", teachClazz=" + teachClazz +
                ", mainTeacherClazz=" + mainTeacherClazz +
                ", schoolPkg=" + schoolPkg +
                ", sectionInfos=" + sectionInfos +
                '}';
    }
}