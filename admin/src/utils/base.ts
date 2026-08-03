const serviceUrl = (import.meta.env.VITE_APP_SERVICE_URL || '/springbootgslq').replace(/\/+$/, '');

const base = {
    get() {
        return {
            url: `${serviceUrl}/`,
            name: "springbootgslq",
            // 退出到首页链接
            indexUrl: `${serviceUrl}/front/index.html`
        };
    },
    getProjectName() {
        return {
            projectName: "篮球训练营"
        }
    }
}
export default base
