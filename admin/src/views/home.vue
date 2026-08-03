<script setup lang="ts" name="Home">
    const serviceUrl = (import.meta.env.VITE_APP_SERVICE_URL || '/springbootgslq').replace(/\/+$/, '');
    const bannerUrl = `${serviceUrl}/upload/1768881258722.jpg`;



</script>

<template>
  <div class="home-bg">
    <div class="home-bg-mask"></div>
    <div class="center">
      <div class="home-content-unified">
        <img :src="bannerUrl" alt="banner" class="home-banner-img-unified" />
        <div class="home-welcome-text-unified">
          <h1>🏀 篮球训练营管理系统</h1>
          <p>
            专业的篮球训练营管理平台，致力于为学员提供优质的训练服务。在这里，我们用专业的教练团队、完善的训练设施、科学的训练方法，助力每一位学员实现篮球梦想，挥洒青春汗水，成就冠军之路！
          </p>
        </div>
      </div>
    </div>
  </div>
</template>


<style scoped lang="scss">
.home-bg {
  min-height: 100vh;
  width: 100vw;
  position: relative;
  background: url('@/assets/hbg.png') center center/cover no-repeat;
  overflow: hidden;
}
.home-bg-mask {
  position: absolute;
  inset: 0;
  background: rgba(0, 0, 0, 0.4);
  z-index: 1;
}
.center {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  z-index: 2;
}
.home-content-unified {
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(15px);
  border-radius: 25px;
  box-shadow: 0 25px 50px rgba(0, 0, 0, 0.15);
  padding: 60px 50px 50px 50px;
  width: 100%;
  max-width: 500px;
  margin: 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid rgba(255, 255, 255, 0.3);
}
.home-banner-img-unified {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 20px;
  margin-bottom: 35px;
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
  border: 2px solid rgba(255, 255, 255, 0.3);
}
.home-welcome-text-unified h1 {
  font-size: 2.2rem;
  font-weight: 800;
  color: #ff6b35;
  margin-bottom: 30px;
  letter-spacing: 1px;
  text-align: center;
  font-family: 'Microsoft YaHei', Arial, sans-serif;
  text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.home-welcome-text-unified p {
  font-size: 1.2rem;
  color: #555;
  text-align: center;
  line-height: 2.2;
  letter-spacing: 1px;
  margin: 0 0.5rem;
  font-weight: 500;
}
</style>
