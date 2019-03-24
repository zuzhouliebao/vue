<template>
  <div id="app" class="container">
    <div class="header">
			<router-link to="/" class="nav-item">首页</router-link>
			<router-link to="/Message" class="nav-item">消息</router-link>
		</div>
   <div class="content">
		 <router-view></router-view>
	 </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
.container{
	width: 80%;
	margin: 0 auto;
	height: 400px;
}
.header{
	display: flex;
	height: 100px;
	background-color: darkcyan;
	font-size: 20px;
	padding-left: 20px;
	align-items: center;
}
.nav-item{
	margin-right: 20px;
}
.content{
	background-color: #2C3E50;
	color: #ffffff;
}
</style>