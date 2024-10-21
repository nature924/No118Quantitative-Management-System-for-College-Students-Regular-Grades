const base = {
    get() {
        return {
            url : "http://localhost:8080/daxueshengpingshichengjilianghua/",
            name: "daxueshengpingshichengjilianghua",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/daxueshengpingshichengjilianghua/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生平时成绩量化管理系统"
        } 
    }
}
export default base
